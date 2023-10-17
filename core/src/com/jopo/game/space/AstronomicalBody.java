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

    protected abstract void evalType();

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
        sprite.setX(x);
    }

    public void setY(int y) {
        this.y = y;
        sprite.setY(y);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
//        sprite.setPosition(x, y);
    }

    public void translate(int amountX, int amountY) {
        this.x += amountX;
        this.y += amountY;
    }
}
