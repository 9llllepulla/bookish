package com.gllllepulla.service.impl;

import com.gllllepulla.entities.Author;
import com.gllllepulla.entities.Book;
import com.gllllepulla.mapper.AuthorMapper;
import com.gllllepulla.mapper.BookMapper;
import com.gllllepulla.repository.AuthorRepository;
import com.gllllepulla.repository.BookRepository;
import com.gllllepulla.service.EditorService;
import com.gllllepulla.transfer.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
class EditorServiceImpl implements EditorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final AuthorMapper authorMapper;
    private final BookMapper bookMapper;

    @Override
    public Optional<Info.Author> editAuthor(Info.Author author) {
        return Optional.empty();
    }

    @Override
    public Info.Author createAuthor(Info.Author authorView) {
        Author author = authorMapper.toAuthor(authorView);
        Author repositoryAuthor = authorRepository.saveAndFlush(author);
        return authorMapper.toAuthorView(repositoryAuthor);
    }

    @Override
    public Optional<Info.Book> editBook(Info.Book book) {
        return Optional.empty();
    }

    @Override
    public Info.Book createBook(Info.Book bookView) {
        Book book = bookMapper.toBook(bookView);
        Book repositoryBook = bookRepository.saveAndFlush(book);
        return bookMapper.toBookView(repositoryBook);
    }

    @Override
    public void deleteAuthorsByIds(Set<Long> ids) {
        List<Author> authors = authorRepository.findAllById(ids);
        authorRepository.deleteInBatch(authors);
    }

    @Override
    public void deleteBooksByIds (Set<Long> ids) {

    }
}
