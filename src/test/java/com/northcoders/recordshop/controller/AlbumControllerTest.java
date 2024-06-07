package com.northcoders.recordshop.controller;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.repository.IAlbumRepository;
import com.northcoders.recordshop.service.AlbumService;
import com.northcoders.recordshop.service.IAlbumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;

class AlbumControllerTest {


    @Mock
    private IAlbumRepository albumRepository;

    @InjectMocks
    private AlbumService albumService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testGetAllAlbums() {
        Album album1 = new Album();
        album1.setId(1L);
        album1.setName("Album 1");
        album1.setDescription("Album 1 description");

        Album album2 = new Album();
        album2.setId(2L);
        album2.setName("Album 2");
        album2.setDescription("Album 2 description");

        when(albumRepository.findAll()).thenReturn(List.of(album1, album2));

        List<Album> result = albumService.getAllAlbums();
        assert result.size() == 2;
        verify(albumRepository, times(1)).findAll();
    }

    @Test
    void testGetAlbumById() {
        Album album = new Album();
        album.setId(1L);
        album.setName("Album 1");
        album.setDescription("Album 1 description");

        when(albumRepository.findById(1L)).thenReturn(java.util.Optional.of(album));

        Album result = albumService.getAlbumById("1");
        assert result.getId() == 1L;
        verify(albumRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateAlbum() {
        Album album = new Album();
        album.setId(1L);
        album.setName("Album 1");
        album.setDescription("Album 1 description");

        when(albumRepository.save(album)).thenReturn(album);

        Album result = albumService.createAlbum(album);
        assert result.getId() == 1L;
        verify(albumRepository, times(1)).save(album);
    }

}// end of class