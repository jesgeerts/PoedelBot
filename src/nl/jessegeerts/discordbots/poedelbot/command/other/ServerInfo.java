package nl.jessegeerts.discordbots.poedelbot.command.other;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

import java.awt.*;

public class ServerInfo implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        event.getMessage().delete().queue();
        event.getChannel().sendMessage(event.getGuild().getIconUrl()).queue();
        event.getChannel().sendMessage(new EmbedBuilder().setColor(Color.ORANGE).setDescription("ID: %id%\nMembers: %members%\nNaam: %dcname%\nOwner: %owner%\nAantal ranks: %rolecount%".replace("%dcname%", event.getGuild().getName()).replace("%id%", event.getGuild().getId())
        .replace("%members%", String.valueOf(event.getGuild().getMembers().size())).replace("%owner%", event.getGuild().getOwner().getAsMention()).replace("%rolecount%", String.valueOf(event.getGuild().getRoles().size()))).build()).queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}