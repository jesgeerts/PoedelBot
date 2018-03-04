package nl.jessegeerts.discordbots.poedelbot.command.hostrelated;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

import java.awt.*;

public class panelmove implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getMessage().delete().queue();
        if(args.length==0){
            event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Voorbeeld: ```.panelmove pterodactyl multicraft poedelhost```").queue();
            return;
        }
        event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Je aanvraag is ingediend.").queue();
        event.getGuild().getTextChannelById("419857949909975040").sendMessage(new EmbedBuilder().setTitle("Panel aanvraag")
                .setDescription("Huidige Panel: %panel%\nWelke panel wil je?: %topanel%\nWat is je huidige gebruikersnaam op je panel?: %username%\nAanvrager: %mention%"
                        .replace("%panel%", args[0]).replace("%topanel%", args[1]).replace("%username%", args[2]).replace("%mention%", event.getAuthor().getAsMention()))
                .setAuthor(event.getAuthor().getName(), null, event.getAuthor().getEffectiveAvatarUrl()).setColor(Color.BLUE).build()).queue();

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}