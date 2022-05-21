package com.gllllepulla.transfer.impl;

import com.gllllepulla.entities.Author;
import com.gllllepulla.entities.Book;
import com.gllllepulla.mapper.AuthorMapper;
import com.gllllepulla.mapper.BookMapper;
import com.gllllepulla.repository.AuthorRepository;
import com.gllllepulla.repository.BookAuthorRepository;
import com.gllllepulla.repository.BookRepository;
import com.gllllepulla.model.Dto;
import com.gllllepulla.model.Info;
import com.gllllepulla.transfer.TransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/**
 * Service for transfer DTO's between layers
 */
@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
class TransferServiceImpl implements TransferService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final BookAuthorRepository bookAuthorRepository;
    private final AuthorMapper authorMapper;
    private final BookMapper bookMapper;

    @Override
    public List<Dto.Author> findAllAuthors() {
        return authorRepository.findAll().stream()
                .map(authorMapper::toAuthorDto)
                .collect(toList());
    }

    @Override
    public Optional<Dto.Author> findAuthorById(Long id) {
        return authorRepository.findById(id)
                .map(authorMapper::toAuthorDto);
    }

    @Override
    public List<Dto.Author> findAllAuthorsByNames(Set<String> names) {
        return authorRepository.findAllByNames(names).stream()
                .map(authorMapper::toAuthorDto)
                .collect(toList());
    }

    @Override
    public List<Dto.Book> findAllBooksByTitles(Set<String> titles) {
        return bookRepository.findAllByTitles(titles).stream()
                .map(bookMapper::toBookDto)
                .collect(toList());
    }

    @Override
    public List<Dto.Author> findAuthorsByBookId(Long bookId) {
        return bookAuthorRepository.findAuthorsByBookId(bookId).stream()
                .map(authorMapper::toAuthorDto)
                .collect(toList());
    }

    @Override
    public Dto.Author createAuthor(Info.Author authorInfo) {
        Author author = authorMapper.toAuthor(authorInfo);
        Author repositoryAuthor = authorRepository.saveAndFlush(author);
        return authorMapper.toAuthorDto(repositoryAuthor);
    }

    @Override
    public Dto.Book createBook(Info.Book bookInfo) {
        Book book = bookMapper.toBook(bookInfo);
        Book repositoryBook = bookRepository.saveAndFlush(book);
        return bookMapper.toBookDto(repositoryBook);
    }

    @Override
    public void deleteAuthorsById(Set<Long> ids) {
        List<Author> authors = authorRepository.findAllById(ids);
        authorRepository.deleteAllInBatch(authors);
    }

    @Override
    public void deleteBooksById(Set<Long> ids) {
        List<Book> books = bookRepository.findAllById(ids);
        bookRepository.deleteAllInBatch(books);
    }

    @Override
    public List<Dto.Book> findAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toBookDto)
                .collect(toList());
    }

    @Override
    public Optional<Dto.Book> findBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .map(bookMapper::toBookDto);
    }

    @Override
    public List<Dto.Book> findBooksByAuthorId(Long authorId) {
        return bookAuthorRepository.findBooksByAuthorId(authorId).stream()
                .map(bookMapper::toBookDto)
                .collect(toList());
    }

}
