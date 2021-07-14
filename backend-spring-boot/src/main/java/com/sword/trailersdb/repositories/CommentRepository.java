package com.sword.trailersdb.repositories;

import com.sword.trailersdb.data.models.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentModel, Long> {
}
