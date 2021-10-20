package com.erivas.embd.repositories;

import com.erivas.embd.data.models.DirectorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<DirectorModel, Long> {

}
