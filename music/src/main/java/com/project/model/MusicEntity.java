package com.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Music")
public class MusicEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int musicId;

	private String musicTitle;
	private String musicArtist;
	private String musicGenre;
	private Long musicYear;
	private String musicDescription;

	public MusicEntity() {
		// TODO Auto-generated constructor stub
	}

	public MusicEntity(int musicId, String musicTitle, String musicArtist, String musicGenre, Long musicYear,
			String musicDescription) {
		super();
		this.musicId = musicId;
		this.musicTitle = musicTitle;
		this.musicArtist = musicArtist;
		this.musicGenre = musicGenre;
		this.musicYear = musicYear;
		this.musicDescription = musicDescription;
	}

	public int getMusicId() {
		return musicId;
	}

	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}

	public String getMusicTitle() {
		return musicTitle;
	}

	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}

	public String getMusicArtist() {
		return musicArtist;
	}

	public void setMusicArtist(String musicArtist) {
		this.musicArtist = musicArtist;
	}

	public String getMusicGenre() {
		return musicGenre;
	}

	public void setMusicGenre(String musicGenre) {
		this.musicGenre = musicGenre;
	}

	public Long getMusicYear() {
		return musicYear;
	}

	public void setMusicYear(Long musicYear) {
		this.musicYear = musicYear;
	}

	public String getMusicDescription() {
		return musicDescription;
	}

	public void setMusicDescription(String musicDescription) {
		this.musicDescription = musicDescription;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
