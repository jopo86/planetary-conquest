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
            case BlackHoleType.DEFAULT -> {
                Texture texture = BlackHoleType.Default.texture();
                setTexture(texture);
                radius = BlackHoleType.Default.radius;
                float aspectRatio = (float) texture.getWidth() / texture.getHeight();
                setSize(radius * aspectRatio, radius);
            }
            case BlackHoleType.BLUE -> {
                Texture texture = BlackHoleType.Blue.texture();
                setTexture(texture);
                radius = BlackHoleType.Blue.radius;
                float aspectRatio = (float) texture.getWidth() / texture.getHeight();
                setSize(radius * aspectRatio, radius);
            }
        }
    }

    public static BlackHole randBlackHole() {
        BlackHole blackHole = new BlackHole();
        ChanceEvent.randEvent(
                new ChanceEvent(() -> blackHole.setType(BlackHoleType.DEFAULT), BlackHoleType.Default.chance),
                new ChanceEvent(() -> blackHole.setType(BlackHoleType.BLUE), BlackHoleType.Blue.chance)
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
