package com.example.spring_boot.Models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int GameId;
    public Date CreatedOn;
    public int InitialScore;
    public int FinalScore;
    public int MoveCount;
    public boolean ForceQuit;
    @OneToMany(mappedBy = "game")
    public List<Log> logs;
}