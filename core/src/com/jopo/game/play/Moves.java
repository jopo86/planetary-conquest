package com.jopo.game.play;

import com.jopo.game.core.PqConstants;
import com.jopo.game.core.PqGameScreen;
import com.jopo.game.space.Planet;

public class Moves {

    private Moves() {}

    public static void pass(PqGameScreen gameScreen, Player player) {
        for (Planet planet : player.getGameState().getPlanets()) {
            planet.giveResources(PqConstants.PASS_RESOURCE_MULTIPLIER);
        }
    }

    public static void buildUpgrade(PqGameScreen gameScreen, Player player) {
        gameScreen.buildUpgradeSequence(player);
    }

    public static void attack(PqGameScreen gameScreen, Player attacker, Player defender) {
        gameScreen.attackSequence(attacker, defender);
    }

}
