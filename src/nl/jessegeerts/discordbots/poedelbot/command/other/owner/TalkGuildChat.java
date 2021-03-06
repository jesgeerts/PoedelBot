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

public class TalkGuildChat implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {


        MessageChannel channel = event.getChannel();
        if(event.getAuthor().getId().equals(STATIC.JESSE_DISCORD_TOKEN)){
            if(args.length==0){
                channel.sendMessage("Ik doe maar ff niks :stuck_out_tongue: " + LeMojis.lol).complete();
                event.getMessage().delete().queue();
                return;
            }


            String msg = "";
            String[] arrayOfString;
            int j = (arrayOfString = args).length;
            for (int i = 2; i < j; i++) {
                String a = arrayOfString[i];
                msg = msg + " " + a;
            }

            try{
                event.getMessage().delete().queue();
            }catch (PermissionException e){


            }
            event.getJDA().getGuildById(args[0]).getTextChannelById(args[1]).sendMessage(msg).queue();
            if(!event.getGuild().getId().equals(STATIC.DISCORD_SERVER_ID)){
                channel.sendMessage(event.getAuthor().getAsMention() + " Bericht is verzonden.").queue();
            }

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


