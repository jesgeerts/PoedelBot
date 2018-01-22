package nl.jessegeerts.discordbots.poedelbot.command.other;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.util.Timer;
import java.util.TimerTask;

public class Help implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        Message msg = event.getMessage();
        MessageChannel channel = event.getChannel();

        if (args.length == 0) {
            channel.sendMessage(new EmbedBuilder().setTitle("Help").setDescription("**Basis commands**\n%pref%website\n%pref%tutorial\n**Leuke en gezellige commands**\n%pref%dog\n%pref%dora\n%pref%eightball\n%pref%pikvis\n%pref%roll\n%pref%shrek\n%pref%tennis\n%pref%vis\n%pref%wat".replace("%pref%", STATIC.PREFIX)).build()).queue();

            channel.sendMessage("//Even iets minder serieus Deze bot is voor PoedelHost(ing) gemaakt. Mede mogelijk gemaakt door onze poedel 1e klas: %jesse% en de dikste poedel: %jordy%".replace("%jesse%", event.getGuild().getMemberById(STATIC.JESSE_DISCORD_TOKEN).getAsMention()).replace("%jordy%", event.getGuild().getMemberById(STATIC.JORDY_DISCORD_TOKEN).getAsMention())).queue();
        }

        msg.delete().queue();
        if (msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help shutdown")) {
            channel.sendMessage("Attempting to shutdown").queue();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    event.getJDA().getPresence().setPresence(OnlineStatus.INVISIBLE, Game.watching("Slapende poedels"));
                }
            }, 1500);
        }
        if (msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help start")) {
            channel.sendMessage("Attempting to going back online").queue();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    event.getJDA().getPresence().setPresence(OnlineStatus.ONLINE, Game.watching("Slapende poedels"));

                }
            }, 1500);
        }

        if (msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help channels")) {
            channel.sendMessage(event.getGuild().getTextChannels().toString()).queue();
        }
        if (msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help roles")) {
            channel.sendMessage(event.getGuild().getRoles().toString()).queue();
        }
        if (msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help users")) {
            channel.sendMessage(event.getGuild().getMembers().toString()).queue();
        }

        if (msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help owner")) {
            channel.sendMessage("De guild/discord server eigenaar: " + event.getGuild().getOwner().getAsMention()).queue();
        }

        if (msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help image")) {
            channel.sendMessage(event.getAuthor().getAvatarUrl()).queue();
        }
        if (msg.getContentDisplay().equalsIgnoreCase("%pref%help ping".replace("%pref%", STATIC.PREFIX))) {
            channel.sendTyping().queue();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    channel.sendMessage("Mijn ping met de discord server: "+String.valueOf(event.getJDA().getPing() + "ms")).queue();
                }
            }, 2000);
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


