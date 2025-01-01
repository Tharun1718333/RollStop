package com.example.spring_boot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring_boot.Models.Move;
import com.example.spring_boot.Services.GameService;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping("/GetGameId")
    public ResponseEntity<Integer> requestMethodName() {
        return ResponseEntity.ok(gameService.generateGameId());
    }

    @RequestMapping(value = "/MakeMove", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Integer> makeMove(@RequestBody Move move) {
        int result = gameService.makeMove(move.selectedNumber, move.gameId, move.reward);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/Quit", method = RequestMethod.POST)
    public ResponseEntity<Void> quit(@RequestBody Move move) {
        gameService.EndGame(move.gameId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/GetGameStats", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<Integer, Integer>> getGameStats() {
        return ResponseEntity.ok(gameService.GetGameStats());
    }
}
