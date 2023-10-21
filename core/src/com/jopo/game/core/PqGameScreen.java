package com.jopo.game.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import com.jopo.game.play.PlayerGameState;
import com.jopo.game.space.Galaxy;
import com.jopo.game.space.Planet;
import com.jopo.game.space.SolarSystem;
import com.jopo.utils.MathUtils;

public class PqGameScreen implements Screen {

    private final Galaxy galaxy;
    private final PqGameUI ui;
    private float galaxyZoom;

    private final Stage gameStage;

    private final PqGameRenderer renderer;
    private final PqInputHandler input;

    private final Vector2 tmpVec2;

    public PqGameScreen(final PlanetaryConquest game) {
        input = game.inputHandler;
        galaxy = new Galaxy();
        galaxy.populate((short)5);
        galaxy.translate(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        galaxyZoom = .5f;
        gameStage = new Stage(new ScreenViewport());
        ui = new PqGameUI(this);
        Gdx.input.setInputProcessor(new InputMultiplexer(gameStage, ui, input));

        renderer = new PqGameRenderer(gameStage, ui, galaxy);

        tmpVec2 = new Vector2(0, 0);

    }

    public void attackSequence(PlayerGameState attacker, PlayerGameState defender) {

    }

    public void buildUpgradeSequence(PlayerGameState player) {

    }

    private void update(float delta) {
        input.update();

        if (input.isLeftMouseButtonPressed()) galaxy.translate(input.getDeltaMouse());

        galaxyZoom += -input.getScroll() / 20f;
        galaxyZoom = MathUtils.clamp(galaxyZoom, .1f, 2f);
        galaxy.zoom(galaxyZoom);

        if (input.isKeyTapped(Input.Keys.ALT_LEFT) || input.isKeyTapped(Input.Keys.ALT_RIGHT)) {
            renderer.toggleShouldDrawRings();
        }

        if (input.isKeyTapped(Input.Keys.CONTROL_LEFT) || input.isKeyTapped(Input.Keys.CONTROL_RIGHT)) {
            MoveToAction mta = new MoveToAction();
            mta.setPosition(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
            mta.setDuration(.2f);
            galaxy.getGroup().addAction(mta);
        }

        galaxy.getGroup().setPosition((int)MathUtils.clamp(galaxy.getGroup().getX(), -5000 * galaxy.getGroup().getScaleX(), 5000),
                ((int)MathUtils.clamp(galaxy.getGroup().getY(), -5000, 5000)));

        for (SolarSystem solarSystem : galaxy.getSolarSystems()) {
            for (Planet planet : solarSystem.getPlanets()) {
                planet.updateHitbox(galaxy.getGroup());
                planet.listenForSelection();
                planet.setSelected(MathUtils.hit(new MathUtils.Point(input.getMouseX(), input.getMouseY()), planet.getHitbox()));
            }
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        gameStage.dispose();
        ui.dispose();
    }
}
