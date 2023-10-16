package com.jopo.game.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.jopo.game.space.Galaxy;
import com.jopo.game.space.Planet;
import com.jopo.game.space.SolarSystem;

public class PqGameRenderer {

    private SpriteBatch batch;
    private Stage stage;
    private Galaxy galaxy;

    public PqGameRenderer(Stage stage, Galaxy galaxy) {
        batch = new SpriteBatch();
        this.stage = stage;
        this.galaxy = galaxy;
    }

    public void render() {
        ScreenUtils.clear(1f, 1f, 1f, 1f);
        stage.draw();
        for (SolarSystem solarSystem : galaxy.getSolarSystems()) {
            for (Planet planet : solarSystem.getPlanets()) {
                planet.getSprite().draw(batch);
            }
        }
    }

}
