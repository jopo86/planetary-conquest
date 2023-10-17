package com.jopo.game.play;

import java.io.Serializable;

public class PlayerSaveState implements Serializable {

    private final Player player;
    private int wins;
    private int level;
    private int xp;
    private int totalXP;

    public PlayerSaveState(Player player, int wins, int level) {
        this.player = player;
        this.wins = wins;
        this.level = level;
    }

    public Player getPlayer() {
        return player;
    }

    public int getWins() {
        return wins;
    }

    public int getLevel() {
        return level;
    }

    public int getXP() {
        return xp;
    }

    public int getTotalXP() {
        return totalXP;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void addWins(int amount) {
        wins += amount;
    }

    public void addWin() {
        wins++;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void addXp(int amount) {
        totalXP += amount;
        xp += amount;
        levelUpCheck();
    }

    public void levelUp() {
        level++;
    }

    private void levelUpCheck() {
        if (xp >= 5000) {
            levelUp();
            xp -= 5000;
        }
    }
}
