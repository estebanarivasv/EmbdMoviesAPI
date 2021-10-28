package com.erivas.embd.data.mappers;

import com.erivas.embd.data.dtos.UserDto;
import com.erivas.embd.data.models.UserModel;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = true)
    UserDto userToDto(UserModel userModel);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "playlists", ignore = true)
    UserModel dtoToUser(UserDto userDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "playlists", ignore = true)
    void updateUserFromDto(UserDto userDto, @MappingTarget UserModel userModel);

}