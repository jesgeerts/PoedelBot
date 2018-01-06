package nl.jessegeerts.discordbots.poedelbot.command.hostrelated;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

import java.awt.*;

public class Prijzen implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        MessageChannel channel = event.getChannel();
        event.getChannel().sendMessage(new EmbedBuilder().setTitle("Prijzen/Pricing").setColor(Color.GREEN)
                .setDescription("***Minecraft pakketten/packages***" +
                        "\n1GB SSD only: €0,75" +
                        "\n3GB SSD only: €1,75" +
                        "\n4GB SSD only: €2,25" +
                        "\n6GB SSD only: €3,50" +
                        "\n8GB SSD only: €5,50" +
                        "\n10GB SSD only: €6,50" +
                        "\n\n" +
                        "***Alle pakketten vanaf 6GB zijn opdeelbaar in meerdere servers. Geef dit aan bij het bestellen./All packages from 6GB are splittable into multiple servers. Notice that whilst ordering the server.***" +
                        "\n***Minecraft Netwerk/Network" +
                        "\n" +
                        "\n***Webhosting met/with SSD***" +
                        "\n5GB: €2/mo, €5/3 months, €9/6 months or €12/yr" +
                        "\n25GB storage: €8/mo, 20/6 months or €32/yr" +
                        "\n"+
                        "\nAlle webhosting pakketten komen met DDoS bescherming, onbeperkt bandbreedte etc./All packages are coming with DDoS protection, unlimited bandwith etc.").build()).queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
