package com.jopo.game.resources;

import java.util.ArrayList;

public class Planet extends AstronomicalBody {

    private PlanetType type;
    private boolean habited;
    private Player occupant;
    private ArrayList<ResourceBase> resourceBases;

    public Planet(PlanetType type) {
        this.type = type;
        habited = false;
        occupant = null;
        resourceBases = new ArrayList<>();
        setSprite();
    }

    public void setSprite() {

    };

    public boolean isHabited() {
        return habited;
    }

    public Player getOccupant() {
        return occupant;
    }

    public ArrayList<ResourceBase> getResourceBases() {
        return resourceBases;
    }

    public ResourceBase getResourceBase(int i) {
        return resourceBases.get(i);
    }

    public void setHabited(boolean habited) {
        this.habited = habited;
    }

    public void setOccupant(Player occupant) {
        this.occupant = occupant;
    }

    public void setResourceBases(ArrayList<ResourceBase> resourceBases) {
        this.resourceBases = resourceBases;
    }

    public void addResourceBase(ResourceBase resourceBase) {
        resourceBases.add(resourceBase);
    }
}
