package nl.jessegeerts.discordbots.poedelbot.listeners;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;

public class messageListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();
        Message msg = event.getMessage();
        if (event.getAuthor().isBot()) return;



        if (msg.getContentDisplay().startsWith("Welkom") || msg.getContentDisplay().startsWith("welkom") || msg.getContentDisplay().startsWith("Welkom!") || msg.getContentDisplay().startsWith("welkom!")) {
            channel.sendMessage(":star: :star: Welkom bij Poedel Host! :star: :star: ").queue();
        }

        if(msg.getContentDisplay().contains("zullen we vrienden worden")||msg.getContentDisplay().contains("Zullen we vrienden worden") || msg.getContentDisplay().contains("Wil je vrienden zijn")|| msg.getContentDisplay().contains("wil je vrienden zijn")){
            channel.sendMessage("Mijn enigste vrienden zijn Poedel 1e klas Jesse, Papa poedel Jordy en mijn programmataal: Java " + LeMojis.happy).queue();
        }





        if(msg.getContentDisplay().contains("Tot poedels") || msg.getContentDisplay().contains("tot poedels")){
            channel.sendMessage("Tot poedels! Bij https://poedelhost.nl".replace("%poedelbot%", event.getJDA().getSelfUser().getAsMention())).queue();
        }


        if(msg.getContentDisplay().contains("Ik heb betaald") || msg.getContentDisplay().contains("ik heb betaald")){
            channel.sendMessage("Hallo %user%,\nIk denk dat ik je met deze url je kan helpen: https://klanten.poedelhost.nl/knowledgebase/6/Ik-heb-betaald-maar-ik-heb-mijn-serverorwebhosting-nog-niet-ontvangen.html\nTot poedels!"
                    .replace("%user%", event.getAuthor().getAsMention())).queue();
        }

String emojisrotop = LeMojis.kappa + LeMojis.lol + LeMojis.happyTrump;


        if(msg.getContentDisplay().contains("rot op") || msg.getContentDisplay().contains("Rot op") || msg.getContentDisplay().contains("ROT OP")){

            channel.sendMessage("Dit is verwijderd. OK DOEI" + emojisrotop).queue();
        }


    }
}
