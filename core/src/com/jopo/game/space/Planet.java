package com.jopo.game.space;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.jopo.game.player.Player;

import java.util.ArrayList;

public class Planet extends AstronomicalBody {

    private byte type;
    private boolean habited;
    private Player occupant;
    private ArrayList<ResourceBase> resourceBases;
    private int orbitRadius;

    public Planet(byte type) {
        this.type = type;
        habited = false;
        occupant = null;
        resourceBases = new ArrayList<>();
        evalType();
    }

    @Override
    protected void evalType() {
        switch (type) {
            case PlanetType.SMALL_BLUE -> {
                sprite = new Sprite(PlanetType.SmallBlue.texture());
                sprite.setPosition(x, y);
                radius = PlanetType.SmallBlue.radius;
            }
            case PlanetType.SMALL_RED -> {
                sprite = new Sprite(PlanetType.SmallRed.texture());
                sprite.setPosition(x, y);
                radius = PlanetType.SmallRed.radius;
            }
            case PlanetType.SMALL_GRAY -> {
                sprite = new Sprite(PlanetType.SmallGray.texture());
                sprite.setPosition(x, y);
                radius = PlanetType.SmallGray.radius;
            }
            case PlanetType.MEDIUM_BLUE -> {
                sprite = new Sprite(PlanetType.MediumBlue.texture());
                sprite.setPosition(x, y);
                radius = PlanetType.MediumBlue.radius;
            }
            case PlanetType.MEDIUM_RED -> {
                sprite = new Sprite(PlanetType.MediumRed.texture());
                sprite.setPosition(x, y);
                radius = PlanetType.MediumRed.radius;
            }
            case PlanetType.MEDIUM_GRAY -> {
                sprite = new Sprite(PlanetType.MediumGray.texture());
                sprite.setPosition(x, y);
                radius = PlanetType.MediumGray.radius;
            }
            case PlanetType.MEDIUM_RED_RINGS -> {
                sprite = new Sprite(PlanetType.MediumRedRings.texture());
                sprite.setPosition(x, y);
                radius = PlanetType.MediumRedRings.radius;
            }
            case PlanetType.MEDIUM_EARTH -> {
                sprite = new Sprite(PlanetType.MediumEarth.texture());
                sprite.setPosition(x, y);
                radius = PlanetType.MediumEarth.radius;
            }
            case PlanetType.LARGE_BLUE -> {
                sprite = new Sprite(PlanetType.LargeBlue.texture());
                sprite.setPosition(x, y);
                radius = PlanetType.LargeBlue.radius;
            }
            case PlanetType.LARGE_RED -> {
                sprite = new Sprite(PlanetType.LargeRed.texture());
                sprite.setPosition(x, y);
                radius = PlanetType.LargeRed.radius;
            }
            case PlanetType.LARGE_RED_RINGS -> {
                sprite = new Sprite(PlanetType.LargeRedRings.texture());
                sprite.setPosition(x, y);
                radius = PlanetType.LargeRedRings.radius;
            }
            case PlanetType.LARGE_EARTH -> {
                sprite = new Sprite(PlanetType.LargeEarth.texture());
                sprite.setPosition(x, y);
                radius = PlanetType.LargeEarth.radius;
            }
            case PlanetType.GAS_GIANT -> {
                sprite = new Sprite(PlanetType.GasGiant.texture());
                sprite.setPosition(x, y);
                radius = PlanetType.GasGiant.radius;
            }
            case PlanetType.GAS_GIANT_RINGS -> {
                sprite = new Sprite(PlanetType.GasGiantRings.texture());
                sprite.setPosition(x, y);
                radius = PlanetType.GasGiantRings.radius;
            }
        }
    };

    public byte getType() {
        return type;
    }

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

    public void giveResources() {
        for (ResourceBase resourceBase : resourceBases) {
            resourceBase.give();
        }
    }

    public void giveResources(float multiplier) {
        for (ResourceBase resourceBase : resourceBases) {
            resourceBase.give(multiplier);
        }
    }
}
