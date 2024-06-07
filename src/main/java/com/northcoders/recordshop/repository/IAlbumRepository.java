package com.northcoders.recordshop.repository;

import com.northcoders.recordshop.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlbumRepository extends JpaRepository<Album, Long> {

}
