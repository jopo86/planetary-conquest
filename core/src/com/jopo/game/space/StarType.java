package com.jopo.game.space;

import com.badlogic.gdx.graphics.Texture;
import com.jopo.game.core.PlanetaryConquest;

public final class StarType {

    private StarType() {}

    public static final byte SMALL_YELLOW = 0;
    public static final byte MEDIUM_YELLOW = 1;
    public static final byte MEDIUM_BLUE = 2;
    public static final byte LARGE_YELLOW = 3;
    public static final byte LARGE_BLUE = 4;


    public static final class SmallYellow {
        public static final int radius = 90;
        public static Texture texture() {
            return PlanetaryConquest.yellowStarTexture;
        }
        public static final float chance = 100/5f;
    }

    public static final class MediumYellow {
        public static final int radius = 120;
        public static Texture texture() {
            return PlanetaryConquest.yellowStarTexture;
        }
        public static final float chance = 100/5f;
    }

    public static final class MediumBlue {
        public static final int radius = 120;
        public static Texture texture() {
            return PlanetaryConquest.blueStarTexture;
        }
        public static final float chance = 100/5f;
    }

    public static final class LargeYellow {
        public static final int radius = 150;
        public static Texture texture() {
            return PlanetaryConquest.yellowStarTexture;
        }
        public static final float chance = 100/5f;
    }

    public static final class LargeBlue {
        public static final int radius = 150;
        public static Texture texture() {
            return PlanetaryConquest.blueStarTexture;
        }
        public static final float chance = 100/5f;
    }

}
