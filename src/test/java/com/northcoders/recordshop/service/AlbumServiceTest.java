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
import java.util.Optional;

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
        Album album = new Album();
        album.setId(1L);
        album.setName("Album 1");
        album.setArtist("Artist 1");
        album.setStockLevel(10);
        album.setReleaseYear(2000);
        album.setDescription("Album 1 description");
        album.setGenre(Genre.ROCK);
        when(albumRepository.findAll()).thenReturn(List.of(album));

        // Act
        List<Album> albums = albumService.getAllAlbums();
        // Assert
        assertNotNull(albums);
        assertEquals(1, albums.size());

    }

    @Test
    void getAlbumById() {
        Album album = new Album();
        album.setId(1L);
        album.setName("Album 1");
        album.setArtist("Artist 1");
        album.setStockLevel(10);
        album.setReleaseYear(2000);
        album.setDescription("Album 1 description");
        album.setGenre(Genre.ROCK);

        when(albumRepository.findById(1L)).thenReturn(Optional.of(album));

        Album foundAlbum = albumService.getAlbumById(1L);
        assertNotNull(foundAlbum);
        assertEquals("Album 1", foundAlbum.getName());
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
    void AlbumService_getAlbumByArtist_ReturnsAlbum() {
        Album album = new Album();
        album.setId(1L);
        album.setName("Album 1");
        album.setArtist("Artist 1");
        album.setStockLevel(10);
        album.setReleaseYear(2000);
        album.setDescription("Album 1 description");
        album.setGenre(Genre.ROCK);

        when(albumRepository.findByArtistContainingIgnoreCase("artist")).thenReturn(List.of(album));

        List<Album> foundAlbums = albumService.getAlbumByArtist("artist");

        assertNotNull(foundAlbums);
        assertEquals(1, foundAlbums.size());
        assertEquals("Album 1", foundAlbums.getFirst().getName());
        assertEquals("Artist 1", foundAlbums.getFirst().getArtist());

    }

    @Test
    void getAlbumByReleaseYear() {
        Album album = new Album();
        album.setId(1L);
        album.setName("Album 1");
        album.setArtist("Artist 1");
        album.setStockLevel(10);
        album.setReleaseYear(2000);
        album.setDescription("Album 1 description");
        album.setGenre(Genre.ROCK);


        when(albumRepository.findByReleaseYear(2000)).thenReturn(List.of(album));

        List<Album> foundAlbums = albumService.getAlbumByReleaseYear(2000);

        assertNotNull(foundAlbums);
        assertEquals(1, foundAlbums.size());
        assertEquals("Album 1", foundAlbums.getFirst().getName());
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