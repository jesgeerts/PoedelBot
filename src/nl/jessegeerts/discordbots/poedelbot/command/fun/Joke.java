package nl.jessegeerts.discordbots.poedelbot.command.fun;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

public class Joke implements Command {

    private JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = rd.readLine();
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    private String yomama() {

        String out = "";

        try {
            out = readJsonFromUrl("http://api.yomomma.info").getString("joke");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return out;
    }


    private String icanhazdadjoke() {

        String out = "";

        try {
            out = readJsonFromUrl("https://icanhazdadjoke.com/").getString("joke");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return out;
    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        event.getMessage().delete().queue();
        event.getTextChannel().sendMessage(new EmbedBuilder().setColor(new Color(0xFF00C7))
                .setDescription("Yo Momma joke: %yomamma%\nRandom Jokes: %icanhazdadjoke%".replace("%yomamma%", yomama())
                        .replace("%icanhazdadjoke%", icanhazdadjoke())).setDescription("Leuke grappen :D").build()).queue();

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
