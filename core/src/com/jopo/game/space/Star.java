package com.jopo.game.space;

import com.badlogic.gdx.graphics.Texture;
import com.jopo.utils.ChanceEvent;

public class Star extends AstronomicalBody {

    private byte type;

    public Star() {}

    public Star(byte type) {
        this.type = type;
        evalType();
    }

    @Override
    protected void evalType() {
        switch(type) {
            case StarType.SMALL_YELLOW -> {
                Texture texture = StarType.SmallYellow.texture();
                setTexture(texture);
                radius = StarType.SmallYellow.radius;
                setSize(radius, radius);
            }
            case StarType.MEDIUM_YELLOW -> {
                Texture texture = StarType.MediumYellow.texture();
                setTexture(texture);
                radius = StarType.MediumYellow.radius;
                setSize(radius, radius);
            }
            case StarType.MEDIUM_BLUE -> {
                Texture texture = StarType.MediumBlue.texture();
                setTexture(texture);
                radius = StarType.MediumBlue.radius;
                setSize(radius, radius);
            }
            case StarType.LARGE_YELLOW -> {
                Texture texture = StarType.LargeYellow.texture();
                setTexture(texture);
                radius = StarType.LargeYellow.radius;
                setSize(radius, radius);
            }
            case StarType.LARGE_BLUE -> {
                Texture texture = StarType.LargeBlue.texture();
                setTexture(texture);
                radius = StarType.LargeBlue.radius;
                setSize(radius, radius);
            }
        }
    }

    public static Star randStar() {
        Star star = new Star();
        ChanceEvent.randEvent(
                new ChanceEvent(() -> star.setType(StarType.SMALL_YELLOW), StarType.SmallYellow.chance),
                new ChanceEvent(() -> star.setType(StarType.MEDIUM_YELLOW), StarType.MediumYellow.chance),
                new ChanceEvent(() -> star.setType(StarType.MEDIUM_BLUE), StarType.MediumBlue.chance),
                new ChanceEvent(() -> star.setType(StarType.LARGE_YELLOW), StarType.LargeYellow.chance),
                new ChanceEvent(() -> star.setType(StarType.LARGE_BLUE), StarType.LargeBlue.chance)
        );
        return star;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
        evalType();
    }
}
