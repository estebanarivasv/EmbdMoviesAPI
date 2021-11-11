package com.erivas.embd.services;

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

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }


    public ResponseEntity<List<ActorModel>> getAll() throws RuntimeException {
        return ResponseEntity.status(HttpStatus.OK).body(actorRepository.findAll());
    }

    public ResponseEntity<ActorModel> getOne(Long id) throws RuntimeException {
        Optional<ActorModel> actorModel = actorRepository.findById(id);
        if (actorModel.isPresent()) {
            ActorModel actor = actorModel.get();
            return ResponseEntity.status(HttpStatus.OK).body(actor);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
