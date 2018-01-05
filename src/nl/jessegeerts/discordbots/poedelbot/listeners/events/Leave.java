package nl.jessegeerts.discordbots.poedelbot.listeners.events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;

public class Leave extends ListenerAdapter {
    @Override
    public void onGuildMemberLeave(GuildMemberLeaveEvent event){


        String user = event.getUser().getName();
        EmbedBuilder kek = new EmbedBuilder().setColor(Color.RED).setDescription("De poedel %user% heeft de server verlaten.".replace("%user%", user)).setTitle("**VAARWEL**").setAuthor(user, event.getUser().getEffectiveAvatarUrl());
        event.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getTextChannelById(STATIC.CHANNEL_LEAVE_LOG_ID).sendMessage(kek.build()).queue();


    }
}