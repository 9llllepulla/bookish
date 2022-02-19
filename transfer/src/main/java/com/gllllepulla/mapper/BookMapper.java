package com.gllllepulla.mapper;

import com.gllllepulla.transfer.Dto;
import com.gllllepulla.transfer.Info;

public interface BookMapper {

    Info.Book toBookInfo(Dto.Book bookDto);

}
