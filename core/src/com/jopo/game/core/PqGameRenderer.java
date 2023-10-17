package com.jopo.game.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import com.jopo.game.space.Galaxy;
import com.jopo.game.space.Planet;
import com.jopo.game.space.SolarSystem;
import com.jopo.utils.MathUtils;

public class PqGameRenderer {

    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private Stage stage;
    private Galaxy galaxy;
    private Sprite galaxyBackground;

    public PqGameRenderer(Stage stage, Galaxy galaxy) {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        this.stage = stage;
        this.galaxy = galaxy;
//        galaxyBackground = new Sprite(PlanetaryConquest.galaxyBackgroundTexture);
    }

    public void render() {
        ScreenUtils.clear(1f, 1f, 1f, 1f);
        stage.draw();
        galaxy.update(Gdx.graphics.getDeltaTime());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (SolarSystem solarSystem : galaxy.getSolarSystems()) {
//            solarSystem.getStar().getSprite().draw(batch);
            shapeRenderer.setColor(1f, 1f, 0f, 1f);
            shapeRenderer.circle(solarSystem.getStar().getX(), solarSystem.getStar().getY(), solarSystem.getStar().getRadius());
            for (Planet planet : solarSystem.getPlanets()) {
//                planet.getSprite().draw(batch);
                shapeRenderer.set(ShapeRenderer.ShapeType.Line);
                shapeRenderer.setColor(.8f, .8f, .8f, .5f);
                shapeRenderer.circle(solarSystem.getStar().getX(), solarSystem.getStar().getY(), MathUtils.distance(solarSystem.getStar().getX(), solarSystem.getStar().getY(), planet.getX(), planet.getY()));
                shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
                shapeRenderer.setColor(.6f, .6f, .6f, 1f);
                shapeRenderer.circle(planet.getX(), planet.getY(), planet.getRadius());
            }
        }
        shapeRenderer.end();
    }

}
