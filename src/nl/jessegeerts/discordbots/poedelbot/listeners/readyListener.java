package nl.jessegeerts.discordbots.poedelbot.listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;

public class readyListener extends ListenerAdapter {

    public void onReady(ReadyEvent event) {

        String out = "Versie: %version%\nIk draai op de volgende servers: \n.\n\n".replace("%version%", STATIC.VERSION);

        for (Guild g : event.getJDA().getGuilds() ) {
            out += g.getName() + " (" + g.getId() + ") \n";
        }

        System.out.println(out);
        event.getJDA().getGuildById(STATIC.bot_Log_server).getTextChannelById("407921144310792192").sendMessage(new EmbedBuilder().setColor(Color.green).setTitle("Bot is opgestart").setDescription(out).build()).queue();

    }
}
