package com.northcoders.recordshop.controller;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.repository.IAlbumRepository;
import com.northcoders.recordshop.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/albums")
public class AlbumController {

    @Autowired
    IAlbumService albumService;

    @GetMapping("")
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    } // end of getAllAlbums

    @GetMapping("/{id}")
    public Album getAlbumById(
            @PathVariable("id") String id
    ) {
        return  albumService.getAlbumById(id);
    }

    @GetMapping("/name/{name}")
    public List<Album> getAlbumByName(
            @PathVariable("name") String name
    ) {
        return  albumService.getAlbumByName(name);
    }

    @GetMapping("/name/artist/{name}")
    public List<Album> getAlbumByArtistName(
            @PathVariable("name") String name
    ) {
        return  albumService.getAlbumByArtist(name);
    }

    @GetMapping("/year/{year}")
    public List<Album> getAlbumByReleaseYear(
            @PathVariable("year") int year
    ) {
        return  albumService.getAlbumByReleaseYear(year);
    }

    @GetMapping("/genre/{genre}")
    public List<Album> getAlbumByGenre(
            @PathVariable("genre") String genre
    ) {
        return  albumService.getAlbumByGenre(genre.toUpperCase());
    }

    @GetMapping("/in_stock")
    public List<Album> getAlbumsInStock() {
        return  albumService.getAllAlbumsInStock();
    }

    @PostMapping("")
    public Album createAlbum(
            @RequestBody Album album
    ) {
        return albumService.createAlbum(album);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Album> deleteAlbum(
            @PathVariable("id") String id
    ) {
        // check if id is integer
        if (!id.matches("[0-9]+")) {
            return null;
        }
        albumService.deleteAlbumById(id);

        return null;
    }
} // end of AlbumController
