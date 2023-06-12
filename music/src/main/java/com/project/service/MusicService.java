package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.exception.NoAlbumFoundException;
import com.project.model.MusicEntity;
import com.project.repository.MusicRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {
	@Autowired
	private MusicRepository musicRepository;

	public MusicEntity saveMusic(MusicEntity music) {
		// Perform any additional validation or business logic before saving
		return musicRepository.save(music);
	}

	public MusicEntity getMusicById(int musicId)throws NoAlbumFoundException {
		return musicRepository.findById(musicId).orElse(null);
	}

	public List<MusicEntity> getAllMusic() {
		return musicRepository.findAll();
	}
	public List<MusicEntity> getMusicByName(String musicTitle)throws NoAlbumFoundException {
		
		return musicRepository.findAllByMusicTitle(musicTitle);
	
	}
	

	public List<MusicEntity> getMusicByGenre(String musicGenre) throws NoAlbumFoundException {
		return musicRepository.findByMusicGenre(musicGenre);
	}

	public List<MusicEntity> getMusicByArtist(String musicArtist)throws NoAlbumFoundException {
		return musicRepository.findByMusicArtist(musicArtist);
	}

	public List<MusicEntity> getMusicByYear(Long musicYear)throws NoAlbumFoundException {
		return musicRepository.findByMusicYear(musicYear);

	}

	public MusicEntity updateMusic(MusicEntity musicEntity) {
		MusicEntity music = null;
		Optional<MusicEntity> dup = musicRepository.findById(musicEntity.getMusicId());

		if (dup.isPresent()) {
			music = dup.get();
			music.setMusicArtist(musicEntity.getMusicArtist());
			music.setMusicDescription(musicEntity.getMusicDescription());
			music.setMusicGenre(musicEntity.getMusicGenre());
			music.setMusicTitle(musicEntity.getMusicTitle());
			music.setMusicYear(musicEntity.getMusicYear());
		}
		return musicRepository.save(music);
	}

	public ResponseEntity<String> deleteMusic(int musicId) {
		if (musicRepository.existsById(musicId)) {
			musicRepository.deleteById(musicId);
			return new ResponseEntity<>("Entity Deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
		}
	}

	
}
