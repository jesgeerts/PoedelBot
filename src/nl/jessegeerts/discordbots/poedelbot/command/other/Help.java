package nl.jessegeerts.discordbots.poedelbot.command.other;

import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.util.Timer;
import java.util.TimerTask;

public class Help implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (args.length == 0) {
            event.getTextChannel().sendMessage("Deze bot is voor PoedelHost(ing) gemaakt. Mede mogelijk gemaakt door onze poedel 1e klas: @jessegeerts#0330").queue();
        }
        if (args.length == 1) {
            event.getMessage().delete().queue();
            if (event.getMessage().getContent().equalsIgnoreCase(STATIC.PREFIX +"help shutdown")) {
                event.getTextChannel().sendMessage("Attempting to shutdown").queue();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                       event.getJDA().getPresence().setPresence(OnlineStatus.INVISIBLE, Game.listening("Blaffende poedels"));
                    }
                }, 1500);
            }
            if(event.getMessage().getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help start")){
                event.getChannel().sendMessage("Attempting to going back online").queue();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getJDA().getPresence().setPresence(OnlineStatus.ONLINE, Game.listening("Blaffende poedels"));

                    }
                }, 1500);
            }

            if(event.getMessage().getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help channels")){
                event.getChannel().sendMessage(event.getGuild().getTextChannels().toString()).queue();
            }
            if(event.getMessage().getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help roles")){
                event.getChannel().sendMessage(event.getGuild().getRoles().toString()).queue();
            }
            if(event.getMessage().getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help users")){
                event.getChannel().sendMessage(event.getGuild().getMembers().toString()).queue();
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


