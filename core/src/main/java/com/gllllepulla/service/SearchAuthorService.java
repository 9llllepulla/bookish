package com.gllllepulla.service;

import com.gllllepulla.transfer.View;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SearchAuthorService {

    Set<View.Author> getAllAuthors();

    Optional<View.Author> findAuthorById(Long id);

    List<View.Author> findAuthorsByNames(Set<String> names);

}
