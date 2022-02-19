package com.gllllepulla.service;

import com.gllllepulla.transfer.Info;

import java.util.Optional;
import java.util.Set;

public interface SearchAuthorService {

    Set<Info.Author> getAllAuthors();

    Optional<Info.Author> findAuthorById(Long id);

    Set<Info.Author> findAuthorsByNames(Set<String> names);

    Set<Info.Author> findAuthorsByBookTitles (Set<String> titles);

}
