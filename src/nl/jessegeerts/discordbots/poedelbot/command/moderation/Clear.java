package nl.jessegeerts.discordbots.poedelbot.command.moderation;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

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
        int numb = getInt(args[0]);
        User user2 = event.getAuthor();


        for (Role role : user2.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getMember(user2).getRoles()) {
            if (role.getId().equalsIgnoreCase(STATIC.ROLE_CEO_ID) || role.getId().equalsIgnoreCase(STATIC.ROLE_STAFF_ID)) {

                if (args.length == 0) {
                    event.getTextChannel().sendTyping().queue();
                    event.getTextChannel().sendMessage(
                            error.setDescription("Hoeveel berichten moet ik voor je verwijderen? Het kan vanaf 2 tot 100").build()
                    ).queue();
                }


                if (numb > 1 && numb <= 100) {

                    try {


                        if (event.getGuild().getSelfMember().hasPermission(Permission.MESSAGE_MANAGE) || event.getGuild().getSelfMember().hasPermission(Permission.ADMINISTRATOR)) {
                            MessageHistory history = new MessageHistory(event.getTextChannel());
                            List<Message> msgs;

                            event.getMessage().delete().queue();

                            msgs = history.retrievePast(numb).complete();

                            event.getTextChannel().deleteMessages(msgs).queue();

                            Message msg = event.getTextChannel().sendMessage(
                                    new EmbedBuilder().setColor(Color.GREEN).setDescription("Deleted " + args[0] + " messages!").build()
                            ).complete();

                            new Timer().schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    msg.delete().queue();
                                }
                            }, 3000);
                        } else {

                            event.getTextChannel().sendTyping().queue();

                            new Timer().schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    event.getTextChannel().sendMessage(event.getAuthor().getAsMention()).queue();
                                    event.getTextChannel().sendMessage(new EmbedBuilder().setDescription("I don't have permission to remove messages. (MESSAGE_MANAGE) OR (ADMINISTRATOR)").setColor(Color.RED).build()).queue();
                                }
                            }, 2000);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        event.getChannel().sendTyping().queue();
                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                event.getTextChannel().sendMessage(
                                        error.setDescription("There was an error occured whilst searching for messages. Probably messages which are older then 2 weeks.\nPlease try an lower value then " + args[0]).build()
                                ).queue();
                            }
                        }, 500);
                    }

                } else {
                    event.getTextChannel().sendTyping().queue();
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            event.getTextChannel().sendMessage(
                                    error.setDescription("Please enter a number of messages between 2 and 100!").build()
                            ).queue();
                        }
                    }, 1000);
                }
            }else{
                event.getChannel().sendMessage("Je hebt geen permsissie").queue();
            }
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

