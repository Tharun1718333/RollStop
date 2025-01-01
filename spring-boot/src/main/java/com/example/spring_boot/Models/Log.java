package com.example.spring_boot.Models;

import jakarta.persistence.*;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long log_id; // Change type based on your needs

    @ManyToOne
    @JoinColumn(name = "gameId")
    public Game game;

    public int selectedNumber;
    public int rolledNumber;
}