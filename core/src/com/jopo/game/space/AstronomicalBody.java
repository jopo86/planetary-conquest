package com.jopo.game.space;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.jopo.utils.MathUtils;


public abstract class AstronomicalBody extends Image {

    protected MathUtils.Circle hitbox;
    protected int radius;

    protected AstronomicalBody() {
        super();
    }

    protected abstract void evalType();

    protected void setTexture(Texture texture) {
        setDrawable(new TextureRegionDrawable(new TextureRegion(texture)));
    }

    public MathUtils.Point getCenter() {
        return new MathUtils.Point(getX() + getWidth() / 2f, getY() + getHeight() / 2f);
    }

    public float getCenterX() {
        return getCenter().getX();
    }

    public float getCenterY() {
        return getCenter().getY();
    }

    public MathUtils.Circle getHitbox() {
        return hitbox;
    }

    public int getRadius() {
        return radius;
    }
}
