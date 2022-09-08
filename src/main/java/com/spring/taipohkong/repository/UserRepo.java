package com.spring.taipohkong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<com.spring.taipohkong.model.User, Long> {
    @Query("SELECT u.password FROM User u WHERE u.username = ?1")
    Optional<String> findPasswordByUsername(String username);
}
