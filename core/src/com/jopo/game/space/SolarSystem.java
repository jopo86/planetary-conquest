package com.jopo.game.space;

import com.jopo.game.core.PqConstants;
import com.jopo.utils.MathUtils;

import java.util.ArrayList;

public class SolarSystem {

    private Star star;
    private ArrayList<Planet> planets;

    public SolarSystem() {
        star = null;
        this.planets = new ArrayList<>();
    }

    public void populate(float starX, float starY) {
        star = Star.randStar();
        star.setPosition(starX, starY);
        int collectiveRadius = 50 + star.getRadius();
        int numPlanets = MathUtils.randInt(PqConstants.NUM_PLANETS_MIN, PqConstants.NUM_PLANETS_MAX + 1);
        for (int i = 0; i < numPlanets; i++) {
            collectiveRadius += MathUtils.randInt(PqConstants.ORBIT_RADIUS_GAP_MIN, PqConstants.ORBIT_RADIUS_GAP_MAX);
            planets.add(Planet.randPlanet());
            planets.get(i).setOrbitRadius(collectiveRadius);
            planets.get(i).setOrbitAngle(MathUtils.randInt(0, 361));
            planets.get(i).setOrbitSpeed(MathUtils.randInt(PqConstants.ORBIT_SPEED_MIN, PqConstants.ORBIT_SPEED_MAX));
        }
    }

    public Star getStar() {
        return star;
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public Planet getPlanet(int i) {
        return planets.get(i);
    }

    public void setPlanets(ArrayList<Planet> planets) {
        this.planets = planets;
    }
}
