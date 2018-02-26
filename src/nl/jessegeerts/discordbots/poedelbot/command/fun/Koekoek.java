package nl.jessegeerts.discordbots.poedelbot.command.fun;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

public class Koekoek implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        try{
            event.getMessage().delete().queue();
        }catch (PermissionException e){
            event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Er ging iets mis tijdens het verwijderen van het bericht").queue();
        }
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(event.getAuthor().getAsMention() + "KOEKOEK JONGHUH").queue();
        event.getChannel().sendMessage("http://gallery.wietforum.nl/gallery/album_16172/gallery_37674_16172_29133.png").queue();
        event.getChannel().sendMessage("https://open.spotify.com/track/1dSveR2X7Ne0BQ3gjUPxX6?si=UHZLSMokSIiKHVnecZqLBw").queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
