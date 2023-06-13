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

	public List<MusicEntity> getAllMusic() {
		return musicRepository.findAll();
	}

	public Optional<MusicEntity> getMusicById(int musicId) throws NoAlbumFoundException {
		Optional<MusicEntity> music = musicRepository.findById(musicId);
		if (music.isPresent()) {
			return musicRepository.findById(musicId);
		} else {
			throw new NoAlbumFoundException("no user found");
		}
	}

	public MusicEntity saveMusic(MusicEntity music) {
		return musicRepository.save(music);
	}

	public ResponseEntity<String> deleteMusic(int musicId) throws NoAlbumFoundException {
		Optional<MusicEntity> op = musicRepository.findById(musicId);
		if (op.isPresent()) {
//		if (musicRepository.existsById(musicId)) {
			musicRepository.deleteById(musicId);
			return new ResponseEntity<>("Entity Deleted successfully", HttpStatus.OK);
		} else {
			throw new NoAlbumFoundException("No Album found to delete");
			// return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
		}
	}

	public MusicEntity updateMusic(MusicEntity musicEntity) throws NoAlbumFoundException {
		MusicEntity music = null;
		Optional<MusicEntity> dup = musicRepository.findById(musicEntity.getMusicId());

		if (dup.isPresent()) {
			music = dup.get();
			music.setMusicArtist(musicEntity.getMusicArtist());
			music.setMusicDescription(musicEntity.getMusicDescription());
			music.setMusicGenre(musicEntity.getMusicGenre());
			music.setMusicTitle(musicEntity.getMusicTitle());
			music.setMusicYear(musicEntity.getMusicYear());
			return musicRepository.save(music);
		} else {
			throw new NoAlbumFoundException("no update");
//			return musicRepository.save(music);
		}

	}

	public List<MusicEntity> getMusicByName(String musicTitle) throws NoAlbumFoundException {
		List<MusicEntity> music = musicRepository.findAllByMusicTitle(musicTitle);
		if (music.isEmpty()) {
			throw new NoAlbumFoundException("noo title");
//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return music;
		}
	}

	public List<MusicEntity> getMusicByGenre(String musicGenre) throws NoAlbumFoundException {
		List<MusicEntity> music = musicRepository.findByMusicGenre(musicGenre);
		if (music.isEmpty()) {
			throw new NoAlbumFoundException("noo genre");
//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return music;
		}
	}

	public List<MusicEntity> getMusicByYear(Long musicYear) throws NoAlbumFoundException {
		List<MusicEntity> music = musicRepository.findByMusicYear(musicYear);
		if (music.isEmpty()) {
			throw new NoAlbumFoundException("noo year");
//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return music;
		}
	}

	public List<MusicEntity> getMusicByArtist(String musicArtist) throws NoAlbumFoundException {
		List<MusicEntity> music = musicRepository.findByMusicArtist(musicArtist);
		if (music.isEmpty()) {
			throw new NoAlbumFoundException("noo artist");
//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return music;
		}
	}

}
