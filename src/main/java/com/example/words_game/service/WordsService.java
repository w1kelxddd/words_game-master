package com.example.words_game.service;

import com.example.words_game.dto.WordsDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordsService {

    public WordsService() {
    }

    public WordsDto evaluateWordsList(WordsDto wordsInput) {

        List<String> wordsInputList = wordsInput.getWords();
        List<String> wordsOutputList = new ArrayList<>();

        if (wordsInputList.get(0).equals("")) {
            return new WordsDto(wordsOutputList);
        }
        wordsOutputList.add(wordsInputList.get(0));

        for (int i = 0; i < wordsInputList.size() - 1; i++) {

            if (wordsInputList.get(i + 1).equals("")) {
                return new WordsDto(wordsOutputList);
            }

            char lastLetter = wordsInputList.get(i).charAt(wordsInputList.get(i).length() - 1);
            char firstLetter = wordsInputList.get(i + 1).charAt(0);

            if (lastLetter == firstLetter) {
                wordsOutputList.add(wordsInputList.get(i + 1));
            }
            else {
                return new WordsDto(wordsOutputList);
            }
        }
        return new WordsDto(wordsOutputList);
    }
}
