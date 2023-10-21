package com.jopo.game.core;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

public class PqGameUI extends Stage {

    private final PqGameScreen gameScreen;

    private final Table constKeybinds;

    public PqGameUI(PqGameScreen gameScreen) {
        this.gameScreen = gameScreen;

        constKeybinds = new Table();
        constKeybinds.align(Align.topRight);
        constKeybinds.setFillParent(true);
        constKeybinds.padTop(30f).padRight(30f).add(new Label("[ALT] Show/Hide Rings", PlanetaryConquest.skin, "size-32")).right().row();
        constKeybinds.add(new Label("[CTRL] Center", PlanetaryConquest.skin, "size-32")).right().row();

        addActor(constKeybinds);
    }

}
