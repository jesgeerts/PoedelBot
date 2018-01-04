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


        if (event.getAuthor().isBot()) return;

        if (event.isFromType(ChannelType.TEXT))
        {
            System.out.printf("[%s][%s] %#s: %s%n", event.getGuild().getName(),
                    event.getChannel().getName(), event.getAuthor(), event.getMessage().getContent());
            if (event.getMessage().getContent().startsWith(STATIC.PREFIX) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
                commandHandler.handleCommand(commandHandler.parse.parser(event.getMessage().getContentRaw(), event));
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
