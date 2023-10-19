package com.jopo.game.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class PlanetaryConquest extends Game {

	public static final float passResourceMultiplier = 1.2f;

	public PqInputHandler inputHandler;

	public static Skin skin;

	public static Texture bluePlanetTexture;
	public static Texture bluePlanetRingsTexture;
	public static Texture earthPlanetTexture;
	public static Texture grayPlanetTexture;
	public static Texture lavaPlanetTexture;
	public static Texture marsPlanetTexture;
	public static Texture saturnPlanetTexture;

	public static Texture whiteStarTexture;
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
		bluePlanetRingsTexture = new Texture(Gdx.files.internal("textures\\planet-blue.png"));
		earthPlanetTexture = new Texture(Gdx.files.internal("textures\\planet-blue.png"));
		grayPlanetTexture = new Texture(Gdx.files.internal("textures\\planet-blue.png"));
		lavaPlanetTexture = new Texture(Gdx.files.internal("textures\\planet-blue.png"));
		marsPlanetTexture = new Texture(Gdx.files.internal("textures\\planet-blue.png"));
		saturnPlanetTexture = new Texture(Gdx.files.internal("textures\\planet-blue.png"));

		whiteStarTexture = new Texture(Gdx.files.internal("textures\\planet-blue.png"));
		yellowStarTexture = new Texture(Gdx.files.internal("textures\\planet-blue.png"));
		blueStarTexture = new Texture(Gdx.files.internal("textures\\planet-blue.png"));

		blackHoleTexture = new Texture(Gdx.files.internal("textures\\planet-blue.png"));

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
		whiteStarTexture.dispose();
		yellowStarTexture.dispose();
		blueStarTexture.dispose();
		blackHoleTexture.dispose();
		woodResourceBaseTexture.dispose();
		stoneResourceBaseTexture.dispose();
		metalResourceBaseTexture.dispose();
	}
}
