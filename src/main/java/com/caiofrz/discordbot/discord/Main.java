package com.caiofrz.discordbot.discord;

import lombok.extern.slf4j.Slf4j;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.intent.Intent;

@Slf4j
public class Main {

  public static void main(String[] args) {
    DiscordApi api = new DiscordApiBuilder()
            .setToken(System.getenv("KEY"))
            .addIntents(Intent.MESSAGE_CONTENT)
            .login().join();
    api.addMessageCreateListener(event -> {

      String message = event.getMessageContent().toLowerCase();

      var response = switch (message) {
        case "!ping" -> MessagesAcceptedsEnum.PING.getResponsePrefix();
        case "!oi" -> MessagesAcceptedsEnum.OI.getResponsePrefix() + event.getMessageAuthor().getDisplayName();
        default -> {
          log.warn("Comando não reconhecido: " + message);
          yield " ";
        }
      };

      event.getChannel().sendMessage(response);
    });
  }
}
