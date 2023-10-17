package com.jopo.game.space;

import com.badlogic.gdx.graphics.Texture;
import com.jopo.game.core.PlanetaryConquest;

public final class PlanetType {

    private PlanetType() {}

    public static final byte SMALL_BLUE = 0;
    public static final byte SMALL_RED = 1;
    public static final byte SMALL_GRAY = 2;
    public static final byte MEDIUM_BLUE = 3;
    public static final byte MEDIUM_RED = 4;
    public static final byte MEDIUM_RED_RINGS = 5;
    public static final byte MEDIUM_GRAY = 6;
    public static final byte MEDIUM_EARTH = 7;
    public static final byte LARGE_BLUE = 8;
    public static final byte LARGE_RED = 9;
    public static final byte LARGE_RED_RINGS = 10;
    public static final byte LARGE_EARTH = 11;
    public static final byte GAS_GIANT = 100;
    public static final byte GAS_GIANT_RINGS = 13;

    public static boolean isSmall(byte type) {
        return (type == SMALL_BLUE || type == SMALL_RED || type == SMALL_GRAY);
    }

    public static boolean isMedium(byte type) {
        return (type == MEDIUM_BLUE || type == MEDIUM_RED || type == MEDIUM_RED_RINGS
                || type == MEDIUM_GRAY || type == MEDIUM_EARTH);
    }

    public static boolean isLarge(byte type) {
        return (type == LARGE_BLUE || type == LARGE_RED || type == LARGE_RED_RINGS || type == LARGE_EARTH);
    }

    public static boolean isGiant(byte type) {
        return (type == GAS_GIANT || type == GAS_GIANT_RINGS);
    }

    public static final class SmallBlue {
        public static final int radius = 30;
        public static Texture texture() {
            return PlanetaryConquest.smallBluePlanetTexture;
        }
        public static final float chance = 100/14f;
    }

    public static final class SmallRed {
        public static final int radius = 30;
        public static Texture texture() {
            return PlanetaryConquest.smallRedPlanetTexture;
        }
        public static final float chance = 100/14f;
    }

    public static final class SmallGray {
        public static final int radius = 30;
        public static Texture texture() {
            return PlanetaryConquest.smallGrayPlanetTexture;
        }
        public static final float chance = 100/14f;
    }

    public static final class MediumBlue {
        public static final int radius = 40;
        public static Texture texture() {
            return PlanetaryConquest.mediumBluePlanetTexture;
        }
        public static final float chance = 100/14f;
    }

    public static final class MediumRed {
        public static final int radius = 40;
        public static Texture texture() {
            return PlanetaryConquest.mediumRedPlanetTexture;
        }
        public static final float chance = 100/14f;
    }

    public static final class MediumRedRings {
        public static final int radius = 40;
        public static Texture texture() {
            return PlanetaryConquest.mediumRedRingsPlanetTexture;
        }
        public static final float chance = 100/14f;
    }

    public static final class MediumGray {
        public static final int radius = 40;
        public static Texture texture() {
            return PlanetaryConquest.mediumGrayPlanetTexture;
        }
        public static final float chance = 100/14f;
    }

    public static final class MediumEarth {
        public static final int radius = 40;
        public static Texture texture() {
            return PlanetaryConquest.mediumEarthPlanetTexture;
        }
        public static final float chance = 100/14f;
    }

    public static final class LargeBlue {
        public static final int radius = 50;
        public static Texture texture() {
            return PlanetaryConquest.largeBluePlanetTexture;
        }
        public static final float chance = 100/14f;
    }

    public static final class LargeRed {
        public static final int radius = 50;
        public static Texture texture() {
            return PlanetaryConquest.largeRedPlanetTexture;
        }
        public static final float chance = 100/14f;
    }

    public static final class LargeRedRings {
        public static final int radius = 50;
        public static Texture texture() {
            return PlanetaryConquest.largeRedRingsPlanetTexture;
        }
        public static final float chance = 100/14f;
    }

    public static final class LargeEarth {
        public static final int radius = 50;
        public static Texture texture() {
            return PlanetaryConquest.largeEarthPlanetTexture;
        }
        public static final float chance = 100/14f;
    }

    public static final class GasGiant {
        public static final int radius = 60;
        public static Texture texture() {
            return PlanetaryConquest.gasGiantPlanetTexture;
        }
        public static final float chance = 100/14f;
    }

    public static final class GasGiantRings {
        public static final int radius = 60;
        public static Texture texture() {
            return PlanetaryConquest.gasGiantRingsPlanetTexture;
        }
        public static final float chance = 100/14f;
    }

}
