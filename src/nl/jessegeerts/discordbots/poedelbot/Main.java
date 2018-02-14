package nl.jessegeerts.discordbots.poedelbot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import nl.jessegeerts.discordbots.poedelbot.command.fun.*;
import nl.jessegeerts.discordbots.poedelbot.command.fun.poedels.DeDikkePoedel;
import nl.jessegeerts.discordbots.poedelbot.command.fun.poedels.PoedelEersteKlas;
import nl.jessegeerts.discordbots.poedelbot.command.hostrelated.*;
import nl.jessegeerts.discordbots.poedelbot.command.hostrelated.movechat.BotCommands;
import nl.jessegeerts.discordbots.poedelbot.command.hostrelated.movechat.Offtopic;
import nl.jessegeerts.discordbots.poedelbot.command.moderation.Ban;
import nl.jessegeerts.discordbots.poedelbot.command.moderation.Clear;
import nl.jessegeerts.discordbots.poedelbot.command.moderation.Kick;
import nl.jessegeerts.discordbots.poedelbot.command.other.*;
import nl.jessegeerts.discordbots.poedelbot.core.commandHandler;
import nl.jessegeerts.discordbots.poedelbot.listeners.commandListener;
import nl.jessegeerts.discordbots.poedelbot.listeners.events.BannedListener;
import nl.jessegeerts.discordbots.poedelbot.listeners.events.Join;
import nl.jessegeerts.discordbots.poedelbot.listeners.events.Leave;
import nl.jessegeerts.discordbots.poedelbot.listeners.events.Unban;
import nl.jessegeerts.discordbots.poedelbot.listeners.readyListener;
import nl.jessegeerts.discordbots.poedelbot.util.SECRETS;

import javax.security.auth.login.LoginException;

public class Main {

    public static JDABuilder builder;
    public static JDA jda;

    public static void main(String[] Args) {

        builder = new JDABuilder(AccountType.BOT);

        builder.setToken(SECRETS.TOKEN);
        builder.setAutoReconnect(true);

        builder.setStatus(OnlineStatus.ONLINE);


        builder.setGame(Game.watching("Slapende poedels"));

addListeners();
addCommands();
        try {
            builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void addCommands(){
        commandHandler.commands.put("clear", new Clear());
        commandHandler.commands.put("help", new Help());
        commandHandler.commands.put("done", new ImDone());
        commandHandler.commands.put("lenny", new Lenny());
        commandHandler.commands.put("len", new Lenny());
        commandHandler.commands.put("dog", new Dog());
        commandHandler.commands.put("dogs", new Dog());
        commandHandler.commands.put("doge", new Dog());
        commandHandler.commands.put("tut", new Tutorial());
        commandHandler.commands.put("tutorial", new Tutorial());
        commandHandler.commands.put("poedel", new Poedel());
        commandHandler.commands.put("poedels", new Poedel());
        commandHandler.commands.put("vis", new Vis());
        commandHandler.commands.put("gfy", new GFY());
        commandHandler.commands.put("gofuckyourself", new GFY());
        commandHandler.commands.put("wat", new Wat());
        commandHandler.commands.put("website", new Website());
        commandHandler.commands.put("offtopic", new Offtopic());
        commandHandler.commands.put("roll", new Roll());
        commandHandler.commands.put("rol", new Roll());
        commandHandler.commands.put("kick", new Kick());
        commandHandler.commands.put("schop", new Kick());
        commandHandler.commands.put("ban", new Ban());
        commandHandler.commands.put("banhamer", new Ban());
        commandHandler.commands.put("prijzen", new Prijzen());
        commandHandler.commands.put("pricing", new Prijzen());
        commandHandler.commands.put("eightball", new Eightball());
        commandHandler.commands.put("8ball", new Eightball());
        commandHandler.commands.put("pikvis", new Pikvis());
        commandHandler.commands.put("pingpong", new Tennis());
        commandHandler.commands.put("tennis", new Tennis());
        commandHandler.commands.put("botcommands", new BotCommands());
        commandHandler.commands.put("shrek", new Shrek());
        commandHandler.commands.put("shrekt", new Shrek());
        commandHandler.commands.put("dedikkepoedel", new DeDikkePoedel());
        commandHandler.commands.put("dedikkstepoedel", new DeDikkePoedel());
        commandHandler.commands.put("poedeleersteklas", new PoedelEersteKlas());
        commandHandler.commands.put("poedel1eklas", new PoedelEersteKlas());
        commandHandler.commands.put("micdrop", new MicDrop());
        commandHandler.commands.put("sponsor", new Sponsor());
        commandHandler.commands.put("dora", new Dora());
        commandHandler.commands.put("welkomchannelcommand", new Welkomchannelcommand());
        commandHandler.commands.put("givecustomer", new GiveCustomer());
        commandHandler.commands.put("takecustomer", new TakeCustomer());
        commandHandler.commands.put("addmember", new AddMember());
        commandHandler.commands.put("aanbiedingenchannel", new AanbiedingenStartCmd());
        commandHandler.commands.put("poedelfanadvertentie", new Poedelfanadvertentie());
        commandHandler.commands.put("say", new Say());
        commandHandler.commands.put("dikkiedik", new DikkieDik());
        commandHandler.commands.put("dikkie", new DikkieDik());
        commandHandler.commands.put("dik", new DikkieDik());
        commandHandler.commands.put("pbsay", new PBSay());
        commandHandler.commands.put("lol", new Lol());
        commandHandler.commands.put("happy", new Happy());
        commandHandler.commands.put("dikname", new Dikname());
        commandHandler.commands.put("broadcast", new Broadcast());
        commandHandler.commands.put("bottalk", new Talk());
        commandHandler.commands.put("quote", new Quote());
        commandHandler.commands.put("joke", new Joke());
        commandHandler.commands.put("gas", new Gas());
        commandHandler.commands.put("talk", new Talk());
    }

    public static void addListeners(){
        builder.addEventListener(new commandListener());
        builder.addEventListener(new readyListener());
        builder.addEventListener(new Join());
        builder.addEventListener(new Leave());
        builder.addEventListener(new BannedListener());
        builder.addEventListener(new Unban());
    }


}
