package nl.jessegeerts.discordbots.poedelbot.command.hostrelated;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

import java.awt.*;

public class AanbiedingenStartCmd implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getMessage().delete().queue();
        event.getChannel().sendMessage(new EmbedBuilder().setColor(Color.BLUE).setTitle("Aanbiedingen").setDescription("Hey hallo!, We zullen hier met enige regelmaat prachtige aanbiedingen plaatsen. Heb je een idee voor een aanbieding? Laat onze CEO's het weten!").build()).queue();

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}