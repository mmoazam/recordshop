package com.northcoders.recordshop.service;

import com.northcoders.recordshop.exception.BadRequestException;
import com.northcoders.recordshop.model.Album;

import java.util.List;

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


}
