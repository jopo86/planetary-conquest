package com.jopo.game.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import com.jopo.game.space.Galaxy;
import com.jopo.game.space.Planet;
import com.jopo.game.space.SolarSystem;
import com.jopo.utils.MathUtils;

public class PqGameRenderer {

    private Stage stage;
    private ShapeRenderer shapeRenderer;
    private Galaxy galaxy;
    private Sprite galaxyBackground;

    public PqGameRenderer(Stage stage, Galaxy galaxy) {
        this.stage = stage;
        shapeRenderer = new ShapeRenderer();
        this.galaxy = galaxy;
        stage.addActor(galaxy.getGroup());
//        galaxyBackground = new Sprite(PlanetaryConquest.galaxyBackgroundTexture);
    }

    public void render() {
        galaxy.update(Gdx.graphics.getDeltaTime());
        ScreenUtils.clear(.03f, 0f, .07f, 0f);
        stage.act();
        drawRings();
        stage.draw();
    }

    public void drawRings() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(.33f, .3f, .37f, 0f);
        for (SolarSystem solarSystem : galaxy.getSolarSystems()) {
            for (Planet planet : solarSystem.getPlanets()) {
                float radius = MathUtils.distance(planet.getCenter(), solarSystem.getStar().getCenter());
                shapeRenderer.circle(
                        galaxy.getGroup().getX() + galaxy.getGroup().getScaleX() * solarSystem.getStar().getCenterX(),
                        galaxy.getGroup().getY() + galaxy.getGroup().getScaleY() * solarSystem.getStar().getCenterY(),
                        galaxy.getGroup().getScaleX() * radius,
                        (int)((new MathUtils.Circle(0, 0, radius).getCircumference()) / 20f)
                );
            }
        }
        shapeRenderer.end();
    }
}
