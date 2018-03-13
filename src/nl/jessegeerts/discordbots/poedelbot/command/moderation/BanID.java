package nl.jessegeerts.discordbots.poedelbot.command.moderation;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class BanID implements Command {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getMessage().delete().queue();

        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();


        String tagsender = event.getAuthor().getAsMention();
        Member member3 = event.getMember();

        if (member3.hasPermission(Permission.ADMINISTRATOR) || member3.hasPermission(Permission.BAN_MEMBERS)) {

            if (args.length == 0) {
                Message msg = channel.sendMessage(event.getAuthor().getAsMention()).complete();
                Message msg2 = channel.sendMessage(STATIC.id.build()).complete();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        msg.delete().queue();
                        msg2.delete().queue();
                    }
                }, 2000);
                return;
            }

            Guild guild = event.getGuild();
            Member selfMember = guild.getSelfMember();  //This is the currently logged in account's Member object.
            // Very similar to JDA#getSelfUser()!

            //Now, we the the logged in account doesn't have permission to kick members.. well.. we can't kick!
            if (!selfMember.hasPermission(Permission.BAN_MEMBERS) || !selfMember.hasPermission(Permission.ADMINISTRATOR)) {
                channel.sendMessage(tagsender + " HE POEDEL! IK HEB GEEN TOESTEMMING OM POEDELS TE BANNEN").queue();
                return; //We jump out of the method instead of using cascading if/else
            }


            guild.getController().ban(args[0], 0).queue(

                    success -> channel.sendMessage("De gebruikersID ``").append(args[0]).append("`` Is verbannen van %server%".replace("%server%", event.getGuild().getName())).queue()


            );


        } else {
            Message tag = channel.sendMessage(event.getAuthor().getAsMention()).complete();
            Message embed = channel.sendMessage(new EmbedBuilder().setTitle("**ERROR 403**").setAuthor(event.getGuild().getOwner().getEffectiveName(), null, event.getGuild().getOwner().getUser().getEffectiveAvatarUrl()).setDescription("%lol% Je hebt hier geen permissie voor %lol%\nJe actie is bijgehouden.".replace("%lol%", LeMojis.lol)).build()).complete();
            event.getGuild().getTextChannelById(STATIC.CHANNEL_NO_PERMISSON_LOG_ID).sendMessage(new EmbedBuilder().setColor(Color.RED)
                    .setAuthor(event.getJDA().getSelfUser().getName(), null, event.getJDA().getSelfUser().getEffectiveAvatarUrl()).setDescription("%author% heeft het volgende gebruikt waar hij/zij geen toegang voor heeft: ``` %msg%```".replace("%author%", event.getAuthor().getAsMention()).replace("%msg%", event.getMessage().getContentDisplay())).build()).queue();
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