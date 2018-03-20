package nl.jessegeerts.discordbots.poedelbot.command.other.owner;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class GuildBan  implements Command {


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
                Message msg2 = channel.sendMessage(new EmbedBuilder().setTitle("FOUT").setColor(Color.RED).setDescription("%lol% Vul een ID in om deze actie uit te voeren %lol%".replace("%lol%", LeMojis.lol).replace("%happy%", LeMojis.happy)).build()).complete();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        msg.delete().queue();
                        msg2.delete().queue();
                    }
                }, 2000);
                return;
            }
            if(args.length==1){
                Message msg = channel.sendMessage(event.getAuthor().getAsMention()).complete();
                Message msg2 = channel.sendMessage(new EmbedBuilder().setTitle("FOUT").setColor(Color.RED).setDescription("%lol% Vul een ID in om deze actie uit te voeren %lol%".replace("%lol%", LeMojis.lol).replace("%happy%", LeMojis.happy)).build()).complete();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        msg.delete().queue();
                        msg2.delete().queue();
                    }
                }, 2000);
                return;
            }

            Guild guild = event.getJDA().getGuildById(args[0]);
            Member selfMember = guild.getSelfMember();  //This is the currently logged in account's Member object.
            // Very similar to JDA#getSelfUser()!

            //Now, we the the logged in account doesn't have permission to kick members.. well.. we can't kick!
            if (!selfMember.hasPermission(Permission.BAN_MEMBERS) || !selfMember.hasPermission(Permission.ADMINISTRATOR)) {
                channel.sendMessage(tagsender + " HE POEDEL! IK HEB GEEN TOESTEMMING OM POEDELS TE BANNEN").queue();
                return; //We jump out of the method instead of using cascading if/else
            }

            guild.getController().ban(args[1], 0).queue(

                    success -> channel.sendMessage("De gebruikersID ``").append(args[0]).append("`` Is verbannen van %id%".replace("%id%", args[0])).queue()


            );


        } else {
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