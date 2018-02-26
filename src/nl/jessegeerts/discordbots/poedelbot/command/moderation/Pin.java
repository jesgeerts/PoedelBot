package nl.jessegeerts.discordbots.poedelbot.command.moderation;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

import java.awt.*;

public class Pin implements Command {
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

                    event.getChannel().pinMessageById(args[0]).queue();
                    event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Het bericht met de id ``%id%`` is nu vastgezet.".replace("%id%", args[0])).queue();
                }
            } else {
                channel.sendMessage("This is a Guild-Only command!").queue();
            }
        }else{
            event.getMessage().delete().queue();
            if(!event.getAuthor().hasPrivateChannel()){
                event.getAuthor().openPrivateChannel().queue();

            }

            event.getAuthor().openPrivateChannel().queue((privateChannel) ->
            {
                privateChannel.sendMessage(new EmbedBuilder().setColor(Color.RED).setTitle("Geen permissie").setDescription("**TOEGANG GEWEIGERD**\nJe toegang tot dit command is geweigerd.\n\nHet commando wat je deed was: %msg%\nIn de discord server: %server%".replace("%msg%", event.getMessage().getContentDisplay()).replace("%server%",event.getGuild().getName())).build()).queue();
            });
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
