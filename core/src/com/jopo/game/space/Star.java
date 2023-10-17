package com.jopo.game.space;

import com.badlogic.gdx.graphics.g2d.Sprite;
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
            case StarType.SMALL_WHITE -> {
//                sprite = new Sprite(StarType.SmallWhite.texture());
//                sprite.setPosition(x, y);
                radius = StarType.SmallWhite.radius;
            }
            case StarType.SMALL_ORANGE -> {
//                sprite = new Sprite(StarType.SmallOrange.texture());
//                sprite.setPosition(x, y);
                radius = StarType.SmallOrange.radius;
            }
            case StarType.MEDIUM_WHITE -> {
//                sprite = new Sprite(StarType.MediumWhite.texture());
//                sprite.setPosition(x, y);
                radius = StarType.MediumWhite.radius;
            }
            case StarType.MEDIUM_ORANGE -> {
//                sprite = new Sprite(StarType.MediumOrange.texture());
//                sprite.setPosition(x, y);
                radius = StarType.MediumOrange.radius;
            }
            case StarType.MEDIUM_BLUE -> {
//                sprite = new Sprite(StarType.MediumBlue.texture());
//                sprite.setPosition(x, y);
                radius = StarType.MediumBlue.radius;
            }
            case StarType.LARGE_WHITE -> {
//                sprite = new Sprite(StarType.LargeWhite.texture());
//                sprite.setPosition(x, y);
                radius = StarType.LargeWhite.radius;
            }
            case StarType.LARGE_ORANGE -> {
//                sprite = new Sprite(StarType.LargeOrange.texture());
//                sprite.setPosition(x, y);
                radius = StarType.LargeOrange.radius;
            }
            case StarType.LARGE_BLUE -> {
//                sprite = new Sprite(StarType.LargeBlue.texture());
//                sprite.setPosition(x, y);
                radius = StarType.LargeBlue.radius;
            }
        }
    }

    public static Star randStar() {
        Star star = new Star();
        ChanceEvent.randEvent(
                new ChanceEvent(() -> star.setType(StarType.SMALL_WHITE), StarType.SmallWhite.chance),
                new ChanceEvent(() -> star.setType(StarType.SMALL_ORANGE), StarType.SmallOrange.chance),
                new ChanceEvent(() -> star.setType(StarType.MEDIUM_WHITE), StarType.MediumWhite.chance),
                new ChanceEvent(() -> star.setType(StarType.MEDIUM_ORANGE), StarType.MediumOrange.chance),
                new ChanceEvent(() -> star.setType(StarType.MEDIUM_BLUE), StarType.MediumBlue.chance),
                new ChanceEvent(() -> star.setType(StarType.LARGE_WHITE), StarType.LargeWhite.chance),
                new ChanceEvent(() -> star.setType(StarType.LARGE_ORANGE), StarType.LargeOrange.chance),
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
