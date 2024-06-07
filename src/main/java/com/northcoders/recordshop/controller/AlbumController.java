package com.northcoders.recordshop.controller;

import com.northcoders.recordshop.model.Album;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/albums")
public class AlbumController {

    @GetMapping("")
    public List<Album> getAllAlbums() {
        return List.of(new Album(), new Album());
    } // end of getAllAlbums

    @GetMapping("/{id}")
    public Album getAlbumById(
            @PathVariable("id") String id
    ) {
        return new Album();
    }

    @PostMapping("")
    public Album createAlbum(
            @RequestBody Album album
    ) {
        return album;
    }


} // end of AlbumController
