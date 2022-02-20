package com.gllllepulla.mapper;


import com.gllllepulla.entities.Book;
import com.gllllepulla.repository.AuthorRepository;
import com.gllllepulla.repository.GenreRepository;
import com.gllllepulla.repository.PublisherRepository;
import com.gllllepulla.model.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Set;

public abstract class BookMapperDecorator implements BookMapper {

    @Autowired
    @Qualifier ("delegate")
    private BookMapper delegate;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public Book toBook(Info.Book bookInfo) {
        Book book = delegate.toBook(bookInfo);
        genreRepository.findByName(bookInfo.genreName())
                .ifPresent(book::setGenre);

        publisherRepository.findByName(bookInfo.publisherName())
                        .ifPresent(book::setPublisher);

        authorRepository.findAllByNames(Set.of(bookInfo.authorName())).stream()
                .findFirst()
                .ifPresent(book::addAuthor);
        return book;
    }
}
