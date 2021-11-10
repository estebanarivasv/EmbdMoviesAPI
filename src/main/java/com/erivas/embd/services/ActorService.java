package com.erivas.embd.services;

import com.erivas.embd.data.dtos.ActorDto;
import com.erivas.embd.data.mappers.ActorMapper;
import com.erivas.embd.data.models.ActorModel;
import com.erivas.embd.repositories.ActorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    public ActorService(ActorRepository actorRepository, ActorMapper actorMapper) {
        this.actorRepository = actorRepository;
        this.actorMapper = actorMapper;
    }

    public ResponseEntity<List<ActorDto>> getAll() throws RuntimeException {
        List<ActorModel> actorModels = actorRepository.findAll();
        List<ActorDto> actorDtoList = actorMapper.actorsToDto(actorModels);
        return ResponseEntity.status(HttpStatus.OK).body(actorDtoList);
    }

    public ResponseEntity<ActorDto> getOne(Long id) throws RuntimeException {

        Optional<ActorModel> actorModel = actorRepository.findById(id);
        if (actorModel.isPresent()) {
            ActorModel actor = actorModel.get();
            return ResponseEntity.status(HttpStatus.OK).body(actorMapper.actorToDto(actor));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
