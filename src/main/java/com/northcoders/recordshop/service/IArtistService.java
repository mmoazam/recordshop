package com.northcoders.recordshop.service;

import com.northcoders.recordshop.model.Artist;

import java.util.List;

public interface IArtistService {

    List<Artist> getAllArtists();

    Artist getArtistById(String number);

    Artist createArtist(Artist artist);

    void deleteArtistById(String number);

    Artist updateArtist(Artist artist);

    Artist getArtistByName(String name);

}
