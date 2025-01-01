package com.example.spring_boot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot.Models.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

}