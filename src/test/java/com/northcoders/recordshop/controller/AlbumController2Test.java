package com.northcoders.recordshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.Genre;
import com.northcoders.recordshop.repository.IAlbumRepository;
import com.northcoders.recordshop.service.IAlbumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AlbumController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class AlbumController2Test {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IAlbumRepository albumRepository;

    @MockBean
    private IAlbumService albumServiceBean;

    @Autowired
    private ObjectMapper objectMapper;

    private Album album;

    @BeforeEach
    public void init() {
        album = new Album();
        album.setId(1L);
        album.setName("Album 1");
        album.setArtist("Artist 1");
        album.setGenre(Genre.ROCK);
        album.setStockLevel(10);
        album.setReleaseYear(2000);
        album.setDescription("Album 1 description");
    }

    @Test
    public void AlbumController_CreateAlbum() throws Exception {

        mockMvc.perform(post("/api/v1/albums")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(album)))
                .andExpect(status().isCreated());
    }

}
