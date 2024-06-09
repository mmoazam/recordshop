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
	CommandLineRunner runner(IAlbumRepository albumRepository) {
		return args -> {
			albumRepository.save(new Album(1L,"Album 1", "Album 1 description", "Artist 1", Genre.ROCK, 2020, 10));
			albumRepository.save(new Album(2L,"Album 2", "Album 2 description", "Artist 2", Genre.POP, 2010, 10));
			albumRepository.save(new Album(3L,"Album 3", "Album 3 description", "Artist 3", Genre.COUNTRY, 2000, 10));
			albumRepository.save(new Album(4L,"Album 4", "Album 4 description", "Artist 4", Genre.BLUES, 1990, 10));
		};
	}
}// end of class

