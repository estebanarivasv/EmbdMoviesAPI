package com.erivas.embd.services;

import com.erivas.embd.data.dtos.UserDto;
import com.erivas.embd.data.mappers.UserMapper;
import com.erivas.embd.data.models.UserModel;
import com.erivas.embd.repositories.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public ResponseEntity<UserModel> getOne(Long id) throws RuntimeException {

        Optional<UserModel> userModel = userRepository.findById(id);
        return userModel.map(model -> ResponseEntity.status(HttpStatus.OK).body(model))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }

    public ResponseEntity<UserModel> update(Long id, UserDto userDto) throws RuntimeException {

        Optional<UserModel> userModel = userRepository.findById(id);
        if (userModel.isPresent()) {
            UserModel user = userModel.get();
            userMapper.updateUserFromDto(userDto, user);
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
