package de.nordrheintvplay.discord.levelbot.core;

import de.nordrheintvplay.discord.levelbot.listeners.JoinListener;
import de.nordrheintvplay.discord.levelbot.listeners.LeaveListener;
import de.nordrheintvplay.discord.levelbot.utils.Const;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;

public class LevelBot {

    private static JDA jda;

    public static void start() {

        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(Const.TOKEN)
                .setAutoReconnect(true)
                .setStatus(OnlineStatus.ONLINE)
                .setGame(Game.of(Game.GameType.LISTENING, "seine Entwickler"))
                .addEventListener(new JoinListener())
                .addEventListener(new LeaveListener());

        try {
            jda = builder.buildBlocking();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static JDA getJda() {
        return jda;
    }
}
