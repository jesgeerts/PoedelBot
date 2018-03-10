package nl.jessegeerts.discordbots.poedelbot.listeners.events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.GuildUnbanEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;

public class Unban extends ListenerAdapter {
    @Override
    public void onGuildUnban(GuildUnbanEvent event){
        String user = event.getUser().getAsMention();
        EmbedBuilder unbanned = new EmbedBuilder().setColor(Color.GREEN)
                .setDescription("De poedel %user% is van de banlijst afgehaald..\nDIKKE POEDELS"
                        .replace("%user%", user)).setTitle("**UNBANNED**").setAuthor(event.getUser().getName(), null, event.getUser().getEffectiveAvatarUrl());

        if (event.getGuild().getId().equals(STATIC.DISCORD_SERVER_ID)) {
            event.getGuild().getTextChannelById(STATIC.CHANNEL_BAN_LOG_ID).sendMessage(unbanned.build()).queue();
        }else if(event.getGuild().getName().equalsIgnoreCase("Poedel Fans")){
            event.getGuild().getTextChannelById("404713558065152001").sendMessage(unbanned.build()).queue();
        }else{
            return;
        }
    }
}
