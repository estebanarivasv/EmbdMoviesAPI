package com.erivas.embd.data.mappers;

import com.erivas.embd.data.dtos.ActorDto;
import com.erivas.embd.data.dtos.UserDto;
import com.erivas.embd.data.models.ActorModel;
import com.erivas.embd.data.models.UserModel;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ActorMapper {

    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

    ActorDto actorToDto(ActorModel actorModel);

    List<ActorDto> actorsToDto(List<ActorModel> actorModels);

    @Mapping(target = "id", ignore = true)
    ActorModel dtoToActor(ActorDto actorDto);

}