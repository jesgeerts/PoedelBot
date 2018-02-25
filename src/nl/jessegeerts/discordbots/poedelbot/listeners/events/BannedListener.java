package nl.jessegeerts.discordbots.poedelbot.listeners.events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.GuildBanEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;

public class BannedListener extends ListenerAdapter {

    @Override
    public void onGuildBan(GuildBanEvent event){

        String user = event.getUser().getAsMention();
        EmbedBuilder kek = new EmbedBuilder().setColor(Color.RED).setDescription("De gebruiker **%user%** is verbannen van de discord server.\nWat een poedel zeg..".replace("%user%", user)).setTitle("**BANNED**").setAuthor(user, event.getUser().getEffectiveAvatarUrl());
        if (event.getGuild().getId().equals(STATIC.DISCORD_SERVER_ID)) {
            event.getGuild().getTextChannelById(STATIC.CHANNEL_BAN_LOG_ID).sendMessage(kek.build()).queue();
        } else if(event.getGuild().getName().equalsIgnoreCase("Poedel Fans")){
            event.getGuild().getTextChannelById("404713558065152001").sendMessage(kek.build()).queue();
        }else{
            return;
        }

    }
}
