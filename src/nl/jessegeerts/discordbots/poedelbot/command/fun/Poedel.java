package nl.jessegeerts.discordbots.poedelbot.command.fun;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

public class Poedel implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        event.getChannel().sendMessage("https://giphy.com/gifs/dog-weird-exercising-fhQDRJCRCgOwU").queue();
        event.getChannel().sendMessage(":poodle: GROTE POEDELS :open_mouth: :poodle:").queue();
        event.getChannel().sendMessage(event.getGuild().getMemberById("300153354842013696").getAsMention() + " is een **DIKKE POEDEL**").queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
