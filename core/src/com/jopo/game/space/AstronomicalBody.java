package com.jopo.game.space;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jopo.utils.MathUtils;

public abstract class AstronomicalBody {

    protected MathUtils.Circle hitbox;
    protected Sprite sprite;
    protected int radius;
    protected int x;
    protected int y;

    public MathUtils.Circle getHitbox() {
        return hitbox;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getRadius() {
        return radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
