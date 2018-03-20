package nl.jessegeerts.discordbots.poedelbot.command.other;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.constants.Emoji;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class PBSay implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        event.getMessage().delete().queue();
        MessageChannel channel = event.getChannel();
        if(event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.ADMINISTRATOR) || event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.MESSAGE_MANAGE)){
            if(args.length==0){
                channel.sendMessage(Emoji.NO + "Ik doe maar ff niks :stuck_out_tongue: ").complete();
                return;
            }


            String msg = "";
            String[] arrayOfString;
            int j = (arrayOfString = args).length;
            for (int i = 0; i < j; i++) {
                String a = arrayOfString[i];
                msg = msg + " " + a;
            }
            channel.sendMessage(msg).queue();
        }else{
            Message tag = channel.sendMessage(event.getAuthor().getAsMention()).complete();
            Message embed = channel.sendMessage(new EmbedBuilder().setTitle("**ERROR 403**").setAuthor(event.getGuild().getOwner().getEffectiveName(), null, event.getGuild().getOwner().getUser().getEffectiveAvatarUrl()).setDescription("%lol% Je hebt hier geen permissie voor %lol%\nJe actie is bijgehouden.".replace("%lol%", LeMojis.lol)).build()).complete();
            event.getGuild().getTextChannelById(STATIC.CHANNEL_NO_PERMISSON_LOG_ID).sendMessage(new EmbedBuilder().setColor(Color.RED)
                    .setAuthor(event.getJDA().getSelfUser().getName(), null, event.getJDA().getSelfUser().getEffectiveAvatarUrl()).setDescription("%author% heeft het volgende gebruikt waar deze persoon geen toegang voor heeft: ``` %msg%```".replace("%author%", event.getAuthor().getAsMention()).replace("%msg%", event.getMessage().getContentDisplay())).build()).queue();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    tag.delete().queue();
                    embed.delete().queue();
                }
            }, 5000);



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


