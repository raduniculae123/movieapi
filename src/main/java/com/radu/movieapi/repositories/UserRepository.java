package com.radu.movieapi.repositories;

import com.radu.movieapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
