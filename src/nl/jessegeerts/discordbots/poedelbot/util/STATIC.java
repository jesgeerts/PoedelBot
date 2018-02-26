package nl.jessegeerts.discordbots.poedelbot.util;


import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;

public class STATIC {
    public static final String VERSION = "0.5-BETA";

    public static final String GAME = "https://www.poedelhost.nl/discord";

    public static final String PREFIX = ".";


public static final String RULES = "1. Spammen is verboden\n2. Schelden is niet toegestaan!\n3. Wees vriendelijk tegen elkaar. We hebben geen zin dat het een chagrijnige boel wordt.\n4. Discriminatie of racisme is verboden" +
        "\n5. Niet onnodig mensen of ranks pingen (@naam). Een keer is meestal voldoende.\n6. Reclame maken voor andere hostings en discords is verboden.\n7. Het plaatsen van memedog of andere chat doorstuur memes is verboden.";


    public static final String JORDY_DISCORD_TOKEN = "300153354842013696";
    public static final String JESSE_DISCORD_TOKEN = "264697177736085507";


    public static final String CHANNEL_BAN_LOG_ID = "398448517653463041";
    public static final String CHANNEL_NIEUWS_ID = "398442005451112449";
    public static final String CHANNEL_JOIN_LOG_ID = "398468381373628416";
    public static final String CHANNEL_LEAVE_LOG_ID = "398468392127954944";
    public static final String CHANNEL_OFFTOPIC_ID = "398419813577261060";
    public static final String CHANNEL_BOTCOMMANDS_ID = "398421115925561354";
    public static final String CHANNEL_PRICES_ID = "399880740680237067";
    public static final String CHANNEL_MINECRAFT_SUPPORT_ID = "398419699341197322";

    public static final String ROLE_CEO_ID = "398405360190488577";
    public static final String ROLE_SUPPORT_ID = "398411061436481538";
    public static final String ROLE_PSUPPORT_ID = "398411312972955648";
    public static final String ROLE_CUSTOMER_ID = "399529694606655488";
    public static final String ROLE_MEMBER_ID = "399915466824613888";



    public static final String DISCORD_SERVER_ID = "398389558099836939";


    public static final String sorry_maar = "Sorry maar dit commando werkt niet in deze discord server. Dit commando werkt wel in de Discord van PoedelHost: <https://poedelhost.nl/discord>";

    public static final String bot_Log_server = "407920941121929217";




public static EmbedBuilder shit = new EmbedBuilder().setTitle("FOUT").setColor(Color.RED).setDescription("%lol% Tag een of meerdere personen om deze actie uit te voeren %lol%".replace("%lol%", LeMojis.lol).replace("%happy%", LeMojis.happy));
}
