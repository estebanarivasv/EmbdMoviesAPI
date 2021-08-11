package com.erivas.embd.repositories;

import com.erivas.embd.data.models.ActorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<ActorModel, Long> {

}

