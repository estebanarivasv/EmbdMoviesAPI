package com.sword.trailersdb.repositories;

import com.sword.trailersdb.data.models.ActorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<ActorModel, Long> {

}

