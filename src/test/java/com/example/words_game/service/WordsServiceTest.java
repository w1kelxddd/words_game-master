package com.example.words_game.service;

import com.example.words_game.dto.WordsDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WordsServiceTest {

    @Autowired
    public WordsService wordsService;

    @Test
    public void canServiceEvaluateWordsCorrectly() {

        doAssertionWithCustomParameters(Arrays.asList("fish", "horse", "egg", "goose", "eagle"), 5);
        doAssertionWithCustomParameters(Arrays.asList("fish", "horse", "snake", "goose", "eagle"), 2);
        doAssertionWithCustomParameters(Arrays.asList("fish", "horse", "", "goose", "eagle"), 2);
        doAssertionWithCustomParameters(Arrays.asList("", "horse", "", "goose", "eagle"), 0);
    }

    private void doAssertionWithCustomParameters(List<String> input, int substringLastIndex) {
        assertEquals(new WordsDto(input.subList(0, substringLastIndex)), wordsService.evaluateWordsList(new WordsDto(input)));
    }
}

