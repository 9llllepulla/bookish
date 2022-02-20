package com.gllllepulla.service;

import com.gllllepulla.model.Info;

import java.util.Optional;
import java.util.Set;

public interface EditorService {

    Optional<Info.Author> editAuthor(Info.Author author);

    Info.Author createAuthor(Info.Author author);

    Optional<Info.Book> editBook(Info.Book book);

    Info.Book createBook(Info.Book book);

    void deleteAuthorsByIds(Set<Long> ids);

    void deleteBooksByIds(Set<Long> ids);

}
