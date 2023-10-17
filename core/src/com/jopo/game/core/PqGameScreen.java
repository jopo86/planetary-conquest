package com.jopo.game.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import com.jopo.game.play.PlayerGameState;
import com.jopo.game.space.Galaxy;
import com.jopo.utils.MathUtils;

public class PqGameScreen implements Screen {

    private final PlanetaryConquest game;
    private final Galaxy galaxy;

    private final Stage stage;
    private final Table table;

    private final PqGameRenderer renderer;

    private MathUtils.Point lastMouse;

    public PqGameScreen(final PlanetaryConquest game) {
        this.game = game;
        galaxy = new Galaxy();
        galaxy.populate((short)2);
        galaxy.translateAll(200, 700);
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setInputProcessor(new InputMultiplexer(stage, game.inputHandler));

        table = new Table(PlanetaryConquest.skin);
        table.setFillParent(true);
        table.align(Align.center | Align.top);

        stage.addActor(table);

        renderer = new PqGameRenderer(stage, galaxy);

        lastMouse = new MathUtils.Point(Gdx.input.getX(), Gdx.input.getY());
    }

    public void attackSequence(PlayerGameState attacker, PlayerGameState defender) {

    }

    public void buildUpgradeSequence(PlayerGameState player) {

    }

    private void update(float delta) {

        if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) galaxy.translateAll(Gdx.input.getX() - lastMouse.getX(), -(Gdx.input.getY() - lastMouse.getY()));
        lastMouse.set(Gdx.input.getX(), Gdx.input.getY());
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
        stage.dispose();
    }
}
