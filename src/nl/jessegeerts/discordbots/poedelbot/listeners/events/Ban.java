package nl.jessegeerts.discordbots.poedelbot.listeners.events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.GuildBanEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;

public class Ban extends ListenerAdapter {

    @Override
    public void onGuildBan(GuildBanEvent event){
        String user = event.getUser().getName();
        EmbedBuilder kek = new EmbedBuilder().setColor(Color.RED).setDescription("De gebruiker **%user%** is verbannen van de discord server.\nWat een poedel zeg..".replace("%user%", user)).setTitle("**BANNED**").setAuthor(user, event.getUser().getEffectiveAvatarUrl());
        event.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getTextChannelById(STATIC.CHANNEL_BAN_LOG_ID).sendMessage(kek.build()).queue();



    }
}
