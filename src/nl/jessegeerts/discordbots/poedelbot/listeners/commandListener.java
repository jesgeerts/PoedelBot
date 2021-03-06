package nl.jessegeerts.discordbots.poedelbot.listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.core.commandHandler;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class commandListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {


        if (event.getAuthor().isBot()) return;

        if (event.isFromType(ChannelType.TEXT))
        {

            EmbedBuilder embed = new EmbedBuilder().setColor(Color.CYAN).setAuthor(event.getAuthor().getName()).setDescription(event.getMessage().getContentDisplay()).setFooter("[%server%] [%channel%]".replace("%server%", event.getAuthor().getName() + "#"+event.getAuthor().getDiscriminator()).replace("%channel%", event.getChannel().getName()), event.getAuthor().getEffectiveAvatarUrl());
            if(event.getGuild().getId().equalsIgnoreCase("397505603179905035")){
                event.getJDA().getGuildById(STATIC.bot_Log_server).getTextChannelById("407983272325414922").sendMessage(embed.build()).queue();
            }else if(event.getGuild().getId().equalsIgnoreCase("398389558099836939")){
                event.getJDA().getGuildById(STATIC.bot_Log_server).getTextChannelById("407986032177446912").sendMessage(embed.build()).queue();
            } else if(event.getGuild().getId().equalsIgnoreCase("404619891698827265")){
                event.getJDA().getGuildById(STATIC.bot_Log_server).getTextChannelById("407986422553903104").sendMessage(embed.build()).queue();
            } else if(event.getGuild().getId().equals("409780291142680577")){
                event.getJDA().getGuildById(STATIC.bot_Log_server).getTextChannelById("409782280396210187").sendMessage(embed.build()).queue();
            }
                else{
                event.getJDA().getGuildById(STATIC.bot_Log_server).getTextChannelById("407921159833780234").sendMessage(embed.build()).queue();
            }

            System.out.printf("[%s][%s] %#s: %s%n", event.getGuild().getName(),
                    event.getChannel().getName(), event.getAuthor(), event.getMessage().getContentDisplay());


            if (event.getMessage().getContentDisplay().startsWith(STATIC.PREFIX) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
                if(event.getGuild().getId().equals(STATIC.DISCORD_SERVER_ID) || event.getGuild().getId().equals("407920941121929217") || event.getGuild().getId().equals("404619891698827265")){
                    if(event.getAuthor().getId().equals("1")){
                        Message msg = event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Je bent verbannen van de discord bot").complete();
                        event.getMessage().delete().queue();
                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                               msg.delete().queue();
                            }
                        }, 1000);
                        return;
                    }
                    commandHandler.handleCommand(commandHandler.parse.parser(event.getMessage().getContentRaw(), event));
                }else{
                    event.getChannel().sendMessage("Ik werk niet in deze server.. DOEI DIKKE POEDELS " + LeMojis.lol).queue();
                    event.getGuild().leave().queue();
                    return;
                }

            }
            if(event.getGuild().getId().equals("421785913673252866")){
                event.getChannel().sendMessage("Rot op dikjood").queue();
                event.getGuild().leave().queue();
            }
            if(event.getAuthor().getId().equals("362542839399186435")){
                event.getChannel().sendMessage("NEE FLIKKER OP ROT MENS DAT JIJ BENT! VIEZE VUILE OPLICHTER DAT JIJ BENT! DOEI DIKJOOD").queue();

                return;
            }
        }


    }

    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        System.out.println("{PRIVATE} " + event.getAuthor().getName() + " : " + event.getMessage().getContentDisplay());
        if(event.getAuthor().getId().equals("362542839399186435")){
            event.getChannel().sendMessage("NEE FLIKKER OP ROT MENS DAT JIJ BENT! VIEZE VUILE OPLICHTER DAT JIJ BENT! DOEI DIKJOOD").queue();
            event.getChannel().close().queue();
            return;
        }

        event.getJDA().getGuildById(STATIC.bot_Log_server).getTextChannelById("407925320826617856").sendMessage(new EmbedBuilder().setColor(Color.RED).setDescription(event.getMessage().getContentDisplay()).setTitle("Een DM ontvangen").setFooter(event.getAuthor().getName() + "#"+event.getAuthor().getDiscriminator(), event.getAuthor().getEffectiveAvatarUrl()).build()).queue();
        event.getChannel().sendMessage(
                new EmbedBuilder().setColor(Color.RED).setDescription("Hallo,\n" +
                        "Je kunt mij alleen gebruiken op de discord van PoedelHost. Je kunt de server joinen met: https://poedelhost.nl/discord\nMet vriendelijke groet,\nJesse")
                        .setTitle("Error 500").setAuthor(event.getJDA().getUserById(STATIC.JESSE_DISCORD_TOKEN).getName(), null, event.getJDA().getUserById(STATIC.JESSE_DISCORD_TOKEN).getEffectiveAvatarUrl()).build()
        ).complete();

    }
}
