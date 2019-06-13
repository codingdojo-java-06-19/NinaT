package com.ninatompkin.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ninatompkin.lookify.models.Song;
import com.ninatompkin.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepo;
	
	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;
	}
	
	//returns all the Songs
	public List<Song> allSongs(){
		return songRepo.findAll();
	}
	
	//creates a Song
	public Song addSong(Song song) {
		return songRepo.save(song);
	}
	
	//retrieves a song
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}
		else {
			return null;
		}
	}
	
	//updates a song
	public Song updateSong(Long id, String title, String artist, Integer rating) {
		Song songFromDB = songRepo.findById(id).get();
		songFromDB.setTitle(title);
		songFromDB.setArtist(artist);
		songFromDB.setRating(rating);
		return songRepo.save(songFromDB);
	}
	
	
}
