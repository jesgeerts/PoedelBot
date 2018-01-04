package nl.jessegeerts.discordbots.poedelbot.listeners.events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.GuildUnbanEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;

public class BanRemoved extends ListenerAdapter {
    @Override
    public void onGuildUnban(GuildUnbanEvent event){
        String user = event.getUser().getName();
        EmbedBuilder kek = new EmbedBuilder().setColor(Color.GREEN).setDescription("De poedel %user% is van de banlijst afgehaald..\nDIKKE POEDELS".replace("%user%", user)).setTitle("**UNBANNED**").setAuthor(user, event.getUser().getEffectiveAvatarUrl());
        event.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getTextChannelById(STATIC.CHANNEL_BAN_LOG_ID).sendMessage(kek.build()).queue();


    }
}
