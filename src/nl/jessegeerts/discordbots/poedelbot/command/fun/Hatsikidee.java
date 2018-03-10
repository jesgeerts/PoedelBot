package nl.jessegeerts.discordbots.poedelbot.command.fun;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

import java.util.Timer;
import java.util.TimerTask;

public class Hatsikidee implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getChannel().sendTyping().queue();
        event.getMessage().delete().queue();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                event.getChannel().sendMessage("HATS HATS HATS HATSIKIDEE").queue();
                event.getChannel().sendMessage("https://youtu.be/ma11f8YxnXA").queue();
            }
        }, 500);
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
