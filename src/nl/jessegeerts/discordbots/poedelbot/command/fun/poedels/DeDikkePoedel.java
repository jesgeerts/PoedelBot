package nl.jessegeerts.discordbots.poedelbot.command.fun.poedels;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.util.Timer;
import java.util.TimerTask;

public class DeDikkePoedel implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getChannel().sendTyping().queue();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                event.getChannel().sendMessage(event.getGuild().getMemberById(STATIC.JORDY_DISCORD_TOKEN    ).getAsMention() + " is de **DIKSTE POEDEL** van deze discord server.").queue();
            }
        }, 1500);
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
