package nl.jessegeerts.discordbots.poedelbot.command.moderation;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.util.List;

public class Kick implements Command {
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


        for(Role role : user2.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getMember(user2).getRoles()) {

            if (role.getId().equalsIgnoreCase(STATIC.ROLE_CEO_ID) || role.getId().equalsIgnoreCase(STATIC.ROLE_STAFF_ID)) {
                if (message.isFromType(ChannelType.TEXT)) {
                    //If no users are provided, we can't kick anyone!
                    if (message.getMentionedUsers().isEmpty()) {
                        channel.sendMessage(user2.getAsMention() + " :poodle: Je moet een of meerdere poedels taggen om te kunnen kicken. :poodle:").queue();
                    } else {
                        Guild guild = event.getGuild();
                        Member selfMember = guild.getSelfMember();  //This is the currently logged in account's Member object.
                        // Very similar to JDA#getSelfUser()!

                        //Now, we the the logged in account doesn't have permission to kick members.. well.. we can't kick!
                        if (!selfMember.hasPermission(Permission.KICK_MEMBERS) || !selfMember.hasPermission(Permission.ADMINISTRATOR)) {
                            channel.sendMessage("HE POEDEL! IK HEB GEEN TOESTEMMING OM POEDELS TE KICKEN").queue();
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
                                channel.sendMessage("Ik kan d(i)e poedel(s) niet kicken want: ")
                                        .append(member.getEffectiveName())
                                        .append(", hij/zij heeft een hogere rank dan ik. :sob:")
                                        .queue();
                                continue;   //Continue to the next mentioned user to be kicked.
                            }

                            //Remember, due to the fact that we're using queue we will never have to deal with RateLimits.
                            // JDA will do it all for you so long as you are using queue!
                            guild.getController().kick(member).queue(
                                    success -> channel.sendMessage("D(i)e poedel(s) ").append(member.getEffectiveName()).append(" zijn eruit gegooid..").queue(),
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
                    channel.sendMessage("This is a Guild-Only command!").queue();
                }
            }else{
                channel.sendMessage("**ERROR 403**\nJe hebt geen toegang om dit commando uit te voeren.").queue();
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
