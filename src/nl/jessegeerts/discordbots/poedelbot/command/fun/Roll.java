package nl.jessegeerts.discordbots.poedelbot.command.fun;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

import java.util.Random;

public class Roll implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        Random rand = new Random();
        int roll = rand.nextInt(6) + 1; //This results in 1 - 6 (instead of 0 - 5)
        event.getChannel().sendMessage("Your roll: " + roll).queue(sentMessage ->  //This is called a lambda statement. If you don't know
        {                                                               // what they are or how they work, try google!
            if (roll < 3)
            {
                event.getChannel().sendMessage("The roll for messageId: " + sentMessage.getId() + " wasn't very good... Must be bad luck!\n").queue();
            }
        });
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
