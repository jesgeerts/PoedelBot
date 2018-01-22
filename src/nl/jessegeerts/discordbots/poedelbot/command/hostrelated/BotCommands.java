package nl.jessegeerts.discordbots.poedelbot.command.hostrelated;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

public class BotCommands implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getGuild().getName().equalsIgnoreCase("Poedel Host")) {
            event.getChannel().sendMessage(":poodle: De staff verzoekt jullie om de bot commands in : " + event.getGuild().getTextChannelById(STATIC.CHANNEL_BOTCOMMANDS_ID).getAsMention() + " uit te voeren :poodle:").queue();
        }else if(event.getGuild().getName().equalsIgnoreCase("Poedel Fans")){
            event.getChannel().sendMessage(":poodle: De staff verzoekt jullie om de bot commands in : " + event.getGuild().getTextChannelById("404705649231003649").getAsMention() + " uit te voeren :poodle:").queue();

        }else{
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