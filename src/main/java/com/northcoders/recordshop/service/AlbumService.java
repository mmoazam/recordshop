package com.northcoders.recordshop.service;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.Genre;
import com.northcoders.recordshop.repository.IAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;

@Service
public class AlbumService implements IAlbumService {

    private final IAlbumRepository albumRepository;

    @Autowired
    public AlbumService(IAlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }




    @Override
    public Album getAlbumById(String number) {
        return albumRepository.findById(Long.parseLong(number)).orElse(null);
    }

    @Override
    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public List<Album> getAlbumByName(String name) {
        return albumRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Album> getAlbumByArtist(String artist) {
        return albumRepository.findByArtistContainingIgnoreCase(artist);
    }

    @Override
    public List<Album> getAlbumByReleaseYear(int year) {
        return albumRepository.findByReleaseYear(year);
    }

    @Override
    public List<Album> getAlbumByGenre(String genre) {
        return albumRepository.findByGenre(Genre.valueOf(genre));
    }

    @Override
    public Album updateAlbum(Album album) {
        return null;
    }


    // delete album by ID
    @Override
    public void deleteAlbumById(String id) {
         albumRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public List<Album> getAllAlbumsInStock() {
        return albumRepository.findByStockLevelGreaterThan(0);
    }
}
