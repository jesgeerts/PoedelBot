package nl.jessegeerts.discordbots.poedelbot.listeners.events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;

public class Leave extends ListenerAdapter {
    @Override
    public void onGuildMemberLeave(GuildMemberLeaveEvent event){
        if (event.getGuild().getId().equals(STATIC.DISCORD_SERVER_ID)) {
            String user = event.getUser().getName();
            String mentioned = event.getUser().getAsMention();
            EmbedBuilder kek = new EmbedBuilder().setColor(Color.RED)
                    .setDescription("%user% heeft de server verlaten :sob:.".replace("%user%", mentioned))
                    .setTitle("**VAARWEL %name%**".replace("%name%", user)).setAuthor(user, null,event.getUser().getEffectiveAvatarUrl());



            event.getGuild().getTextChannelById(STATIC.CHANNEL_MEMBER_LOG_ID).sendMessage(kek.build()).queue();

        } else {
            return;
        }

    }
}
