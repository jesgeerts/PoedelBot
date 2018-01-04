package nl.jessegeerts.discordbots.poedelbot.listeners;

import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

public class Events extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        Spam.onUserJoin(event);
        int currentMembers = event.getGuild().getMembers().size();
        if (currentMembers % 3 == 0){
            event.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getTextChannelById(STATIC.CHANNEL_NIEUWS_ID).sendMessage("DE SERVER HEEFT NU 100 LEDEN BEREIKT!").queue();
        }
    }
}
