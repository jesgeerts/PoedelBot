package nl.jessegeerts.discordbots.poedelbot.command;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Tutorial implements Command {
    EmbedBuilder kek = new EmbedBuilder().setColor(Color.GREEN);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd-MM-yyyy");

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        event.getTextChannel().sendTyping().queue();
        event.getTextChannel().sendMessage(kek.setAuthor(event.getJDA().getSelfUser().getName(), "https://poedelhost.nl", event.getJDA().getSelfUser().getAvatarUrl())
                .setDescription("****\n**Hoe upload je een plugin**\n<https://youtu.be/sbZB3AouOlQ>\n\n\n\nCopyright PoedelHost "+ sdf.format(timestamp))
                .setTitle("**Tutorials**").build()).queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}