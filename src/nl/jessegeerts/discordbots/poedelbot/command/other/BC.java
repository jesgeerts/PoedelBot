package nl.jessegeerts.discordbots.poedelbot.command.other;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

public class BC  implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        event.getMessage().delete().queue();
        MessageChannel channel = event.getChannel();
        if(event.getAuthor().getId().equals(STATIC.JESSE_DISCORD_TOKEN)){

        }else{
            channel.sendMessage("NEIN").queue();
        }
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}


//**[here](https://www.paypal.me/zekro)**