package com.gllllepulla.mapper;

import com.gllllepulla.entities.Author;
import com.gllllepulla.transfer.View;

public interface AuthorMapper {

    View.Author toAuthorView(Author author);

    Author toAuthor(View.Author authorView);

}
