package com.example.words_game.controller;

import com.example.words_game.dto.WordsDto;
import com.example.words_game.service.WordsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest
public class WordsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WordsService service;

    @Test
    void testInputProcessedCorrectly() throws Exception {
        List<String> testListInput = Arrays.asList("англия", "якутия", "ялта", "бангладеш");
        WordsDto dtoInput = new WordsDto(testListInput);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dtoInput);

        log.info(requestJson);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/game/play")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}
