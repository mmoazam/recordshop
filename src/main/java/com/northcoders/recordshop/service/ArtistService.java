package com.northcoders.recordshop.service;

import com.northcoders.recordshop.model.Artist;
import com.northcoders.recordshop.repository.IArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService implements IArtistService {

    private final IArtistRepository artistRepository;

    @Autowired
    public ArtistService(IArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> getAllArtists() {
        return List.of();
    }

    @Override
    public Artist getArtistById(String number) {
        return artistRepository.findById(Long.parseLong(number)).orElse(null);
    }

    @Override
    public Artist createArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public void deleteArtistById(String number) {
        artistRepository.deleteById(Long.parseLong(number));
    }

    @Override
    public Artist updateArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public Artist getArtistByName(String name) {
        return artistRepository.findByName(name);
    }
}
