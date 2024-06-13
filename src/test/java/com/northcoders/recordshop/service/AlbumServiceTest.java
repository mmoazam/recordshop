package com.northcoders.recordshop.service;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.repository.IAlbumRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        // Arrange
        Album album = new Album();
        album.setId(1L);
        album.setName("Album 1");
        album.setDescription("Album 1 description");
        // Act
        Album createdAlbum = albumService.createAlbum(album);
        // Assert
        //assertNotNull(createdAlbum);
        assertEquals(1L, createdAlbum.getId());
        assertEquals("Album 1", createdAlbum.getName());
        assertEquals("Album 1 description", createdAlbum.getDescription());
    }

    @Test
    void getAlbumByName() {
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