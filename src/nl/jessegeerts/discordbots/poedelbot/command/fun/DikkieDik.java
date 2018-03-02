package nl.jessegeerts.discordbots.poedelbot.command.fun;

import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DikkieDik implements Command {
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
                    channel.sendMessage(event.getAuthor().getAsMention() + " is Dikkie Dik " + LeMojis.dikkiedik).queue();
                }
            }, 1000);
        }

        if (args.length>=1){
            Guild guild = event.getGuild();
            List<User> mentionedUsers = message.getMentionedUsers();

            if(mentionedUsers.contains(""))
            try{
                message.delete().queue();
            }catch (PermissionException e){
                channel.sendMessage("Er werkt helaas iets niet..").queue();
                return;
            }
            for (User user : mentionedUsers) {
                Member member = guild.getMember(user);

                channel.sendMessage("Wist je dat ").append(member.getAsMention()).append(" Dikkie Dik is? " + LeMojis.dikkiedik + "\n\n" + LeMojis.lol).queue();
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