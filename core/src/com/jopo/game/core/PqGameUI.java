package com.jopo.game.core;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.jopo.game.space.Planet;
import com.jopo.game.space.PlanetType;
import com.jopo.game.space.SolarSystem;

public class PqGameUI extends Stage {

    private final PqGameScreen gameScreen;

    private final Table topRight;
    private final Table topLeft;
    private final Label selectedPlanet;
    private byte selectedPlanetType;
    private byte selectedPlanetTypeLastFrame;

    public PqGameUI(PqGameScreen gameScreen) {
        this.gameScreen = gameScreen;

        topRight = new Table();
        topRight.align(Align.topRight);
        topRight.setFillParent(true);

        topLeft = new Table();
        topLeft.align(Align.topLeft);
        topLeft.setFillParent(true);

        topRight.padTop(30f).padRight(30f).add(new Label("[ALT] Show/Hide Rings", PlanetaryConquest.skin, "size-32")).right().row();
        topRight.add(new Label("[CTRL] Center", PlanetaryConquest.skin, "size-32")).right().row();

        selectedPlanet = new Label("Planet Selected: none", PlanetaryConquest.skin, "size-32");
        topLeft.padTop(30f).padLeft(30f).add(selectedPlanet).left();

        addActor(topLeft);
        addActor(topRight);
    }

    public void update() {
        selectedPlanetType = -1;
        for (SolarSystem solarSystem : gameScreen.getGalaxy().getSolarSystems()) {
            for (Planet planet : solarSystem.getPlanets()) {
                if (planet.isSelected()) selectedPlanetType = planet.getType();
            }
        }
        if (selectedPlanetType != selectedPlanetTypeLastFrame) {
            selectedPlanet.setText("Planet Selected: " + PlanetType.typeStr.get(selectedPlanetType));
        }
        selectedPlanetTypeLastFrame = selectedPlanetType;
    }

}
