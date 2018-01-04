package nl.jessegeerts.discordbots.poedelbot.listeners.events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;

public class Join extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        int currentMembers = event.getGuild().getMembers().size();
        if (currentMembers % 3 == 0){
            event.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getTextChannelById(STATIC.CHANNEL_NIEUWS_ID).sendMessage("DE SERVER HEEFT NU %count% LEDEN BEREIKT! Waarschuw de staff voor een giveaway!!".replace("%count%", String.valueOf(currentMembers))).queue();
        }

        String user = event.getUser().getName();
        EmbedBuilder kek = new EmbedBuilder().setColor(Color.GREEN).setDescription("De poedel %user% is erbij gekomen.".replace("%user%", user)).setTitle("**WELKOM**").setAuthor(user, event.getUser().getEffectiveAvatarUrl());
        event.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getTextChannelById(STATIC.CHANNEL_JOIN_LOG_ID).sendMessage(kek.build()).queue();
    }


}
