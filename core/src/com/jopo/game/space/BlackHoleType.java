package com.jopo.game.space;

import com.badlogic.gdx.graphics.Texture;
import com.jopo.game.core.PlanetaryConquest;

public final class BlackHoleType {

    private BlackHoleType() {}

    public static final byte SMALL = 0;
    public static final byte MEDIUM = 1;
    public static final byte LARGE = 2;
    public static final byte SUPERMASSIVE = 3;

    public static final class Small {
        public static final int radius = 200;
        public static Texture texture() {
            return PlanetaryConquest.blackHoleTexture;
        }
        public static final float chance = 100/4f;
    }

    public static final class Medium {
        public static final int radius = 250;
        public static Texture texture() {
            return PlanetaryConquest.blackHoleTexture;
        }
        public static final float chance = 100/4f;
    }

    public static final class Large {
        public static final int radius = 300;
        public static Texture texture() {
            return PlanetaryConquest.blackHoleTexture;
        }
        public static final float chance = 100/4f;
    }

    public static final class Supermassive {
        public static final int radius = 400;
        public static Texture texture() {
            return PlanetaryConquest.blackHoleTexture;
        }
        public static final float chance = 100/4f;
    }

}
