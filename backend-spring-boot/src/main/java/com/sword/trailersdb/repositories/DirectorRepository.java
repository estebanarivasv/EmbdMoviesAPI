package src.main.java.com.sword.trailersdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import src.main.java.com.sword.trailersdb.models.Director;

interface DirectorRepository extends JpaRepository<Director, Long> {
}