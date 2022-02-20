package com.gllllepulla.service.impl;

import com.gllllepulla.mapper.AuthorMapper;
import com.gllllepulla.mapper.BookMapper;
import com.gllllepulla.service.EditorService;
import com.gllllepulla.transfer.TransferService;
import com.gllllepulla.model.Dto;
import com.gllllepulla.model.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
class EditorServiceImpl implements EditorService {

    private final TransferService transferService;
    private final AuthorMapper authorMapper;
    private final BookMapper bookMapper;

    @Override
    public Optional<Info.Author> editAuthor(Info.Author author) {
        return Optional.empty();
    }

    @Override
    public Info.Author createAuthor(Info.Author authorInfo) {
        Dto.Author authorDto = transferService.createAuthor(authorInfo);
        return authorMapper.toAuthorInfo(authorDto);
    }

    @Override
    public Optional<Info.Book> editBook(Info.Book book) {
        return Optional.empty();
    }

    @Override
    public Info.Book createBook(Info.Book bookInfo) {
        Dto.Book bookDto = transferService.createBook(bookInfo);
        return bookMapper.toBookInfo(bookDto);
    }

    @Override
    public void deleteAuthorsByIds(Set<Long> ids) {
        transferService.deleteAuthorsById(ids);
    }

    @Override
    public void deleteBooksByIds(Set<Long> ids) {
        transferService.deleteBooksById(ids);
    }
}
