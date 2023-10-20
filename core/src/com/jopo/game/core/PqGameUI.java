package com.jopo.game.core;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

public class PqGameUI extends Table {

    private final PqGameScreen gameScreen;

    public PqGameUI(PqGameScreen gameScreen) {
        this.gameScreen = gameScreen;
        setFillParent(true);

        Label altToShowHideRings = new Label("[ALT] Show/Hide Rings", PlanetaryConquest.skin, "size-32");
        altToShowHideRings.setAlignment(Align.left);
        Label ctrlToReCenter = new Label("[CTRL] Center", PlanetaryConquest.skin, "size-32");
        ctrlToReCenter.setAlignment(Align.left);

        padTop(30f).padLeft(30f).add(altToShowHideRings).left().row();
        row();
        add(ctrlToReCenter).left().row();

        align(Align.topLeft);
    }

}
