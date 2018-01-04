package nl.jessegeerts.discordbots.poedelbot.listeners;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

public class readyListener extends ListenerAdapter {

    public void onReady(ReadyEvent event) {

        String out = "VERSION: %version%\nThis bot is running on following servers: \n".replace("%version%", STATIC.VERSION);

        for (Guild g : event.getJDA().getGuilds() ) {
            out += g.getName() + " (" + g.getId() + ") \n";
        }

        System.out.println(out);

    }
}
