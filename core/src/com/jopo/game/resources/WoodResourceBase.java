package com.jopo.game.resources;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class WoodResourceBase extends ResourceBase {

    @Override
    public void setSprite() {
        sprite = new Sprite(/*PlanetaryConquest.woodResourceBaseTexture*/);
    }

    public void give() {
        receiver.addWood(amount);
    }

}
