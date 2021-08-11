package com.erivas.embd.data.mappers;

import com.erivas.embd.data.dtos.user.InputUserDto;
import com.erivas.embd.data.dtos.user.UserDto;
import com.erivas.embd.data.models.UserModel;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserModel toEntity(InputUserDto userDto);

    UserDto toDto(UserModel userModel);

    void updateUserFromDto(InputUserDto userDto, @MappingTarget UserModel userModel);

}