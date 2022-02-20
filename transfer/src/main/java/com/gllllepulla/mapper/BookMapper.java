package com.gllllepulla.mapper;

import com.gllllepulla.entities.Book;
import com.gllllepulla.model.Dto;
import com.gllllepulla.model.Info;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(BookMapperDecorator.class)
public interface BookMapper {

    Info.Book toBookInfo(Dto.Book bookDto);

    @Mapping(target = "genreName", expression = "java(book.getGenre().getGenreName())")
    @Mapping(target = "publisherName", expression = "java(book.getPublisher().getPublisherName())")
    Dto.Book toBookDto(Book book);

    @Mapping(target = "genre", ignore = true)
    @Mapping(target = "publisher", ignore = true)
    Book toBook(Info.Book bookInfo);

}
