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
        shapeRenderer.setAutoShapeType(true);
        batch = new SpriteBatch();
        gameStage.addActor(galaxy.getGroup());
        shouldDrawRings = true;
    }

    public void render() {
        galaxy.update(Gdx.graphics.getDeltaTime());
        ScreenUtils.clear(.03f, 0f, .07f, 0f);
        batch.begin();
        galaxy.getBackground().setPosition(galaxy.getGroup().getX() * .1f - galaxy.getBackground().getWidth() / 2f, galaxy.getGroup().getY() * .1f - galaxy.getBackground().getHeight() / 2f);
        galaxy.getBackground().setScale(galaxy.getGroup().getScaleX() * .05f + .95f);
        galaxy.getBackground().draw(batch, PqConstants.GALAXY_BACKGROUND_OPACITY);
        batch.end();
        gameStage.act();
        if (shouldDrawRings) drawRings();
        gameStage.draw();
        uiStage.act();
        uiStage.draw();
    }

    public void drawRings() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(.23f, .2f, .27f, 0f);
        for (SolarSystem solarSystem : galaxy.getSolarSystems()) {
            for (Planet planet : solarSystem.getPlanets()) {
                MathUtils.Circle renderCirc = MathUtils.applyGroupTransform(new MathUtils.Circle(
                        solarSystem.getStar().getCenterX(),
                        solarSystem.getStar().getCenterY(),
                        MathUtils.distance(planet.getCenter(), solarSystem.getStar().getCenter())
                ), galaxy.getGroup());
                shapeRenderer.circle(
                        renderCirc.getX(),
                        renderCirc.getY(),
                        renderCirc.getRadius(),
                        (int)(renderCirc.getCircumference() / 20f)
                );
            }
        }
        shapeRenderer.end();
    }

    public void toggleShouldDrawRings() {
        shouldDrawRings = !shouldDrawRings;
    }
}
