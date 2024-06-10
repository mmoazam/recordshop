package com.northcoders.recordshop.service;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.Genre;
import com.northcoders.recordshop.repository.IAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return albumRepository.findById(Long.parseLong(number)).orElseThrow(() -> new IllegalArgumentException("Album with Id " + number + " not found"));
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
        return albumRepository.save(album);
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

    @Override
    public List<Album> getAlbumsWithStockLevelLessThan(int level) {
        return albumRepository.findByStockLevelLessThan(level);
    }

    @Override
    public List<Album> getAlbumsWithStockLevelGreaterThan(int stockLevel) {
        return albumRepository.findByStockLevelGreaterThan(stockLevel);
    }

}
