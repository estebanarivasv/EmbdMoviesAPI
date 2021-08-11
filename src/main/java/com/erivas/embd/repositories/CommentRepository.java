package com.erivas.embd.repositories;

import com.erivas.embd.data.models.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentModel, Long> {
}
