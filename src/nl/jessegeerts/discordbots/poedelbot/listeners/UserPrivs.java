package nl.jessegeerts.discordbots.poedelbot.listeners;

import jdk.nashorn.internal.parser.JSONParser;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import nl.jessegeerts.discordbots.poedelbot.Main;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONPointer;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class UserPrivs {


    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    private static ArrayList<User> adminUsers = new ArrayList<>();

    public static void setupUsers() {
        addDefaultUsers();
    }

    public static boolean isUserCEO(User user) {
        if (adminUsers.contains(user)) {
            return true;
        } else {
            for (Role role : user.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getMember(user).getRoles()) {
                if (role.getId().equalsIgnoreCase(STATIC.ROLE_CEO_ID)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isUserStaff(User user) {

        for (Role role : user.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getMember(user).getRoles()) {
            if (role.getId().equalsIgnoreCase(STATIC.ROLE_STAFF_ID)) {
                return true;
            }
        }
        return false;
    }

    public static void addDefaultUsers() {

        try {
            JSONObject jsonObject = readJsonFromUrl(STATIC.ADMIN_USERS_URL);
            JSONArray jsonArray = jsonObject.getJSONArray("adminUsers");
            if (jsonArray != null) {
                for (int x = 0; x < jsonArray.length(); x++) {
                    JSONObject jsonItem = jsonArray.getJSONObject(x);

                    String id = String.valueOf(jsonItem.get("id"));

                    adminUsers.add(Main.jda.getUserById(id));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean hasPermission(User user, Permission permission) {
        for (Role role : user.getJDA().getGuildById(STATIC.DISCORD_SERVER_ID).getMember(user).getRoles()) {
            return role.hasPermission(permission);
        }
        return false;
    }

    public static ArrayList<User> getAllStaff() {
        ArrayList<User> allStaff = new ArrayList<>();
        for (Member user : Main.jda.getGuildById(STATIC.DISCORD_SERVER_ID).getMembers()) {
            if (isUserStaff(user.getUser())) {
                allStaff.add(user.getUser());
            }
        }
        return allStaff;
    }
}
