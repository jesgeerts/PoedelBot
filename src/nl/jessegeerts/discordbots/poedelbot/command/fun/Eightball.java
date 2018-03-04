package nl.jessegeerts.discordbots.poedelbot.command.fun;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;

import java.util.Timer;
import java.util.TimerTask;

public class Eightball implements Command {

    private final String[] a = {
            "As I see it, yes",
            "Better not tell you now",
            "Cannot predict now",
            "Don't count on it",
            "If you say so",
            "In your dreams",
            "It is certain",
            "Most likely",
            "My CPU is saying no",
            "My CPU is saying yes",
            "Out of psychic coverage range",
            "Signs point to yes",
            "Sure, sure",
            "Very doubtful",
            "When life gives you lemon, you drink it",
            "Without a doubt",
            "Wow, Much no, very yes, so maybe",
            "Yes, definitely",
            "Yes, unless you run out of memes",
            "You are doomed",
            "You can't handle the truth",
            "The :poodle: says no"};
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(args.length==0){
            event.getChannel().sendMessage("Ik doe nu niks want je hebt geen vraag gesteld " + LeMojis.kappa).queue();
            return;
        }

        event.getTextChannel().sendTyping().queue();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " :crystal_ball: " + a[(int) (Math.random() * a.length)]).queue();
            }
        }, 1000);
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
