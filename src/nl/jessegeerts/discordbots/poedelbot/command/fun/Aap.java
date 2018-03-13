package nl.jessegeerts.discordbots.poedelbot.command.fun;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

import java.util.Timer;
import java.util.TimerTask;

public class Aap implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getChannel().sendTyping().queue();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                event.getChannel().sendMessage(event.getAuthor().getAsMention() + " *Gooit pc op de grond*").queue();
                event.getChannel().sendMessage("https://giphy.com/gifs/monkey-laptop-baboon-xTiTnJ3BooiDs8dL7W").queue();
            }
        }, 1000);
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}