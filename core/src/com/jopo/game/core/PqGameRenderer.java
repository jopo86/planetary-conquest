package com.jopo.game.core;

import com.badlogic.gdx.Gdx;
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

    private final Stage gameStage;
    private final Stage uiStage;
    private final ShapeRenderer shapeRenderer;
    private final SpriteBatch batch;
    private final Galaxy galaxy;
    private Sprite galaxyBackground;
    private boolean shouldDrawRings;

    public PqGameRenderer(Stage gameStage, Stage uiStage, Galaxy galaxy) {
        this.gameStage = gameStage;
        this.uiStage = uiStage;
        this.galaxy = galaxy;
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        gameStage.addActor(galaxy.getGroup());
        shouldDrawRings = true;
//        galaxyBackground = new Sprite(PlanetaryConquest.galaxyBackgroundTexture);
    }

    public void render() {
        galaxy.update(Gdx.graphics.getDeltaTime());
        ScreenUtils.clear(.03f, 0f, .07f, 0f);
        gameStage.act();
        if (shouldDrawRings) drawRings();
        gameStage.draw();
        uiStage.act();
        uiStage.draw();
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

    public boolean getShouldDrawRings() {
        return shouldDrawRings;
    }

    public void setShouldDrawRings(boolean shouldDrawRings) {
        this.shouldDrawRings = shouldDrawRings;
    }

    public void toggleShouldDrawRings() {
        shouldDrawRings = !shouldDrawRings;
    }
}
