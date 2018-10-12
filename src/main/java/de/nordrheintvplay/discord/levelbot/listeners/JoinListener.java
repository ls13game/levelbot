package de.nordrheintvplay.discord.levelbot.listeners;

import de.nordrheintvplay.discord.levelbot.json.Json;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class JoinListener extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        Json.addMember(event.getUser().getId());
    }

}
