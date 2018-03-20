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
import java.util.Timer;
import java.util.TimerTask;

public class Join extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        if (event.getGuild().getId().equals(STATIC.DISCORD_SERVER_ID)) {


            if(event.getUser().getId().equals("134762702122909696") || event.getUser().getId().equals("277458924238667776") || event.getUser().getId().equals("272292524432031746")){

                event.getUser().openPrivateChannel().queue((privateChannel -> privateChannel.sendMessage("Je bent niet welkom bij Poedel Host discord. Fijne dag verder")));
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getGuild().getController().ban(event.getMember(), 1, "We houden niet zo erg van je").queue();
                    }
                }, 1500);
                System.out.println("Een dikke tyfus jood is gejoined");
                return;
            }



            MessageChannel channel = event.getGuild().getTextChannelById(STATIC.CHANNEL_MEMBER_LOG_ID);
            int currentMembers = event.getGuild().getMembers().size();
            if (currentMembers % 100 == 0) {
                event.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getTextChannelById(STATIC.CHANNEL_NIEUWS_ID).sendMessage("DE SERVER HEEFT NU %count% LEDEN BEREIKT! Waarschuw de staff voor een giveaway!!".replace("%count%", String.valueOf(currentMembers))).queue();
            }

            String user = event.getUser().getName();
            String joined = event.getUser().getAsMention();
            EmbedBuilder kek = new EmbedBuilder().setColor(Color.GREEN)
                    .setAuthor(event.getUser().getName(), null, event.getUser().getEffectiveAvatarUrl())
                    .setDescription("De poedel %user% is erbij gekomen.".replace("%user%", joined)).setTitle("**WELKOM %user%**".replace("%user%", user));

            channel.sendMessage(kek.build()).queue();

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


                            event.getGuild().getOwner().getUser().openPrivateChannel().queue((privateChannel -> privateChannel.sendMessage("PermissionError giving permisson [").append(event.getMember().getEffectiveName()).append("]: ")
                                    .append(error.getMessage())));
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
