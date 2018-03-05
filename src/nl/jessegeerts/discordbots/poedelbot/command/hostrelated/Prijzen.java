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
                        "1GB RAM, NVME SSD: €0,79/mo" +
                                "\n3GB RAM, NVME SSD: €2,30/mo" +
                                "\n4GB RAM, NVME SSD: €3,10/mo" +
                                "\n6GB RAM, NVME SSD: €4,70/mo" +
                                "\n8GB RAM, NVME SSD: €6,30/mo" +
                                "\n10GB RAM, NVME SSD: €7,56/mo\n" +
                                "768MB RAM BungeeCord: €0,50/mo (Wil je meer RAM? Dan dien je helaas een normale server hiervoor te bestellen)\n" +
                                "\n\n" +
                                "***Alle pakketten vanaf 6GB zijn opdeelbaar in meerdere servers. Geef dit aan bij het bestellen. Je kunt dit ook later aan laten passen***")
                        .setTitle("Minecraft Shared **Pterodactyl** Hosting").build()).queue();


                channel.sendMessage(minecraft.setDescription(
                        "1GB RAM, NVME SSD: €0,76/mo\n" +
                                "3GB RAM, NVME SSD: €2,26/mo\n" +
                                "4GB RAM, NVME SSD: €3,00/mo\n" +
                                "6GB RAM, NVME SSD: €4,55/mo\n" +
                                "8GB RAM, NVME SSD: €6,05/mo\n" +
                                "10GB RAM, NVME SSD: €7,55/mo\n" +
                                "768MB RAM BungeeCord: €0,45/mo (Wil je meer RAM? Dan dien je helaas een normale server hiervoor te bestellen)\n" +
                                "\n\n" +
                                "***Alle pakketten vanaf 6GB zijn opdeelbaar in meerdere servers. Geef dit aan bij het bestellen. Je kunt dit ook later aan laten passen***")
                        .setTitle("Minecraft Shared **Multicraft** Hosting").build()).queue();


                channel.sendMessage(minecraft.setTitle("Minecraft Netwerk").setDescription(
                        "2x 3GB - 2x 1GB - 1x BungeeCord 512MB » 6,99\n" +
                                "2x 4GB - 3x 1GB - 1x BungeeCord 512MB » 8\n" +
                                "1x 6GB - 3x 3GB - 1x 1GB - 1x BungeeCord 768MB » 13" +
                                "\n***Je netwerk komt dan op een Multicraft panel te staan en je hebt geen eigen panel en je kunt je GB's zelf niet opdelen.*** *Wil je graag Pterodactyl? Dat is dan €1/pm extra! (Geef dit aan tijdens het bestellen)*".replace("%ceo%", event.getGuild().getRoleById(STATIC.ROLE_CEO_ID).getAsMention())).build()).queue();

                channel.sendMessage(minecraft.setTitle("Overige Minecraft Pakketten").setDescription(
                        "8GB RAM, 80GB NVME SSD, DDoS Bescherming » €11" +
                                "\n12GB RAM, 300GB 100% SSD, **GEEN** DDoS bescherming » 9,10" +
                                "\n16GB RAM, 160GB NVME SSD, DDoS Bescherming » 19,50" +
                                "\n24GB RAM, 600GB 100% SSD, **GEEN** DDoS bescherming » 15,20" +
                                "\n32GB RAM, 240GB NVME SSD, DDoS bescherming » 36,40" +
                                "\n50GB RAM, 100% SSD, **GEEN** DDoS bescherming » 27,50" +
                                "\n\n" +
                                "***Je krijgt een eigen panel waarbij je dus je eigen GB's kunt opdelen en beheren. Aldus je kunt dan ook je eigen servers aanmaken :smile:*** *Wil je graag een eigen panel link onder je eigen domeinnaam? Vermeld dit tijdens het bestellen en zorg ervoor dat je een domein al in bezit hebt!*" +
                                "\nDit is wellicht ook wel leuk om te weten: Je krijgt bij de 16GB RAM en de 32GB RAM: SSH toegang! Vraag naar de voorwaarden bij %jesse% (Jesse).\n\nAls je pterodactyl of pufferpanel kiest dan is de installatie hiervan inbegrepen. Dus dat kost je niks extra!".replace("%jesse%", event.getGuild().getMemberById(STATIC.JESSE_DISCORD_TOKEN).getAsMention())
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
                                "\nTeamspeak (32 slots) » 0,60"

                ).build()).queue();



                channel.sendMessage(new EmbedBuilder().setTitle("**WEB HOSTING**")
                        .setDescription("Forum: 1GB, 100GB Bandbreedte » 0,50/mo" +
                                "\nStarter: 2GB, 200GB bandbreedte » 2/mo" +
                                "\nMedium: 4GB, 400GB bandbreedte » 4/mo" +
                                "\nExpert: 8GB, 800GB bandbreedte » 8/mo" +
                                "\nExtra Large: 25GB, 2500GB bandbreedte » 25/mo" +
                                "\nExtra Extra Large: 50GB, 5TB bandbreedte » 35/mo" +
                                "\n\nAlle webhosting pakketten bevatten onbeperkt MySQL databases, E-Mail adressen, Extra domeinen, subdomeinen, en FTP accounts. Ook hebben iedere webhosting pakketten 1GB RAM en 1 Processor kern.\nWebhosting maakt gebruik van enterprise SSD's wat dus je website lekker snel maakt!\n\nHeb je meer RAM of bandbreedte of processorkracht voor je website nodig? Neem dan contact met ons op met een gedetailleerde uitleg waarom je dat nodig hebt.").setColor(new Color(96, 170, 238)).build()).queue();

                channel.sendMessage(new EmbedBuilder().build()).queue();


                channel.sendMessage(new EmbedBuilder().setColor(Color.orange).setTitle("Bot Hosting").setDescription("**LET OP** Je discord bot moet de programmeertaal Java hebben!" +
                        "\n1GB RAM, 10Gbps internet » €1/mo").build()).queue();

                channel.sendMessage(new EmbedBuilder().setTitle("**Betalingen, Transactiekosten en Algemene voorwaarden**").setDescription("**BETAALMETHODES**\nWij accepteren het volgende: PayPal, iDEAL, bankoverschrijving en PaySafeCard\n\n**TRANSACTIEKOSTEN**\nVoor een PaySafeCard transactie kunnen de transactiekosten varieren.\nVoor een iDEAL transactie vragen wij 50 cent transactiekosten.\nVoor bankoverschrijving en PayPal vragen wij geen transactiekosten.\n\n**ALGEMENE VOORWAARDEN**\nDoor een bestelling te plaatsen + betalen ga je automatisch akkoord met onze Algemene voorwaarden. Je kunt deze hier vinden: https://poedelhost.nl/Algemene%20Voorwaarden.php").build()).queue();

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
