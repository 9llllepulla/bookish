package com.gllllepulla.mapper;

import com.gllllepulla.transfer.Dto;
import com.gllllepulla.transfer.Info;

public interface AuthorMapper {

    Info.Author toAuthorView(Dto.Author authorDto);

}
