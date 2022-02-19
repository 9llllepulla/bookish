package com.gllllepulla.mapper;

import com.gllllepulla.entities.Book;
import com.gllllepulla.transfer.Info;

public interface BookMapper {


    Info.Book toBookView(Book book);

    Book toBook (Info.Book bookView);

}
