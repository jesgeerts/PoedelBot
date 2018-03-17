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

public class Kick implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        event.getMessage().delete().queue();
        Member member3 = event.getMember();
        event.getMessage().delete().queue();


            if(member3.hasPermission(Permission.ADMINISTRATOR) || member3.hasPermission(Permission.KICK_MEMBERS)){
                    //If no users are provided, we can't kick anyone!
                    if (message.getMentionedUsers().isEmpty()) {
                            Message msg = channel.sendMessage(event.getAuthor().getAsMention()).complete();
                            Message msg2 = channel.sendMessage(new EmbedBuilder().setTitle("FOUT").setColor(Color.RED).setDescription("%lol% Tag een of meerdere personen om deze actie uit te voeren %lol%".replace("%lol%", LeMojis.lol).replace("%happy%", LeMojis.happy)).build()).complete();
                                new Timer().schedule(new TimerTask() {
                                @Override
                                public void run() {
                                msg.delete().queue();
                                    msg2.delete().queue();
                                }
                                }, 2000);
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
                                channel.sendMessage("Ik kan de poedel niet kicken want: ")
                                        .append(member.getEffectiveName())
                                        .append(", hij/zij heeft een hogere rank dan ik. :sob:")
                                        .queue();
                                continue;   //Continue to the next mentioned user to be kicked.
                            }

                            //Remember, due to the fact that we're using queue we will never have to deal with RateLimits.
                            // JDA will do it all for you so long as you are using queue!

                            if(member.getUser().hasPrivateChannel()){
                                member.getUser().openPrivateChannel().queue();
                            }

                            guild.getController().kick(member).queue(
                                    success -> channel.sendMessage("De dikke idiote poedel ").append(member.getAsMention()).append(" heeft een tik van papa poedel gekregen..").queue(),
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

            }else{
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
