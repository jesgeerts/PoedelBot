package nl.jessegeerts.discordbots.poedelbot.command.other;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.MSGS;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

            channel.sendMessage(kek.setAuthor(event.getJDA().getSelfUser().getName(), "https://poedelhost.nl", event.getJDA().getSelfUser().getEffectiveAvatarUrl()).setDescription("Vul een message ID in").build()).queue();
            return;
        }
        event.getMessage().delete().queue();

        Message chanMSG = event.getTextChannel().sendMessage(new EmbedBuilder().setDescription("Ik ben nu op zoek naar het bericht.. Een moment geduld A.U.B.").setColor(Color.BLUE).build()).complete();

        List<Message> msg = new ArrayList<>();
        event.getGuild().getTextChannels().forEach(c -> {
            try {
                msg.add(c.getMessageById(args[0]).complete());
            } catch (Exception e) {}
        });

        if (msg.size() < 1) {
            chanMSG.editMessage(MSGS.error().setDescription(
                    "Er is geen bericht in welke kanaal dan ook op deze server met de ID: '%id%' .".replace("%id%", args[0])
            ).build()).queue();
            return;
        }

        chanMSG.editMessage(new EmbedBuilder()
                .setAuthor(msg.get(0).getAuthor().getName(), null, msg.get(0).getAuthor().getAvatarUrl())
                .setDescription(msg.get(0).getContentDisplay())
                .setFooter(
                        msg.get(0).getCreationTime().getDayOfMonth() + ". " +
                                msg.get(0).getCreationTime().getMonth()  + " " +
                                msg.get(0).getCreationTime().getYear() +
                                " om " + msg.get(0).getCreationTime().getHour() + ":" +
                                msg.get(0).getCreationTime().getMinute() + ":" +
                                msg.get(0).getCreationTime().getSecond() +
                                " in kanaal #" + msg.get(0).getTextChannel().getName(),
                        null).setColor(Color.GREEN)
                .build()
        ).queue();

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}


