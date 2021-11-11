package com.erivas.embd.data.mappers;

import com.erivas.embd.data.dtos.UserDto;
import com.erivas.embd.data.models.UserModel;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserModel dtoToUser(UserDto userDto);

    //@Mapping(target = "comments", ignore = true)
    void updateUserFromDto(UserDto userDto, @MappingTarget UserModel userModel);

}