package com.jopo.game.play;

import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private int id;
    private PlayerGameState gameState;
    private PlayerSaveState saveState;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        gameState = new PlayerGameState();
        saveState = new PlayerSaveState();
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public PlayerGameState getGameState() {
        return gameState;
    }

    public PlayerSaveState getSaveState() {
        return saveState;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setGameState(PlayerGameState gameState) {
        this.gameState = gameState;
    }

    public void setSaveState(PlayerSaveState saveState) {
        this.saveState = saveState;
    }
}
