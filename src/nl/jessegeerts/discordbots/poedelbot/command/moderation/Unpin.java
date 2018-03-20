package nl.jessegeerts.discordbots.poedelbot.command.moderation;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Unpin implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        User user2 = event.getAuthor();
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        event.getMessage().delete().queue();
        Member member3 = event.getMember();


        if(member3.hasPermission(Permission.MESSAGE_MANAGE) || member3.hasPermission(Permission.ADMINISTRATOR)){
            if (message.isFromType(ChannelType.TEXT)) {
                //If no users are provided, we can't kick anyone!
                if(args.length==0){
                    channel.sendMessage(event.getAuthor().getAsMention() + " Je moet een messageId invullen :thinking:").queue();
                }else {
                    Guild guild = event.getGuild();
                    Member selfMember = guild.getSelfMember();  //This is the currently logged in account's Member object.
                    // Very similar to JDA#getSelfUser()!

                    //Now, we the the logged in account doesn't have permission to kick members.. well.. we can't kick!
                    if (!selfMember.hasPermission(Permission.MESSAGE_MANAGE) || !selfMember.hasPermission(Permission.ADMINISTRATOR)) {
                        channel.sendMessage("HE POEDEL! IK HEB GEEN TOESTEMMING OM BERICHTEN TE PINNEN").queue();
                        return; //We jump out of the method instead of using cascading if/else
                    }

                    event.getChannel().unpinMessageById(args[0]).queue();
                    event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Het bericht met de id ``%id%`` is niet langer vastgezet.".replace("%id%", args[0])).queue();
                }
            } else {
                channel.sendMessage("This is a Guild-Only command!").queue();
            }
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
