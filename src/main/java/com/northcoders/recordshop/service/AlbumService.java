package com.northcoders.recordshop.service;

import com.northcoders.recordshop.exception.ResourceNotFoundException;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.Genre;
import com.northcoders.recordshop.repository.IAlbumRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Album getAlbumById(long number) {
        return albumRepository.findById(number).orElseThrow(() -> new ResourceNotFoundException("Album with Id " + number + " not found"));
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


    @Override
    public void deleteAlbumById(long id) {
        if (!albumRepository.existsById(id)) {
            throw new ResourceNotFoundException("Album with Id " + id + " not found");
        }
        albumRepository.deleteById(id);
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


    @Override
    public Album addOrUpdateAlbum(Album album) {
        if(album.getStockLevel() < 0) {
            throw new IllegalArgumentException("Stock level cannot be less than 0");
        }
        if(album.getReleaseYear() < 0) {
            throw new IllegalArgumentException("Release year cannot be less than 0");
        }

        if(album.getGenre() == null) {
            album.setGenre(Genre.OTHER);
        }

        return albumRepository.save(album);
    }


    @Override
    @Transactional
    public Optional<Album> updateAlbum(Long id, Map<String, Object> updates) {
        Optional<Album> albumOpt = albumRepository.findById(id);
        if (albumOpt.isPresent()) {
            Album album = albumOpt.get();
            updates.forEach((key, value) -> {
                switch (key) {
                    case "name":
                        album.setName((String) value);
                        break;
                    case "description":
                        album.setDescription((String) value);
                        break;
                    case "artist":
                        album.setArtist((String) value);
                        break;
                    case "genre":
                        album.setGenre(Genre.valueOf((String) value));
                        break;
                    case "releaseYear":
                        album.setReleaseYear((int) value);
                        break;
                    case "stockLevel":
                        album.setStockLevel((int) value);
                        break;
                    default:
                        break;}
            });
            return Optional.of(albumRepository.save(album));
        }
        return Optional.empty();
    }

}
