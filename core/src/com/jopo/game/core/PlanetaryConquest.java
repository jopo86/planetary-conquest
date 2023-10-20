package com.jopo.game.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class PlanetaryConquest extends Game {

	public PqInputHandler inputHandler;

	public static Skin skin;

	public static Texture bluePlanetTexture;
	public static Texture bluePlanetRingsTexture;
	public static Texture earthPlanetTexture;
	public static Texture grayPlanetTexture;
	public static Texture lavaPlanetTexture;
	public static Texture marsPlanetTexture;
	public static Texture saturnPlanetTexture;

	public static Texture yellowStarTexture;
	public static Texture blueStarTexture;

	public static Texture blackHoleTexture;

	public static Texture woodResourceBaseTexture;
	public static Texture stoneResourceBaseTexture;
	public static Texture metalResourceBaseTexture;

	public static Texture galaxyBackgroundTexture;
	
	@Override
	public void create () {
		inputHandler = new PqInputHandler();
		Gdx.input.setInputProcessor(inputHandler);
		skin = new Skin(Gdx.files.internal("ui\\uiskin.json"));

		bluePlanetTexture = new Texture(Gdx.files.internal("textures\\planet-blue.png"));
		bluePlanetRingsTexture = new Texture(Gdx.files.internal("textures\\planet-blue-rings.png"));
		earthPlanetTexture = new Texture(Gdx.files.internal("textures\\planet-earth.png"));
		grayPlanetTexture = new Texture(Gdx.files.internal("textures\\planet-gray.png"));
		lavaPlanetTexture = new Texture(Gdx.files.internal("textures\\planet-lava.png"));
		marsPlanetTexture = new Texture(Gdx.files.internal("textures\\planet-mars.png"));
		saturnPlanetTexture = new Texture(Gdx.files.internal("textures\\planet-saturn.png"));

		yellowStarTexture = new Texture(Gdx.files.internal("textures\\star-yellow.png"));
		blueStarTexture = new Texture(Gdx.files.internal("textures\\star-blue.png"));

		blackHoleTexture = new Texture(Gdx.files.internal("textures\\black-hole.png"));

		setScreen(new PqTitleScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		skin.dispose();
		bluePlanetTexture.dispose();
		bluePlanetRingsTexture.dispose();
		earthPlanetTexture.dispose();
		grayPlanetTexture.dispose();
		lavaPlanetTexture.dispose();
		marsPlanetTexture.dispose();
		saturnPlanetTexture.dispose();
		yellowStarTexture.dispose();
		blueStarTexture.dispose();
		blackHoleTexture.dispose();
//		woodResourceBaseTexture.dispose();
//		stoneResourceBaseTexture.dispose();
//		metalResourceBaseTexture.dispose();
	}
}
