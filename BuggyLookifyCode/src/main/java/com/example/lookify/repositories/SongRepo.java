package com.example.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.lookify.models.Song;

@Repository
public interface SongRepo extends CrudRepository<Song, Long> {
	
	List<Song> findAll();
	
	@Query(value = "SELECT * FROM songs ORDER BY rating DESC limit 10", nativeQuery = true) 
	List<Song> getTopTen();
	
	//List<Song> findTop10ByOrderByRatingDesc(); 
	
	List<Song> findByArtist(String name);
}
