package nl.jessegeerts.discordbots.poedelbot.command.moderation;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class UnMute  implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        MessageChannel channel = event.getChannel();

        String tagsender = event.getAuthor().getAsMention();
        Message message = event.getMessage();
        Member member3 = event.getMember();

        event.getMessage().delete().queue();

        if(member3.hasPermission(Permission.MANAGE_ROLES) || member3.hasPermission(Permission.MANAGE_PERMISSIONS) || member3.hasPermission(Permission.ADMINISTRATOR)) {


            if (message.isFromType(ChannelType.TEXT)) {
                if (message.getMentionedUsers().isEmpty()) {
                    channel.sendMessage(tagsender + " :poodle: Je moet een of meerdere leden taggen om te unmuten.").queue();
                } else {
                    Guild guild = event.getGuild();
                    Member selfMember = guild.getSelfMember();

                    //Now, we the the logged in account doesn't have permission to kick members.. well.. we can't kick!
                    if (!selfMember.hasPermission(Permission.MANAGE_ROLES) || !selfMember.hasPermission(Permission.MANAGE_PERMISSIONS) || !selfMember.hasPermission(Permission.ADMINISTRATOR)) {
                        channel.sendMessage(tagsender + " HE POEDEL! IK HEB GEEN TOESTEMMING OM POEDELS TE RANKS UIT TE GEVEN").queue();
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
                            channel.sendMessage(tagsender + " Ik kan d(i)e poedel(s) niet aanpassen want: ")
                                    .append(member.getEffectiveName())
                                    .append(", want hij/zij heeft een hogere rank dan ik. :sob:")
                                    .queue();
                            continue;   //Continue to the next mentioned user to be kicked.
                        }


                        guild.getController().removeRolesFromMember(member, event.getGuild().getRoleById(STATIC.ROLE_MUTED_ROLE)).queue(
                                success -> channel.sendMessage(tagsender + " , ").append(member.getAsMention()).append(" is niet langer gemuted").queue(),
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
            }
        }else{

            event.getMessage().delete().queue();
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
