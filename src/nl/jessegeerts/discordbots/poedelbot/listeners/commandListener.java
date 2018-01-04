package nl.jessegeerts.discordbots.poedelbot.listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.core.commandHandler;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class commandListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        JDA jda = event.getJDA();
        long responseNumber = event.getResponseNumber();
        User author = event.getAuthor();
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        if (event.getAuthor().isBot()) return;

        if (event.isFromType(ChannelType.TEXT))
        {
            System.out.printf("[%s][%s] %#s: %s%n", event.getGuild().getName(),
                    event.getChannel().getName(), event.getAuthor(), event.getMessage().getContent());
            if (event.getMessage().getContent().startsWith(STATIC.PREFIX) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
                commandHandler.handleCommand(commandHandler.parse.parser(event.getMessage().getContent(), event));
            }
            if(event.getMessage().getContent().contains("(╯°□°）╯︵ ┻━┻")){
                event.getTextChannel().sendTyping().queue();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " Stop flipping tables!\n┬─┬\uFEFF ノ( ゜-゜ノ)").queue();
                    }
                }, 1000);
            }
            if(event.getMessage().getContent().contains("┬─┬\uFEFF ノ( ゜-゜ノ)")){
                event.getTextChannel().sendTyping().queue();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " PLEASE DON'T UNFLIP THE TABLE WHILST IT'S NOT FLIPPED AT ALL!").queue();
                    }
                }, 1000);
            }
            if(event.getMessage().getContent().contains("( ͡° ͜ʖ ͡°)")){
                event.getTextChannel().sendTyping().queue();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " You're not Lenny... But I am Lenny :sob:.").queue();
                    }
                }, 500);
            }
            if(event.getMessage().getContent().contains("¯\\_(ツ)_/¯")){
                event.getTextChannel().sendTyping().queue();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + " Ok.. You did shrug but I could also do a shrug for you :D. Do %pref%shrug".replace("%pref%", STATIC.PREFIX)).queue();
                    }
                }, 500);
            }

            if(event.getMessage().getContent().contains("ヽ(^o^)ノ")){
                event.getChannel().sendTyping().queue();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                    event.getChannel().sendMessage("HURRAY!").queue();
                    }
                }, 200);
            }
            


            if(event.getMessage().getContent().contains("SHOTS FIRED") || event.getMessage().getContent().contains("shots fired") || event.getMessage().getContent().contains("shots")){
                event.getChannel().sendTyping().queue();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getChannel().sendMessage("SHOTS FIRED https://giphy.com/gifs/kpop-k-pop-k-pop-3o84sBvfGL9sXgKDIc").queue();
                    }
                }, 500);
            }




        }


    }

    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        System.out.println("{PRIVATE} " + event.getAuthor().getName().toString() + " : " + event.getMessage().getContent().toString());
        event.getChannel().sendMessage(
                new EmbedBuilder().setColor(Color.RED).setDescription("Hi,\nThanks for using this bot but I'm sorry because this bot works only in public servers.\nKind regards,\nJesse")
                        .setTitle("Error 500").setAuthor("jessegeerts#0330", "https://www.jessegeerts.nl", "https://cdn.discordapp.com/avatars/264697177736085507/86f2c9ab66e111df60bc1dc091e67134.png").build()
        ).complete();
    }
}
