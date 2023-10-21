package com.jopo.game.space;

import com.badlogic.gdx.graphics.Texture;
import com.jopo.game.core.PlanetaryConquest;

public final class PlanetType {

    private PlanetType() {}

    public static final byte SMALL_BLUE = 0;
    public static final byte SMALL_GRAY = 1;
    public static final byte SMALL_LAVA = 2;
    public static final byte SMALL_MARS = 3;
    public static final byte MEDIUM_BLUE = 4;
    public static final byte MEDIUM_BLUE_RINGS = 5;
    public static final byte MEDIUM_EARTH = 6;
    public static final byte MEDIUM_GRAY = 7;
    public static final byte MEDIUM_LAVA = 8;
    public static final byte MEDIUM_MARS = 9;
    public static final byte LARGE_BLUE = 10;
    public static final byte LARGE_BLUE_RINGS = 11;
    public static final byte LARGE_EARTH = 12;
    public static final byte LARGE_GRAY = 13;
    public static final byte LARGE_LAVA = 14;
    public static final byte LARGE_MARS = 15;
    public static final byte LARGE_SATURN = 16;

    public static final class SmallBlue {
        public static final int radius = 45;
        public static Texture texture() {
            return PlanetaryConquest.bluePlanetTexture;
        }
        public static final float chance = 100/17f;
    }

    public static final class SmallGray {
        public static final int radius = 45;
        public static Texture texture() {
            return PlanetaryConquest.grayPlanetTexture;
        }
        public static final float chance = 100/17f;
    }

    public static final class SmallLava {
        public static final int radius = 45;
        public static Texture texture() {
            return PlanetaryConquest.lavaPlanetTexture;
        }
        public static final float chance = 100/17f;
    }

    public static final class SmallMars {
        public static final int radius = 45;
        public static Texture texture() {
            return PlanetaryConquest.marsPlanetTexture;
        }
        public static final float chance = 100/17f;
    }

    public static final class MediumBlue {
        public static final int radius = 60;
        public static Texture texture() {
            return PlanetaryConquest.bluePlanetTexture;
        }
        public static final float chance = 100/17f;
    }

    public static final class MediumBlueRings {
        public static final int radius = 60;
        public static Texture texture() {
            return PlanetaryConquest.bluePlanetRingsTexture;
        }
        public static final float chance = 100/17f;
    }

    public static final class MediumEarth {
        public static final int radius = 60;
        public static Texture texture() {
            return PlanetaryConquest.earthPlanetTexture;
        }
        public static final float chance = 100/17f;
    }

    public static final class MediumGray {
        public static final int radius = 60;
        public static Texture texture() {
            return PlanetaryConquest.grayPlanetTexture;
        }
        public static final float chance = 100/17f;
    }

    public static final class MediumLava {
        public static final int radius = 60;
        public static Texture texture() {
            return PlanetaryConquest.lavaPlanetTexture;
        }
        public static final float chance = 100/17f;
    }

    public static final class MediumMars {
        public static final int radius = 60;
        public static Texture texture() {
            return PlanetaryConquest.marsPlanetTexture;
        }
        public static final float chance = 100/17f;
    }

    public static final class LargeBlue {
        public static final int radius = 75;
        public static Texture texture() {
            return PlanetaryConquest.bluePlanetTexture;
        }
        public static final float chance = 100/17f;
    }

    public static final class LargeBlueRings {
        public static final int radius = 75;
        public static Texture texture() {
            return PlanetaryConquest.bluePlanetRingsTexture;
        }
        public static final float chance = 100/17f;
    }

    public static final class LargeEarth {
        public static final int radius = 75;
        public static Texture texture() {
            return PlanetaryConquest.earthPlanetTexture;
        }
        public static final float chance = 100/17f;
    }

    public static final class LargeGray {
        public static final int radius = 75;
        public static Texture texture() {
            return PlanetaryConquest.grayPlanetTexture;
        }
        public static final float chance = 100/17f;
    }

    public static final class LargeLava {
        public static final int radius = 75;
        public static Texture texture() {
            return PlanetaryConquest.lavaPlanetTexture;
        }
        public static final float chance = 100/17f;
    }

    public static final class LargeMars {
        public static final int radius = 75;
        public static Texture texture() {
            return PlanetaryConquest.marsPlanetTexture;
        }
        public static final float chance = 100/17f;
    }

    public static final class LargeSaturn {
        public static final int radius = 75;
        public static Texture texture() {
            return PlanetaryConquest.saturnPlanetTexture;
        }
        public static final float chance = 100/17f;
    }

}
