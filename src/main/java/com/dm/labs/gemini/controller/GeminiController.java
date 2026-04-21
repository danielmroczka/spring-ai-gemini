package com.dm.labs.gemini.controller;

import com.dm.labs.gemini.service.GeminiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GeminiController {

    private final GeminiService geminiService;

    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @GetMapping("/api/ask")
    public Map<String, String> askGemini(@RequestParam String message) {
        String response = geminiService.getAiResponse(message);
        return Map.of(
                "question", message,
                "answer", response
        );
    }
}