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
import nl.jessegeerts.discordbots.poedelbot.command.hostrelated.movechat.Minecraft;
import nl.jessegeerts.discordbots.poedelbot.command.hostrelated.movechat.Offtopic;
import nl.jessegeerts.discordbots.poedelbot.command.moderation.*;
import nl.jessegeerts.discordbots.poedelbot.command.other.*;
import nl.jessegeerts.discordbots.poedelbot.command.other.brb.Back;
import nl.jessegeerts.discordbots.poedelbot.command.other.brb.Brb;
import nl.jessegeerts.discordbots.poedelbot.command.other.owner.*;
import nl.jessegeerts.discordbots.poedelbot.listeners.commandListener;
import nl.jessegeerts.discordbots.poedelbot.listeners.events.BannedListener;
import nl.jessegeerts.discordbots.poedelbot.listeners.events.Join;
import nl.jessegeerts.discordbots.poedelbot.listeners.events.Leave;
import nl.jessegeerts.discordbots.poedelbot.listeners.events.Unban;
import nl.jessegeerts.discordbots.poedelbot.listeners.messageListener;
import nl.jessegeerts.discordbots.poedelbot.listeners.readyListener;
import nl.jessegeerts.discordbots.poedelbot.util.SECRETS;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

import javax.security.auth.login.LoginException;

import static nl.jessegeerts.discordbots.poedelbot.core.commandHandler.commands;

public class Main {



    public static JDABuilder builder;
    public static JDA jda;

    public static void main(String[] args) {

        builder = new JDABuilder(AccountType.BOT);

        builder.setToken(SECRETS.TOKEN);
        builder.setAutoReconnect(true);

        builder.setStatus(OnlineStatus.ONLINE);


builder.setGame(Game.playing(STATIC.GAME));

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
        commands.put("clear", new Clear());
        commands.put("help", new Help());
        commands.put("done", new ImDone());
        commands.put("lenny", new Lenny());
        commands.put("len", new Lenny());
        commands.put("dog", new Dog());
        commands.put("dogs", new Dog());
        commands.put("doge", new Dog());
        commands.put("tut", new Tutorial());
        commands.put("tutorial", new Tutorial());
        commands.put("poedel", new Poedel());
        commands.put("poedels", new Poedel());
        commands.put("vis", new Vis());
        commands.put("gfy", new GFY());
        commands.put("gofuckyourself", new GFY());
        commands.put("wat", new Wat());
        commands.put("offtopic", new Offtopic());
        commands.put("roll", new Roll());
        commands.put("rol", new Roll());
        commands.put("kick", new Kick());
        commands.put("schop", new Kick());
        commands.put("ban", new Ban());
        commands.put("banhamer", new Ban());
        commands.put("prijzen", new Prijzen());
        commands.put("pricing", new Prijzen());
        commands.put("eightball", new Eightball());
        commands.put("8ball", new Eightball());
        commands.put("pingpong", new Tennis());
        commands.put("tennis", new Tennis());
        commands.put("botcommands", new BotCommands());
        commands.put("shrek", new Shrek());
        commands.put("shrekt", new Shrek());
        commands.put("dedikkepoedel", new DeDikkePoedel());
        commands.put("dedikkstepoedel", new DeDikkePoedel());
        commands.put("poedeleersteklas", new PoedelEersteKlas());
        commands.put("poedel1eklas", new PoedelEersteKlas());
        commands.put("micdrop", new MicDrop());
        commands.put("dora", new Dora());
        commands.put("welkomchannelcommand", new Welkomchannelcommand());
        commands.put("givecustomer", new GiveCustomer());
        commands.put("takecustomer", new TakeCustomer());
        commands.put("addmember", new AddMember());
        commands.put("aanbiedingenchannel", new AanbiedingenStartCmd());
        commands.put("say", new Say());
        commands.put("pbsay", new PBSay());
        commands.put("lol", new Lol());
        commands.put("happy", new Happy());
        commands.put("dikname", new Dikname());
        commands.put("broadcast", new Broadcast());
        commands.put("bottalk", new PBSay());
        commands.put("quote", new Quote());
        commands.put("gas", new Gas());
        commands.put("talk", new PBSay());
        commands.put("shrug", new Shrug());
        commands.put("popcorn", new Popcorn());
        commands.put("pin", new Pin());
        commands.put("unpin",new Unpin());
        commands.put("brb", new Brb());
        commands.put("back", new Back());
        commands.put("koekoek", new Koekoek());
        commands.put("jonge", new Koekoek());
        commands.put("minecraft", new Minecraft());
        commands.put("botspam", new BotCommands());
        commands.put("mc", new Minecraft());
        commands.put("vroom", new Vroom());
        commands.put("famkelouise", new Vroom());
        commands.put("famke", new Vroom());
        commands.put("mute", new Mute());
        commands.put("unmute", new UnMute());
        commands.put("serverinfo", new ServerInfo());
        commands.put("hatsikidee", new Hatsikidee());
        commands.put("normaal", new Normaal());
        commands.put("talkinguild", new TalkInGuild());
        commands.put("leaveinguild", new LeaveGuild());
        commands.put("leaveguild", new LeaveGuild());
        commands.put("grabowner", new GrabOwnerGuild());
        commands.put("guildchannels", new GuildChannels());
        commands.put("talkguildchat", new TalkGuildChat());
        commands.put("getguilds", new GetGuilds());
        commands.put("aap",new Aap());
        commands.put("no", new No());
        commands.put("banid", new BanID());
        commands.put("unbanid", new UnbanID());
        commands.put("kickid", new KickID());
        commands.put("guildban", new GuildBan());
        commands.put("game", new GameRequest());
        commands.put("gamerequest", new GameRequest());
        commands.put("reqgame", new GameRequest());
        commands.put("aanvraag", new GameRequest());
        commands.put("land", new Land());
        commands.put("grappig", new Land());

        commands.put("panel", new Links());
        commands.put("links", new Links());
        commands.put("link", new Links());
        commands.put("klanten", new Links());
        commands.put("website", new Links());
        commands.put("cpanel", new Links());
        commands.put("idee", new Idee());
        commands.put("warn", new Warn());

        commands.put("facepalm", new Facepalm());
        commands.put("yes", new Yes());
        commands.put("idc", new Idc());

        commands.put("alert", new Alerts());
        commands.put("alerts", new Alerts());
    }

    public static void addListeners(){
        builder.addEventListener(new commandListener());
        builder.addEventListener(new readyListener());
        builder.addEventListener(new Join());
        builder.addEventListener(new Leave());
        builder.addEventListener(new BannedListener());
        builder.addEventListener(new Unban());
        builder.addEventListener(new messageListener());


    }


}
