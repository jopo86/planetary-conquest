package com.jopo.game.space;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

public class Galaxy {

    private ArrayList<SolarSystem> solarSystems;

    public Galaxy() {
        solarSystems = new ArrayList<>();
    }

    public Galaxy(ArrayList<SolarSystem> solarSystems) {
        this.solarSystems = solarSystems;
    }

    public void populate(short players) {
        SolarSystemPlacer placer = new SolarSystemPlacer(players);
        for (int i = 0; i < players; i++) {
            solarSystems.add(new SolarSystem());
            solarSystems.get(i).populate(placer.placements.get(i).getX(), placer.placements.get(i).getY());
        }
    }

    public void update(float delta) {
        for (SolarSystem solarSystem : solarSystems) {
            for (Planet planet : solarSystem.getPlanets()) {
                planet.orbitStep(delta);
                planet.goToOrbitPosition(solarSystem.getStar());
            }
        }
    }

    public void translateAll(int amountX, int amountY) {
        for (SolarSystem solarSystem : solarSystems) {
            solarSystem.getStar().translate(amountX, amountY);
            for (Planet planet : solarSystem.getPlanets()) {
                planet.translate(amountX, amountY);
            }
        }
    }

    public ArrayList<SolarSystem> getSolarSystems() {
        return solarSystems;
    }

    public SolarSystem getSolarSystem(int i) {
        return solarSystems.get(i);
    }

    public void setSolarSystems(ArrayList<SolarSystem> solarSystems) {
        this.solarSystems = solarSystems;
    }

    public void addSolarSystem(SolarSystem solarSystem) {
        solarSystems.add(solarSystem);
    }
}
