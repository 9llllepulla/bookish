package com.gllllepulla.mapper;

import com.gllllepulla.model.Dto;
import com.gllllepulla.model.Info;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    Info.BookishUser toUserInfo(Dto.BookishUser bookishUser);

}
