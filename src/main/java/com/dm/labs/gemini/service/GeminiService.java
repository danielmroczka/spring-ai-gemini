package com.dm.labs.gemini.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class GeminiService {

    private final ChatModel chatModel;

    public GeminiService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getAiResponse(String prompt) {
        return chatModel.call(prompt);
    }
}