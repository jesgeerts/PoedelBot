package nl.jessegeerts.discordbots.poedelbot.command.hostrelated;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;

public class Prijzen implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        EmbedBuilder intro = new EmbedBuilder().setColor(Color.YELLOW);
        EmbedBuilder minecraft = new EmbedBuilder().setColor(Color.GREEN);
        EmbedBuilder webhosting = new EmbedBuilder().setColor(Color.RED);
        EmbedBuilder overig = new EmbedBuilder().setColor(Color.CYAN);
        event.getMessage().delete().queue();
        MessageChannel channel = event.getChannel();

        if (args.length == 0) {
            channel.sendMessage(event.getAuthor().getAsMention() + ", Hier is onze prijslijst: " + event.getGuild().getTextChannelById(STATIC.CHANNEL_PRICES_ID).getAsMention()).queue();
        } else {


            if (args[0].equalsIgnoreCase("lijst")) {
                channel.sendMessage(intro.setTitle("Leuk dat je kijkt!").setDescription("Hey! Leuk dat je kijkt naar onze prijzen. Mocht je nog eventueel vragen hebben dan kan je bij de juiste support kanalen terecht. Zoek je naar een pakket die er hier niet tussen staat? Neem dan contact op met een van de %ceo%.".replace("%ceo%", event.getJDA().getRoleById(STATIC.ROLE_CEO_ID).getAsMention())).build()).queue();
                channel.sendMessage(minecraft.setDescription(
                        "1GB RAM, SSD only: €0,90/mo" +
                                "\n3GB RAM, SSD only: €2,00/mo" +
                                "\n4GB RAM, SSD only: €2,75/mo" +
                                "\n6GB RAM, SSD only: €4,00/mo" +
                                "\n8GB RAM, SSD only: €6,00/mo" +
                                "\n10GB RAM, SSD only: €7,50/mo\n" +
                                "768MB RAM BungeeCord: €0,40/mo (Wil je meer RAM? Dan dien je helaas een normale server hiervoor te bestellen)\n" +
                                "\n\n" +
                                "***Alle pakketten vanaf 6GB zijn opdeelbaar in meerdere servers. Geef dit aan bij het bestellen. Je kunt dit ook later aan laten passen***")
                        .setTitle("Minecraft Shared **MULTICRAFT** Hosting").build()).queue();
                channel.sendMessage(minecraft.setDescription(
                        "1GB RAM, SSD only: €0,75/mo\n" +
                                "3GB RAM, SSD only: €1,75/mo\n" +
                                "4GB RAM, SSD only: €2,25/mo\n" +
                                "6GB RAM, SSD only: €3,50/mo\n" +
                                "8GB RAM, SSD only: €5,50/mo\n" +
                                "10GB RAM, SSD only: €6,50/mo\n" +
                                "768MB RAM BungeeCord: €0,40/mo (Wil je meer RAM? Dan dien je helaas een normale server hiervoor te bestellen)\n" +
                                "\n\n" +
                                "***Alle pakketten vanaf 6GB zijn opdeelbaar in meerdere servers. Geef dit aan bij het bestellen. Je kunt dit ook later aan laten passen***")
                        .setTitle("Minecraft Shared **PTERODACTYL** Hosting").build()).queue();
                channel.sendMessage(minecraft.setTitle("Minecraft Netwerk").setDescription(
                        "2x 3GB - 2x 1GB - 1x BungeeCord 512MB » 5\n" +
                                "2x 4GB - 3x 1GB - 1x BungeeCord 512MB » 8\n" +
                                "1x 6GB - 3x 3GB - 1x 1GB - 1x BungeeCord 768MB » 9,90" +
                                "\n***Je netwerk komt dan op een Pterodactyl panel te staan en je hebt geen eigen panel en je kunt je GB's zelf niet opdelen.*** *Wil je Multicraft als panel? Dan komt er een toeslag van €4,50 per maand extra! (Geef dit aan tijdens het bestellen!)*".replace("%ceo%", event.getGuild().getRoleById(STATIC.ROLE_CEO_ID).getAsMention())).build()).queue();

                channel.sendMessage(minecraft.setTitle("Overige Minecraft Pakketten").setDescription(
                        "8GB RAM, 80GB NVME SSD, DDoS Bescherming » €11" +
                                "\n12GB RAM, 300GB 100% SSD, **GEEN** DDoS bescherming » 9,10" +
                                "\n16GB RAM, 160GB NVME SSD, DDoS Bescherming » 19,50" +
                                "\n24GB RAM, 600GB 100% SSD, **GEEN** DDoS bescherming » 15,20" +
                                "\n32GB RAM, 240GB NVME SSD, DDoS bescherming » 36,40" +
                                "\n50GB RAM, 100% SSD, **GEEN** DDoS bescherming » 27,50" +
                                "\n\n" +
                                "***Je krijgt een eigen panel waarbij je dus je eigen GB's kunt opdelen en beheren. Aldus je kunt dan ook je eigen servers aanmaken :smile:*** *Wil je graag een eigen panel link onder je eigen domeinnaam? Vermeld dit tijdens het bestellen en zorg ervoor dat je een domein al in bezit hebt!*" +
                                "\nDit is wellicht ook wel leuk om te weten: Je krijgt bij de 16GB RAM en de 32GB RAM: SSH toegang! Vraag naar de voorwaarden bij %jesse%".replace("%jesse%", event.getGuild().getMemberById(STATIC.JESSE_DISCORD_TOKEN).getAsMention())
                ).build()).queue();

                channel.sendMessage(overig.setTitle("Overige pakketten").setDescription(

                        "**Domeinen**" +
                                "\nNL DOMEIN » 4,85" +
                                "\nEU DOMEIN » 5,80" +
                                "\nCOM DOMEIN » 8,46" +
                                "\nBE DOMEIN » 6,05" +
                                "\nXYZ DOMEIN » 12,20" +
                                "\n" +
                                "\n**OVERIG**" +
                                "\nTeamspeak (32 slots) » 0,60" +
                                "\nPanel Installatie (Pterodactyl) » 3" +
                                "\nPanel Installatie (Multicraft) » 3,50"

                ).build()).queue();

                channel.sendMessage(new EmbedBuilder().setColor(Color.orange).setTitle("Bot Hosting").setDescription("**LET OP** Je discord bot moet de programmeertaal Java hebben!" +
                        "\n1GB RAM, 10Gbps internet » €1/mo").build()).queue();
                channel.sendMessage("Voor een PaysafeCard transactie vragen wij transactiekosten voor (8% en 5,50 en we moeten dan een hele paysafe code van je overnemen dus zorg ervoor dat je deze niet hebt geclaimed).\nVoor iDEAL vragen wij €0,50 transactiekosten\n**ALGEMENE VOORWAARDEN** Hier is onze algemene voorwaarden: Als je betaald ga je automatisch akkoord met onze algemene voorwaarden die je hier kunt vinden: https://poedelhost.nl/Algemene%20Voorwaarden.php Je gaat er automatisch mee akkoord als je hebt betaald.").queue();

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
