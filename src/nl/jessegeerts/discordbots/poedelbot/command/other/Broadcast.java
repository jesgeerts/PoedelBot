package nl.jessegeerts.discordbots.poedelbot.command.other;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Broadcast implements Command {
    @Override
public boolean called(String[] args, MessageReceivedEvent event) {
    return false;
}

    private final String regular(String[] args){
        String msg = "";
        String[] arrayOfString;
        int j = (arrayOfString = args).length;
        for (int i = 0; i < j; i++) {
            String a = arrayOfString[i];
            msg = msg + " " + a;
        }
        return msg;
    }
        @Override
        public void action(String[] args, MessageReceivedEvent event) {
            Message message = event.getMessage();
            message.delete().queue();

            MessageChannel channel = event.getChannel();
            if(event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.ADMINISTRATOR) || event.getGuild().getMember(event.getAuthor()).hasPermission(Permission.MESSAGE_MANAGE)){
                if(args.length==0){
                    channel.sendMessage("Ik doe maar ff niks :stuck_out_tongue: ").complete();
                    return;
                }


                String msg = "";
                String[] arrayOfString;
                int j = (arrayOfString = args).length;
                for (int i = 0; i < j; i++) {
                    String a = arrayOfString[i];
                    msg = msg + " " + a;
                }



                event.getGuild().getRoleById(STATIC.ROLE_ALERTS_ID).getManager().setMentionable(true).queue();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        channel.sendMessage("%alert%\n".replace("%alert%", event.getGuild().getRoleById(STATIC.ROLE_ALERTS_ID).getAsMention())+event.getAuthor().getAsMention() + " **Heeft het volgende verteld:**\n\n" + regular(args) + "\n\n```Bericht is verzonden op: %dag% %maand% %jaar% om %uur%:%min%:%sec%```\n\nWil je niet langer worden getagt? Doe dan: ``.alerts off`` in %botspam%"
                                .replace("%dag%", String.valueOf(message.getCreationTime().getDayOfMonth())).replace("%maand%", String.valueOf(message.getCreationTime().getMonth())).replace("%jaar%", String.valueOf(message.getCreationTime().getYear()))
                                .replace("%uur%", String.valueOf(message.getCreationTime().getHour())).replace("%min%", String.valueOf(message.getCreationTime().getMinute())).replace("%sec%", String.valueOf(message.getCreationTime().getSecond())).replace("%botspam%", event.getGuild().getTextChannelById(STATIC.CHANNEL_BOTCOMMANDS_ID).getAsMention())).queue();
                    }
                }, 500);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        event.getGuild().getRoleById(STATIC.ROLE_ALERTS_ID).getManager().setMentionable(false).queue();
                    }
                }, 1000);
            }else{
                Message tag = channel.sendMessage(event.getAuthor().getAsMention()).complete();
                Message embed = channel.sendMessage(new EmbedBuilder().setTitle("**ERROR 403**").setAuthor(event.getGuild().getOwner().getEffectiveName(), null, event.getGuild().getOwner().getUser().getEffectiveAvatarUrl()).setDescription("%lol% Je hebt hier geen permissie voor %lol%\nJe actie is bijgehouden.".replace("%lol%", LeMojis.lol)).build()).complete();
                event.getGuild().getTextChannelById(STATIC.CHANNEL_NO_PERMISSON_LOG_ID).sendMessage(new EmbedBuilder().setColor(Color.RED)
                        .setAuthor(event.getJDA().getSelfUser().getName(), null, event.getJDA().getSelfUser().getEffectiveAvatarUrl()).setDescription("%author% heeft het volgende gebruikt waar deze persoon geen toegang voor heeft: ``` %msg%```".replace("%author%", event.getAuthor().getAsMention()).replace("%msg%", event.getMessage().getContentDisplay())).build()).queue();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        tag.delete().queue();
                        embed.delete().queue();
                    }
                }, 5000);



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