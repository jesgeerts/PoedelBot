package nl.jessegeerts.discordbots.poedelbot.command.fun;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;

public class Happy implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }


    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        try{
            event.getMessage().delete().queue();
            event.getChannel().sendMessage(LeMojis.happy).queue();
            event.getChannel().sendMessage(LeMojis.happyTrump).queue();
        }catch (PermissionException e){
            event.getChannel().sendMessage("Ik kon het bericht van %author% niet verwijderen dus jammer.. Alsnog lol".replace("%author%", event.getAuthor().getAsMention())).queue();
            event.getChannel().sendMessage(LeMojis.happy).queue();
            event.getChannel().sendMessage(LeMojis.happyTrump).queue();
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
