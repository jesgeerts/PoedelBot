package nl.jessegeerts.discordbots.poedelbot.listeners;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;
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

            if(msg.getContentDisplay().contains(event.getGuild().getSelfMember().getAsMention()) || msg.getContentDisplay().contains("@PoedelBot")){
                channel.sendMessage(event.getAuthor().getAsMention() + " Ja wat is er?").queue();
            }
            if (msg.getContentDisplay().contains("┬─┬\uFEFF ノ( ゜-゜ノ)")) {
                channel.sendMessage(event.getAuthor().getAsMention() + " Waarom zou je de tafel terug omdraaien terwijl ik dat al heb gedaan?").queue();
            }

            if(msg.getContentDisplay().contains("lol") || msg.getContentDisplay().contains("Lol") || msg.getContentDisplay().contains("LOL")){
                if(msg.getContentDisplay().contains(STATIC.PREFIX + "lol")){
                    return;
                }
                channel.sendMessage(LeMojis.lol).queue();
            }

            if(msg.getContentDisplay().contains("happy") || msg.getContentDisplay().contains("Happy")){
                if(msg.getContentDisplay().contains(STATIC.PREFIX + "happy")){
                    return;
                }
                channel.sendMessage(LeMojis.happy).queue();
            }


            if(msg.getContentDisplay().contains("\uD83E\uDD26")){
                channel.sendMessage("https://giphy.com/gifs/reactionseditor-classic-facepalm-3og0INyCmHlNylks9O").queue();
            }

            if(msg.getContentDisplay().contains("¯\\_(ツ)_/¯") || msg.getContentDisplay().contains("\uD83E\uDD37")){
                channel.sendMessage("https://giphy.com/gifs/idk-shrug-power-rangers-y65VoOlimZaus").queue();
            }

            if(msg.getContentDisplay().contains("skid") || msg.getContentDisplay().contains("Skid")){
                channel.sendMessage("https://i.jessegeerts.nl/skid.gif").queue();
            }

            if(msg.getContentDisplay().contains("legend") || msg.getContentDisplay().contains("Legend")){
                Message msg2 = channel.sendMessage("https://giphy.com/gifs/david-bowie-davidbowie-starman-7bVRxNQHN34Va").complete();
                msg2.addReaction("\uD83C\uDDF1").queue();
                msg2.addReaction("\uD83C\uDDF2").queue();
                msg2.addReaction("\uD83C\uDDE6").queue();
                msg2.addReaction("\uD83C\uDDF4").queue();
            }

            if(msg.getContentDisplay().equalsIgnoreCase("youtu.be") || msg.getContentDisplay().equalsIgnoreCase("youtube.com") || msg.getContentDisplay().contains("https://www.youtube.com") || msg.getContentDisplay().contains("https://youtu.be")||msg.getContentDisplay().contains("https://www.youtu.be") || msg.getContentDisplay().contains("https://youtube.com")){
                Message msg2 = channel.sendMessage("O leuk! Een YouTube video :D").complete();
                msg2.addReaction("\uD83D\uDE04").queue();
                msg2.addReaction("\uD83D\uDC29").queue();
            }

            if(msg.getContentDisplay().startsWith("clap") || msg.getContentDisplay().startsWith("claps") || msg.getContentDisplay().startsWith("CLAPS") || msg.getContentDisplay().startsWith("CLAP")){
                msg.delete().queue();
                channel.sendMessage("https://giphy.com/gifs/happy-yes-P0RWkdsRpK7ss").queue();
            }

            if(msg.getContentDisplay().startsWith(STATIC.PREFIX + "poedel")){
            return;
            }

            if(msg.getContentDisplay().startsWith("thinking") || msg.getContentDisplay().startsWith("think") || msg.getContentDisplay().startsWith(":thinking:") || msg.getContentDisplay().startsWith("\uD83E\uDD14")){
                channel.sendMessage(":thinking:").queue();
            }
            if(msg.getContentDisplay().contains("pepsi") || msg.getContentDisplay().contains("Pepsi")){
                Message msg2 = channel.sendMessage("<:pepsi:407929729899954206>").complete();
                msg2.addReaction("<:pepsi:407929729899954206>").queue();
                msg2.addReaction("\uD83C\uDDF5").queue();
                msg2.addReaction("\uD83C\uDDEA").queue();
                msg2.addReaction("\uD83C\uDD7F").queue();
                msg2.addReaction("\uD83C\uDDF8").queue();
                msg2.addReaction("\uD83C\uDDEE").queue();

            }
            if(msg.getContentDisplay().contains("Zwanger") || msg.getContentDisplay().contains("zwanger") || msg.getContentDisplay().contains("pregnant") || msg.getContentDisplay().contains("Pregnant")){
                channel.sendMessage(":pregnant_woman: Don't make women pregnant :pregnant_woman: ").queue();
            }
            if(msg.getContentDisplay().contains("gay") || msg.getContentDisplay().contains("GAY")){
                channel.sendMessage("https://giphy.com/gifs/quote-gay-class-fiUYFctPsxGUM").queue();
            }
            if(msg.getContentDisplay().contains("\uD83D\uDC4B")){
                channel.sendMessage("https://giphy.com/gifs/fashion-blog-UrcXN0zTfzTPi").queue();
            }
            if(msg.getContentDisplay().equalsIgnoreCase("rip") || msg.getContentDisplay().equalsIgnoreCase("RIP") || msg.getContentDisplay().equalsIgnoreCase("Rip")){
                channel.sendMessage("https://giphy.com/gifs/dying-TqZZf1OihxJHq").queue();
            }


            if(msg.getContentDisplay().contains("Poedel")||msg.getContentDisplay().contains("Poodle")||msg.getContentDisplay().contains("poedel") || msg.getContentDisplay().contains("POEDEL") || msg.getContentDisplay().contains("poodle") || msg.getContentDisplay().contains("POODLE") || msg.getContentDisplay().contains("\uD83D\uDC29")){
               if(msg.getContentDisplay().contains("PoedelBot") || msg.getContentDisplay().contains("poedelbot") || msg.getContentDisplay().contains(STATIC.PREFIX + "dedikkepoedel") || msg.getContentDisplay().contains(STATIC.PREFIX + "poedel1eklas") || msg.getContentDisplay().contains("poedelhost.nl") || msg.getContentDisplay().contains("poedelhosting.nl") || msg.getContentDisplay().contains("poedelhost")){
                   return;
               }
                channel.sendMessage(":poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle: :poodle:").queue();
                channel.sendMessage("https://i.jessegeerts.nl/1LS.gif").queue();
            }
            if(msg.getContentDisplay().startsWith("welkom") || msg.getContentDisplay().startsWith("Welkom")){
                channel.sendMessage(":star: :star: **WELKOM** bij PoedelHost :star: :star:").queue();
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
                if(msg.getContentDisplay().contains("spammen") || msg.getContentDisplay().contains("Spammen")){
                    return;
                }
            channel.sendMessage("%user% Hilary Clinton vindt dat je een spammer bent https://i.jessegeerts.nl/SPAMMER.jpg".replace("%user%", event.getAuthor().getAsMention())).queue();
            }
            if(msg.getContentDisplay().contains("ok") || msg.getContentDisplay().contains("okeh")|| msg.getContentDisplay().contains("Ok") || msg.getContentDisplay().contains("Okeh")){
                if(msg.getContentDisplay().contains("ook") ||msg.getContentDisplay().contains("Ook")){
                    return;
                }
                channel.sendMessage("https://giphy.com/gifs/reaction-yes-dykJfX4dbM0Vy ").queue();
            }
        }

        //end of channel text

    }
}
