package com.northcoders.recordshop.controller;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.repository.IAlbumRepository;
import com.northcoders.recordshop.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("")
    public Album createAlbum(
            @RequestBody Album album
    ) {
        return albumService.createAlbum(album);
    }


} // end of AlbumController
