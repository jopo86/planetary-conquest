package com.jopo.game.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class PlanetaryConquest extends Game {

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

	public static Texture smallBlackHoleTexture;
	public static Texture mediumBlackHoleTexture;
	public static Texture largeBlackHoleTexture;

	public static Texture woodResourceBaseTexture;
	public static Texture stoneResourceBaseTexture;
	public static Texture metalResourceBaseTexture;
	
	@Override
	public void create () {
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
		smallBlackHoleTexture =
		mediumBlackHoleTexture =
		largeBlackHoleTexture =
		woodResourceBaseTexture =
		stoneResourceBaseTexture =
		metalResourceBaseTexture = null;

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
