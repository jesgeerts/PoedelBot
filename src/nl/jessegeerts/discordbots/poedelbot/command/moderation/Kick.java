package nl.jessegeerts.discordbots.poedelbot.command.moderation;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.Args;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Kick implements Command {


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

        if (member3.hasPermission(Permission.ADMINISTRATOR) || member3.hasPermission(Permission.KICK_MEMBERS)) {
            if (message.getMentionedUsers().isEmpty()) {
                Message msg = channel.sendMessage(event.getAuthor().getAsMention()).complete();
                Message msg2 = channel.sendMessage(new EmbedBuilder().setTitle("FOUT").setColor(Color.RED).setDescription("%lol% Tag een persoon om deze actie uit te voeren %lol%".replace("%lol%", LeMojis.lol).replace("%happy%", LeMojis.happy)).build()).complete();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        msg.delete().queue();
                        msg2.delete().queue();
                    }
                }, 2000);
            }
                if(args.length==1){
                    Message noarg1 = channel.sendMessage(event.getAuthor().getAsMention()).complete();
                    Message noarg2 = channel.sendMessage(new EmbedBuilder().setTitle("FOUT").setColor(Color.RED).setDescription("%lol% Vul een reden in %lol%".replace("%lol%", LeMojis.lol).replace("%happy%", LeMojis.happy)).build()).complete();
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            noarg1.delete().queue();
                            noarg2.delete().queue();
                        }
                    }, 2000);
                    return;
                }

                Guild guild = event.getGuild();
                Member selfMember = guild.getSelfMember();  //This is the currently logged in account's Member object.
                // Very similar to JDA#getSelfUser()!

                //Now, we the the logged in account doesn't have permission to kick members.. well.. we can't kick!
                if (!selfMember.hasPermission(Permission.BAN_MEMBERS) || !selfMember.hasPermission(Permission.ADMINISTRATOR)) {
                    channel.sendMessage(tagsender + " HE POEDEL! IK HEB GEEN TOESTEMMING OM POEDELS TE KICKEN").queue();
                    return; //We jump out of the method instead of using cascading if/else
                }

                //Loop over all mentioned users, kicking them one at a time. Mwauahahah!


                User user = event.getMessage().getMentionedUsers().get(0);

                Member member = guild.getMember(user);

                if (!selfMember.canInteract(member)) {
                    channel.sendMessage("Ik kan de poedel %user% niet kicken want deze persoon zit hoger in de hierachie dan ik :sob: :thinking:".replace("%user%", member.getEffectiveName())).queue();
                    return;
                }


                event.getGuild().getMember(message.getMentionedUsers().get(0)).getUser().openPrivateChannel().queue((privateChannel -> privateChannel.sendMessage(new EmbedBuilder()
                        .setColor(Color.RED).setTitle("Je bent eruit getrapt").setDescription("Je bent uit de discord: '_%discord%_' verwijderd.\nVerstuurder: %sender%\nReden: %reden%\nDatum en tijd van insturing: %dag% %maand% %jaar% om %uur%:%min%:%sec%"
                                .replace("%discord%", event.getGuild().getName())
                                .replace("%sender%", event.getAuthor().getAsMention())
                                .replace("%dag%", String.valueOf(message.getCreationTime().getDayOfMonth()))
                                .replace("%maand%", String.valueOf(message.getCreationTime().getMonth()))
                                .replace("%jaar%", String.valueOf(message.getCreationTime().getYear()))
                                .replace("%uur%", String.valueOf(message.getCreationTime().getHour()))
                                .replace("%min%", String.valueOf(message.getCreationTime().getMinute()))
                                .replace("%sec%", String.valueOf(message.getCreationTime().getSecond()))
                                .replace("%reden%", new Args().banandkick(args))).build()).queue()));


                guild.getController().kick(member).queue(success -> channel.sendMessage(new EmbedBuilder().setTitle("Er is iemand stout geweest..").setDescription("Papa Poedel heeft een corrigerende tik aan %target% gegeven\n\nOvertreder: %target%\nVerstuurder: %sender%\nType: KICK\nReden: %reden%\nDatum en tijd van insturing: %dag% %maand% %jaar% om %uur%:%min%:%sec%\n\nMet dank aan %jordy% voor het cadeautjes idee."
                        .replace("%target%", member.getEffectiveName()).replace("%sender%", event.getAuthor().getAsMention()).replace("%reden%", new Args().banandkick(args)).replace("%dag%", String.valueOf(message.getCreationTime().getDayOfMonth())).replace("%maand%", String.valueOf(message.getCreationTime().getMonth())).replace("%jaar%", String.valueOf(message.getCreationTime().getYear()))
                        .replace("%uur%", String.valueOf(message.getCreationTime().getHour())).replace("%min%", String.valueOf(message.getCreationTime().getMinute())).replace("%sec%", String.valueOf(message.getCreationTime().getSecond())).replace("%jordy%", event.getGuild().getMemberById(STATIC.JORDY_DISCORD_TOKEN).getAsMention())
                        .replace("%target%", member.getEffectiveName())).setColor(Color.RED).build()).queue());


            }else {
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