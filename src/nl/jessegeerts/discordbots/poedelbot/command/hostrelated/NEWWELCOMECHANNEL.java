package nl.jessegeerts.discordbots.poedelbot.command.hostrelated;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

public class NEWWELCOMECHANNEL implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getMessage().delete().queue();
        MessageChannel channel = event.getChannel();


Message welcome = channel.sendMessage("Welkom op de discord van Poedel Host!\n\n**REGELS** ```%rules%```**Houd al je support vragen in de juiste support channels!**".replace("%rules%", STATIC.RULES)).complete();
channel.sendMessage("**Straf regelement**\nDe staff is ten allen tijden gemachtigd om een warn, kick, mute of ban uit te voeren als zij denken dat dit nodig is.\nVoor complexe vragen willen we bij deze mededelen dat je een ticket moet openen. Je kunt alle urls in %links% vinden\nDe prijzen kan je in %prijzen% vinden."
.replace("%links%", event.getGuild().getTextChannelById(STATIC.CHANNEL_LINKS_ID).getAsMention()).replace("%prijzen%", event.getGuild().getTextChannelById(STATIC.CHANNEL_PRICES_ID).getAsMention())).queue();

        welcome.addReaction(":regional_indicator_n:").queue();
        welcome.addReaction(":regional_indicator_i:").queue();
        welcome.addReaction(":regional_indicator_c:").queue();
        welcome.addReaction(":regional_indicator_e:").queue();
        welcome.addReaction(":poodle:").queue();

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}