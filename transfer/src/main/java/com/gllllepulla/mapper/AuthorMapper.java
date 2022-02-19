package com.gllllepulla.mapper;

import com.gllllepulla.entities.Author;
import com.gllllepulla.transfer.Dto;
import com.gllllepulla.transfer.Info;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AuthorMapper {

    Info.Author toAuthorInfo(Dto.Author authorDto);

    @Mapping(target = "name", source = "authorName")
    Dto.Author toAuthorDto(Author author);

    @Mapping(target = "authorName", source = "name")
    Author toAuthor(Info.Author authorInfo);

}
