package com.miningbot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class TelegramService {

    private  final String botToken;
    private final String chatId;
    private final RestClient restClient;


    public TelegramService(@Value("${telegram.bot-token:}") String botToken,
                           @Value("${telegram.chat-id:}") String chatId) {
        this.botToken = botToken;
        this.chatId = chatId;
        this.restClient = RestClient.create();
    }

    public void sendMessage(String message) {
        if(botToken.isBlank() || chatId.isBlank()){
            throw  new IllegalArgumentException("Telegram bot token or chat ID is not configured");
        }

        String url = String.format("https://api.telegram.org/bot" + botToken + "/sendMessage");
        restClient.post()
                .uri(url)
                .body(Map.of("chat_id", chatId, "text", message))
                .retrieve()
                .toBodilessEntity();
    }

    public void sendMessageTest() {
        sendMessage("Garimpo Bot está conectado ao Telegram!");
    }
}
