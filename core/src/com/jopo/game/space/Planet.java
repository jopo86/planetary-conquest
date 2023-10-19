package com.jopo.game.space;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.jopo.game.play.Player;
import com.jopo.utils.ChanceEvent;
import com.jopo.utils.MathUtils;

import java.util.ArrayList;

public class Planet extends AstronomicalBody {

    private byte type;
    private boolean habited;
    private Player occupant;
    private ArrayList<ResourceBase> resourceBases;
    private int orbitRadius;
    private int orbitSpeed;
    private float orbitAngle;

    public Planet() {
        habited = false;
        occupant = null;
        resourceBases = new ArrayList<>();
        orbitRadius = orbitSpeed = 0;
        orbitAngle = 0f;
    }

    public Planet(byte type) {
        this.type = type;
        habited = false;
        occupant = null;
        resourceBases = new ArrayList<>();
        evalType();
        orbitRadius = orbitSpeed = 0;
        orbitAngle = 0f;
    }

    @Override
    protected void evalType() {
        switch (type) {
            case PlanetType.SMALL_BLUE -> {
//                sprite = new Sprite(PlanetType.SmallBlue.texture());
//                sprite.setPosition(x, y);
                radius = PlanetType.SmallBlue.radius;
            }
            case PlanetType.SMALL_RED -> {
//                sprite = new Sprite(PlanetType.SmallRed.texture());
//                sprite.setPosition(x, y);
                radius = PlanetType.SmallRed.radius;
            }
            case PlanetType.SMALL_GRAY -> {
//                sprite = new Sprite(PlanetType.SmallGray.texture());
//                sprite.setPosition(x, y);
                radius = PlanetType.SmallGray.radius;
            }
            case PlanetType.MEDIUM_BLUE -> {
//                sprite = new Sprite(PlanetType.MediumBlue.texture());
//                sprite.setPosition(x, y);
                radius = PlanetType.MediumBlue.radius;
            }
            case PlanetType.MEDIUM_RED -> {
//                sprite = new Sprite(PlanetType.MediumRed.texture());
//                sprite.setPosition(x, y);
                radius = PlanetType.MediumRed.radius;
            }
            case PlanetType.MEDIUM_GRAY -> {
//                sprite = new Sprite(PlanetType.MediumGray.texture());
//                sprite.setPosition(x, y);
                radius = PlanetType.MediumGray.radius;
            }
            case PlanetType.MEDIUM_RED_RINGS -> {
//                sprite = new Sprite(PlanetType.MediumRedRings.texture());
//                sprite.setPosition(x, y);
                radius = PlanetType.MediumRedRings.radius;
            }
            case PlanetType.MEDIUM_EARTH -> {
//                sprite = new Sprite(PlanetType.MediumEarth.texture());
//                sprite.setPosition(x, y);
                radius = PlanetType.MediumEarth.radius;
            }
            case PlanetType.LARGE_BLUE -> {
//                sprite = new Sprite(PlanetType.LargeBlue.texture());
//                sprite.setPosition(x, y);
                radius = PlanetType.LargeBlue.radius;
            }
            case PlanetType.LARGE_RED -> {
//                sprite = new Sprite(PlanetType.LargeRed.texture());
//                sprite.setPosition(x, y);
                radius = PlanetType.LargeRed.radius;
            }
            case PlanetType.LARGE_RED_RINGS -> {
//                sprite = new Sprite(PlanetType.LargeRedRings.texture());
//                sprite.setPosition(x, y);
                radius = PlanetType.LargeRedRings.radius;
            }
            case PlanetType.LARGE_EARTH -> {
//                sprite = new Sprite(PlanetType.LargeEarth.texture());
//                sprite.setPosition(x, y);
                radius = PlanetType.LargeEarth.radius;
            }
            case PlanetType.GAS_GIANT -> {
//                sprite = new Sprite(PlanetType.GasGiant.texture());
//                sprite.setPosition(x, y);
                radius = PlanetType.GasGiant.radius;
            }
            case PlanetType.GAS_GIANT_RINGS -> {
//                sprite = new Sprite(PlanetType.GasGiantRings.texture());
//                sprite.setPosition(x, y);
                radius = PlanetType.GasGiantRings.radius;
            }
        }
    }

    public static Planet randPlanet() {
        final Planet planet = new Planet();
        ChanceEvent.randEvent(
                new ChanceEvent(() -> planet.setType(PlanetType.SMALL_BLUE), PlanetType.SmallBlue.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.SMALL_RED), PlanetType.SmallRed.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.SMALL_GRAY), PlanetType.SmallGray.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.MEDIUM_BLUE), PlanetType.MediumBlue.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.MEDIUM_RED), PlanetType.MediumRed.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.MEDIUM_RED_RINGS), PlanetType.MediumRedRings.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.MEDIUM_GRAY), PlanetType.MediumGray.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.MEDIUM_EARTH), PlanetType.MediumEarth.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.LARGE_BLUE), PlanetType.LargeBlue.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.LARGE_RED), PlanetType.LargeRed.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.LARGE_RED_RINGS), PlanetType.LargeRedRings.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.LARGE_EARTH), PlanetType.LargeEarth.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.GAS_GIANT), PlanetType.GasGiantRings.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.GAS_GIANT_RINGS), PlanetType.GasGiantRings.chance)
        );
        return planet;
    }

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

    public void setType(byte type) {
        this.type = type;
        evalType();
    }

    public int getOrbitRadius() {
        return orbitRadius;
    }

    public int getOrbitSpeed() {
        return orbitSpeed;
    }

    public float getOrbitAngle() {
        return orbitAngle;
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

    public void setOrbitRadius(int orbitRadius) {
        this.orbitRadius = orbitRadius;
    }

    public void setOrbitSpeed(int orbitSpeed) {
        this.orbitSpeed = orbitSpeed;
    }

    public void setOrbitAngle(float orbitAngle) {
        this.orbitAngle = orbitAngle;
    }

    public void orbitStep(float delta) {
        orbitAngle += orbitSpeed * delta;
        if (orbitAngle >= 360) orbitAngle -= 360;
    }

    public void goToOrbitPosition(Star star) {
        setX(star.getX() + (int)(Math.cos(MathUtils.degToRad(orbitAngle)) * orbitRadius));
        setY(star.getY() + (int)(Math.sin(MathUtils.degToRad(orbitAngle)) * orbitRadius));
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
