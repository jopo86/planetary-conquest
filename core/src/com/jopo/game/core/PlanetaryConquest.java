package com.jopo.game.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.jopo.utils.TimeUtils;

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

	public static Texture bluePlanetSelectedTexture;
	public static Texture bluePlanetRingsSelectedTexture;
	public static Texture earthPlanetSelectedTexture;
	public static Texture grayPlanetSelectedTexture;
	public static Texture lavaPlanetSelectedTexture;
	public static Texture marsPlanetSelectedTexture;
	public static Texture saturnPlanetSelectedTexture;

	public static Texture yellowStarTexture;
	public static Texture blueStarTexture;
	public static Texture redStarTexture;

	public static Texture blackHoleTexture;
	public static Texture blueBlackHoleTexture;

	public static Texture woodResourceBaseTexture;
	public static Texture stoneResourceBaseTexture;
	public static Texture metalResourceBaseTexture;

	public static Texture galaxyBackgroundTexture;
	
	@Override
	public void create () {
		TimeUtils.Stopwatch.setMode(TimeUtils.MILLIS);
		TimeUtils.Stopwatch.start();
		System.out.println(TimeUtils.getDate());

		inputHandler = new PqInputHandler();
		skin = new Skin(Gdx.files.internal("ui\\uiskin.json"));

		bluePlanetTexture = new Texture(Gdx.files.internal("textures\\planet-blue.png"));
		bluePlanetRingsTexture = new Texture(Gdx.files.internal("textures\\planet-blue-rings.png"));
		earthPlanetTexture = new Texture(Gdx.files.internal("textures\\planet-earth.png"));
		grayPlanetTexture = new Texture(Gdx.files.internal("textures\\planet-gray.png"));
		lavaPlanetTexture = new Texture(Gdx.files.internal("textures\\planet-lava.png"));
		marsPlanetTexture = new Texture(Gdx.files.internal("textures\\planet-mars.png"));
		saturnPlanetTexture = new Texture(Gdx.files.internal("textures\\planet-saturn.png"));

		bluePlanetSelectedTexture = new Texture(Gdx.files.internal("textures\\planet-blue-selected.png"));
		bluePlanetRingsSelectedTexture = new Texture(Gdx.files.internal("textures\\planet-blue-rings-selected.png"));
		earthPlanetSelectedTexture = new Texture(Gdx.files.internal("textures\\planet-earth-selected.png"));
		grayPlanetSelectedTexture = new Texture(Gdx.files.internal("textures\\planet-gray-selected.png"));
		lavaPlanetSelectedTexture = new Texture(Gdx.files.internal("textures\\planet-lava-selected.png"));
		marsPlanetSelectedTexture = new Texture(Gdx.files.internal("textures\\planet-mars-selected.png"));
		saturnPlanetSelectedTexture = new Texture(Gdx.files.internal("textures\\planet-saturn-selected.png"));

		yellowStarTexture = new Texture(Gdx.files.internal("textures\\star-yellow.png"));
		blueStarTexture = new Texture(Gdx.files.internal("textures\\star-blue.png"));
		redStarTexture = new Texture(Gdx.files.internal("textures\\star-red.png"));

		blackHoleTexture = new Texture(Gdx.files.internal("textures\\black-hole.png"));
		blueBlackHoleTexture = new Texture(Gdx.files.internal("textures\\black-hole-blue.png"));

		galaxyBackgroundTexture = new Texture(Gdx.files.internal("textures\\galaxy-background.png"));

		setScreen(new PqTitleScreen(this));

		System.out.println("init: " + TimeUtils.Stopwatch.end() + "ms");
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
		blueBlackHoleTexture.dispose();
//		woodResourceBaseTexture.dispose();
//		stoneResourceBaseTexture.dispose();
//		metalResourceBaseTexture.dispose();
	}
}
