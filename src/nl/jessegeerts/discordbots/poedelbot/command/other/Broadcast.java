package nl.jessegeerts.discordbots.poedelbot.command.other;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;

import java.util.Timer;
import java.util.TimerTask;

public class Broadcast implements Command {
    @Override
public boolean called(String[] args, MessageReceivedEvent event) {
    return false;
}

        @Override
        public void action(String[] args, MessageReceivedEvent event) {
            Message message = event.getMessage();
            message.delete().queue();

            MessageChannel channel = event.getChannel();
            if(event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.ADMINISTRATOR) || event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.MESSAGE_MANAGE)){
                if(args.length==0){
                    channel.sendMessage("Ik doe maar ff niks :stuck_out_tongue: ").complete();
                    return;
                }


                String msg = "";
                String[] arrayOfString;
                int j = (arrayOfString = args).length;
                for (int i = 0; i < j; i++) {
                    String a = arrayOfString[i];
                    msg = msg + " " + a;
                }
                channel.sendMessage("@everyone").queue();
                channel.sendMessage(event.getAuthor().getAsMention() + " Heeft het volgende verteld:\n" + msg + "\n\n```Creatie data van aankondiging/bericht: %dag% %maand% %jaar% om %uur%:%min%:%sec%```"
                .replace("%dag%", String.valueOf(message.getCreationTime().getDayOfMonth())).replace("%maand%", String.valueOf(message.getCreationTime().getMonth())).replace("%jaar%", String.valueOf(message.getCreationTime().getYear()))
                .replace("%uur%", String.valueOf(message.getCreationTime().getHour())).replace("%min%", String.valueOf(message.getCreationTime().getMinute())).replace("%sec%", String.valueOf(message.getCreationTime().getSecond()))).queue();
            }else{
                Message msg = channel.sendMessage(event.getAuthor().getAsMention() +" NEE " + LeMojis.happy).complete();
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