package com.los.tddpractice.controller;

import java.lang.String;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest
@RunWith(SpringRunner.class)
public class GreetingsGreetingsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void dayGreetingTest200k() throws Exception {
        // Arrange
        String name = "Nick";
        String timeOfDay = "day";

        // Act
        mockMvc.perform(
                get("/api/greeting")
                .param("name", name)
                .param("timeOfDay", timeOfDay)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string(containsString(
                        String.format("Good day %s", name)
                ))
        );

        // Assert

    }

    @Test
    public void nightGreetingTest200k() throws Exception {
        // Arrange
        String name = "Nick";
        String timeOfDay = "night";

        // Act
        mockMvc.perform(
                get("/api/greeting")
                        .param("name", name)
                        .param("timeOfDay", timeOfDay)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string(containsString(
                        String.format("Good evening %s", name)
                ))
        );

        // Assert

    }

}
