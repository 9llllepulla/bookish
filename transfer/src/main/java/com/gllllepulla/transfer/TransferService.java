package com.gllllepulla.transfer;

import com.gllllepulla.model.Dto;
import com.gllllepulla.model.Info;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TransferService {

    List<Dto.Author> findAllAuthors();

    Optional<Dto.Author> findAuthorById(Long id);

    List<Dto.Author> findAllAuthorsByNames(Set<String> names);

    List<Dto.Book> findAllBooksByTitles(Set<String> titles);

    List<Dto.Author> findAuthorsByBookId(Long bookId);

    Dto.Author createAuthor(Info.Author authorInfo);

    Dto.Book createBook(Info.Book bookView);

    void deleteAuthorsById(Set<Long> ids);

    void deleteBooksById(Set<Long> ids);

    List<Dto.Book> findAllBooks();

    Optional<Dto.Book> findBookById(Long bookId);

    List<Dto.Book> findBooksByAuthorId(Long authorId);
}
