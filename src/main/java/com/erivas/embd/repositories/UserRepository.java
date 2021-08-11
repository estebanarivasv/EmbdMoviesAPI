package com.erivas.embd.repositories;

import com.erivas.embd.data.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
        
}
