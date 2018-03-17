package nl.jessegeerts.discordbots.poedelbot.command.fun;

import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

import java.util.List;

public class Land implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getMessage().delete().queue();

        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();


        if (message.getMentionedUsers().isEmpty()) {
            event.getChannel().sendMessage("https://i.jessegeerts.nl/hetlanduit.jpg").queue();
            event.getChannel().sendMessage(event.getAuthor().getAsMention() + " MOET HET LAND UIT OMDAT HIJ/ZIJ NIET GRAPPIG IS").queue();
            return;
        } else {
            Guild guild = event.getGuild();

            List<User> mentionedUsers = message.getMentionedUsers();
            for (User user : mentionedUsers) {
                Member member = guild.getMember(user);  //We get the member object for each mentioned user to kick them!


                channel.sendMessage(member.getAsMention()).append(" Moet het land uit omdat hij/zij niet grappig is\n\nhttps://i.jessegeerts.nl/hetlanduit.jpg").queue();
            }

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