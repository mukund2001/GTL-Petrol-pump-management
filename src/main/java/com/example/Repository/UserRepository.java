package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.user;

public interface UserRepository extends JpaRepository<user, Long> {
    user findByUsername(String username);
}