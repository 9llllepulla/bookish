package com.gllllepulla.repository;

import com.gllllepulla.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select a from Author a where a.authorName in :names")
    List<Author> findAllByNames(@Param("names") Set<String> names);
}
