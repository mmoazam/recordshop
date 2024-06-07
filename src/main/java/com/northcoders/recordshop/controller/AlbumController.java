package com.northcoders.recordshop.controller;

import com.northcoders.recordshop.model.Album;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



} // end of AlbumController
