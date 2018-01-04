package nl.jessegeerts.discordbots.poedelbot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import nl.jessegeerts.discordbots.poedelbot.command.*;
import nl.jessegeerts.discordbots.poedelbot.core.commandHandler;
import nl.jessegeerts.discordbots.poedelbot.listeners.commandListener;
import nl.jessegeerts.discordbots.poedelbot.listeners.readyListener;
import nl.jessegeerts.discordbots.poedelbot.util.SECRETS;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import javax.security.auth.login.LoginException;

public class Main {

    public static JDABuilder builder;

    public static void main(String[] Args) {

        builder = new JDABuilder(AccountType.BOT);

        builder.setToken(SECRETS.TOKEN);
        builder.setAutoReconnect(true);

        builder.setStatus(OnlineStatus.ONLINE);

        builder.setGame(Game.of("Hallo PoedelHost.".replace("%pref%", STATIC.PREFIX)));

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
        commandHandler.commands.put("poedelspam", new Poedelspam());
        commandHandler.commands.put("wat", new Wat());
        commandHandler.commands.put("website", new Website());
    }

    public static void addListeners(){
        builder.addEventListener(new commandListener());
        builder.addEventListener(new readyListener());
    }
}
