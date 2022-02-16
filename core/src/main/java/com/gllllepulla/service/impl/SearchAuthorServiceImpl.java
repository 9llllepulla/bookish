package com.gllllepulla.service.impl;

import com.gllllepulla.entities.Book;
import com.gllllepulla.mapper.AuthorMapper;
import com.gllllepulla.repository.AuthorRepository;
import com.gllllepulla.repository.BookAuthorRepository;
import com.gllllepulla.repository.BookRepository;
import com.gllllepulla.service.SearchAuthorService;
import com.gllllepulla.transfer.View;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@RequiredArgsConstructor
@Service
class SearchAuthorServiceImpl implements SearchAuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final BookAuthorRepository bookAuthorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public Set<View.Author> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(authorMapper::toAuthorView)
                .collect(toSet());
    }

    @Override
    public Optional<View.Author> findAuthorById(Long id) {
        return authorRepository.findById(id)
                .map(authorMapper::toAuthorView);
    }

    @Override
    public Set<View.Author> findAuthorsByNames(Set<String> names) {
        return authorRepository.findAllByNames(names).stream()
                .map(authorMapper::toAuthorView)
                .collect(toSet());
    }

    @Override
    public Set<View.Author> findAuthorsByBookTitles(Set<String> titles) {
        return bookRepository.findAllByTitles(titles).stream()
                .map(Book::getId)
                .map(bookAuthorRepository::findAuthorsByBookId)
                .flatMap(authors -> authors.stream()
                        .map(authorMapper::toAuthorView))
                .collect(toSet());
    }
}
