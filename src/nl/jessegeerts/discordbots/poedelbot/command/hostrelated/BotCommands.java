package nl.jessegeerts.discordbots.poedelbot.command.hostrelated;

import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
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

        User user = event.getAuthor();

        for(Role role : user.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getMember(user).getRoles()) {
            if (role.getId().equalsIgnoreCase(STATIC.ROLE_CEO_ID) || role.getId().equalsIgnoreCase(STATIC.ROLE_STAFF_ID)) {
                event.getChannel().sendMessage(":poodle: De staff verzoekt jullie om de bot commands in : "+event.getGuild().getTextChannelById(STATIC.CHANNEL_BOTCOMMANDS_ID).getAsMention() + " uit te voeren :poodle:").queue();
            }else{
                event.getChannel().sendMessage(user.getAsMention()+" Je hebt geen toegang om dit commando uit te voeren.").queue();
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