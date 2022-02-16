package com.gllllepulla.mapper;

import com.gllllepulla.entities.Book;
import com.gllllepulla.transfer.View;

public interface BookMapper {


    View.Book toBookView(Book book);

    Book toBook (View.Book bookView);

}
