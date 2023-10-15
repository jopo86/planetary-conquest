package com.jopo.game.resources;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class ResourceBase {

    protected int amount;
    protected PlayerGameState receiver;
    protected Sprite sprite;

    public ResourceBase() {
        amount = 0;
        receiver = null;
        sprite = new Sprite();
    }

    public ResourceBase(int amount, PlayerGameState receiver) {
        this.amount = amount;
        this.receiver = receiver;
        setSprite();
    }

    public abstract void setSprite();

    public int getAmount() {
        return amount;
    }

    public PlayerGameState getReceiver() {
        return receiver;
    }

    public abstract void give();
}
