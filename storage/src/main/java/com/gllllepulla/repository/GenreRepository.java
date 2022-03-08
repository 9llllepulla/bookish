package com.gllllepulla.repository;

import com.gllllepulla.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query("select g.genreName from Genre g where g.genreName = :genreName")
    Optional<Genre> findByName(@Param("genreName") String genreName);
}
