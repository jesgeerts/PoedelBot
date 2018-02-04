package nl.jessegeerts.discordbots.poedelbot.command.moderation;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Ban implements Command {




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

if(member3.hasPermission(Permission.ADMINISTRATOR) || member3.hasPermission(Permission.BAN_MEMBERS)){
    if (message.isFromType(ChannelType.TEXT)) {
        //If no users are provided, we can't kick anyone!
        if (message.getMentionedUsers().isEmpty()) {
            Message msg = channel.sendMessage(event.getAuthor().getAsMention()).complete();
            Message msg2 = channel.sendMessage(STATIC.shit.build()).complete();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    msg.delete().queue();
                    msg2.delete().queue();
                }
            }, 1000);
        } else {
            Guild guild = event.getGuild();
            Member selfMember = guild.getSelfMember();  //This is the currently logged in account's Member object.
            // Very similar to JDA#getSelfUser()!

            //Now, we the the logged in account doesn't have permission to kick members.. well.. we can't kick!
            if (!selfMember.hasPermission(Permission.BAN_MEMBERS) || !selfMember.hasPermission(Permission.ADMINISTRATOR)) {
                channel.sendMessage(tagsender + " HE POEDEL! IK HEB GEEN TOESTEMMING OM POEDELS TE BANNEN").queue();
                return; //We jump out of the method instead of using cascading if/else
            }

            //Loop over all mentioned users, kicking them one at a time. Mwauahahah!
            List<User> mentionedUsers = message.getMentionedUsers();
            for (User user : mentionedUsers) {
                Member member = guild.getMember(user);  //We get the member object for each mentioned user to kick them!

                //We need to make sure that we can interact with them. Interacting with a Member means you are higher
                // in the Role hierarchy than they are. Remember, NO ONE is above the Guild's Owner. (Guild#getOwner())
                if (!selfMember.canInteract(member)) {
                    // use the MessageAction to construct the content in StringBuilder syntax using append calls
                    channel.sendMessage(tagsender + " Ik kan d(i)e poedel(s) niet bannen want: ")
                            .append(member.getEffectiveName())
                            .append(", want hij/zij heeft een hogere rank dan ik. :sob:")
                            .queue();
                    continue;   //Continue to the next mentioned user to be kicked.
                }

if(!member.getUser().hasPrivateChannel()){
                    member.getUser().openPrivateChannel().queue();
}
    if(!event.getAuthor().hasPrivateChannel()){
                    event.getAuthor().openPrivateChannel().queue();
    }
                guild.getController().ban(member, 7).queue(

                        success -> member.getUser().openPrivateChannel().queue((privateChannel) ->
                        {
                            privateChannel.sendMessage("Je bent verbannen van de Discord server: %server%".replace("%server%", event.getGuild().getName())).queue();

                        }),

                        error ->
                        {
                            //The failure consumer provides a throwable. In this case we want to check for a PermissionException.
                            if (error instanceof PermissionException) {
                                PermissionException pe = (PermissionException) error;
                                Permission missingPermission = pe.getPermission();  //If you want to know exactly what permission is missing, this is how.
                                //Note: some PermissionExceptions have no permission provided, only an error message!

                                channel.sendMessage("PermissionError kicking [")
                                        .append(member.getEffectiveName()).append("]: ")
                                        .append(error.getMessage()).queue();
                            } else {
                                channel.sendMessage("Unknown error while kicking [")
                                        .append(member.getEffectiveName())
                                        .append("]: <").append(error.getClass().getSimpleName()).append(">: ")
                                        .append(error.getMessage()).queue();
                            }
                        });
            }
        }
    } else {
        channel.sendMessage(tagsender + " This is a Guild-Only command!").queue();
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
