package nl.jessegeerts.discordbots.poedelbot.command.other;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
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

        Message msg = event.getMessage();
        MessageChannel channel = event.getChannel();

        if (args.length == 0) {
            channel.sendMessage(new EmbedBuilder().setTitle("Help").setDescription("**Basis commands**\n%pref%website\n%pref%").build()).queue();

            channel.sendMessage("//Even iets minder serieusDeze bot is voor PoedelHost(ing) gemaakt. Mede mogelijk gemaakt door onze poedel 1e klas: @jessegeerts#0330 en de dikste poedel: @Jordy | Developer | FTW#9157").queue();
        }
        if (args.length == 1) {
            msg.delete().queue();
            if(msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX +"help shutdown")) {
                channel.sendMessage("Attempting to shutdown").queue();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                       event.getJDA().getPresence().setPresence(OnlineStatus.INVISIBLE, Game.watching("Slapende poedels"));
                    }
                }, 1500);
            }
            if(msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help start")){
                channel.sendMessage("Attempting to going back online").queue();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getJDA().getPresence().setPresence(OnlineStatus.ONLINE, Game.watching("Slapende poedels"));

                    }
                }, 1500);
            }

            if(msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help channels")){
                channel.sendMessage(event.getGuild().getTextChannels().toString()).queue();
            }
            if(msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help roles")){
                channel.sendMessage(event.getGuild().getRoles().toString()).queue();
            }
            if(msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help users")){
                channel.sendMessage(event.getGuild().getMembers().toString()).queue();
            }

            if(msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help owner")){
                channel.sendMessage("The server owner: " + event.getGuild().getOwner().getAsMention()).queue();
            }

            if(msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help image")){
                channel.sendMessage(event.getAuthor().getAvatarUrl()).queue();
            }
            if(msg.getContentDisplay().equalsIgnoreCase("%pref%help ping".replace("%pref%", STATIC.PREFIX))){
                channel.sendTyping().queue();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        channel.sendMessage(String.valueOf(event.getJDA().getPing())).queue();
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


