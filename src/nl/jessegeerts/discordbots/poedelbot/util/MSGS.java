package nl.jessegeerts.discordbots.poedelbot.util;

import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;

public class MSGS {
    public static EmbedBuilder success() {
        return new EmbedBuilder().setColor(Color.green);
    }

    public static EmbedBuilder error() {
        return new EmbedBuilder().setColor(Color.red);
    }
}
