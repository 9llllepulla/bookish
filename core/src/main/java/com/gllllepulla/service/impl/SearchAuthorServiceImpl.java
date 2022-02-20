package com.gllllepulla.service.impl;

import com.gllllepulla.mapper.AuthorMapper;
import com.gllllepulla.transfer.TransferService;
import com.gllllepulla.service.SearchAuthorService;
import com.gllllepulla.model.Dto;
import com.gllllepulla.model.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@RequiredArgsConstructor
@Service
class SearchAuthorServiceImpl implements SearchAuthorService {

    private final AuthorMapper authorMapper;
    private final TransferService transferService;

    @Override
    public Set<Info.Author> getAllAuthors() {
        return transferService.findAllAuthors().stream()
                .map(authorMapper::toAuthorInfo)
                .collect(toSet());
    }

    @Override
    public Optional<Info.Author> findAuthorById(Long id) {
        return transferService.findAuthorById(id)
                .map(authorMapper::toAuthorInfo);
    }

    @Override
    public Set<Info.Author> findAuthorsByNames(Set<String> names) {
        return transferService.findAllAuthorsByNames(names).stream()
                .map(authorMapper::toAuthorInfo)
                .collect(toSet());
    }

    @Override
    public Set<Info.Author> findAuthorsByBookTitles(Set<String> titles) {
        return transferService.findAllBooksByTitles(titles).stream()
                .map(Dto.Book::id)
                .map(transferService::findAuthorsByBookId)
                .flatMap(authors -> authors.stream()
                        .map(authorMapper::toAuthorInfo))
                .collect(toSet());
    }
}
