package com.example.spring_boot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot.Models.Log;

public interface LogRepository extends JpaRepository<Log, Integer> {

}