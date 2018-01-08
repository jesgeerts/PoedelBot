package nl.jessegeerts.discordbots.poedelbot.command.hostrelated;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;

public class Welkomchannelcommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
event.getMessage().delete().queue();
        MessageChannel channel = event.getChannel();



        channel.sendMessage(new EmbedBuilder().setColor(Color.YELLOW).setTitle("**Welkom**").setDescription("Hallo! En welkom op de discord server van PoedelHost. We vragen aan je om eerst de onderstaande informatie even door te nemen zodat het voor iedereen leuk blifjt.\nHet doel van deze discord server is dat alle klanten en medewerkers van PoedelHost samen komen voor een hele community. Op deze manier is er meer tijd voor de staff om de hosting te verbeteren en dan kunnen wij elkaar zo snel mogelijk helpen. Ben je al nieuwsgierig geworden naar de prijzen? Klik hier dan voor het kanaal %prijzen%".replace("%prijzen%", event.getJDA().getTextChannelById("399880740680237067").getAsMention())).build()).queue();
        channel.sendMessage(new EmbedBuilder().setColor(Color.magenta).setTitle("**Ranks**").setDescription("Al onze staff heeft haar eigen rank binnen de server\nCEO (Eigenaar) hebben %ceo%\nSupport: %support%\nProef-Support: %psupport%\n***Ben je klant bij ons?*** Neem dan contact op met een van de %ceo% zodat je de %klanten% rank krijgt.\nJe hebt als het goed is heb je nu de %member% rank."
        .replace("%ceo%", event.getJDA().getRoleById(STATIC.ROLE_CEO_ID).getAsMention()).replace("%support%", event.getJDA().getRoleById(STATIC.ROLE_SUPPORT_ID).getAsMention()).replace("%psupport%", event.getJDA().getRoleById(STATIC.ROLE_PSUPPORT_ID).getAsMention()).replace("%klanten%", event.getJDA().getRoleById(STATIC.ROLE_CUSTOMER_ID).getAsMention())
        .replace("%member%", event.getJDA().getRoleById(STATIC.ROLE_MEMBER_ID).getAsMention())).build()).queue();



        channel.sendMessage(new EmbedBuilder().setTitle("Regels")
                .setDescription(STATIC.RULES)
                .setColor(Color.RED).build()).queue();
        channel.sendMessage(new EmbedBuilder().setColor(Color.GREEN).setDescription("Verder vragen wij om al je support vragen in de juiste support channels te stellen.\nMinecraft: %minecraftsupport%\nMinecraft Netwerk: %mcnetwork%\nPanel support: %panelsupport%\nWebhosting: %webhostingsupport%\n \nGebruik de bot commands in %botcommands% kanaal"
        .replace("%minecraftsupport%", event.getJDA().getTextChannelById("398419699341197322").getAsMention()).replace("%mcnetwork%", event.getJDA().getTextChannelById("398419736993464322").getAsMention()).replace("%panelsupport%", event.getJDA().getTextChannelById("398419783198179328").getAsMention()).replace("%webhostingsupport%", event.getJDA().getTextChannelById("398419717762711563").getAsMention()).replace("%botcommands%", event.getJDA().getTextChannelById("398421115925561354").getAsMention())+ "\nVoor de prijzen kan je hier terecht: %prijzen%\nEn voor alles wat niet support hoort en gewoon gezellige praat/discussie is hoort in %offtopic%".replace("%offtopic%", event.getJDA().getTextChannelById("398419813577261060").getAsMention()).replace("%prijzen%", event.getJDA().getTextChannelById("399880740680237067").getAsMention())).build()).queue();
        channel.sendMessage(new EmbedBuilder().setDescription("De staff is ten allen tijde gemachtigd om je te bannen of te kicken als wij denken dat het nodig is.\nVerder wenst de staff van PoedelHost je een prettige dag verder en veel plezier op de server!").setColor(Color.BLUE).build()).queue();

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}