package nl.jessegeerts.discordbots.poedelbot.command.hostrelated.movechat;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.util.Timer;
import java.util.TimerTask;

public class Offtopic implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {


        if(event.getGuild().getName().equalsIgnoreCase("Poedel Host")){
            if(event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.ADMINISTRATOR) || event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.MESSAGE_MANAGE)){
                event.getChannel().sendMessage(":poodle: De staff verzoekt jullie om het gesprek verder te voeren in: "+event.getGuild().getTextChannelById(STATIC.CHANNEL_OFFTOPIC_ID).getAsMention() + " :poodle:").queue();
            }else{
                Message msg = event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Je bent hiervoor niet gemachtigd").complete();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                      msg.delete().queue();
                    }
                },1000);
            }
        }else{
            event.getChannel().sendMessage(STATIC.sorry_maar).queue();
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
