package com.jopo.game.space;

import com.badlogic.gdx.graphics.Texture;
import com.jopo.game.core.PlanetaryConquest;

public final class BlackHoleType {

    private BlackHoleType() {}

    public static final byte DEFAULT = 0;
    public static final byte BLUE = 1;

    public static final class Default {
        public static final int radius = 400;
        public static Texture texture() {
            return PlanetaryConquest.blackHoleTexture;
        }
        public static final float chance = 100/2f;
    }

    public static final class Blue {
        public static final int radius = 400;
        public static Texture texture() {
            return PlanetaryConquest.blueBlackHoleTexture;
        }
        public static final float chance = 100/2f;
    }

}
