package com.jopo.game.space;

import com.badlogic.gdx.graphics.Texture;
import com.jopo.utils.ChanceEvent;

public class BlackHole extends AstronomicalBody {

    private byte type;

    public BlackHole() {
        super();
    }

    public BlackHole(byte type) {
        super();
        this.type = type;
        evalType();
    }

    @Override
    protected void evalType() {
        switch (type) {
            case BlackHoleType.LARGE -> {
                Texture texture = BlackHoleType.Large.texture();
                setTexture(texture);
                radius = BlackHoleType.Large.radius;
                float aspectRatio = (float) texture.getWidth() / texture.getHeight();
                setSize(radius * aspectRatio, radius);
            }
        }
    }

    public static BlackHole randBlackHole() {
        BlackHole blackHole = new BlackHole();
        ChanceEvent.randEvent(
                new ChanceEvent(() -> blackHole.setType(BlackHoleType.SMALL), BlackHoleType.Small.chance),
                new ChanceEvent(() -> blackHole.setType(BlackHoleType.MEDIUM), BlackHoleType.Medium.chance),
                new ChanceEvent(() -> blackHole.setType(BlackHoleType.LARGE), BlackHoleType.Large.chance),
                new ChanceEvent(() -> blackHole.setType(BlackHoleType.SUPERMASSIVE), BlackHoleType.Supermassive.chance)
        );
        return blackHole;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
        evalType();
    }
}
