package nl.jessegeerts.discordbots.poedelbot.listeners;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.util.Timer;
import java.util.TimerTask;

public class messageListener extends ListenerAdapter{


    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if (event.isFromType(ChannelType.TEXT)) {
            Message msg = event.getMessage();
            MessageChannel channel = event.getChannel();
            if (msg.getContentDisplay().contains("(╯°□°）╯︵ ┻━┻")) {
                channel.sendTyping().queue();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        channel.sendMessage(event.getAuthor().getAsMention() + " Stop met het omdraaien van tafels..\n┬─┬\uFEFF ノ( ゜-゜ノ)").queue();
                    }
                }, 1000);
            }
            if (msg.getContentDisplay().contains("┬─┬\uFEFF ノ( ゜-゜ノ)")) {
                channel.sendMessage(event.getAuthor().getAsMention() + " Waarom zou je de tafel terug omdraaien terwijl ik dat al heb gedaan?").queue();
            }


            if (msg.getContentDisplay().contains("SHOTS FIRED") || msg.getContentDisplay().contains("shots fired") || msg.getContentDisplay().contains("shots")) {
                channel.sendTyping().queue();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        channel.sendMessage("SHOTS FIRED https://giphy.com/gifs/kpop-k-pop-k-pop-3o84sBvfGL9sXgKDIc").queue();
                    }
                }, 500);
            }

            if(msg.getContentDisplay().startsWith("clap") || msg.getContentDisplay().startsWith("claps") || msg.getContentDisplay().startsWith("CLAPS") || msg.getContentDisplay().startsWith("CLAP")){
                msg.delete().queue();
                channel.sendMessage("https://giphy.com/gifs/happy-yes-P0RWkdsRpK7ss").queue();
            }

            if(msg.getContentDisplay().startsWith(STATIC.PREFIX + "poedel")){
            return;
            }

            if(msg.getContentDisplay().startsWith("thinking") || msg.getContentDisplay().startsWith("think") || msg.getContentDisplay().startsWith(":thinking:") || msg.getContentDisplay().startsWith("\uD83E\uDD14")){
                channel.sendMessage("https://giphy.com/gifs/problem-exam-uzZh2psw4J3ri ").queue();
            }
            if(msg.getContentDisplay().contains("gay") || msg.getContentDisplay().contains("GAY")){
                channel.sendMessage("https://giphy.com/gifs/quote-gay-class-fiUYFctPsxGUM").queue();
            }
            if(msg.getContentDisplay().contains("\uD83D\uDC4B")){
                channel.sendMessage("https://giphy.com/gifs/bye-goodbye-the-little-rascals-GB0lKzzxIv1te").queue();
            }

            if(msg.getContentDisplay().contains("poedel") || msg.getContentDisplay().contains("POEDEL") || msg.getContentDisplay().contains("poodle") || msg.getContentDisplay().contains("POODLE")){
                channel.sendMessage(":poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle:").queue();
                channel.sendMessage("https://giphy.com/gifs/poodle-XdihmyBs3QNRm").queue();
            }
            if(msg.getContentDisplay().contains("bruh") || msg.getContentDisplay().contains("Bruh") || msg.getContentDisplay().contains("BRUH")){
                channel.sendMessage("https://giphy.com/gifs/NrqabhEpXWsGA").queue();
            }

            if(msg.getContentDisplay().contains("noot") || msg.getContentDisplay().contains("NOOT") || msg.getContentDisplay().contains("NOOT NOOT") || msg.getContentDisplay().contains("noot noot")){
                channel.sendMessage(":fish: :fish: **NOOT NOOT** :fish: :fish:").queue();
                channel.sendMessage("https://i.jessegeerts.nl/noot_noot.gif").queue();
                channel.sendMessage(":fish: :fish: **NOOT NOOT** :fish: :fish:").queue();
            }

            if(msg.getContentDisplay().contains("Kan iemand me helpen")||msg.getContentDisplay().contains("Kan iemand mij helpen") ||msg.getContentDisplay().contains("kan iemand me helpen")||msg.getContentDisplay().contains("kan iemand mij helpen")){
                channel.sendMessage(event.getAuthor().getAsMention() + " Met wat kunnen we je helpen? Ik haal eventjes " + event.getGuild().getRoleById(STATIC.ROLE_SUPPORT_ID).getAsMention() + " en " + event.getGuild().getRoleById(STATIC.ROLE_PSUPPORT_ID).getAsMention() + " erbij.").queue();
            }
            if(msg.getContentDisplay().contains("spam") || msg.getContentDisplay().contains("spammer") || msg.getContentDisplay().contains("Spam") || msg.getContentDisplay().contains("SPAMMER")){
            channel.sendMessage("Dat is Hilary Clinton en jij bent een: https://i.jessegeerts.nl/SPAMMER.jpg").queue();
            }
            if(msg.getContentDisplay().contains("ok") || msg.getContentDisplay().contains("okeh")|| msg.getContentDisplay().contains("Ok") || msg.getContentDisplay().contains("Okeh")){
                if(msg.getContentDisplay().contains("ook") ||msg.getContentDisplay().contains("Ook")){
                    return;
                }
                channel.sendMessage("https://giphy.com/gifs/hollywoodsuite-80s-eddie-murphy-beverly-hills-cop-3oEjI5VtIhHvK37WYo").queue();
            }
        }

        //end of channel text

    }
}
