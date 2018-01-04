package nl.jessegeerts.discordbots.poedelbot.listeners;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.util.Timer;
import java.util.TimerTask;

public class messageListener extends ListenerAdapter{


    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.isFromType(ChannelType.TEXT)) {
            if (event.getMessage().getContent().contains("(╯°□°）╯︵ ┻━┻")) {
                event.getTextChannel().sendTyping().queue();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " Stop flipping tables!\n┬─┬\uFEFF ノ( ゜-゜ノ)").queue();
                    }
                }, 1000);
            }
            if (event.getMessage().getContent().contains("┬─┬\uFEFF ノ( ゜-゜ノ)")) {
                event.getTextChannel().sendTyping().queue();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " PLEASE DON'T UNFLIP THE TABLE WHILST IT'S NOT FLIPPED AT ALL!").queue();
                    }
                }, 1000);
            }
            if (event.getMessage().getContent().contains("( ͡° ͜ʖ ͡°)")) {
                event.getTextChannel().sendTyping().queue();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " You're not Lenny... But I am Lenny :sob:.").queue();
                    }
                }, 500);
            }
            if (event.getMessage().getContent().contains("¯\\_(ツ)_/¯")) {
                event.getTextChannel().sendTyping().queue();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " Ok.. You did shrug but I could also do a shrug for you :D. Do %pref%shrug".replace("%pref%", STATIC.PREFIX)).queue();
                    }
                }, 500);
            }

            if (event.getMessage().getContent().contains("ヽ(^o^)ノ")) {
                event.getChannel().sendTyping().queue();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getChannel().sendMessage("HURRAY!").queue();
                    }
                }, 200);
            }


            if (event.getMessage().getContent().contains("SHOTS FIRED") || event.getMessage().getContent().contains("shots fired") || event.getMessage().getContent().contains("shots")) {
                event.getChannel().sendTyping().queue();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getChannel().sendMessage("SHOTS FIRED https://giphy.com/gifs/kpop-k-pop-k-pop-3o84sBvfGL9sXgKDIc").queue();
                    }
                }, 500);
            }
        }

        //end of channel text

    }
}
