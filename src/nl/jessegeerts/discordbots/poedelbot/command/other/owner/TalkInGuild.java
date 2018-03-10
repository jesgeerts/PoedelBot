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

public class TalkInGuild implements Command {

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
                try{
                    event.getMessage().delete().queue();
                }catch (PermissionException e){

                }
                return;
            }


            String msg = "";
            String[] arrayOfString;
            int j = (arrayOfString = args).length;
            for (int i = 1; i < j; i++) {
                String a = arrayOfString[i];
                msg = msg + " " + a;
            }

            try{
                event.getMessage().delete().queue();
            }catch (PermissionException e){


            }
            event.getJDA().getGuildById(args[0]).getSystemChannel().sendMessage(msg).queue();
            channel.sendMessage(msg).queue();
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


