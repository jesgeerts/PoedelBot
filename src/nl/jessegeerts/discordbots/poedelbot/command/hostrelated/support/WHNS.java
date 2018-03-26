package nl.jessegeerts.discordbots.poedelbot.command.hostrelated.support;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

public class WHNS implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getMessage().delete().queue();
        event.getChannel().sendMessage("Onze naamservers voor de webhosting zijn:\neen.dnssrv.nl\ntwee.dnssrv.nl\ndrie.dnssrv.nl").queue();

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}