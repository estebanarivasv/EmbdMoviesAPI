package com.erivas.embd.repositories;

import com.erivas.embd.data.models.PlaylistModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<PlaylistModel, Long> {

}

