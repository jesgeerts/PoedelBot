package nl.jessegeerts.discordbots.poedelbot.command.fun;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;

import java.util.Timer;
import java.util.TimerTask;

public class Dikname implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();
        Message message = event.getMessage();

        if(args.length==0){
            channel.sendTyping().queue();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    channel.sendMessage(event.getAuthor().getAsMention() + " is Dikkie Dik " + LeMojis.dikkiedik + " " + LeMojis.lol).queue();
                }
            }, 1000);
        }

        if (args.length==1){
                            try{
                    message.delete().queue();
                }catch (PermissionException e){
                    channel.sendMessage("Er werkt helaas iets niet..").queue();
                    return;
                }
                channel.sendMessage("Wist je dat %arg% Dikkie Dik is? %dikkie% %lol%".replace("%dikkie%", LeMojis.dikkiedik).replace("%lol%", LeMojis.lol).replace("%arg%", args[0])).queue();


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