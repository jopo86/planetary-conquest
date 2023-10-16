package com.jopo.game.space;

import com.badlogic.gdx.graphics.Texture;
import com.jopo.game.core.PlanetaryConquest;

public final class ResourceBaseType {

    private ResourceBaseType() {}

    public static final byte WOOD = 0;
    public static final byte STONE = 1;
    public static final byte METAL = 2;

    public static final class Wood {
        public static final short type = WOOD;
        public static final short amountLevel1 = 15;
        public static final short amountLevel2 = 30;
        public static final short amountLevel3 = 50;
        public static Texture texture() { return PlanetaryConquest.woodResourceBaseTexture;
        };
    }

    public static final class Stone {
        public static final short type = STONE;
        public static final short amountLevel1 = 8;
        public static final short amountLevel2 = 16;
        public static final short amountLevel3 = 25;
        public static Texture texture() { return PlanetaryConquest.stoneResourceBaseTexture; };
    }

    public static final class Metal {
        public static final short type = METAL;
        public static final short amountLevel1 = 5;
        public static final short amountLevel2 = 10;
        public static final short amountLevel3 = 16;
        public static Texture texture() { return PlanetaryConquest.metalResourceBaseTexture; };
    }

}
