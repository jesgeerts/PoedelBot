package nl.jessegeerts.discordbots.poedelbot.command.fun;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

public class Vroom implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
event.getMessage().delete().queue();
        event.getChannel().sendMessage("VROOM VROOM VROOM").queue();
        event.getChannel().sendMessage("https://i.jessegeerts.nl/6cde7fa46938ccfa780952837d21c853.png").queue();
        event.getChannel().sendMessage(new EmbedBuilder().setDescription("Wij kregen dit idee van: " + event.getJDA().getUserById("346933091555737602").getAsMention()).build()).queue();

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
