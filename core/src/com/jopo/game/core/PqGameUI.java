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
    private final Table bottomRight;
    private final Label selectedPlanetLabel;
    private Planet selectedPlanet;
    private Planet selectedPlanetLastFrame;

    public PqGameUI(PqGameScreen gameScreen) {
        this.gameScreen = gameScreen;

        topRight = new Table();
        topRight.align(Align.topRight);
        topRight.setFillParent(true);

        bottomRight = new Table();
        bottomRight.align(Align.bottomRight);
        bottomRight.setFillParent(true);

        topRight.padTop(30f).padRight(30f).add(new Label("[ALT] Show/Hide Rings", PlanetaryConquest.skin, "size-32")).right().row();
        topRight.add(new Label("[CTRL] Center", PlanetaryConquest.skin, "size-32")).right().row();

        selectedPlanetLabel = new Label("Planet Selected: none", PlanetaryConquest.skin, "size-32");
        bottomRight.padBottom(30f).padRight(30f).add(selectedPlanetLabel).right();

        addActor(bottomRight);
        addActor(topRight);
    }

    public void update() {
        selectedPlanet = null;
        for (SolarSystem solarSystem : gameScreen.getGalaxy().getSolarSystems()) {
            for (Planet planet : solarSystem.getPlanets()) {
                if (planet.isSelected()) selectedPlanet = planet;
            }
        }
        if (selectedPlanet != selectedPlanetLastFrame) {
            if (selectedPlanet == null) selectedPlanetLabel.setText("Planet Selected: None");
             else selectedPlanetLabel.setText("Planet Selected: " + PlanetType.typeStr.get(selectedPlanet.getType()) +
                    "\nOccupant: " + (selectedPlanet.getOccupant() != null ? selectedPlanet.getOccupant().getName() : "None"));
        }
        selectedPlanetLastFrame = selectedPlanet;
    }

}
