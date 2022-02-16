package com.gllllepulla.repository;

import com.gllllepulla.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // TODO написать запрос поиска списка книг(с дубликатами) по наименованию
    List<Book> findAllByTitles(Set<String> titles);
}
