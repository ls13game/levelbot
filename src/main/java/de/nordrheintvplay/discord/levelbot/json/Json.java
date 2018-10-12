package de.nordrheintvplay.discord.levelbot.json;

import de.nordrheintvplay.discord.levelbot.utils.Const;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Json {

    private static String content;


    static {
        try {
            content = new String(Files.readAllBytes(Paths.get(Const.JSON_PATH)), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject json = new JSONObject(content);


    public static void addMember(String id) {

        JSONObject member = new JSONObject();
        member.put("xp", 0)
                .put("coins", 0)
                .put("role", 1)
                .put("lastxp", "");
        json.put(id, member);
       save();
    }

    public static void removeMember(String id) {
        json.remove(id);
        save();
    }

    public static Member getMember(String id) {
        Member member = new Member();
        member.setAll(getXp(id), getCoins(id), getRole(id), getLastxp(id));
        return member;
    }

    public static String getLastxp(String id) {
        return new JSONObject(json.get(id).toString()).get("lastxp").toString();
    }

    public static int getXp(String id) {
        return (int) new JSONObject(json.get(id).toString()).get("xp");
    }

    public static int getCoins(String id) {
        return (int) new JSONObject(json.get(id).toString()).get("coins");
    }

    public static int getRole(String id) {
        return (int) new JSONObject(json.get(id).toString()).get("role");
    }


    public static void updateMember(String id, int xp, int coins, int role, String lastxp) {
        setXp(id, xp);
        setCoins(id, coins);
        setRole(id, role);
        setLastxp(id, lastxp);
    }

    public static void setLastxp(String id, String lastxp) {
        JSONObject member = new JSONObject(json.get(id).toString());
        member.put("lastxp", lastxp);
        json.put(id, member);
        save();
    }

    public static void setXp(String id, int xp) {
        JSONObject member = new JSONObject(json.get(id).toString());
        member.put("xp", xp);
        json.put(id, member);
        save();
    }

    public static void setCoins(String id, int coins) {
        JSONObject member = new JSONObject(json.get(id).toString());
        member.put("coins", coins);
        json.put(id, member);
        save();
    }

    public static void setRole(String id, int role) {
        JSONObject member = new JSONObject(json.get(id).toString());
        member.put("role", role);
        json.put(id, member);
        save();
    }

    private static void save() {

        try {
            FileWriter fw = new FileWriter(new File(Const.JSON_PATH));
            fw.write(json.toString());
            fw.flush();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
