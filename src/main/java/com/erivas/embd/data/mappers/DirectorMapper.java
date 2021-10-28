package com.erivas.embd.data.mappers;

import com.erivas.embd.data.dtos.ActorDto;
import com.erivas.embd.data.dtos.DirectorDto;
import com.erivas.embd.data.models.ActorModel;
import com.erivas.embd.data.models.DirectorModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DirectorMapper {

    DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);

    DirectorDto directorToDto(DirectorModel directorModel);

    List<DirectorDto> directorsToDto(List<DirectorModel> directorModels);

    @Mapping(target = "id", ignore = true)
    DirectorModel dtoToDirector(DirectorDto directorDto);

}