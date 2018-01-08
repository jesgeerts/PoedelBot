package nl.jessegeerts.discordbots.poedelbot.command.hostrelated;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;

public class Sponsor implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getMessage().delete().queue();
        event.getChannel().sendMessage(new EmbedBuilder().setColor(Color.BLUE).setTitle("Sponsoring").setDescription("Het is mogelijk om een server gesponserd te krijgen.\nVoor YouTubers hebben we de volgende eisen:\nMinstens 2 videos per dag en 1 stream per week" +
                "\nMinstens 300 views per video\n400 Abonnees\nVoor overige sponsor aanvragen kan je bij: " + event.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getMemberById(STATIC.JESSE_DISCORD_TOKEN).getAsMention() + " terecht").build()).queue();

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}