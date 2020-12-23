package com.los.tddpractice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingsController {

    @GetMapping("/greeting")
    public ResponseEntity<String> greetings(
            @RequestParam("name")String name,
            @RequestParam("timeOfDay")String timeOfDay
    ){
        String dayOrNight = "day".equals(timeOfDay) ? "day" : "evening";
        return new ResponseEntity<>(
                String.format("Good %s %s", dayOrNight, name),
                HttpStatus.OK
        );
    }
}
