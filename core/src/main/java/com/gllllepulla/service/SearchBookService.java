package com.gllllepulla.service;

import com.gllllepulla.transfer.Info;

import java.util.Optional;
import java.util.Set;

public interface SearchBookService {

    Set<Info.Book> getAllBooks();

    Optional<Info.Book> findBookById(Long id);

    Set<Info.Book> findBooksByTitles(Set<String> titles);

    Set<Info.Book> findBooksByAuthorsNames(Set<String> names);
}
