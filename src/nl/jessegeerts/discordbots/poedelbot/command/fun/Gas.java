package nl.jessegeerts.discordbots.poedelbot.command.fun;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

public class Gas implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        try {
            event.getMessage().delete().queue();
        }catch (PermissionException e){

        }
        event.getChannel().sendMessage("POM POM GAS EROP GAS EROP").queue();
        event.getChannel().sendMessage("https://i.jessegeerts.nl/27337378_2414178001928924_5296215652512064458_n.jpg").queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
