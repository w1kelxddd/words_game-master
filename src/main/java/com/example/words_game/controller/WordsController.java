package com.example.words_game.controller;

import com.example.words_game.dto.WordsDto;
import com.example.words_game.service.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class WordsController {

    private final WordsService service;

    @Autowired
    public WordsController(WordsService service){
        this.service = service;
    }

    @PostMapping("/play")
    public WordsDto playGame (@RequestBody WordsDto wordsDto) {
        return service.evaluateWordsList(wordsDto);
    }
}
