package com.jopo.game.player;

import com.jopo.game.core.PlanetaryConquest;
import com.jopo.game.core.PqGameScreen;
import com.jopo.game.space.Planet;

public class Move {

    public Move(PqGameScreen gameScreen, byte type, PlayerGameState source, PlayerGameState target) {
        switch(type) {
            case MoveType.PASS -> {
                for (Planet planet : source.getPlanets()) {
                    planet.giveResources(PlanetaryConquest.passResourceMultiplier);
                }
            }
            case MoveType.BUILD_UPGRADE -> {
                gameScreen.buildUpgradeSequence(source);
            }
            case MoveType.ATTACK -> {
                gameScreen.attackSequence(source, target);
            }
        }
    }

}
