package com.jopo.game.space;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Align;
import com.jopo.utils.MathUtils;

import java.util.ArrayList;

public class Galaxy {

    private ArrayList<SolarSystem> solarSystems;
    private Group group;
    private float zoom;

    public Galaxy() {
        solarSystems = new ArrayList<>();
        group = new Group();
        group.setOrigin(0, 0);
        zoom = 1f;
    }

    public Galaxy(ArrayList<SolarSystem> solarSystems) {
        this.solarSystems = solarSystems;
        group = new Group();
        group.setOrigin(-Gdx.graphics.getWidth() / 2f, -Gdx.graphics.getHeight() / 2f);
        zoom = 1f;
    }

    public void populate(short players) {
        SolarSystemPlacer placer = new SolarSystemPlacer(players);
        for (int i = 0; i < players; i++) {
            solarSystems.add(new SolarSystem());
            solarSystems.get(i).populate(placer.placements.get(i).getX(), placer.placements.get(i).getY());
        }
        regroup();
    }

    public void regroup() {
        group.clear();
        for (SolarSystem solarSystem : solarSystems) {
            group.addActor(solarSystem.getStar());
            for (Planet planet : solarSystem.getPlanets()) {
                group.addActor(planet);
            }
        }
    }

    public void update(float delta) {
        for (SolarSystem solarSystem : solarSystems) {
            for (Planet planet : solarSystem.getPlanets()) {
                planet.orbitStep(delta);
                planet.goToOrbitPosition(solarSystem.getStar());
            }
        }
        // TODO: apply zoom
    }

    public void translate(float amountX, float amountY) {
        group.moveBy(amountX, amountY);
    }

    public void translate(MathUtils.Point amount) {
        group.moveBy(amount.getX(), amount.getY());
    }

    public void zoom(float amount) {
        group.setScale(amount);
    }

    public ArrayList<SolarSystem> getSolarSystems() {
        return solarSystems;
    }

    public SolarSystem getSolarSystem(int i) {
        return solarSystems.get(i);
    }

    public Group getGroup() {
        return group;
    }

    public void setSolarSystems(ArrayList<SolarSystem> solarSystems) {
        this.solarSystems = solarSystems;
    }

    public void addSolarSystem(SolarSystem solarSystem) {
        solarSystems.add(solarSystem);
    }
}
