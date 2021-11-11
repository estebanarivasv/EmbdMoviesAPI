package com.erivas.embd.repositories;

import com.erivas.embd.data.models.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieModel, Long> {

}

