package nl.jessegeerts.discordbots.poedelbot.listeners;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class messageListener extends ListenerAdapter{


    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if (event.isFromType(ChannelType.TEXT)) {

            if (event.getMessage().getContentDisplay().contains("(╯°□°）╯︵ ┻━┻")) {
                event.getTextChannel().sendTyping().queue();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " Stop met het omdraaien van tafels..\n┬─┬\uFEFF ノ( ゜-゜ノ)").queue();
                    }
                }, 1000);
            }
            if (event.getMessage().getContentDisplay().contains("┬─┬\uFEFF ノ( ゜-゜ノ)")) {
                event.getTextChannel().sendTyping().queue();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " Waarom zou je de tafel terug omdraaien terwijl ik dat al heb gedaan?").queue();
                    }
                }, 1000);
                event.getChannel().sendMessage(event.getGuild().getMemberById("264697177736085507").getAsMention() + " is een Poedel 1e klas.").queue();
            }


            if (event.getMessage().getContentDisplay().contains("SHOTS FIRED") || event.getMessage().getContentDisplay().contains("shots fired") || event.getMessage().getContentDisplay().contains("shots")) {
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
