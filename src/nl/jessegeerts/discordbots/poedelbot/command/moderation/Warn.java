package nl.jessegeerts.discordbots.poedelbot.command.moderation;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Warn implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }


    private final String msg(String[] args){
        String msg = "";
        String[] arrayOfString;
        int j = (arrayOfString = args).length;
        for (int i = 1; i < j; i++) {
            String a = arrayOfString[i];
            msg = msg + " " + a;
        }
        return msg;
    }
    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        event.getMessage().delete().queue();
        Member member3 = event.getMember();

        if(member3.hasPermission(Permission.ADMINISTRATOR) || member3.hasPermission(Permission.MESSAGE_MANAGE)){



            if(args.length==0){
                channel.sendMessage(new EmbedBuilder().setColor(Color.RED).setTitle("**ERROR 500**").setDescription("Je mist de gebruiker en de reden. Voorbeeld:\n```.warn @Poedel Host Je bent een grote poedel```").build()).queue();
                return;
            }
            if(args.length==1){
                channel.sendMessage(new EmbedBuilder().setColor(Color.RED).setTitle("**ERROR 500**").setDescription("Je mist de reden. Voorbeeld:\n```.warn @Poedel Host Je bent een grote poedel```").build()).queue();
                return;
            }





            if(args[0].equals(event.getGuild().getOwner().getEffectiveName())){
                channel.sendMessage(event.getAuthor().getAsMention() + " Je kan de eigenaar van deze discord niet warnen " + LeMojis.lol + LeMojis.happy + ".").queue();
                return;
            }



            channel.sendMessage(new EmbedBuilder().setTitle("Er is iemand stout geweest..").setDescription("Deze persoon krijgt eventjes geen cadeautjes van papa poedel..\n\nOvertreder: %target%\nVerstuurder: %sender%\nType: WAARSCHUWING\nReden: %reden%\nDatum en tijd van insturing: %dag% %maand% %jaar% om %uur%:%min%:%sec%\n\nMet dank aan %jordy% voor het cadeautjes idee."
            .replace("%target%", args[0]).replace("%sender%", event.getAuthor().getAsMention()).replace("%reden%", msg(args)).replace("%dag%", String.valueOf(message.getCreationTime().getDayOfMonth())).replace("%maand%", String.valueOf(message.getCreationTime().getMonth())).replace("%jaar%", String.valueOf(message.getCreationTime().getYear()))
                    .replace("%uur%", String.valueOf(message.getCreationTime().getHour())).replace("%min%", String.valueOf(message.getCreationTime().getMinute())).replace("%sec%", String.valueOf(message.getCreationTime().getSecond())).replace("%jordy%", event.getGuild().getMemberById(STATIC.JORDY_DISCORD_TOKEN).getAsMention())).setColor(Color.RED).build()).queue();

            event.getGuild().getMember(message.getMentionedUsers().get(0)).getUser().openPrivateChannel().queue((privateChannel -> privateChannel.sendMessage(new EmbedBuilder()
                    .setColor(Color.RED).setTitle("Je hebt een waarschuwing").setDescription("Je hebt een waarschuwing op de discord: '%discord%'.\nVerstuurder van waarschuwing: %sender%\nReden: %reden%\nDatum en tijd van insturing: %dag% %maand% %jaar% om %uur%:%min%:%sec%"
                    .replace("%discord%", event.getGuild().getName())
                            .replace("%sender%", event.getAuthor().getAsMention())
                            .replace("%dag%", String.valueOf(message.getCreationTime().getDayOfMonth()))
                            .replace("%maand%", String.valueOf(message.getCreationTime().getMonth()))
                            .replace("%jaar%", String.valueOf(message.getCreationTime().getYear()))
                            .replace("%uur%", String.valueOf(message.getCreationTime().getHour()))
                            .replace("%min%", String.valueOf(message.getCreationTime().getMinute()))
                            .replace("%sec%", String.valueOf(message.getCreationTime().getSecond()))
                            .replace("%reden%", msg(args))).build()).queue()));




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