package nl.jessegeerts.discordbots.poedelbot.command.other;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

import java.awt.*;

public class Quote  implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    EmbedBuilder kek = new EmbedBuilder().setColor(Color.RED);


    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();
        if(args.length==0){

            channel.sendMessage(kek.setAuthor(event.getJDA().getSelfUser().getName(), "https://jessegeerts.nl", event.getJDA().getSelfUser().getEffectiveAvatarUrl()).setDescription("").build()).queue();
            return;
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


