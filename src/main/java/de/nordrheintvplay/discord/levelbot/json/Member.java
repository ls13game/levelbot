package de.nordrheintvplay.discord.levelbot.json;

public class Member {

    private int xp, coins, role;
    private String lasxp;

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getLasxp() {
        return lasxp;
    }

    public void setLasxp(String lasxp) {
        this.lasxp = lasxp;
    }

    public void setAll(int xp, int coins, int role, String lasxp) {
        this.xp = xp;
        this.coins = coins;
        this.role = role;
        this.lasxp = lasxp;
    }



}
