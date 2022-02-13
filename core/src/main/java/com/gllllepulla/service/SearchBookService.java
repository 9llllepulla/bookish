package com.gllllepulla.service;

import com.gllllepulla.transfer.View;

import java.util.Optional;
import java.util.Set;

public interface SearchBookService {

    Set<View.Book> getAllBooks();

    Optional<View.Book> findBookById(Long id);

    Set<View.Book> findBooksByTitles(Set<String> titles);

    Set<View.Book> findBooksByAuthorsNames(Set<String> names);
}
