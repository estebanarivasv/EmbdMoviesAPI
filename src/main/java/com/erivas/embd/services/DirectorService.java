package com.erivas.embd.services;

import com.erivas.embd.data.models.DirectorModel;
import com.erivas.embd.repositories.DirectorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public ResponseEntity<List<DirectorModel>> getAll() throws RuntimeException {
        return ResponseEntity.status(HttpStatus.OK).body(directorRepository.findAll());
    }

    public ResponseEntity<DirectorModel> getOne(Long id) throws RuntimeException {

        Optional<DirectorModel> directorModel = directorRepository.findById(id);
        if (directorModel.isPresent()) {
            DirectorModel director = directorModel.get();
            return ResponseEntity.status(HttpStatus.OK).body(director);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
}
