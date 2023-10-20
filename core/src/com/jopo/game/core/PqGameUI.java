package com.jopo.game.core;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

public class PqGameUI extends Table {

    private final PqGameScreen gameScreen;

    public PqGameUI(PqGameScreen gameScreen) {
        this.gameScreen = gameScreen;
        setFillParent(true);
        align(Align.topLeft);

        Label altToShowHideRings = new Label("[ALT] to show/hide rings", PlanetaryConquest.skin, "size-32");

        padTop(30f).padLeft(30f).add(altToShowHideRings);
    }

}
