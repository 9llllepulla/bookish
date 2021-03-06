package com.gllllepulla.service.impl;

import com.gllllepulla.mapper.BookMapper;
import com.gllllepulla.service.EditorService;
import com.gllllepulla.service.SearchBookService;
import com.gllllepulla.transfer.TransferService;
import com.gllllepulla.model.Dto;
import com.gllllepulla.model.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@RequiredArgsConstructor
@Service("books")
class BookService implements SearchBookService, EditorService<Info.Book> {

    private final TransferService transferService;
    private final BookMapper bookMapper;

    @Override
    public Set<Info.Book> getAllBooks() {
        return transferService.findAllBooks().stream()
                .map(bookMapper::toBookInfo)
                .collect(toSet());
    }

    @Override
    public Optional<Info.Book> findBookById(Long id) {
        return transferService.findBookById(id)
                .map(bookMapper::toBookInfo);
    }

    @Override
    public Set<Info.Book> findBooksByTitles(Set<String> titles) {
        return transferService.findAllBooksByTitles(titles).stream()
                .map(bookMapper::toBookInfo)
                .collect(toSet());
    }

    @Override
    public Set<Info.Book> findBooksByAuthorsNames(Set<String> names) {
        return transferService.findAllAuthorsByNames(names).stream()
                .map(Dto.Author::id)
                .map(transferService::findBooksByAuthorId)
                .flatMap(books -> books.stream()
                        .map(bookMapper::toBookInfo))
                .collect(toSet());
    }

    @Override
    public Optional<Info.Book> edit(Info.Book book) {
        return Optional.empty();
    }

    @Override
    public Info.Book create(Info.Book book) {
        Dto.Book bookDto = transferService.createBook(book);
        return bookMapper.toBookInfo(bookDto);
    }

    @Override
    public void deleteByIds(Set<Long> ids) {
        transferService.deleteBooksById(ids);
    }
}
