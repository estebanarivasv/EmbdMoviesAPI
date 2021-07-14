package com.sword.trailersdb.services;

import com.sword.trailersdb.data.dtos.user.InputUserDto;
import com.sword.trailersdb.data.dtos.user.UserDto;
import com.sword.trailersdb.exceptions.ElementNotFoundException;
import com.sword.trailersdb.data.mappers.UserMapper;
import com.sword.trailersdb.data.models.UserModel;
import com.sword.trailersdb.repositories.UserRepository;
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

    // Achieves user from db and raises exception
    public UserModel getUserQuery(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException("user", id));
    }

    // Get user's dto
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
