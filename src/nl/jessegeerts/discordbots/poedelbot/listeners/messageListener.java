package nl.jessegeerts.discordbots.poedelbot.listeners;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

public class messageListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();
        Message msg = event.getMessage();
        if (event.getAuthor().isBot()) return;



        if (msg.getContentDisplay().startsWith("Welkom") || msg.getContentDisplay().startsWith("welkom") || msg.getContentDisplay().startsWith("Welkom!") || msg.getContentDisplay().startsWith("welkom!")) {
            channel.sendMessage(":star: :star: Welkom bij Poedel Host! :star: :star: ").queue();
        }

        if(msg.getContentDisplay().contains("zullen we vrienden worden")||msg.getContentDisplay().contains("Zullen we vrienden worden") || msg.getContentDisplay().contains("Wil je vrienden zijn")|| msg.getContentDisplay().contains("wil je vrienden zijn")){
            channel.sendMessage("Mijn enigste vrienden zijn Poedel 1e klas Jesse, Papa poedel Jordy en mijn programmataal: Java " + LeMojis.happy).queue();
        }
        if(msg.getContentDisplay().contains("rot op") || msg.getContentDisplay().contains("Rot op") || msg.getContentDisplay().contains("ROT OP")){

            if(event.getAuthor().getId().equals(STATIC.JORDY_DISCORD_TOKEN)){
                channel.sendMessage("Rot toch zelf op DIKKE JORDY! "+ LeMojis.kappa + LeMojis.lol).queue();
                return;
            }
            channel.sendMessage("Rot toch zelf op! " + LeMojis.kappa + LeMojis.lol).queue();
        }


    }
}
