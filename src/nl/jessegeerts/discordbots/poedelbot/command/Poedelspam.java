package nl.jessegeerts.discordbots.poedelbot.command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Poedelspam implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getChannel().sendMessage("https://giphy.com/gifs/dog-weird-exercising-fhQDRJCRCgOwU").queue();
        event.getChannel().sendMessage(":poodle: GROTE POEDELS :open_mouth: :poodle:").queue();
        for (int i = 0; i < 1000; i++) {
            event.getChannel().sendMessage(":poodle: :poodle: :poodle::poodle::poodle::poodle::poodle::poodle::poodle::poodle:").queue();
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