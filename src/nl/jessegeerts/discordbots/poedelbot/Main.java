package nl.jessegeerts.discordbots.poedelbot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import nl.jessegeerts.discordbots.poedelbot.command.fun.*;
import nl.jessegeerts.discordbots.poedelbot.command.hostrelated.Offtopic;
import nl.jessegeerts.discordbots.poedelbot.command.hostrelated.Prijzen;
import nl.jessegeerts.discordbots.poedelbot.command.hostrelated.Tutorial;
import nl.jessegeerts.discordbots.poedelbot.command.hostrelated.Website;
import nl.jessegeerts.discordbots.poedelbot.command.moderation.Clear;
import nl.jessegeerts.discordbots.poedelbot.command.moderation.Kick;
import nl.jessegeerts.discordbots.poedelbot.command.other.Help;
import nl.jessegeerts.discordbots.poedelbot.core.commandHandler;
import nl.jessegeerts.discordbots.poedelbot.listeners.*;
import nl.jessegeerts.discordbots.poedelbot.listeners.events.Ban;
import nl.jessegeerts.discordbots.poedelbot.listeners.events.BanRemoved;
import nl.jessegeerts.discordbots.poedelbot.listeners.events.Join;
import nl.jessegeerts.discordbots.poedelbot.listeners.events.Leave;
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


        builder.setGame(Game.listening("Blaffende Poedels"));

addListeners();
addCommands();
        try {
            builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RateLimitedException e) {
            e.printStackTrace();
        }
    }

    public static void addCommands(){
        commandHandler.commands.put("clear", new Clear());
        commandHandler.commands.put("help", new Help());
        commandHandler.commands.put("imdone", new ImDone());
        commandHandler.commands.put("i'mdone", new ImDone());
        commandHandler.commands.put("done", new ImDone());
        commandHandler.commands.put("lenny", new Lenny());
        commandHandler.commands.put("len", new Lenny());
        commandHandler.commands.put("shrug", new Shrug());
        commandHandler.commands.put("dog", new Dog());
        commandHandler.commands.put("dogs", new Dog());
        commandHandler.commands.put("doge", new Dog());
        commandHandler.commands.put("hurray", new Hurray());
        commandHandler.commands.put("tut", new Tutorial());
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
        commandHandler.commands.put("ban", new nl.jessegeerts.discordbots.poedelbot.command.moderation.Ban());
        commandHandler.commands.put("banhamer", new nl.jessegeerts.discordbots.poedelbot.command.moderation.Ban());
        commandHandler.commands.put("prijzen", new Prijzen());
        commandHandler.commands.put("pricing", new Prijzen());
        commandHandler.commands.put("eightball", new Eightball());
        commandHandler.commands.put("8ball", new Eightball());
    }

    public static void addListeners(){
        builder.addEventListener(new commandListener());
        builder.addEventListener(new readyListener());
        builder.addEventListener(new messageListener());
        builder.addEventListener(new Join());
        builder.addEventListener(new Leave());
        builder.addEventListener(new Ban());
        builder.addEventListener(new BanRemoved());
    }
}
