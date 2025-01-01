package com.example.spring_boot.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring_boot.Models.Game;
import com.example.spring_boot.Models.Log;
import com.example.spring_boot.Repository.GameRepository;
import com.example.spring_boot.Repository.LogRepository;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private LogRepository logRepository;

    public int generateGameId() {
        Game newGame = new Game();
        return gameRepository.save(newGame).GameId;
    }

    @ResponseBody
    public int makeMove(int SelectedNumber, int gameId, int reward) {
        Random rand = new Random();
        int dice1 = rand.nextInt(6);
        int dice2 = rand.nextInt(6);
        int RolledNumber = dice1 + dice2 + 2;
        Game CurrentGame = gameRepository.findById(gameId).get();
        CurrentGame.MoveCount += 1;
        if (RolledNumber == SelectedNumber) {
            CurrentGame.FinalScore += reward;
        } else {
            CurrentGame.FinalScore -= 20;
        }
        if (CurrentGame.FinalScore <= 0) {
            CurrentGame.ForceQuit = false;
        }
        gameRepository.save(CurrentGame);
        Log newLog = new Log();
        newLog.game = CurrentGame;
        newLog.selectedNumber = SelectedNumber;
        newLog.rolledNumber = RolledNumber;
        logRepository.save(newLog);
        return RolledNumber;
    }

    public void EndGame(int gameId) {
        Game CurrentGame = gameRepository.findById(gameId).get();
        CurrentGame.ForceQuit = true;
        gameRepository.save(CurrentGame);
    }

    public Map<Integer, Integer> GetGameStats() {
        List<Game> allGames = gameRepository.findAll();
        return allGames.stream()
                .collect(Collectors.groupingBy(game -> game.FinalScore,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
    }
}
