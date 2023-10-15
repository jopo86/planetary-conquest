package com.jopo.game.resources;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class ResourceBase {

    private short type;
    private int amount;
    private PlayerGameState receiver;
    private Sprite sprite;

    public ResourceBase(short type) {
        this.type = type;
        amount = 0;
        receiver = null;
        sprite = new Sprite();
    }

    public ResourceBase(int amount, PlayerGameState receiver) {
        this.amount = amount;
        this.receiver = receiver;
        setSprite();
    }

    public void setSprite() {
        switch (type) {
            case ResourceBaseType.WOOD -> sprite = null;
            case ResourceBaseType.STONE -> sprite = null;
            case ResourceBaseType.METAL -> sprite = null;
        }
    }

    public int getAmount() {
        return amount;
    }

    public PlayerGameState getReceiver() {
        return receiver;
    }

    public void give() {
        switch (type) {
            case ResourceBaseType.WOOD -> receiver.addWood(amount);
            case ResourceBaseType.STONE -> receiver.addStone(amount);
            case ResourceBaseType.METAL -> receiver.addMetal(amount);
        }
    }
}
