package com.petrolpump.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petrolpump.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // Method to find user by username
    User findByUsername(String username);

}
