package com.jopo.game.space;

import java.util.ArrayList;

public class Galaxy {

    private ArrayList<SolarSystem> solarSystems;

    public Galaxy() {
        solarSystems = new ArrayList<>();
    }

    public Galaxy(ArrayList<SolarSystem> solarSystems) {
        this.solarSystems = solarSystems;
    }

    public void populate(int players) {
        // TODO: populate galaxy with solar systems
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
