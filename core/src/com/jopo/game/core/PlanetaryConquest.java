package com.jopo.game.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.jopo.game.player.PlayerGameState;

public class PlanetaryConquest extends Game {

	public static final float passResourceMultiplier = 1.2f;

	public PqInputHandler inputHandler;

	public static Skin skin;

	public static Texture smallBluePlanetTexture;
	public static Texture smallRedPlanetTexture;
	public static Texture smallGrayPlanetTexture;
	public static Texture mediumBluePlanetTexture;
	public static Texture mediumRedPlanetTexture;
	public static Texture mediumGrayPlanetTexture;
	public static Texture mediumRedRingsPlanetTexture;
	public static Texture mediumEarthPlanetTexture;
	public static Texture largeBluePlanetTexture;
	public static Texture largeRedPlanetTexture;
	public static Texture largeRedRingsPlanetTexture;
	public static Texture largeEarthPlanetTexture;
	public static Texture gasGiantPlanetTexture;
	public static Texture gasGiantRingsPlanetTexture;

	public static Texture smallWhiteStarTexture;
	public static Texture smallOrangeStarTexture;
	public static Texture mediumWhiteStarTexture;
	public static Texture mediumOrangeStarTexture;
	public static Texture mediumBlueStarTexture;
	public static Texture largeWhiteStarTexture;
	public static Texture largeOrangeStarTexture;
	public static Texture largeBlueStarTexture;

	public static Texture smallBlackHoleTexture;
	public static Texture mediumBlackHoleTexture;
	public static Texture largeBlackHoleTexture;

	public static Texture woodResourceBaseTexture;
	public static Texture stoneResourceBaseTexture;
	public static Texture metalResourceBaseTexture;
	
	@Override
	public void create () {
		inputHandler = new PqInputHandler();
		Gdx.input.setInputProcessor(inputHandler);
		skin = new Skin(Gdx.files.internal("ui\\uiskin.json"));
		smallBluePlanetTexture =
		smallRedPlanetTexture =
		smallGrayPlanetTexture =
		mediumBluePlanetTexture =
		mediumRedPlanetTexture =
		mediumGrayPlanetTexture =
		mediumRedRingsPlanetTexture =
		mediumEarthPlanetTexture =
		largeBluePlanetTexture =
		largeRedPlanetTexture =
		largeRedRingsPlanetTexture =
		largeEarthPlanetTexture =
		gasGiantPlanetTexture =
		gasGiantRingsPlanetTexture =
		smallWhiteStarTexture =
		smallOrangeStarTexture =
		mediumWhiteStarTexture =
		mediumOrangeStarTexture =
		mediumBlueStarTexture =
		largeWhiteStarTexture =
		largeOrangeStarTexture =
		largeBlueStarTexture =
		smallBlackHoleTexture =
		mediumBlackHoleTexture =
		largeBlackHoleTexture =
		woodResourceBaseTexture =
		stoneResourceBaseTexture =
		metalResourceBaseTexture = null;

		setScreen(new PqTitleScreen(this));
    }

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		skin.dispose();
		smallBluePlanetTexture.dispose();
		smallRedPlanetTexture.dispose();
		smallGrayPlanetTexture.dispose();
		mediumBluePlanetTexture.dispose();
		mediumRedPlanetTexture.dispose();
		mediumGrayPlanetTexture.dispose();
		mediumRedRingsPlanetTexture.dispose();
		mediumEarthPlanetTexture.dispose();
		largeBluePlanetTexture.dispose();
		largeRedPlanetTexture.dispose();
		largeRedRingsPlanetTexture.dispose();
		largeEarthPlanetTexture.dispose();
		gasGiantPlanetTexture.dispose();
		gasGiantRingsPlanetTexture.dispose();
		smallWhiteStarTexture.dispose();
		smallOrangeStarTexture.dispose();
		mediumWhiteStarTexture.dispose();
		mediumOrangeStarTexture.dispose();
		mediumBlueStarTexture.dispose();
		largeWhiteStarTexture.dispose();
		largeOrangeStarTexture.dispose();
		largeBlueStarTexture.dispose();
		smallBlackHoleTexture.dispose();
		mediumBlackHoleTexture.dispose();
		largeBlackHoleTexture.dispose();
		woodResourceBaseTexture.dispose();
		stoneResourceBaseTexture.dispose();
		metalResourceBaseTexture.dispose();
	}
}
