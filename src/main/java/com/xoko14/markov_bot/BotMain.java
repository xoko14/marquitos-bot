package com.xoko14.markov_bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import io.github.cdimascio.dotenv.Dotenv;

public class BotMain {
    public static void main(String[] args) {
        try {
            // Create the TelegramBotsApi object to register your bots
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            Dotenv dotenv = Dotenv.load();
  
            // Register your newly created AbilityBot
            botsApi.registerBot(new MarkBot(dotenv.get("BOT_TOKEN"), dotenv.get("BOT_KEY")));
          } catch (TelegramApiException e) {
              e.printStackTrace();
          }
    }
}
