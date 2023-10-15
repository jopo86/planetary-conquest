package com.jopo.game.resources;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jopo.utils.MathUtils;

public abstract class AstronomicalBody {

    protected MathUtils.Circle hitbox;
    protected Sprite sprite;

    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

}
