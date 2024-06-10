package com.northcoders.recordshop.controller;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/albums")
public class AlbumController {

    @Autowired
    IAlbumService albumService;

    @GetMapping("")
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> albums = albumService.getAllAlbums();
        return ResponseEntity.ok(albums);
    } // end of getAllAlbums


    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(
            @PathVariable("id") Long id
    ) {
        Album album = albumService.getAlbumById(id);
        return ResponseEntity.ok(album);
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<List<Album>> getAlbumByName(
            @PathVariable("name") String name
    ) {
       List<Album> albums = albumService.getAlbumByName(name);
       return ResponseEntity.ok(albums);
    }

    @GetMapping("/name/artist/{name}")
    public ResponseEntity<List<Album>> getAlbumByArtistName(
            @PathVariable("name") String name
    ) {
         return ResponseEntity.ok(albumService.getAlbumByArtist(name));
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Album>> getAlbumByReleaseYear(
            @PathVariable("year") int year
    ) {
        return ResponseEntity.ok(albumService.getAlbumByReleaseYear(year));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Album>> getAlbumByGenre(
            @PathVariable("genre") String genre
    ) {
        return ResponseEntity.ok(albumService.getAlbumByGenre(genre.toUpperCase()));
    }

    @GetMapping("/stock")
    public ResponseEntity<List<Album>>getAlbumsInStock() {
        return ResponseEntity.ok().body(albumService.getAllAlbumsInStock());
    }

    @GetMapping("/stock_level_below/{stock_level}")
    public ResponseEntity<List<Album>> getAlbumsByStockLevelBelow(
            @PathVariable("stock_level") int stock_level
    ) {
        return ResponseEntity.ok().body(albumService.getAlbumsWithStockLevelLessThan(stock_level));
    }


    @GetMapping("/stock/")
    public ResponseEntity<List<Album>> getAlbumsByStockLevelAbove(
            @RequestParam("stock_level_above") int stock_level_above
    ) {
        return ResponseEntity.ok().body(albumService.getAlbumsWithStockLevelGreaterThan(stock_level_above));
    }

    @PostMapping("")
    public ResponseEntity<Album>  addOrUpdateAlbum(
            @RequestBody Album album
    ) {
        return ResponseEntity.ok().body(albumService.addOrUpdateAlbum(album));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Album> deleteAlbumById(
            @PathVariable("id") long id
    ) {
        albumService.deleteAlbumById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> updateAlbum(
            @PathVariable("id") long id,
            @RequestBody Album albumDetails
    ) {
        Album album = albumService.getAlbumById(id);

        if (albumDetails.getName() != null) {
            album.setName(albumDetails.getName());
        }
        if (albumDetails.getArtist() != null) {
            album.setArtist(albumDetails.getArtist());
        }

        album.setReleaseYear(albumDetails.getReleaseYear());

        album.setGenre(albumDetails.getGenre());

        if (albumDetails.getStockLevel() >= 0) {
            album.setStockLevel(albumDetails.getStockLevel());
        }

        return ResponseEntity.ok(albumService.addOrUpdateAlbum(album));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Optional<Album>> updateAlbum(
            @PathVariable("id") long id,
            @RequestBody Map<String, Object> updates
    ) {
        return ResponseEntity.ok(albumService.updateAlbum(id, updates));
    }

} // end of AlbumController
