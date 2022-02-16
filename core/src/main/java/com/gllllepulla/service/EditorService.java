package com.gllllepulla.service;

import com.gllllepulla.transfer.View;

import java.util.Optional;
import java.util.Set;

public interface EditorService {

    Optional<View.Author> editAuthor(View.Author author);

    View.Author createAuthor(View.Author author);

    Optional<View.Book> editBook(View.Book book);

    View.Book createBook(View.Book book);

    void deleteAuthorsByIds(Set<Long> ids);

    void deleteBooksByIds(Set<Long> ids);

}
