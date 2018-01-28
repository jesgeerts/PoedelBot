package nl.jessegeerts.discordbots.poedelbot.command.moderation;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

import java.awt.*;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Clear implements Command {

    EmbedBuilder error = new EmbedBuilder().setColor(Color.RED);

    private int getInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
Member selfMember = event.getGuild().getSelfMember();
MessageChannel channel = event.getChannel();
Member member3 =event.getMember();



        if(member3.hasPermission(Permission.ADMINISTRATOR) || member3.hasPermission(Permission.MESSAGE_MANAGE)){
            if (args.length == 0) {
                channel.sendMessage(
                        error.setDescription("Hoeveel berichten moet ik voor je verwijderen? Het kan vanaf 2 tot 100").build()
                ).queue();
            }

            int numb = getInt(args[0]);
            if (numb > 1 && numb <= 100) {

                try {


                    if (selfMember.hasPermission(Permission.MESSAGE_MANAGE) || selfMember.hasPermission(Permission.ADMINISTRATOR)) {
                        MessageHistory history = new MessageHistory(event.getTextChannel());
                        List<Message> msgs;

                        event.getMessage().delete().queue();

                        msgs = history.retrievePast(numb).complete();

                        event.getTextChannel().deleteMessages(msgs).queue();

                        Message msg = channel.sendMessage(
                                new EmbedBuilder().setColor(Color.GREEN).setDescription("%msgs% berichten zijn verwijderd".replace("%msgs%", args[0])).build()
                        ).complete();

                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                msg.delete().queue();
                            }
                        }, 3000);
                    } else {

                        channel.sendTyping().queue();

                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                channel.sendMessage(event.getAuthor().getAsMention()).queue();
                                channel.sendMessage(new EmbedBuilder().setDescription("Ik heb geen permissie om berichten te verwijderen. (MESSAGE_MANAGE) of (ADMINISTRATOR)").setColor(Color.RED).build()).queue();
                            }
                        }, 2000);
                    }

                } catch (Exception e) {

                    Message msg = channel.sendMessage(
                            new EmbedBuilder().setColor(Color.RED).setDescription("Er is iets fout gegaan tijdens het zoeken van berichten. Wellicht zijn het berichten die ouder zijn dan 2 weken.\nProbeer iets minder dan %arg%".replace("%arg%", args[0])).build()
                    ).complete();

                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            msg.delete().queue();
                        }
                    },500);
                }

            } else {
                channel.sendTyping().queue();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {

                        Message msg = channel.sendMessage(
                                new EmbedBuilder().setColor(Color.RED).setDescription("Please enter a number of messages between 2 and 100!").build()
                        ).complete();


                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                msg.delete().queue();
                            }
                        },500);
                    }
                }, 1000);
            }
        }else{
            event.getMessage().delete().queue();
            if(!event.getAuthor().hasPrivateChannel()){
                event.getAuthor().openPrivateChannel().queue();
            }
            event.getAuthor().openPrivateChannel().queue((privateChannel) ->
            {
                privateChannel.sendMessage(new EmbedBuilder().setColor(Color.RED).setTitle("Geen permissie").setDescription("**TOEGANG GEWEIGERD**\nJe toegang tot dit command is geweigerd.\n\nHet commando wat je deed was: %msg%\nIn de discord server: %server%".replace("%msg%", event.getMessage().getContentDisplay()).replace("%server%",event.getGuild().getName())).build()).queue();
            });
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

