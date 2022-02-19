package com.gllllepulla.mapper;

import com.gllllepulla.entities.Author;
import com.gllllepulla.transfer.Info;

public interface AuthorMapper {

    Info.Author toAuthorView(Author author);

    Author toAuthor(Info.Author authorView);

}
