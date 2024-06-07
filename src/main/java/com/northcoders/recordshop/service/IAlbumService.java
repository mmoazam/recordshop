package com.northcoders.recordshop.service;

import com.northcoders.recordshop.model.Album;

import java.util.List;

public interface IAlbumService {

    List<Album> getAllAlbums();

    Album getAlbumById(String number);

    Album createAlbum(Album album);
}
