package nl.jessegeerts.discordbots.poedelbot.command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.util.Timer;
import java.util.TimerTask;

public class Help implements Command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (args.length == 0) {
            event.getTextChannel().sendMessage("This bot was created by Jesse Geerts @jessegeerts#0330").queue();
        }
        if (args.length == 1) {
            if (event.getMessage().getContent().equalsIgnoreCase(STATIC.PREFIX +"help shutdown")) {
                event.getTextChannel().sendMessage("Attempting to shutdown").queue();
                 new Timer().schedule(new TimerTask() {
                     @Override
                     public void run() {
                         event.getTextChannel().sendMessage("Shutdowned").queue();
                     }
                 },2500);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getJDA().shutdown();
                    }
                }, 3000);
            }

            if(event.getMessage().getContent().equalsIgnoreCase(STATIC.PREFIX + "help owner")){
                    event.getTextChannel().sendMessage("The server owner: " + event.getGuild().getOwner().getAsMention()).queue();
            }

            if(event.getMessage().getContent().equalsIgnoreCase(STATIC.PREFIX + "help image")){
                event.getTextChannel().sendMessage(event.getAuthor().getAvatarUrl()).queue();
            }
            if(event.getMessage().getContent().equalsIgnoreCase("%pref%help ping".replace("%pref%", STATIC.PREFIX))){
                event.getTextChannel().sendTyping().queue();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                      event.getTextChannel().sendMessage(String.valueOf(event.getJDA().getPing())).queue();
                    }
                },2000);
            }
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


