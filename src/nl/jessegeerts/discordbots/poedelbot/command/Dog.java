package nl.jessegeerts.discordbots.poedelbot.command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Timer;
import java.util.TimerTask;

public class Dog implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendTyping().queue();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                event.getTextChannel().sendMessage("┈┈╱▏┈┈┈┈┈╱▔▔▔▔╲┈ \n" +
                        "┈┈▏▏┈┈┈┈┈▏╲▕▋▕▋▏\n" +
                        "┈┈╲╲┈┈┈┈┈▏┈▏┈▔▔▔▆ ------- BORF!\n" +
                        "┈┈┈╲▔▔▔▔▔╲╱┈╰┳┳┳╯ \n" +
                        "╱╲╱╲▏┈┈┈┈┈┈▕▔╰━╯ \n" +
                        "▔╲╲╱╱▔╱▔▔╲╲╲╲┈┈┈ \n" +
                        "┈┈╲╱╲╱┈┈┈┈╲╲▂╲▂┈ \n" +
                        "┈┈┈┈┈┈┈┈┈┈┈╲╱╲╱┈").queue();
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