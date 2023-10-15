package com.jopo.game.resources;

import java.io.Serializable;

public class PlayerSaveState implements Serializable {

    private final Player player;
    private int wins;

    public PlayerSaveState(Player player, int wins) {
        this.player = player;
        this.wins = wins;
    }

    public Player getPlayer() {
        return player;
    }

    public int getWins() {
        return wins;
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
}
