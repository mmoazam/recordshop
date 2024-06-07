package com.northcoders.recordshop;

import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.Artist;
import com.northcoders.recordshop.model.Genre;
import com.northcoders.recordshop.repository.IAlbumRepository;
import com.northcoders.recordshop.repository.IArtistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RecordShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecordShopApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadArtists(IArtistRepository artistRepository) {
		return (args -> {
			artistRepository.save(new Artist(1L,"Pink Floyd", "The best band ever!",null));
			artistRepository.save(new Artist(2L,"The Rolling Stones","The best band ever!",null));
			artistRepository.save(new Artist(3L,"Led Zeppelin","The best band ever!",null));
			artistRepository.save(new Artist(4L,"AC/DC","The best band ever!",null));
			artistRepository.save(new Artist(6L,"The Doors","The best band ever!",null));
			artistRepository.save(new Artist(7L,"Queen","The best band ever!",null));
			artistRepository.save(new Artist(8L,"Eagles","The best band ever!",null));
			artistRepository.save(new Artist(9L,"Nirvana","The best band ever!",null));
			artistRepository.save(new Artist(10L,"Pearl Jam","The best band ever!",null));
			artistRepository.save(new Artist(11L,"Red Hot Chili Peppers","The best band ever!",null));
			artistRepository.save(new Artist(12L,"The Beatles","The best band ever!",null));
		});
	}

	@Bean
	public CommandLineRunner loadGenres(IAlbumRepository albumRepository) {
		return (args) -> {
			albumRepository.save(new Album(1L, "The Wall", "The best album ever!",null, Genre.ROCK, 1979, 100));
			albumRepository.save(new Album(2L, "Led Zeppelin IV", "The best album ever!",null, Genre.ROCK, 1971, 100));
			albumRepository.save(new Album(3L, "Abbey Road", "The best album ever!",null, Genre.ROCK, 1969, 100));
			albumRepository.save(new Album(4L, "The Doors", "The best album ever!",null, Genre.ROCK, 1967, 100));
			albumRepository.save(new Album(5L, "Abbey Road", "The best album ever!",null, Genre.ROCK, 1969, 100));
			albumRepository.save(new Album(6L, "The Doors", "The best album ever!",null, Genre.ROCK, 1967, 100));
		};
	}
}

