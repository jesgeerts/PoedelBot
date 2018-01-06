package nl.jessegeerts.discordbots.poedelbot.listeners;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

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
                channel.sendTyping().queue();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        channel.sendMessage(event.getAuthor().getAsMention() + " Waarom zou je de tafel terug omdraaien terwijl ik dat al heb gedaan?").queue();
                    }
                }, 1000);
                channel.sendMessage(event.getGuild().getMemberById("264697177736085507").getAsMention() + " is een Poedel 1e klas.").queue();
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

            if(msg.getContentDisplay().contains("poedel") || msg.getContentDisplay().contains("POEDEL") || msg.getContentDisplay().contains("poodle") || msg.getContentDisplay().contains("POODLE")){
                channel.sendMessage(":poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle:").queue();
                channel.sendMessage("https://giphy.com/gifs/poodle-XdihmyBs3QNRm").queue();
            }

            if(msg.getContentDisplay().contains("noot") || msg.getContentDisplay().contains("NOOT") || msg.getContentDisplay().contains("NOOT NOOT") || msg.getContentDisplay().contains("noot noot")){
                channel.sendMessage(":fish: :fish: **NOOT NOOT** :fish: :fish:").queue();
                channel.sendMessage("https://i.jessegeerts.nl/noot_noot.gif").queue();
                channel.sendMessage(":fish: :fish: **NOOT NOOT** :fish: :fish:").queue();
            }
            if(msg.getContentDisplay().contains("carrothost") || msg.getContentDisplay().contains("CARROTHOST") || msg.getContentDisplay().contains("CarrotHost") || msg.getContentDisplay().contains("CARROTHOSTING")){
                channel.sendMessage(event.getAuthor().getAsMention() + " Flikker op met je klote carrot host.. Die staff heeft PoedelHost en AreaHosting regelmatig geddost en hun staff scheld met een k woord (ziekte). Vermijd die host ten alle tijden!\n#ANTI CARROTGAY").queue();
            }
        }

        //end of channel text

    }
}
