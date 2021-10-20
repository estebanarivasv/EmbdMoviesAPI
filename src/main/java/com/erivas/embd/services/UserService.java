package com.erivas.embd.services;

import com.erivas.embd.data.dtos.user.InputUserDto;
import com.erivas.embd.data.dtos.user.UserDto;
import com.erivas.embd.data.mappers.UserMapper;
import com.erivas.embd.data.models.UserModel;
import com.erivas.embd.exceptions.ElementNotFoundException;
import com.erivas.embd.repositories.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    // CRUD
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Achieves user from db and raises exception if the user is not found
    // TODO: Is this the way I want to handle exceptions?
    public UserModel getUserQuery(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException("user", id));
    }

    public UserDto readUser(Long id) {
        return mapper.toDto(this.getUserQuery(id));
    }

    public UserDto updateUser(Long id, InputUserDto editedUserDto) {

        // Fetch user by id
        UserModel userFromDb = this.getUserQuery(id);
        // Replace dto data in user instance
        mapper.updateUserFromDto(editedUserDto, userFromDb);
        repository.save(userFromDb);
        return mapper.toDto(userFromDb);
    }



}
