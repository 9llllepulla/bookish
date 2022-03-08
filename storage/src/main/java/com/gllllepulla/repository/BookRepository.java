package com.gllllepulla.repository;

import com.gllllepulla.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where b.title in :titles")
    List<Book> findAllByTitles(@Param("titles") Set<String> titles);
}
