package nl.jessegeerts.discordbots.poedelbot.command.moderation;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class BanID implements Command {

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
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getMessage().delete().queue();

        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();



        String tagsender = event.getAuthor().getAsMention();
        Member member3 = event.getMember();

        if(member3.hasPermission(Permission.ADMINISTRATOR) || member3.hasPermission(Permission.BAN_MEMBERS)) {
            if (args.length==0) {
                Message msg = channel.sendMessage(event.getAuthor().getAsMention()).complete();
                Message msg2 = channel.sendMessage(new EmbedBuilder().setTitle("FOUT").setColor(Color.RED).setDescription("%lol% Vul een ID in om deze actie uit te voeren %lol%".replace("%lol%", LeMojis.lol).replace("%happy%", LeMojis.happy)).build()).complete();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        msg.delete().queue();
                        msg2.delete().queue();
                    }
                }, 2000);
            } else {
                Guild guild = event.getGuild();
                Member selfMember = guild.getSelfMember();  //This is the currently logged in account's Member object.
                // Very similar to JDA#getSelfUser()!

                //Now, we the the logged in account doesn't have permission to kick members.. well.. we can't kick!
                if (!selfMember.hasPermission(Permission.BAN_MEMBERS) || !selfMember.hasPermission(Permission.ADMINISTRATOR)) {
                    channel.sendMessage(tagsender + " HE POEDEL! IK HEB GEEN TOESTEMMING OM POEDELS TE BANNEN").queue();
                    return; //We jump out of the method instead of using cascading if/else
                }

                //Loop over all mentioned users, kicking them one at a time. Mwauahahah!







                User user = event.getJDA().getUserById(args[0]);

                Member member = guild.getMember(user);

                if(!selfMember.canInteract(member)){
                    channel.sendMessage("Ik kan de poedel %user% niet bannen want deze persoon zit hoger in de hierachie dan ik :sob: :thinking:".replace("%user%", member.getEffectiveName())).queue();
                    return;
                }


               event.getJDA().getUserById(args[0]).openPrivateChannel().queue((privateChannel -> privateChannel.sendMessage(new EmbedBuilder()
                        .setColor(Color.RED).setTitle("Je hebt een waarschuwing").setThumbnail("https://giphy.com/gifs/hammer-super-mario-8-bit-qPD4yGsrc0pdm").setDescription("Je bent verbannen van de discord: '%discord%'.\nVerstuurder: %sender%\nReden: %reden%\nDatum en tijd van insturing: %dag% %maand% %jaar% om %uur%:%min%:%sec%"
                                .replace("%discord%", event.getGuild().getName())
                                .replace("%sender%", event.getAuthor().getAsMention())
                                .replace("%dag%", String.valueOf(message.getCreationTime().getDayOfMonth()))
                                .replace("%maand%", String.valueOf(message.getCreationTime().getMonth()))
                                .replace("%jaar%", String.valueOf(message.getCreationTime().getYear()))
                                .replace("%uur%", String.valueOf(message.getCreationTime().getHour()))
                                .replace("%min%", String.valueOf(message.getCreationTime().getMinute()))
                                .replace("%sec%", String.valueOf(message.getCreationTime().getSecond()))
                                .replace("%reden%", msg(args))).build()).queue()));


                guild.getController().ban(args[0], 1).queue( success -> channel.sendMessage(new EmbedBuilder().setTitle("Zo.. Die is verbannen").setThumbnail("https://giphy.com/gifs/hammer-super-mario-8-bit-qPD4yGsrc0pdm").setTitle("Er is iemand stout geweest..").setDescription("Papa Poedel is heel boos op %target%\n\nOvertreder: %target%\nVerstuurder: %sender%\nType: BAN\nReden: %reden%\nDatum en tijd van insturing: %dag% %maand% %jaar% om %uur%:%min%:%sec%\n\nMet dank aan %jordy% voor het cadeautjes idee."
                        .replace("%target%", event.getJDA().getUserById(args[0]).getAsMention()).replace("%sender%", event.getAuthor().getAsMention()).replace("%reden%", msg(args)).replace("%dag%", String.valueOf(message.getCreationTime().getDayOfMonth())).replace("%maand%", String.valueOf(message.getCreationTime().getMonth())).replace("%jaar%", String.valueOf(message.getCreationTime().getYear()))
                        .replace("%uur%", String.valueOf(message.getCreationTime().getHour())).replace("%min%", String.valueOf(message.getCreationTime().getMinute())).replace("%sec%", String.valueOf(message.getCreationTime().getSecond())).replace("%jordy%", event.getGuild().getMemberById(STATIC.JORDY_DISCORD_TOKEN).getAsMention())
                        .replace("%target%", member.getEffectiveName())).setColor(Color.RED).build()).queue());





            }
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
