package com.northcoders.recordshop.repository;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findByNameContainingIgnoreCase(String name);

    List<Album> findByArtistContainingIgnoreCase(String artist);

    List<Album> findByReleaseYear(int year);

    List<Album> findByGenre(Genre genre);
}
