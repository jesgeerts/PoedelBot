package nl.jessegeerts.discordbots.poedelbot.command.fun;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

public class Popcorn implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        event.getChannel().sendMessage("https://giphy.com/gifs/trump-michael-donald-UlqLDtI8Qc0j6").queue();
        event.getChannel().sendMessage(":popcorn: :popcorn: **GRABS POPCORN** :popcorn: :popcorn: ").queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}