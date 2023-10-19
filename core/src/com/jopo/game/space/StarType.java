package com.jopo.game.space;

import com.badlogic.gdx.graphics.Texture;
import com.jopo.game.core.PlanetaryConquest;

public final class StarType {

    private StarType() {}

    public static final byte SMALL_WHITE = 0;
    public static final byte SMALL_YELLOW = 1;
    public static final byte MEDIUM_WHITE = 2;
    public static final byte MEDIUM_YELLOW = 3;
    public static final byte MEDIUM_BLUE = 4;
    public static final byte LARGE_WHITE = 5;
    public static final byte LARGE_YELLOW = 6;
    public static final byte LARGE_BLUE = 7;

    public static boolean isSmall(byte type) {
        return (type == SMALL_WHITE || type == SMALL_YELLOW);
    }

    public static boolean isMedium(byte type) {
        return (type == MEDIUM_WHITE || type == MEDIUM_YELLOW || type == MEDIUM_BLUE);
    }

    public static boolean isLarge(byte type) {
        return (type == LARGE_WHITE || type == LARGE_YELLOW || type == LARGE_BLUE);
    }

    public static final class SmallWhite {
        public static final int radius = 50;
        public static Texture texture() {
            return PlanetaryConquest.whiteStarTexture;
        }
        public static final float chance = 100/8f;
    }

    public static final class SmallYellow {
        public static final int radius = 50;
        public static Texture texture() {
            return PlanetaryConquest.yellowStarTexture;
        }
        public static final float chance = 100/8f;
    }

    public static final class MediumWhite {
        public static final int radius = 75;
        public static Texture texture() {
            return PlanetaryConquest.whiteStarTexture;
        }
        public static final float chance = 100/8f;
    }

    public static final class MediumYellow {
        public static final int radius = 75;
        public static Texture texture() {
            return PlanetaryConquest.yellowStarTexture;
        }
        public static final float chance = 100/8f;
    }

    public static final class MediumBlue {
        public static final int radius = 75;
        public static Texture texture() {
            return PlanetaryConquest.blueStarTexture;
        }
        public static final float chance = 100/8f;
    }

    public static final class LargeWhite {
        public static final int radius = 100;
        public static Texture texture() {
            return PlanetaryConquest.whiteStarTexture;
        }
        public static final float chance = 100/8f;
    }

    public static final class LargeYellow {
        public static final int radius = 100;
        public static Texture texture() {
            return PlanetaryConquest.yellowStarTexture;
        }
        public static final float chance = 100/8f;
    }

    public static final class LargeBlue {
        public static final int radius = 100;
        public static Texture texture() {
            return PlanetaryConquest.blueStarTexture;
        }
        public static final float chance = 100/8f;
    }

}
