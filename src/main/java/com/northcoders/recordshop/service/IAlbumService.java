package com.northcoders.recordshop.service;

import com.northcoders.recordshop.exception.BadRequestException;
import com.northcoders.recordshop.model.Album;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IAlbumService {

    List<Album> getAllAlbums();

    Album getAlbumById(long number);

    Album createAlbum(Album album);

    List<Album> getAlbumByName(String name);

    List<Album> getAlbumByArtist(String artist);

    List<Album> getAlbumByReleaseYear(int year);

    List<Album> getAlbumByGenre(String genre);

    Album updateAlbum(Album album);

    void deleteAlbumById(long id);

    List<Album> getAllAlbumsInStock();

    List<Album> getAlbumsWithStockLevelLessThan(int level);

    List<Album> getAlbumsWithStockLevelGreaterThan(int stockLevel);

    Album addOrUpdateAlbum(Album album);

    @Transactional
    Optional<Album> updateAlbum(Long id, Map<String, Object> updates);
}
