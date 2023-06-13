package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.NoAlbumFoundException;
import com.project.model.MusicEntity;
import com.project.repository.MusicRepository;
import com.project.service.MusicService;

@RestController
@RequestMapping("/music")
public class MusicController {
	@Autowired
	private MusicService musicService;

	@GetMapping("/search/artist/{musicArtist}")
	public ResponseEntity<List<MusicEntity>> getMusicByArtist(@PathVariable String musicArtist)
			throws NoAlbumFoundException {

		return ResponseEntity.ok().body(musicService.getMusicByArtist(musicArtist));
	}

	@GetMapping("/search/year/{musicYear}")
	public ResponseEntity<List<MusicEntity>> getMusicByYear(@PathVariable Long musicYear) throws NoAlbumFoundException {
		return ResponseEntity.ok().body(musicService.getMusicByYear(musicYear));
	}

	@GetMapping("/search/genre/{musicGenre}")
	public ResponseEntity<List<MusicEntity>> getMusicByGenre(@PathVariable String musicGenre)
			throws NoAlbumFoundException {
		return ResponseEntity.ok().body(musicService.getMusicByGenre(musicGenre));
	}

	@GetMapping("/search/title/{musicTitle}")
	public ResponseEntity<List<MusicEntity>> getMusicByName(@PathVariable String musicTitle)
			throws NoAlbumFoundException {
		return ResponseEntity.ok().body(musicService.getMusicByName(musicTitle));
	}

	@PutMapping("/update/{musicId}")
	public ResponseEntity<MusicEntity> updateMusic(@PathVariable int musicId, @RequestBody MusicEntity musicEntity) {
		return ResponseEntity.ok().body(musicService.updateMusic(musicEntity));
	}

	@DeleteMapping("/delete/{musicId}")
	public ResponseEntity<?> deleteMusic(@PathVariable int musicId) {
//		musicService.deleteMusic(musicId);
		return ResponseEntity.ok().body(musicService.deleteMusic(musicId));
	}

	@GetMapping("/search/all")
	public ResponseEntity<List<MusicEntity>> getAllMusic() {
		List<MusicEntity> musicList = musicService.getAllMusic();
		return new ResponseEntity<>(musicList, HttpStatus.OK);
	}

	@GetMapping("/search/id/{musicId}")
	public ResponseEntity<Optional<MusicEntity>> getMusicById(@PathVariable int musicId) throws NoAlbumFoundException {
		return ResponseEntity.ok().body(musicService.getMusicById(musicId));
	}

	@PostMapping("/create")
	public ResponseEntity<MusicEntity> createMusic(@RequestBody MusicEntity music) {
		MusicEntity savedMusic = musicService.saveMusic(music);
		return new ResponseEntity<>(savedMusic, HttpStatus.CREATED);
	}

}