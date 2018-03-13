package nl.jessegeerts.discordbots.poedelbot.command.other;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;

public class Say implements Command{

    @Override
public boolean called(String[] args, MessageReceivedEvent event) {
    return false;
}

        @Override
        public void action(String[] args, MessageReceivedEvent event) {

           event.getMessage().delete().queue();
            MessageChannel channel = event.getChannel();
            if (args.length == 0) {
                channel.sendMessage("Ik doe maar ff niks :stuck_out_tongue: " + LeMojis.lol).complete();
                return;
            }


            String msg = "";
            String[] arrayOfString;
            int j = (arrayOfString = args).length;
            for (int i = 0; i < j; i++) {
                String a = arrayOfString[i];
                msg = msg + " " + a;
            }
            channel.sendMessage(event.getAuthor().getAsMention() + " zegt: " + msg).queue();
        }

        @Override
        public void executed(boolean sucess, MessageReceivedEvent event) {

        }

        @Override
        public String help() {
            return null;
        }
}


