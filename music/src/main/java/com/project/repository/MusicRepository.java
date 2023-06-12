package com.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.MusicEntity;

public interface MusicRepository extends JpaRepository<MusicEntity, Integer> {
	
	List<MusicEntity> findAllByMusicTitle(String musicTitle);

	List<MusicEntity> findByMusicArtist(String musicArtist);

	List<MusicEntity> findByMusicGenre(String musicGenre);

	List<MusicEntity> findByMusicYear(Long musicYear);
}
