package com.jopo.game.space;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.jopo.utils.MathUtils;

import java.util.ArrayList;

public class SolarSystem {

    private Star star;
    private ArrayList<Planet> planets;

    public SolarSystem() {
        star = null;
        this.planets = new ArrayList<>();
    }

    public SolarSystem(Star star, ArrayList<Planet> planets) {
        this.planets = planets;
    }

    public void populate(float starX, float starY) {
        star = Star.randStar();
        star.setPosition(starX, starY);
        int collectiveRadius = 50 + star.getRadius();
        int numPlanets = MathUtils.randInt(3, 6);
        for (int i = 0; i < numPlanets; i++) {
            collectiveRadius += MathUtils.randInt(100, 150);
            planets.add(Planet.randPlanet());
            planets.get(i).setOrbitRadius(collectiveRadius);
            planets.get(i).setOrbitAngle(MathUtils.randInt(0, 361));
            planets.get(i).setOrbitSpeed(MathUtils.randInt(25, 50));
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

    public void setStar(Star star) {
        this.star = star;
    }

    public void setPlanets(ArrayList<Planet> planets) {
        this.planets = planets;
    }

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }
}
