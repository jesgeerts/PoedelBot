package nl.jessegeerts.discordbots.poedelbot.listeners.events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.GuildController;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;

public class Join extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        if (event.getGuild().getName().equalsIgnoreCase("Poedel Host")) {
            MessageChannel channel = event.getGuild().getTextChannelById(STATIC.CHANNEL_JOIN_LOG_ID);
            int currentMembers = event.getGuild().getMembers().size();
            if (currentMembers % 100 == 0) {
                event.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getTextChannelById(STATIC.CHANNEL_NIEUWS_ID).sendMessage("DE SERVER HEEFT NU %count% LEDEN BEREIKT! Waarschuw de staff voor een giveaway!!".replace("%count%", String.valueOf(currentMembers))).queue();
            }

            String user = event.getUser().getName();
            String joined = event.getUser().getAsMention();
            EmbedBuilder kek = new EmbedBuilder().setColor(Color.GREEN).setDescription("De poedel %user% is erbij gekomen.".replace("%user%", joined)).setTitle("**WELKOM**").setAuthor(user, event.getUser().getEffectiveAvatarUrl());
            event.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getTextChannelById(STATIC.CHANNEL_JOIN_LOG_ID).sendMessage(kek.build()).queue();

            GuildController guildController = event.getGuild().getController();
            guildController.addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById(STATIC.ROLE_MEMBER_ID)).queue(
                    success -> event.getMember().getAsMention(),
                    error ->
                    {
                        //The failure consumer provides a throwable. In this case we want to check for a PermissionException.
                        if (error instanceof PermissionException) {
                            PermissionException pe = (PermissionException) error;
                            Permission missingPermission = pe.getPermission();  //If you want to know exactly what permission is missing, this is how.
                            //Note: some PermissionExceptions have no permission provided, only an error message!

                            channel.sendMessage("PermissionError giving permisson [")
                                    .append(event.getMember().getEffectiveName()).append("]: ")
                                    .append(error.getMessage()).queue();
                        } else {
                            channel.sendMessage("Unknown error while rolling [")
                                    .append(event.getMember().getEffectiveName())
                                    .append("]: <").append(error.getClass().getSimpleName()).append(">: ")
                                    .append(error.getMessage()).queue();
                        }
                    });
        } else {
            return;
        }


    }


}
