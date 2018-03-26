package nl.jessegeerts.discordbots.poedelbot.command.other;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.LeMojis;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Help implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        Message msg = event.getMessage();
        MessageChannel channel = event.getChannel();

        if (args.length == 0) {





                channel.sendMessage(event.getAuthor().getAsMention()).queue();
                channel.sendMessage(new EmbedBuilder().setDescription("Hey! %mention%,".replace("%mention%", event.getAuthor().getAsMention()) +
                        "\nBen je op zoek naar hulp? Zoja dan kan je een ticket openen ( ``-new MIJN BERICHT VOOR TICKET`` ) of in een van de bijbehorende support kanalen." +
                        "\n\nWilde je anders graag de commands weten? Doe dan .help commands" +
                        "\nFijne dag verder!" +
                        "\n\nPoedel Host staff team\n\n\nPS: Wij hosten deze discord bot op onze bot hosting platform :smile:").setTitle("Help").setColor(Color.ORANGE).setAuthor(event.getJDA().getSelfUser().getName(), "https://poedelhost.nl", event.getJDA().getSelfUser().getEffectiveAvatarUrl()).build()).queue();
                return;



          /**

            channel.sendMessage(new EmbedBuilder().setTitle("Help").setDescription("**Leuke en gezellige commands**\n%pref%dog\n%pref%dora\n%pref%eightball\n%pref%micdrop\n%pref%popcorn\n%pref%roll\n%pref%shrek\n%pref%tennis\n%pref%vis\n%pref%wat\n%pref%gas".replace("%pref%", STATIC.PREFIX)).setColor(Color.ORANGE).build()).queue();
                if(event.getGuild().getName().equalsIgnoreCase("Poedel Host")){
                channel.sendMessage(new EmbedBuilder().setDescription("//Even iets minder serieus Deze bot is voor PoedelHost(ing) gemaakt. Mede mogelijk gemaakt door onze poedel 1e klas: %jesse% en de dikste poedel: %jordy%".replace("%jesse%", event.getGuild().getMemberById(STATIC.JESSE_DISCORD_TOKEN).getAsMention()).replace("%jordy%", event.getGuild().getMemberById(STATIC.JORDY_DISCORD_TOKEN).getAsMention())).build()).queue();
                return;**/
            }
        if(msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help giveallalerts")){



                    for(Member member : event.getGuild().getMembers()){
                        event.getGuild().getController().removeSingleRoleFromMember(member, event.getGuild().getRoleById(STATIC.ROLE_ALERTS_ID)).queue(success -> event.getAuthor().openPrivateChannel().queue((privateChannel -> privateChannel.sendMessage("De persoon %member% krijgt vanaf nu een tag als ze in de alerts role zitten".replace("%member%", member.getEffectiveName())).queue())),
                                error -> channel.sendMessage("Er is iets mis gegaan..").queue());
                    }




        }
            if(msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help commands")){



            EmbedBuilder embedBuilder = new EmbedBuilder().setColor(Color.YELLOW).setAuthor(event.getGuild().getOwner().getEffectiveName(), "https://poedelhost.nl", event.getGuild().getOwner().getUser().getEffectiveAvatarUrl());
            channel.sendMessage(embedBuilder
                    .setDescription("**Hosting commands**\n\n.links - Stuurt je door naar %links% (#links) kanaal\n.prijzen - Stuurt je door naar onze %prijzen% (#prijzen) kanaal".replace("%prijzen%", event.getGuild().getTextChannelById(STATIC.CHANNEL_PRICES_ID).getAsMention()).replace("%links%", event.getGuild().getTextChannelById("425035118688862218").getAsMention()))

                    .build()).queue();

            channel.sendMessage(embedBuilder.setTitle("**Moderatie commands**").setDescription(".pin - Zet een bericht vast (.pin BERICHTID)\n.unpin - Verwijder bericht uit pins (.unpin BERICHTID)\n.kick - Schop een poedel uit de server (.kick @Mention1 @Mention2)\n.ban - Verban een poedel uit de server (.ban @Mention1 @Mention2)\n.clear - Verwijder een aantal berichten uit de chat. Dit kan vanaf 2 (tot 100) berichten en je moet je eigen clear bericht meetellen. (.clear 50)\n.warn - Waarschuw iemand").build()).queue();
            channel.sendMessage(embedBuilder.setTitle("**Administrator/Owner commands**").setDescription(".givecustomer - Geef een klant zijn klanten rank (.givecustomer @Mention1 @Mention2)\n.talk - Laat de bot praten :open_mouth: (.talk JE BERICHT)").build()).queue();
            channel.sendMessage(embedBuilder.setTitle("Pret Commands").setDescription(".dog - Post memedog zonder het doorstuur gedeelte\n.dora - Dora klik op dora! #RackCity!\n.eightball - Laat de beroemde Eightball een voorspelling doen\n.gas - GEEF GAS!\n.happy - Wees net zo blij als Barrack Obama.\n.hatsikidee - HATSIKIDEEE!\n.koekoek - KOEKOEK JONGUH\n.land - Je moet het land uit! (Of mention iemand)\n.lenny - Lenny face\n.lol - Stuurt de %lol% emoji\n.micdrop - Obama mic drop\n.normaal - Doe toch eens normaal!\n.poedel - Stuur schattige fotos van poedels\n.popcorn - *Grabs popcorn*\n.roll - Dobbelsteen\n.shrek - Stuurt een shrekt gif\n.shrug - Haal je schouders op\n.tennis - Lekker tennissen!\n.vis - VISSEN!!!\n.wat - De bekende wat meme").build()).queue();
            channel.sendMessage("Verder hosten wij deze discord bot en %radiolepudel% op ons Bot Hosting platform".replace("%radiolepudel%", event.getGuild().getMemberById("417316799743262720").getAsMention())).queue();

                return;
            }

        msg.delete().queue();
        if(msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help leave") || msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help hoi")){
            if(!event.getGuild().getId().equals(STATIC.DISCORD_SERVER_ID)){
                channel.sendMessage("OK DOEI " + LeMojis.lol + LeMojis.happy).queue();
                event.getGuild().leave().queue();
            }else{
                Message kek = channel.sendMessage(event.getAuthor().getAsMention()+ " NEIN NEIN NEIN NEIN NEIN.. STOMME POEDEL DAT JIJ BENT!").complete();
                Message ok = channel.sendMessage("https://i.imgur.com/sMQoX48.gif").complete();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                      kek.delete().queue();
                    }
                },3000);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                      ok.delete().queue();
                    }
                },5000);
                return;
            }

        }
        if (msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help shutdown")) {
            channel.sendMessage("Attempting to shutdown").queue();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    event.getJDA().getPresence().setPresence(OnlineStatus.INVISIBLE, Game.watching("Slapende poedels"));
                }
            }, 1500);
        }
        if(msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help emojis")){
            channel.sendMessage(String.valueOf(event.getGuild().getEmotes())).complete();
        }
        if (msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help start")) {
            channel.sendMessage("Attempting to going back online").queue();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    event.getJDA().getPresence().setPresence(OnlineStatus.ONLINE, Game.playing(STATIC.GAME));

                }
            }, 1500);
        }

        if (msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help channels")) {
            channel.sendMessage(event.getGuild().getTextChannels().toString()).queue();
        }
        if (msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help roles")) {
            channel.sendMessage(event.getGuild().getRoles().toString()).queue();
        }
        if (msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help users")) {
            channel.sendMessage(event.getGuild().getMembers().toString()).queue();
        }

        if (msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help owner")) {
            channel.sendMessage("De guild/discord server eigenaar: " + event.getGuild().getOwner().getAsMention()).queue();
        }
        if(msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help members")){
            channel.sendMessage(String.valueOf(event.getGuild().getMembers())).queue();
        }

        if (msg.getContentDisplay().equalsIgnoreCase(STATIC.PREFIX + "help image")) {
            channel.sendMessage(event.getAuthor().getAvatarUrl()).queue();
        }
        if (msg.getContentDisplay().equalsIgnoreCase("%pref%help ping".replace("%pref%", STATIC.PREFIX))) {
            channel.sendTyping().queue();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    channel.sendMessage("Mijn ping met de discord '%server%' server: ".replace("%server%" ,event.getGuild().getName())+String.valueOf(event.getJDA().getPing() + "ms")).queue();
                }
            }, 2000);
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


