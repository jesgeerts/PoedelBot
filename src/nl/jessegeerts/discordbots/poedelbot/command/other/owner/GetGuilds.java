package nl.jessegeerts.discordbots.poedelbot.command.other.owner;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.util.Timer;
import java.util.TimerTask;

public class GetGuilds   implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {


        MessageChannel channel = event.getChannel();
        if(event.getAuthor().getId().equals(STATIC.JESSE_DISCORD_TOKEN)){
            String out = "Ik draai op de volgende servers: \n.\n\n";

            for (Guild g : event.getJDA().getGuilds() ) {
                out += g.getName() + " (" + g.getId() + ") \n";
            }
            channel.sendMessage(out).queue();
        }else{
            Message msg = channel.sendMessage(event.getAuthor().getAsMention() +" NEE " + LeMojis.lol).complete();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    msg.delete().queue();
                }
            }, 1500);
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






/**

 }
 */