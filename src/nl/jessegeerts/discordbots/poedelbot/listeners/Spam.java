package nl.jessegeerts.discordbots.poedelbot.listeners;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberRoleRemoveEvent;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.util.ArrayList;
import java.util.List;

public class Spam {
    private static List<User> spammerUsers = new ArrayList<>();

    public static void onUserJoin(GuildMemberJoinEvent event){
        if (spammerUsers.contains(event.getMember().getUser())) {
            // Is a spammer
            for (Role role : event.getGuild().getRoles()) {
                if (role.getId().equalsIgnoreCase(STATIC.MUTED_ROLE)) {
                    if (UserPrivs.hasPermission(event.getJDA().getSelfUser(), Permission.MANAGE_ROLES)) {
                        event.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getController().addRolesToMember(event.getMember(), event.getGuild().getRoleById(STATIC.MUTED_ROLE));
                    }
                    event.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getTextChannelById(STATIC.CHANNEL_SPAM_LOG_ID).sendMessage("Oi " + event.getMember().getAsMention() + " your still in spammers! Don't try to evade punishments");
                }
            }
        }
    }

    public static void onRoleAdded(GuildMemberRoleAddEvent event) {
        if (!spammerUsers.contains(event.getMember().getUser())) {
            for (Role role : event.getGuild().getMember(event.getMember().getUser()).getRoles()) {
                if (role.getId().equalsIgnoreCase(STATIC.MUTED_ROLE)) {
                    spammerUsers.add(event.getMember().getUser());
                    System.out.println("Put in spammers" + String.valueOf(event.getMember().getEffectiveName()) + " has been put in spammers");
                }
            }
        }
    }

    public static void onRoleRemoved(GuildMemberRoleRemoveEvent event){
        for (Role role : event.getGuild().getMember(event.getMember().getUser()).getRoles()){
            if(role.getId().equalsIgnoreCase(STATIC.MUTED_ROLE)){
                spammerUsers.remove(event.getMember().getUser());
                System.out.println("Removed from spammers" + event.getMember().getEffectiveName() + " has been removed from spammers");
            }
        }
    }

}
