package com.jopo.game.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class PlanetaryConquest extends Game {

	Skin skin;
	
	@Override
	public void create () {
		skin = new Skin(Gdx.files.internal("ui\\uiskin.json"));

		setScreen(new TitleScreen(this));
    }

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {

	}
}
