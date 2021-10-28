package com.erivas.embd.services;

import com.erivas.embd.data.dtos.DirectorDto;
import com.erivas.embd.data.mappers.DirectorMapper;
import com.erivas.embd.data.models.DirectorModel;
import com.erivas.embd.repositories.DirectorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;
    private final DirectorMapper directorMapper;

    public DirectorService(DirectorRepository directorRepository, DirectorMapper directorMapper) {
        this.directorRepository = directorRepository;
        this.directorMapper = directorMapper;
    }

    public ResponseEntity<List<DirectorDto>> getAll() throws RuntimeException {
        List<DirectorModel> directorModels = directorRepository.findAll();
        List<DirectorDto> directorDtoList = directorMapper.directorsToDto(directorModels);
        return ResponseEntity.status(HttpStatus.OK).body(directorDtoList);
    }

    public ResponseEntity<DirectorDto> getOne(@PathVariable Long id) throws RuntimeException {

        Optional<DirectorModel> directorModel = directorRepository.findById(id);
        if (directorModel.isPresent()) {
            DirectorModel director = directorModel.get();
            return ResponseEntity.status(HttpStatus.OK).body(directorMapper.directorToDto(director));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
}
