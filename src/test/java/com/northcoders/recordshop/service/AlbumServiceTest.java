package com.northcoders.recordshop.service;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.Genre;
import com.northcoders.recordshop.repository.IAlbumRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlbumServiceTest {

    @Mock
    private IAlbumRepository albumRepository;

    @InjectMocks
    private AlbumService albumService;

    @Test
    void AlbumService_getAllAlbums_ReturnsAlbums() {
        // Arrange

        // Act
        List<Album> albums = albumService.getAllAlbums();
        // Assert
        assertNotNull(albums);
    }

    @Test
    void getAlbumById() {
    }

    @Test
    void AlbumService_createAlbum_ReturnsAlbum() {
        Album album = new Album();
        album.setId(1L);
        album.setName("Album 1");
        album.setArtist("Artist 1");
        album.setStockLevel(10);
        album.setReleaseYear(2000);
        album.setDescription("Album 1 description");
        album.setGenre(Genre.ROCK);

        when(albumRepository.save(album)).thenReturn(album);

        Album createdAlbum = albumService.createAlbum(album);

        assertNotNull(createdAlbum);
        assertEquals(1L, createdAlbum.getId());
        assertEquals("Album 1", createdAlbum.getName());
        assertEquals("Album 1 description", createdAlbum.getDescription());
    }

    @Test
    void AlbumService_getAlbumByName_ReturnsAlbum() {
        Album album = new Album();
        album.setId(1L);
        album.setName("Album 1");
        album.setArtist("Artist 1");
        album.setStockLevel(10);
        album.setReleaseYear(2000);
        album.setDescription("Album 1 description");
        album.setGenre(Genre.ROCK);

        when(albumRepository.findByNameContainingIgnoreCase("album")).thenReturn(List.of(album));

        List<Album> foundAlbums = albumService.getAlbumByName("album");

        assertNotNull(foundAlbums);
        assertEquals(1, foundAlbums.size());
        assertEquals("Album 1", foundAlbums.getFirst().getName());

    }

    @Test
    void getAlbumByArtist() {


    }

    @Test
    void getAlbumByReleaseYear() {
    }

    @Test
    void getAlbumByGenre() {
    }

    @Test
    void updateAlbum() {
    }

    @Test
    void deleteAlbumById() {
    }

    @Test
    void getAllAlbumsInStock() {
    }

    @Test
    void getAlbumsWithStockLevelLessThan() {
    }

    @Test
    void getAlbumsWithStockLevelGreaterThan() {
    }

    @Test
    void addOrUpdateAlbum() {
    }

    @Test
    void testUpdateAlbum() {
    }
}