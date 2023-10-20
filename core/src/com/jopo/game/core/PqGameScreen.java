package com.jopo.game.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import com.jopo.game.play.PlayerGameState;
import com.jopo.game.space.Galaxy;
import com.jopo.utils.MathUtils;

public class PqGameScreen implements Screen {

    private final Galaxy galaxy;
    private final PqGameUI ui;
    private float galaxyZoom;

    private final Stage gameStage;
    private final Stage uiStage;

    private final PqGameRenderer renderer;
    private final PqInputHandler input;

    public PqGameScreen(final PlanetaryConquest game) {
        input = game.inputHandler;
        galaxy = new Galaxy();
        galaxy.populate((short)3);
        galaxy.translate(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        galaxyZoom = .7f;
        gameStage = new Stage(new ScreenViewport());
        uiStage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(new InputMultiplexer(gameStage, uiStage, input));

        ui = new PqGameUI(this);
        uiStage.addActor(ui);

        renderer = new PqGameRenderer(gameStage, uiStage, galaxy);

    }

    public void attackSequence(PlayerGameState attacker, PlayerGameState defender) {

    }

    public void buildUpgradeSequence(PlayerGameState player) {

    }

    private void update(float delta) {
        input.update();

        if (input.isLeftMouseButtonPressed()) galaxy.translate(input.getDeltaMouse());

        galaxyZoom += -input.getScroll() / 20f;
        galaxyZoom = MathUtils.clamp(galaxyZoom, .1f, 3f);
        galaxy.zoom(galaxyZoom);

        if (input.isKeyTapped(Input.Keys.ALT_LEFT) || input.isKeyTapped(Input.Keys.ALT_RIGHT)) {
            renderer.toggleShouldDrawRings();
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
        uiStage.dispose();
    }
}
