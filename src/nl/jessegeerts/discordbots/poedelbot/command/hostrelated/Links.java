package nl.jessegeerts.discordbots.poedelbot.command.hostrelated;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

public class Links  implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getMessage().delete().queue();

        event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Kijk hier voor onze links: " + event.getGuild().getTextChannelById("425035118688862218").getAsMention()).queue();


    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}