package com.northcoders.recordshop.repository;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.Genre;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class IAlbumRepositoryTest {

    @Autowired
    private IAlbumRepository albumRepository;

    @BeforeEach
    void setUp() {
        albumRepository.deleteAll();
    }

    @Test
    void findByNameContainingIgnoreCase() {
        Album album = Album.builder()
                .id(1L)
                .name("Album1")
                .releaseYear(2000)
                .artist("Artist1")
                .description("Description1")
                .stockLevel(10)
                .genre(Genre.ROCK)
                .build();
        Album savedAlbum = albumRepository.save(album);

        assertNotNull(savedAlbum);
        assertNotNull(albumRepository.findByNameContainingIgnoreCase("album1"));
        assertEquals("Album1", albumRepository.findByNameContainingIgnoreCase("album1").getFirst().getName());
        assertEquals(1, albumRepository.findByNameContainingIgnoreCase("album1").size());
    }

    @Test
    void findByArtistContainingIgnoreCase() throws NoSuchElementException {
        Album album = Album.builder()
                .name("Album1")
                .releaseYear(2000)
                .artist("Artist1")
                .description("Description1")
                .stockLevel(10)
                .genre(Genre.ROCK)
                .build();

        Album album2 = Album.builder()
                .name("Album2")
                .releaseYear(2000)
                .artist("Artist2")
                .description("Description2")
                .stockLevel(10)
                .genre(Genre.ROCK)
                .build();
        Album savedAlbum = albumRepository.save(album);
        Album savedAlbum2 = albumRepository.save(album2);

        assertNotNull(albumRepository.findByArtistContainingIgnoreCase("artist1"));
        assertEquals("Artist1", albumRepository.findByArtistContainingIgnoreCase("artist1").getFirst().getArtist());
        assertEquals(2, albumRepository.findByArtistContainingIgnoreCase("artist").size());
    }

    @Test
    void findByReleaseYear() {
        Album album = Album.builder()
                .name("Album1")
                .releaseYear(2000)
                .artist("Artist1")
                .description("Description1")
                .stockLevel(10)
                .genre(Genre.ROCK)
                .build();

        Album album2 = Album.builder()
                .name("Album2")
                .releaseYear(2000)
                .artist("Artist2")
                .description("Description2")
                .stockLevel(10)
                .genre(Genre.ROCK)
                .build();

        Album album3 = Album.builder()
                .name("Album3")
                .releaseYear(2010)
                .artist("Artist3")
                .description("Description3")
                .stockLevel(10)
                .genre(Genre.ROCK)
                .build();


        Album savedAlbum = albumRepository.save(album);
        Album savedAlbum2 = albumRepository.save(album2);
        Album savedAlbum3 = albumRepository.save(album3);

        assertNotNull(albumRepository.findByReleaseYear(2000));
        assertEquals(2, albumRepository.findByReleaseYear(2000).size());
    }

    @Test
    void findByGenre() {
        Album album = Album.builder()
                .name("Album1")
                .releaseYear(2000)
                .artist("Artist1")
                .description("Description1")
                .stockLevel(10)
                .genre(Genre.COUNTRY)
                .build();

        Album album2 = Album.builder()
                .name("Album2")
                .releaseYear(2000)
                .artist("Artist2")
                .description("Description2")
                .stockLevel(10)
                .genre(Genre.ROCK)
                .build();

        Album album3 = Album.builder()
                .name("Album3")
                .releaseYear(2010)
                .artist("Artist3")
                .description("Description3")
                .stockLevel(10)
                .genre(Genre.ROCK)
                .build();


        Album savedAlbum = albumRepository.save(album);
        Album savedAlbum2 = albumRepository.save(album2);
        Album savedAlbum3 = albumRepository.save(album3);

        assertNotNull(albumRepository.findByGenre(Genre.ROCK));
        assertEquals(2, albumRepository.findByGenre(Genre.ROCK).size());
        assertEquals(1, albumRepository.findByGenre(Genre.COUNTRY).size());
    }

    @Test
    void findByStockLevelGreaterThan() {
        Album album = Album.builder()
                .name("Album1")
                .releaseYear(2000)
                .artist("Artist1")
                .description("Description1")
                .stockLevel(10)
                .genre(Genre.COUNTRY)
                .build();

        Album album2 = Album.builder()
                .name("Album2")
                .releaseYear(2000)
                .artist("Artist2")
                .description("Description2")
                .stockLevel(20)
                .genre(Genre.ROCK)
                .build();

        Album album3 = Album.builder()
                .name("Album3")
                .releaseYear(2010)
                .artist("Artist3")
                .description("Description3")
                .stockLevel(10)
                .genre(Genre.ROCK)
                .build();


        Album savedAlbum = albumRepository.save(album);
        Album savedAlbum2 = albumRepository.save(album2);
        Album savedAlbum3 = albumRepository.save(album3);

        assertNotNull(albumRepository.findByStockLevelGreaterThan(19));
        assertEquals(1, albumRepository.findByStockLevelGreaterThan(10).size());
        assertEquals(3, albumRepository.findByStockLevelGreaterThan(5).size());

    }

    @Test
    void findByStockLevelLessThan() {
        Album album = Album.builder()
                .name("Album1")
                .releaseYear(2000)
                .artist("Artist1")
                .description("Description1")
                .stockLevel(10)
                .genre(Genre.COUNTRY)
                .build();

        Album album2 = Album.builder()
                .name("Album2")
                .releaseYear(2000)
                .artist("Artist2")
                .description("Description2")
                .stockLevel(20)
                .genre(Genre.ROCK)
                .build();

        Album album3 = Album.builder()
                .name("Album3")
                .releaseYear(2010)
                .artist("Artist3")
                .description("Description3")
                .stockLevel(5)
                .genre(Genre.ROCK)
                .build();


        Album savedAlbum = albumRepository.save(album);
        Album savedAlbum2 = albumRepository.save(album2);
        Album savedAlbum3 = albumRepository.save(album3);

        assertNotNull(albumRepository.findByStockLevelLessThan(30));
        assertEquals(2, albumRepository.findByStockLevelLessThan(20).size());
        assertEquals(1, albumRepository.findByStockLevelLessThan(10).size());
    }
}