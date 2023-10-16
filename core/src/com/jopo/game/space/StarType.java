package com.jopo.game.space;

import com.badlogic.gdx.graphics.Texture;
import com.jopo.game.core.PlanetaryConquest;

public final class StarType {

    private StarType() {}

    public static final byte SMALL_WHITE = 0;
    public static final byte SMALL_ORANGE = 1;
    public static final byte MEDIUM_WHITE = 2;
    public static final byte MEDIUM_ORANGE = 3;
    public static final byte MEDIUM_BLUE = 4;
    public static final byte LARGE_WHITE = 5;
    public static final byte LARGE_ORANGE = 6;
    public static final byte LARGE_BLUE = 7;

    public static boolean isSmall(byte type) {
        return (type == SMALL_WHITE || type == SMALL_ORANGE);
    }

    public static boolean isMedium(byte type) {
        return (type == MEDIUM_WHITE || type == MEDIUM_ORANGE || type == MEDIUM_BLUE);
    }

    public static boolean isLarge(byte type) {
        return (type == LARGE_WHITE || type == LARGE_ORANGE || type == LARGE_BLUE);
    }

    public static final class SmallWhite {
        public static final int radius = 100;
        public static Texture texture() {
            return PlanetaryConquest.smallWhiteStarTexture;
        }
        public static final float chance = 1/8f;
    }

    public static final class SmallOrange {
        public static final int radius = 100;
        public static Texture texture() {
            return PlanetaryConquest.smallOrangeStarTexture;
        }
        public static final float chance = 1/8f;
    }

    public static final class MediumWhite {
        public static final int radius = 200;
        public static Texture texture() {
            return PlanetaryConquest.mediumWhiteStarTexture;
        }
        public static final float chance = 1/8f;
    }

    public static final class MediumOrange {
        public static final int radius = 200;
        public static Texture texture() {
            return PlanetaryConquest.mediumOrangeStarTexture;
        }
        public static final float chance = 1/8f;
    }

    public static final class MediumBlue {
        public static final int radius = 200;
        public static Texture texture() {
            return PlanetaryConquest.mediumBlueStarTexture;
        }
        public static final float chance = 1/8f;
    }

    public static final class LargeWhite {
        public static final int radius = 300;
        public static Texture texture() {
            return PlanetaryConquest.largeWhiteStarTexture;
        }
        public static final float chance = 1/8f;
    }

    public static final class LargeOrange {
        public static final int radius = 300;
        public static Texture texture() {
            return PlanetaryConquest.largeOrangeStarTexture;
        }
        public static final float chance = 1/8f;
    }

    public static final class LargeBlue {
        public static final int radius = 300;
        public static Texture texture() {
            return PlanetaryConquest.largeBlueStarTexture;
        }
        public static final float chance = 1/8f;
    }

}
