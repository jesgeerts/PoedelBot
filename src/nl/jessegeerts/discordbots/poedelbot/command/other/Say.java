package nl.jessegeerts.discordbots.poedelbot.command.other;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;

import java.util.Timer;
import java.util.TimerTask;

public class Say implements Command{

    @Override
public boolean called(String[] args, MessageReceivedEvent event) {
    return false;
}

        @Override
        public void action(String[] args, MessageReceivedEvent event) {

            try{
                event.getMessage().delete().queue();
            }catch (PermissionException e){

            }
            MessageChannel channel = event.getChannel();
           if(event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.ADMINISTRATOR) || event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.MESSAGE_MANAGE)){
              if(args.length==0){
                  channel.sendMessage("Ik doe maar ff niks :stuck_out_tongue: " + LeMojis.lol).complete();
                  return;
              }


               String msg = "";
               String[] arrayOfString;
               int j = (arrayOfString = args).length;
               for (int i = 0; i < j; i++) {
                   String a = arrayOfString[i];
                   msg = msg + " " + a;
               }
               channel.sendMessage(event.getAuthor().getAsMention() + " zegt: " +msg).queue();
           }else{
             Message msg = channel.sendMessage(event.getAuthor().getAsMention() +" NEE").complete();
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


