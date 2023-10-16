package com.jopo.game.space;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Star extends AstronomicalBody {

    private byte type;

    public Star(byte type) {
        this.type = type;
        evalType();
    }

    @Override
    protected void evalType() {
        switch(type) {
            case StarType.SMALL_WHITE -> {
                sprite = new Sprite(StarType.SmallWhite.texture());
                sprite.setPosition(x, y);
                radius = StarType.SmallWhite.radius;
            }
            case StarType.SMALL_ORANGE -> {
                sprite = new Sprite(StarType.SmallOrange.texture());
                sprite.setPosition(x, y);
                radius = StarType.SmallOrange.radius;
            }
            case StarType.MEDIUM_WHITE -> {
                sprite = new Sprite(StarType.MediumWhite.texture());
                sprite.setPosition(x, y);
                radius = StarType.MediumWhite.radius;
            }
            case StarType.MEDIUM_ORANGE -> {
                sprite = new Sprite(StarType.MediumOrange.texture());
                sprite.setPosition(x, y);
                radius = StarType.MediumOrange.radius;
            }
            case StarType.MEDIUM_BLUE -> {
                sprite = new Sprite(StarType.MediumBlue.texture());
                sprite.setPosition(x, y);
                radius = StarType.MediumBlue.radius;
            }
            case StarType.LARGE_WHITE -> {
                sprite = new Sprite(StarType.LargeWhite.texture());
                sprite.setPosition(x, y);
                radius = StarType.LargeWhite.radius;
            }
            case StarType.LARGE_ORANGE -> {
                sprite = new Sprite(StarType.LargeOrange.texture());
                sprite.setPosition(x, y);
                radius = StarType.LargeOrange.radius;
            }
            case StarType.LARGE_BLUE -> {
                sprite = new Sprite(StarType.LargeBlue.texture());
                sprite.setPosition(x, y);
                radius = StarType.LargeBlue.radius;
            }
        }
    }

    public byte getType() {
        return type;
    }
}
