package nl.jessegeerts.discordbots.poedelbot.command.hostrelated;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

public class Poedelfanadvertentie implements Command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        MessageChannel channelMessage = event.getChannel();
        Message msg = event.getMessage();

        if(args.length==0){

            return;
        }
        if(msg.getContentDisplay().contains(STATIC.PREFIX + "poedelfanadvertentie ph")){
            event.getMessage().delete().queue();
            channelMessage.sendMessage("Hey jij daar!\n" +
                    "\n" +
                    "Zoek je een goedkope host voor minder dan 0,80 per maand? Ga dan nu naar <https://poedelhost.nl/discord>\n" +
                    "\n" +
                    "Kleine sneakpeak van onze prijslijst:\n" +
                    "```Shared MC hosting: 6GB voor €3,50 per maand\n" +
                    "Netwerk Hosting 24GB RAM: €15,20 per maand\n" +
                    "```\n" +
                    "\n" +
                    "Ben je al voor de rest benieuwd? Join dan onze discord server!\n" +
                    "\n" +
                    "Wij accepteren PayPal, PaysafeCard, iDEAL en bankoverschrijving!\n" +
                    "\n" +
                    "<https://poedelhost.nl/discord>\n" +
                    "\n" +
                    "Met vriendelijke groet,\n" +
                    "PoedelHost staff team").queue();
            return;
        }
        if(msg.getContentDisplay().contains(STATIC.PREFIX + "poedelfanadvertentie ah")){
            event.getMessage().delete().queue();
            channelMessage.sendMessage("Hey jij daar!\n" +
                    "\n" +
                    "Zoek je een goedkope host voor minder dan 0,85 per maand? Ga dan nu naar <https://areahosting.nl/discord>\n" +
                    "\n" +
                    "Kleine sneakpeak van onze prijslijst:\n" +
                    "```Shared MC hosting: 1GB voor €0,80 per maand\n" +
                    "Netwerk Hosting 6GB RAM: €7,50 per maand\n" +
                    "```\n" +
                    "\n" +
                    "Ben je al voor de rest benieuwd? Join dan onze discord server!\n" +
                    "\n" +
                    "Wij accepteren PayPal, PaysafeCard, iDEAL en bankoverschrijving!\n" +
                    "\n" +
                    "<https://areahosting.nl/discord>\n" +
                    "\n" +
                    "Met vriendelijke groet,\n" +
                    "AreaHosting staff team").queue();
            return;
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
