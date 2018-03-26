package nl.jessegeerts.discordbots.poedelbot.command.hostrelated.support;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

public class KVK implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getMessage().delete().queue();
        event.getChannel().sendMessage(event.getAuthor().getAsMention()+"\nMocht het je zo erg interesseren.. Vooruit dan maar!\nKvK nummer: KOMT NOG\nBTW Nummer: KOMT NOG\nTot poedels!").queue();

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}