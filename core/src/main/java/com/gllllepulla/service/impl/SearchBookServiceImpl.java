package com.gllllepulla.service.impl;

import com.gllllepulla.entities.Author;
import com.gllllepulla.mapper.BookMapper;
import com.gllllepulla.repository.AuthorRepository;
import com.gllllepulla.repository.BookAuthorRepository;
import com.gllllepulla.repository.BookRepository;
import com.gllllepulla.service.SearchBookService;
import com.gllllepulla.transfer.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@RequiredArgsConstructor
@Service
class SearchBookServiceImpl implements SearchBookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookAuthorRepository bookAuthorRepository;
    private final BookMapper bookMapper;

    @Override
    public Set<Info.Book> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toBookView)
                .collect(toSet());
    }

    @Override
    public Optional<Info.Book> findBookById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toBookView);
    }

    @Override
    public Set<Info.Book> findBooksByTitles(Set<String> titles) {
        return bookRepository.findAllByTitles(titles).stream()
                .map(bookMapper::toBookView)
                .collect(toSet());
    }

    @Override
    public Set<Info.Book> findBooksByAuthorsNames(Set<String> names) {
        return authorRepository.findAllByNames(names).stream()
                .map(Author::getId)
                .map(bookAuthorRepository::findBooksByAuthorId)
                .flatMap(books -> books.stream()
                        .map(bookMapper::toBookView))
                .collect(toSet());
    }
}
