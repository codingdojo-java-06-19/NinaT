package com.ninatompkin.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ninatompkin.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song> findAll();
	List<Song> findByArtistContaining(String search);
	List<Song> findTop10ByOrderByRatingDesc();
}
