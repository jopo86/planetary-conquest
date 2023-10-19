package com.jopo.game.space;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jopo.utils.MathUtils;


public abstract class AstronomicalBody extends Image {

    protected MathUtils.Circle hitbox;
    protected int radius;

    protected abstract void evalType();

    public MathUtils.Circle getHitbox() {
        return hitbox;
    }

    public int getRadius() {
        return radius;
    }
}
