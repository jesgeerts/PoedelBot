package nl.jessegeerts.discordbots.poedelbot.listeners;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;

public class messageListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();
        Guild guild = event.getGuild();
        Message msg = event.getMessage();
        if (event.getAuthor().isBot()) return;

        if(msg.getContentDisplay().contains(event.getJDA().getSelfUser().getAsMention())){
            channel.sendMessage("Sup "+ LeMojis.lol).queue();
        }
    }
}
