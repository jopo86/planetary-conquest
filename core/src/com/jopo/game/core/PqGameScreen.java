package com.jopo.game.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import com.jopo.game.play.Player;
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
        galaxy.populate((short)6);
        galaxy.translate(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        galaxyZoom = .5f;
        gameStage = new Stage(new ScreenViewport());
        ui = new PqGameUI(this);
        Gdx.input.setInputProcessor(new InputMultiplexer(gameStage, ui, input));

        renderer = new PqGameRenderer(gameStage, ui, galaxy);

        tmpVec2 = new Vector2(0, 0);

    }

    public void attackSequence(Player attacker, Player defender) {

    }

    public void buildUpgradeSequence(Player player) {

    }

    private void update(float delta) {
        processInput();

        galaxyZoom += -input.getScroll() / 20f;
        galaxyZoom = MathUtils.clamp(galaxyZoom, .1f, 2f);
        galaxy.zoom(galaxyZoom);

        galaxy.getGroup().setPosition((int)MathUtils.clamp(galaxy.getGroup().getX(), -5000 * galaxy.getGroup().getScaleX(), 5000),
                ((int)MathUtils.clamp(galaxy.getGroup().getY(), -3000, 3000)));

        boolean cursorPointer = false;
        for (SolarSystem solarSystem : galaxy.getSolarSystems()) {
            for (Planet planet : solarSystem.getPlanets()) {
                planet.updateHitbox(galaxy.getGroup());
                planet.listen();
                planet.setHovered(MathUtils.hit(new MathUtils.Point(input.getMouseX(), input.getMouseY()), planet.getHitbox()));
                if (planet.isHovered()) cursorPointer = true;
            }
        }
        if (cursorPointer) PqInputHandler.setCursor(PqInputHandler.CursorType.POINTER);
        else PqInputHandler.setCursor(PqInputHandler.CursorType.DEFAULT);
    }

    private void processInput() {
        input.update();

        if (input.isLeftMouseButtonPressed()) galaxy.translate(input.getDeltaMouse());

        if (input.isKeyTapped(Input.Keys.ALT_LEFT) || input.isKeyTapped(Input.Keys.ALT_RIGHT)) {
            renderer.toggleShouldDrawRings();
        }

        if (input.isKeyTapped(Input.Keys.CONTROL_LEFT) || input.isKeyTapped(Input.Keys.CONTROL_RIGHT)) {
            MoveToAction mta = new MoveToAction();
            mta.setPosition(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
            mta.setDuration(.2f);
            galaxy.getGroup().addAction(mta);
        }

        if (input.isLeftMouseButtonTapped()) {
            for (SolarSystem solarSystem : galaxy.getSolarSystems()) {
                for (Planet planet : solarSystem.getPlanets()) {
                    if (planet.isHovered()) {
                        planet.setSelected(true);
                        continue;
                    }
                    planet.setSelected(false);
                }
            }
        }

        ui.update();
    }

    public Galaxy getGalaxy() {
        return galaxy;
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
