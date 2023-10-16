package com.jopo.game.space;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.jopo.game.player.PlayerGameState;

public class ResourceBase {

    private byte type;
    private PlayerGameState receiver;
    private short amount;
    private short level;
    private Sprite sprite;

    public ResourceBase(byte type, PlayerGameState receiver) {
        this.type = type;
        this.receiver = receiver;
        level = 1;
        evalType();
    }

    public void evalType() {
        switch (type) {
            case ResourceBaseType.WOOD -> {
                amount = ResourceBaseType.Wood.amountLevel1;
                sprite = new Sprite(ResourceBaseType.Wood.texture());
            }
            case ResourceBaseType.STONE -> {
                amount = ResourceBaseType.Stone.amountLevel1;
                sprite = new Sprite(ResourceBaseType.Stone.texture());
            }
            case ResourceBaseType.METAL -> {
                amount = ResourceBaseType.Metal.amountLevel1;
                sprite = new Sprite(ResourceBaseType.Metal.texture());
            }
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
            case ResourceBaseType.WOOD -> {
                receiver.addWood(amount);
            }
            case ResourceBaseType.STONE -> {
                receiver.addStone(amount);
            }
            case ResourceBaseType.METAL -> {
                receiver.addMetal(amount);
            }
        }
    }

    public void give(float multiplier) {
        switch (type) {
            case ResourceBaseType.WOOD -> {
                receiver.addWood((int)(amount * multiplier));
            }
            case ResourceBaseType.STONE -> {
                receiver.addStone((int)(amount * multiplier));
            }
            case ResourceBaseType.METAL -> {
                receiver.addMetal((int)(amount * multiplier));
            }
        }
    }

    public void upgrade() {
        if (level == 3) throw new RuntimeException("Attempted to upgrade resource base beyond level 3");
        levelUp();
    }

    private void levelUp() {
        level++;
        switch (type) {
            case ResourceBaseType.WOOD -> amount = (level == 2 ? ResourceBaseType.Wood.amountLevel2 : ResourceBaseType.Wood.amountLevel3);
            case ResourceBaseType.STONE -> amount = (level == 2 ? ResourceBaseType.Stone.amountLevel2 : ResourceBaseType.Stone.amountLevel3);
            case ResourceBaseType.METAL -> amount = (level == 2 ? ResourceBaseType.Metal.amountLevel2 : ResourceBaseType.Metal.amountLevel3);
        }
    }
}
