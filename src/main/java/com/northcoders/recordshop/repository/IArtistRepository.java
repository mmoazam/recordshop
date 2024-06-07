package com.northcoders.recordshop.repository;

import com.northcoders.recordshop.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArtistRepository extends JpaRepository<Artist, Long> {

    Artist findByName(String name);
}
