package com.caiofrz.discordbot.discord;

import lombok.Getter;

@Getter
public enum MessagesAcceptedsEnum {
  PING("!ping", "Pong!"),
  OI("!oi", "Olá, ");

  private final String command;
  private final String responsePrefix;

  MessagesAcceptedsEnum(String command, String responsePrefix) {
    this.command = command;
    this.responsePrefix = responsePrefix;
  }
}
