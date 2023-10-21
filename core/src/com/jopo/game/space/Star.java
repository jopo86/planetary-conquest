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
                setSize(radius * 2, radius * 2);
            }
            case StarType.SMALL_BLUE -> {
                Texture texture = StarType.SmallBlue.texture();
                setTexture(texture);
                radius = StarType.SmallBlue.radius;
                setSize(radius * 2, radius * 2);
            }
            case StarType.SMALL_RED -> {
                Texture texture = StarType.SmallRed.texture();
                setTexture(texture);
                radius = StarType.SmallRed.radius;
                setSize(radius * 2, radius * 2);
            }
            case StarType.MEDIUM_YELLOW -> {
                Texture texture = StarType.MediumYellow.texture();
                setTexture(texture);
                radius = StarType.MediumYellow.radius;
                setSize(radius * 2, radius * 2);
            }
            case StarType.MEDIUM_BLUE -> {
                Texture texture = StarType.MediumBlue.texture();
                setTexture(texture);
                radius = StarType.MediumBlue.radius;
                setSize(radius * 2, radius * 2);
            }
            case StarType.MEDIUM_RED -> {
                Texture texture = StarType.MediumRed.texture();
                setTexture(texture);
                radius = StarType.MediumRed.radius;
                setSize(radius * 2, radius * 2);
            }
            case StarType.LARGE_YELLOW -> {
                Texture texture = StarType.LargeYellow.texture();
                setTexture(texture);
                radius = StarType.LargeYellow.radius;
                setSize(radius * 2, radius * 2);
            }
            case StarType.LARGE_BLUE -> {
                Texture texture = StarType.LargeBlue.texture();
                setTexture(texture);
                radius = StarType.LargeBlue.radius;
                setSize(radius * 2, radius * 2);
            }
            case StarType.LARGE_RED -> {
                Texture texture = StarType.LargeRed.texture();
                setTexture(texture);
                radius = StarType.LargeRed.radius;
                setSize(radius * 2, radius * 2);
            }
        }
    }

    public static Star randStar() {
        Star star = new Star();
        ChanceEvent.randEvent(
                new ChanceEvent(() -> star.setType(StarType.SMALL_YELLOW), StarType.SmallYellow.chance),
                new ChanceEvent(() -> star.setType(StarType.SMALL_BLUE), StarType.SmallBlue.chance),
                new ChanceEvent(() -> star.setType(StarType.SMALL_RED), StarType.SmallRed.chance),
                new ChanceEvent(() -> star.setType(StarType.MEDIUM_YELLOW), StarType.MediumYellow.chance),
                new ChanceEvent(() -> star.setType(StarType.MEDIUM_BLUE), StarType.MediumBlue.chance),
                new ChanceEvent(() -> star.setType(StarType.MEDIUM_RED), StarType.MediumRed.chance),
                new ChanceEvent(() -> star.setType(StarType.LARGE_YELLOW), StarType.LargeYellow.chance),
                new ChanceEvent(() -> star.setType(StarType.LARGE_BLUE), StarType.LargeBlue.chance),
                new ChanceEvent(() -> star.setType(StarType.LARGE_RED), StarType.LargeRed.chance)
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
