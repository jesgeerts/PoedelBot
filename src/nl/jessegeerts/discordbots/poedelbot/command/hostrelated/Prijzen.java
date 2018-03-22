
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
                if (channel.getId().equals("399880740680237067") || channel.getId().equals("426476229122588683")) {
                    channel.sendMessage(intro.setTitle("Leuk dat je kijkt!").setDescription("Hey! Leuk dat je kijkt naar onze prijzen. Mocht je nog eventueel vragen hebben dan kan je bij de juiste support kanalen terecht. Zoek je naar een pakket die er hier niet tussen staat? Neem dan contact op met een van de %ceo%.".replace("%ceo%", event.getJDA().getRoleById(STATIC.ROLE_CEO_ID).getAsMention())).build()).queue();


                    channel.sendMessage(minecraft.setDescription(
                                    "256MB RAM, NVME SSD, » €0,29\n" +
                                    "1GB RAM, NVME SSD » €1,15/mo\n" +
                                    "2GB RAM, NVME SSD » €2,30/mo\n" +
                                    "3GB RAM, NVME SSD » €3,45/mo\n" +
                                    "4GB RAM, NVME SSD » €4,60/mo\n" +
                                    "5GB RAM, NVME SSD » €5,75/mo\n" +
                                    "6GB RAM, NVME SSD » €6,90/mo\n" +
                                    "7GB RAM, NVME SSD » €8,05/mo\n" +
                                    "8GB RAM, NVME SSD » €9,20/mo\n" +
                                    "9GB RAM, NVME SSD » €10,35/mo\n" +
                                    "10GB RAM, NVME SSD » €11,00/mo\n" +
                                    "768MB RAM BungeeCord » €0,95/mo (Wil je meer RAM? Dan dien je helaas een normale server hiervoor te bestellen)\n\n***Het opsplitsen is niet mogelijk in verband met onze administratie. Heb je al een splitsing? Dit blijft dan staan tot je server verloopt***")
                            .setTitle("Minecraft Shared Hosting").build()).queue();

                    channel.sendMessage(minecraft.setTitle("Overige Minecraft Pakketten").setDescription(
                            "8GB RAM, 80GB NVME SSD, DDoS Bescherming » €12,10" +
                                    "\n12GB RAM, 300GB 100% SSD, **GEEN** DDoS bescherming » €11,00" +
                                    "\n16GB RAM, 160GB NVME SSD, DDoS Bescherming » €23,50" +
                                    "\n24GB RAM, 600GB 100% SSD, **GEEN** DDoS bescherming » €18,20" +
                                    "\n32GB RAM, 240GB NVME SSD, DDoS bescherming » €44,00" +
                                    "\n50GB RAM, 100% SSD, **GEEN** DDoS bescherming » €33,00" +
                                    "\n\n" +
                                    "***Je krijgt een eigen panel waarbij je dus je eigen GB's kunt opdelen en beheren. Aldus je kunt dan ook je eigen servers aanmaken :smile:*** *Wil je graag een eigen panel link onder je eigen domeinnaam? Vermeld dit tijdens het bestellen en zorg ervoor dat je een domein al in bezit hebt!*" +
                                    "\nJe krijgt bij alle Overige minecraft pakketten SSH toegang. Vraag deze aan bij %jesse% (Jesse)\n\nAls je pterodactyl of pufferpanel kiest dan is de installatie hiervan inbegrepen. Dus dat kost je niks extra!".replace("%jesse%", event.getGuild().getMemberById(STATIC.JESSE_DISCORD_TOKEN).getAsMention())
                    ).build()).queue();




                    channel.sendMessage(new EmbedBuilder().setTitle("**WEB HOSTING**")
                            .setDescription("\nGRATIS, 1GB, 1,5GB bandbreedte » 0,00 bij gebruik van FREEWEB coupon." +
                                    "\nEmail Hosting 1,5GB opslag, 2GB bandbreedte » €1,50/jaar" +
                                    "\nForum: 3GB, 300GB Bandbreedte » €3,00/jaar" +
                                    "\nStarter: 5GB, 500GB bandbreedte » €5,00/jaar" +
                                    "\nMedium: 8GB, 800GB bandbreedte » €8,00/jaar" +
                                    "\nExpert: 10GB, 1TB bandbreedte » €10,00/jaar" +
                                    "\nExtra Large: 25GB, 2500GB bandbreedte » €25,00/jaar" +
                                    "\nExtra Extra Large: 50GB, 5TB bandbreedte » €35,00/jaar" +
                                    "\n\nAlle webhosting pakketten bevatten onbeperkt MySQL databases, E-Mail adressen, Extra domeinen, subdomeinen, en FTP accounts. Ook hebben iedere webhosting pakketten 1GB RAM en 1 Processor kern.\nWebhosting maakt gebruik van enterprise SSD's wat dus je website lekker snel maakt!\n\nHeb je meer RAM of bandbreedte of processorkracht voor je website nodig? Neem dan contact met ons op met een gedetailleerde uitleg waarom je dat nodig hebt.\n\n\nVoorwaarden free webhosting: 1 pakket per persoon, pakket wordt handmatig geactiveerd. Wil je een 2e free webhosting pakket? Dan betaal je 50 euro aan installatiekosten.").setColor(new Color(96, 170, 238)).build()).queue();

                    channel.sendMessage(overig.setTitle("Overige pakketten").setDescription(

                            "**Domeinen**" +
                                    "\n.nl » €2,95* (Regulier €12,85)" +
                                    "\n.com » €9,00" +
                                    "\n.net » €8,00" +
                                    "\n.eu » €5,50" +
                                    "\n.xyz » €9,00" +
                                    "\n.tk » €7,80" +
                                    "\n.lol » €22,00" +
                                    "\n.nu » €24,50" +
                                    "\n.cloud » €34,00" +
                                    "\n.gratis » €29,00" +
                                    "\n.me » €15,00" +
                                    "\n.frl » €2,84* (Regulier €47)" +
                                    "\n**Domeinen zijn per jaar** *Tarief is voor het eerste jaar. Bij verlenging en transfer geldt de reguliere tarief" +
                                    "\n**Bundels**" +
                                    "\n6GB MC shared, Forum web hosting, .nl domein » €85. Per maand: €7,08 (Los per jaar: €88,75. Per maand los: €7,40)" +
                                    "\n8GB MC shared, Starter web hosting, .com domein » €120. Per maand: €10 (Los per jaar: €124,40. Per maand los: €10,37)" +
                                    "\n10GB MC shared, Extra Large Web hosting, .com domein » €160. Per maand: €13,33  (Los per jaar: €166,00. Per maand los: €18,83)" +
                                    "\n\nZo zie je het dus. De bundels zijn voordeliger dan de items zelf als je ze los zou kopen :D\n**LET OP** Wegens administratieve beperkingen is het alleen mogelijk om voor een jaar af te nemen."

                    ).build()).queue();


                    channel.sendMessage(new EmbedBuilder().setTitle("**Betalingen, Transactiekosten en Algemene voorwaarden**").setDescription("**BTW/Belasting**\nAlle genoemde prijzen zijn hier inclusief BTW (21%) tenzij anders vermeld.\n**BETAALMETHODES**\nWij accepteren het volgende: PayPal, iDEAL, bankoverschrijving en PaySafeCard\n\n**TRANSACTIEKOSTEN**\nVoor een PaySafeCard transactie kunnen de transactiekosten varieren.\nVoor een PayPal Transactie vragen wij €0,40 en 4,5% transactiekosten\nVoor een iDEAL transactie vragen wij 43 cent transactiekosten.\nVoor bankoverschrijving vragen wij geen transactiekosten.\n\n**ALGEMENE VOORWAARDEN**\nDoor een bestelling te plaatsen + betalen ga je automatisch akkoord met onze Algemene voorwaarden. Je kunt deze hier vinden: https://poedelhost.nl/Algemene%20Voorwaarden.php").build()).queue();
                    return;
                } else {
                    channel.sendMessage("https://www.youtube.com/watch?v=UADzqQHLzLE").queue();
                    return;
                }
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
