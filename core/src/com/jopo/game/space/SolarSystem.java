package com.jopo.game.space;

import java.util.ArrayList;

public class SolarSystem {

    private ArrayList<Planet> planets;

    public SolarSystem() {
        this.planets = new ArrayList<>();
    }

    public SolarSystem(ArrayList<Planet> planets) {
        this.planets = planets;
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

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }
}
