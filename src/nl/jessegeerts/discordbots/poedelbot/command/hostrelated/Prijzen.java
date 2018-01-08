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
event.getMessage().delete().queue();

        MessageChannel channel = event.getChannel();
        channel.sendMessage(intro.setTitle("Leuk dat je kijkt!").setDescription("Hey! Leuk dat je kijkt naar onze prijzen. Mocht je nog eventueel vragen hebben dan kan je bij de juiste support kanalen terecht. Zoek je naar een pakket die er hier niet tussen staat? Neem dan contact op met een van de %ceo%.".replace("%ceo%", event.getJDA().getRoleById(STATIC.ROLE_CEO_ID).getAsMention())).build()).queue();
        channel.sendMessage(minecraft.setDescription(
                "1GB RAM, SSD only: €0,75/mo" +
                "\n3GB RAM, SSD only: €1,75/mo" +
                "\n4GB RAM, SSD only: €2,25/mo" +
                "\n6GB RAM, SSD only: €3,50/mo" +
                "\n8GB RAM, SSD only: €5,50/mo" +
                "\n10GB RAM, SSD only: €6,50/mo" +
                "\n\n" +
                "***Alle pakketten vanaf 6GB zijn opdeelbaar in meerdere servers. Geef dit aan bij het bestellen./All packages from 6GB are splittable into multiple servers. Notice that whilst ordering the server.***")
                .setTitle("Minecraft Shared Hosting").build()).queue();
        channel.sendMessage(minecraft.setTitle("Minecraft Netwerk/Network").setDescription(
                "16GB RAM, DDoS protection, HDD €30/mo" +
                "\n24GB RAM, no DDoS protection, SSD €18/mo" +
                "\n32GB RAM, DDoS protection, SSD €50" +
                "\n***Je krijgt je eigen controle paneel en je krijgt volledige shell toegang./You get your own control panel and shell access onto it.***").build()).queue();


        channel.sendMessage(webhosting.setTitle("Web Hosting").setDescription(
                        "5GB: €2/mo, €5/3 months, €9/6 months or €12/yr" +
                        "\n25GB storage: €8/mo, €20/6 months or €32/yr" +
                        "\n50GB storage: €15/mo, €35/6 months or €45/yr" +
                        "\n***Alle webhosting pakketten komen met DDoS bescherming, onbeperkt bandbreedte etc en cPanel./All packages are coming with DDoS protection, unlimited bandwith etc and cPanel.***").build()).queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
