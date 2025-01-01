package com.example.spring_boot.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot.Models.aspnetuser;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<aspnetuser, Long> {
    Optional<aspnetuser> findFirstByName(String name);
}