package de.nordrheintvplay.discord.levelbot.core;

import de.nordrheintvplay.discord.levelbot.json.Json;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("[SYSTEM] Bot wird gestartet");
        Json.removeMember("487320784759685130");
        //LevelBot.start();
        //LevelBot.getJda().getTextChannels().get(0).sendMessage("gestartet").queue();

    }

}
