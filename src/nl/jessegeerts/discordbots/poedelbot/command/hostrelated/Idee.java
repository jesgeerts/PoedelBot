package nl.jessegeerts.discordbots.poedelbot.command.hostrelated;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;

import java.awt.*;

public class Idee  implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getMessage().delete().queue();



        if(args.length==0){

            event.getChannel().sendMessage(event.getAuthor().getAsMention() + " FOUT! Je hebt niks ingevuld. Probeer het eens opnieuw. Bijvoorbeeld: ```.idee VPS servers aanbieden```").queue();
            return;
        }

        event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Je idee is verzonden naar onze staff. Hartelijk dank voor je inzending!").queue();
        String msg = "";
        String[] arrayOfString;
        int j = (arrayOfString = args).length;
        for (int i = 0; i < j; i++) {
            String a = arrayOfString[i];
            msg = msg + " " + a;
        }
        EmbedBuilder kek = new EmbedBuilder().setTitle("Nieuwe idee zending").setAuthor(event.getAuthor().getName(), null, event.getAuthor().getEffectiveAvatarUrl())
                .setDescription("Verstuurder: %mentionsender% (%sender%#%tag%)\nWat is je idee?: %msg%".replace("%mentionsender%", event.getAuthor().getAsMention())
                        .replace("%sender%", event.getAuthor().getName()).replace("%tag%", event.getAuthor().getDiscriminator()).replace("%msg%", msg)).setColor(Color.GREEN);

        event.getGuild().getTextChannelById("425052380019556362").sendMessage(kek.build()).queue();


    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}