package nl.jessegeerts.discordbots.poedelbot.command.other.owner;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.util.Timer;
import java.util.TimerTask;

public class LeaveGuild  implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getMessage().delete().queue();

        MessageChannel channel = event.getChannel();
        if(event.getAuthor().getId().equals(STATIC.JESSE_DISCORD_TOKEN)){
            if(args.length==0){
                channel.sendMessage("Ik doe maar ff niks :stuck_out_tongue: " + LeMojis.lol).complete();
                try{
                    event.getMessage().delete().queue();
                }catch (PermissionException e){

                }
                return;
            }

            event.getJDA().getGuildById(args[0]).getTextChannelById(args[1]).sendMessage("Dag dikjoden.. Deze bot is niet gemaakt voor seksuele activiteiten. Wel voor mensen te helpen en om te lachen. DOEI").queue();
            event.getJDA().getGuildById(args[0]).leave().queue();
            channel.sendMessage("Ik ben uit de guild: " + event.getJDA().getGuildById(args[0]).getName() + " (%id%)".replace("%id%", event.getJDA().getGuildById(args[0]).getId())).queue();
        }else{
            Message msg = channel.sendMessage(event.getAuthor().getAsMention() +" Je bent hier niet voor gemachtigd.. Noob " + LeMojis.lol).complete();
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


