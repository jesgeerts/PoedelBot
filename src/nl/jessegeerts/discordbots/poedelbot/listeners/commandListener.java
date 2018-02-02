package nl.jessegeerts.discordbots.poedelbot.listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.core.commandHandler;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;

public class commandListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {


        if (event.getAuthor().isBot()) return;

        if (event.isFromType(ChannelType.TEXT))
        {
            if(event.getGuild().getId().equalsIgnoreCase("397505603179905035")){
                event.getJDA().getGuildById(STATIC.bot_Log_server).getTextChannelById("407983272325414922").sendMessage(new EmbedBuilder().setColor(Color.CYAN).setAuthor(event.getAuthor().getName()).setDescription(event.getMessage().getContentDisplay()).setFooter("[%server%] [%channel%]".replace("%server%", event.getAuthor().getName() + "#"+event.getAuthor().getDiscriminator()).replace("%channel%", event.getChannel().getName()), event.getAuthor().getEffectiveAvatarUrl()).build()).queue();
            }else if(event.getGuild().getId().equalsIgnoreCase("398389558099836939")){
                event.getJDA().getGuildById(STATIC.bot_Log_server).getTextChannelById("407986032177446912").sendMessage(new EmbedBuilder().setColor(Color.CYAN).setAuthor(event.getAuthor().getName()).setDescription(event.getMessage().getContentDisplay()).setFooter("[%server%] [%channel%]".replace("%server%", event.getAuthor().getName() + "#"+event.getAuthor().getDiscriminator()).replace("%channel%", event.getChannel().getName()), event.getAuthor().getEffectiveAvatarUrl()).build()).queue();
            } else if(event.getGuild().getId().equalsIgnoreCase("404619891698827265")){
                event.getJDA().getGuildById(STATIC.bot_Log_server).getTextChannelById("407986422553903104").sendMessage(new EmbedBuilder().setColor(Color.CYAN).setAuthor(event.getAuthor().getName()).setDescription(event.getMessage().getContentDisplay()).setFooter("[%server%] [%channel%]".replace("%server%", event.getAuthor().getName() + "#"+event.getAuthor().getDiscriminator()).replace("%channel%", event.getChannel().getName()), event.getAuthor().getEffectiveAvatarUrl()).build()).queue();
            }
                else{
                event.getJDA().getGuildById(STATIC.bot_Log_server).getTextChannelById("407921159833780234").sendMessage(new EmbedBuilder().setColor(Color.CYAN).setAuthor(event.getAuthor().getName()).setDescription(event.getMessage().getContentDisplay()).setFooter("[%server%] [%channel%]".replace("%server%", event.getAuthor().getName() + "#"+event.getAuthor().getDiscriminator()).replace("%channel%", event.getChannel().getName()), event.getAuthor().getEffectiveAvatarUrl()).build()).queue();
            }

            System.out.printf("[%s][%s] %#s: %s%n", event.getGuild().getName(),
                    event.getChannel().getName(), event.getAuthor(), event.getMessage().getContentDisplay());


            if (event.getMessage().getContentDisplay().startsWith(STATIC.PREFIX) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
                commandHandler.handleCommand(commandHandler.parse.parser(event.getMessage().getContentRaw(), event));
            }
        }


    }

    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        System.out.println("{PRIVATE} " + event.getAuthor().getName() + " : " + event.getMessage().getContentDisplay());
        event.getJDA().getGuildById(STATIC.bot_Log_server).getTextChannelById("407925320826617856").sendMessage(new EmbedBuilder().setColor(Color.RED).setDescription(event.getMessage().getContentDisplay()).setTitle("Een DM ontvangen").setFooter(event.getAuthor().getName() + "#"+event.getAuthor().getDiscriminator(), event.getAuthor().getEffectiveAvatarUrl()).build()).queue();
        event.getChannel().sendMessage(
                new EmbedBuilder().setColor(Color.RED).setDescription("Hallo,\n" +
                        "Je kunt mij alleen gebruiken op de discord van PoedelHost. Je kunt de server joinen met: https://poedelhost.nl/discord\nMet vriendelijke groet,\nJesse")
                        .setTitle("Error 500").setAuthor("Jesse#1337", "https://www.jessegeerts.nl", "https://cdn.discordapp.com/avatars/264697177736085507/86f2c9ab66e111df60bc1dc091e67134.png").build()
        ).complete();
    }
}
