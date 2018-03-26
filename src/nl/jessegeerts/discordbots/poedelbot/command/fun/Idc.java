package nl.jessegeerts.discordbots.poedelbot.command.fun;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

public class Idc implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        event.getMessage().delete().queue();
        event.getChannel().sendMessage("https://giphy.com/gifs/whatever-i-dont-care-idc-Dl2xST2pXRveU").queue();

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}