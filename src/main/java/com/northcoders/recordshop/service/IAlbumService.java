package com.northcoders.recordshop.service;

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


}

/*
*   list all albums in stock
    get album by id
    list all albums by a given artist
    list all albums by a given release year
    list all albums by a given genre
    get album information by album name
    add new albums into the database
    update album details
    delete albums from the database
* */