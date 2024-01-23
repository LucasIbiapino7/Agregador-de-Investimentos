package com.devsuperior.agregadordeinvestimentos.repositories;

import com.devsuperior.agregadordeinvestimentos.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
