package com.jopo.game.space;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.jopo.game.core.PlanetaryConquest;
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
    private int orbitOffsetX;
    private int orbitOffsetY;
    private float orbitAngle;
    private boolean selected;
    private boolean selectedLastFrame;

    public Planet() {
        super();
        habited = false;
        occupant = null;
        resourceBases = new ArrayList<>();
        orbitRadius = orbitSpeed = orbitOffsetX = orbitOffsetY = 0;
        orbitAngle = 0f;
        selected = false;
        selectedLastFrame = false;
    }

    public Planet(byte type) {
        super();
        this.type = type;
        habited = false;
        occupant = null;
        resourceBases = new ArrayList<>();
        evalType();
        orbitRadius = orbitSpeed = orbitOffsetX = orbitOffsetY = 0;
        orbitAngle = 0f;
        selected = false;
        selectedLastFrame = false;
    }

    @Override
    protected void evalType() {
        switch (type) {
            case PlanetType.SMALL_BLUE -> {
                Texture texture = PlanetType.SmallBlue.texture();
                setTexture(texture);
                radius = PlanetType.SmallBlue.radius;
                float aspectRatio = (float)texture.getWidth() / texture.getHeight();
                setSize(radius * 2 * aspectRatio, radius * 2);
                hitbox.setRadius(radius);
            }
            case PlanetType.SMALL_GRAY -> {
                Texture texture = PlanetType.SmallGray.texture();
                setTexture(texture);
                radius = PlanetType.SmallGray.radius;
                float aspectRatio = (float)texture.getWidth() / texture.getHeight();
                setSize(radius * 2 * aspectRatio, radius * 2);
                hitbox.setRadius(radius);
            }
            case PlanetType.SMALL_LAVA -> {
                Texture texture = PlanetType.SmallLava.texture();
                setTexture(texture);
                radius = PlanetType.SmallLava.radius;
                float aspectRatio = (float)texture.getWidth() / texture.getHeight();
                setSize(radius * 2 * aspectRatio, radius * 2);
                hitbox.setRadius(radius);
            }
            case PlanetType.SMALL_MARS -> {
                Texture texture = PlanetType.SmallMars.texture();
                setTexture(texture);
                radius = PlanetType.SmallMars.radius;
                float aspectRatio = (float)texture.getWidth() / texture.getHeight();
                setSize(radius * 2 * aspectRatio, radius * 2);
                hitbox.setRadius(radius);
            }
            case PlanetType.MEDIUM_BLUE -> {
                Texture texture = PlanetType.MediumBlue.texture();
                setTexture(texture);
                radius = PlanetType.MediumBlue.radius;
                float aspectRatio = (float)texture.getWidth() / texture.getHeight();
                setSize(radius * 2 * aspectRatio, radius * 2);
                hitbox.setRadius(radius);
            }
            case PlanetType.MEDIUM_BLUE_RINGS -> {
                Texture texture = PlanetType.MediumBlueRings.texture();
                setTexture(texture);
                radius = PlanetType.MediumBlueRings.radius;
                float aspectRatio = (float)texture.getWidth() / texture.getHeight();
                setSize(radius * 2 * aspectRatio, radius * 2);
                hitbox.setRadius(radius);
            }
            case PlanetType.MEDIUM_EARTH -> {
                Texture texture = PlanetType.MediumEarth.texture();
                setTexture(texture);
                radius = PlanetType.MediumEarth.radius;
                float aspectRatio = (float)texture.getWidth() / texture.getHeight();
                setSize(radius * 2 * aspectRatio, radius * 2);
                hitbox.setRadius(radius);
            }
            case PlanetType.MEDIUM_GRAY -> {
                Texture texture = PlanetType.MediumGray.texture();
                setTexture(texture);
                radius = PlanetType.MediumGray.radius;
                float aspectRatio = (float)texture.getWidth() / texture.getHeight();
                setSize(radius * 2 * aspectRatio, radius * 2);
                hitbox.setRadius(radius);
            }
            case PlanetType.MEDIUM_LAVA -> {
                Texture texture = PlanetType.MediumLava.texture();
                setTexture(texture);
                radius = PlanetType.MediumLava.radius;
                float aspectRatio = (float)texture.getWidth() / texture.getHeight();
                setSize(radius * 2 * aspectRatio, radius * 2);
                hitbox.setRadius(radius);
            }
            case PlanetType.MEDIUM_MARS -> {
                Texture texture = PlanetType.MediumMars.texture();
                setTexture(texture);
                radius = PlanetType.MediumMars.radius;
                float aspectRatio = (float)texture.getWidth() / texture.getHeight();
                setSize(radius * 2 * aspectRatio, radius * 2);
                hitbox.setRadius(radius);
            }
            case PlanetType.LARGE_BLUE -> {
                Texture texture = PlanetType.LargeBlue.texture();
                setTexture(texture);
                radius = PlanetType.LargeBlue.radius;
                float aspectRatio = (float)texture.getWidth() / texture.getHeight();
                setSize(radius * 2 * aspectRatio, radius * 2);
                hitbox.setRadius(radius);
            }
            case PlanetType.LARGE_BLUE_RINGS -> {
                Texture texture = PlanetType.LargeBlueRings.texture();
                setTexture(texture);
                radius = PlanetType.LargeBlueRings.radius;
                float aspectRatio = (float)texture.getWidth() / texture.getHeight();
                setSize(radius * 2 * aspectRatio, radius * 2);
                hitbox.setRadius(radius);
            }
            case PlanetType.LARGE_EARTH -> {
                Texture texture = PlanetType.LargeEarth.texture();
                setTexture(texture);
                radius = PlanetType.LargeEarth.radius;
                float aspectRatio = (float)texture.getWidth() / texture.getHeight();
                setSize(radius * 2 * aspectRatio, radius * 2);
                hitbox.setRadius(radius);
            }
            case PlanetType.LARGE_GRAY -> {
                Texture texture = PlanetType.LargeGray.texture();
                setTexture(texture);
                radius = PlanetType.LargeGray.radius;
                float aspectRatio = (float)texture.getWidth() / texture.getHeight();
                setSize(radius * 2 * aspectRatio, radius * 2);
                hitbox.setRadius(radius);
            }
            case PlanetType.LARGE_LAVA -> {
                Texture texture = PlanetType.LargeLava.texture();
                setTexture(texture);
                radius = PlanetType.LargeLava.radius;
                float aspectRatio = (float)texture.getWidth() / texture.getHeight();
                setSize(radius * 2 * aspectRatio, radius * 2);
                hitbox.setRadius(radius);
            }
            case PlanetType.LARGE_MARS -> {
                Texture texture = PlanetType.LargeMars.texture();
                setTexture(texture);
                radius = PlanetType.LargeMars.radius;
                float aspectRatio = (float)texture.getWidth() / texture.getHeight();
                setSize(radius * 2 * aspectRatio, radius * 2);
                hitbox.setRadius(radius);
            }
            case PlanetType.LARGE_SATURN -> {
                Texture texture = PlanetType.LargeSaturn.texture();
                setTexture(texture);
                radius = PlanetType.LargeSaturn.radius;
                float aspectRatio = (float)texture.getWidth() / texture.getHeight();
                setSize(radius * 2 * aspectRatio, radius * 2);
                hitbox.setRadius(radius);
            }
        }
    }

    public static Planet randPlanet() {
        final Planet planet = new Planet();
        ChanceEvent.randEvent(
                new ChanceEvent(() -> planet.setType(PlanetType.SMALL_BLUE), PlanetType.SmallBlue.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.SMALL_GRAY), PlanetType.SmallGray.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.SMALL_LAVA), PlanetType.SmallLava.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.SMALL_MARS), PlanetType.SmallMars.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.MEDIUM_BLUE), PlanetType.MediumBlue.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.MEDIUM_BLUE_RINGS), PlanetType.MediumBlueRings.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.MEDIUM_EARTH), PlanetType.MediumEarth.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.MEDIUM_GRAY), PlanetType.MediumGray.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.MEDIUM_LAVA), PlanetType.MediumLava.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.MEDIUM_MARS), PlanetType.MediumMars.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.LARGE_BLUE), PlanetType.LargeBlue.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.LARGE_BLUE_RINGS), PlanetType.LargeBlueRings.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.LARGE_EARTH), PlanetType.LargeEarth.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.LARGE_GRAY), PlanetType.LargeLava.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.LARGE_LAVA), PlanetType.LargeLava.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.LARGE_MARS), PlanetType.LargeMars.chance),
                new ChanceEvent(() -> planet.setType(PlanetType.LARGE_SATURN), PlanetType.LargeSaturn.chance)
        );
        return planet;
    }

    public void listenForSelection() {
        if (selected != selectedLastFrame) onSelectedChange();
        selectedLastFrame = selected;
    }

    private void onSelectedChange() {
        if (selected) switch (type) {
            case PlanetType.SMALL_BLUE, PlanetType.MEDIUM_BLUE, PlanetType.LARGE_BLUE -> {
                setTexture(PlanetaryConquest.bluePlanetSelectedTexture);
            }
            case PlanetType.SMALL_GRAY, PlanetType.MEDIUM_GRAY, PlanetType.LARGE_GRAY -> {
                setTexture(PlanetaryConquest.grayPlanetSelectedTexture);
            }
            case PlanetType.SMALL_LAVA, PlanetType.MEDIUM_LAVA, PlanetType.LARGE_LAVA -> {
                setTexture(PlanetaryConquest.lavaPlanetSelectedTexture);
            }
            case PlanetType.SMALL_MARS, PlanetType.MEDIUM_MARS, PlanetType.LARGE_MARS -> {
                setTexture(PlanetaryConquest.marsPlanetSelectedTexture);
            }
            case PlanetType.MEDIUM_BLUE_RINGS, PlanetType.LARGE_BLUE_RINGS -> {
                setTexture(PlanetaryConquest.bluePlanetRingsSelectedTexture);
            }
            case PlanetType.MEDIUM_EARTH, PlanetType.LARGE_EARTH -> {
                setTexture(PlanetaryConquest.earthPlanetSelectedTexture);
            }
            case PlanetType.LARGE_SATURN -> {
                setTexture(PlanetaryConquest.saturnPlanetSelectedTexture);
            }
        } else switch (type) {
            case PlanetType.SMALL_BLUE, PlanetType.MEDIUM_BLUE, PlanetType.LARGE_BLUE -> {
                setTexture(PlanetaryConquest.bluePlanetTexture);
            }
            case PlanetType.SMALL_GRAY, PlanetType.MEDIUM_GRAY, PlanetType.LARGE_GRAY -> {
                setTexture(PlanetaryConquest.grayPlanetTexture);
            }
            case PlanetType.SMALL_LAVA, PlanetType.MEDIUM_LAVA, PlanetType.LARGE_LAVA -> {
                setTexture(PlanetaryConquest.lavaPlanetTexture);
            }
            case PlanetType.SMALL_MARS, PlanetType.MEDIUM_MARS, PlanetType.LARGE_MARS -> {
                setTexture(PlanetaryConquest.marsPlanetTexture);
            }
            case PlanetType.MEDIUM_BLUE_RINGS, PlanetType.LARGE_BLUE_RINGS -> {
                setTexture(PlanetaryConquest.bluePlanetRingsTexture);
            }
            case PlanetType.MEDIUM_EARTH, PlanetType.LARGE_EARTH -> {
                setTexture(PlanetaryConquest.earthPlanetTexture);
            }
            case PlanetType.LARGE_SATURN -> {
                setTexture(PlanetaryConquest.saturnPlanetTexture);
            }
        }
    }

    public void updateHitbox(Group group) {
        hitbox.setPosition(group.getX() + group.getScaleX() * (getCenterX() - radius), group.getY() + group.getScaleY() * (getCenterY() - radius));
        hitbox.setRadius(radius * group.getScaleX());
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

    public boolean isSelected() {
        return selected;
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

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void orbitStep(float delta) {
        orbitAngle += orbitSpeed * delta;
        if (orbitAngle >= 360) orbitAngle = 0;
    }

    public void goToOrbitPosition(Star star) {
        setPosition(
                (float)(star.getCenterX() + orbitRadius * Math.sin(MathUtils.degToRad(orbitAngle)) - getWidth() / 2f),
                (float)(star.getCenterY() + orbitRadius * Math.cos(MathUtils.degToRad(orbitAngle)) - getHeight() / 2f)
        );
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
