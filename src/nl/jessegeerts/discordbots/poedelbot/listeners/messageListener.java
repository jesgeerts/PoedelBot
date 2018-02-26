package nl.jessegeerts.discordbots.poedelbot.listeners;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;

public class messageListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();
        Message msg = event.getMessage();
        if (event.getAuthor().isBot()) return;

        if(msg.getContentDisplay().contains("@Poedel Host")){
            channel.sendMessage(event.getAuthor().getAsMention() + " Hoi! "+ LeMojis.happy).queue();
        }
        if(msg.getContentDisplay().startsWith("Welkom") || msg.getContentDisplay().startsWith("welkom") || msg.getContentDisplay().startsWith("Welkom!") || msg.getContentDisplay().startsWith("welkom!")){
            channel.sendMessage(":star: :star: Welkom bij Poedel Host! :star: :star: ").queue();
        }
    }
}
