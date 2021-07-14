package com.sword.trailersdb.data.mappers;

import com.sword.trailersdb.data.dtos.user.InputUserDto;
import com.sword.trailersdb.data.dtos.user.UserDto;
import com.sword.trailersdb.data.models.UserModel;
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