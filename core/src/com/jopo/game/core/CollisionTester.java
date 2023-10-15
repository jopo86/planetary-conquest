package com.jopo.game.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.jopo.utils.MathUtils;

public class CollisionTester extends Game {

    ShapeRenderer shapeRenderer;
    MathUtils.Rectangle staticRect;
    MathUtils.Circle staticCirc;

    MathUtils.Point cursorPoint;
    MathUtils.Rectangle cursorRect;
    MathUtils.Circle cursorCirc;

    int cursorType = 1;
    boolean rectHit = false;
    boolean circHit = false;

    @Override
    public void create () {
        shapeRenderer = new ShapeRenderer();
        staticRect = new MathUtils.Rectangle(1280 / 2 - 200, 720 / 2 - 50, 200, 100);
        staticCirc = new MathUtils.Circle(1280 / 2 + 150, 720 / 2 - 50, 50);
        cursorPoint = new MathUtils.Point(0, 0);
        cursorRect = new MathUtils.Rectangle(0, 0, 150, 100);
        cursorCirc = new MathUtils.Circle(0, 0, 25);
    }

    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            Gdx.input.setCursorCatched(false);
            if (cursorType == 2) Gdx.input.setCursorPosition(cursorRect.getCenterX(), Gdx.graphics.getHeight() - cursorRect.getCenterY());
            else if (cursorType == 3) Gdx.input.setCursorPosition(cursorCirc.getCenterX(), Gdx.graphics.getHeight() - cursorCirc.getCenterY());
            cursorType = 1;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            cursorType = 2;
            Gdx.input.setCursorCatched(true);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
            cursorType = 3;
            Gdx.input.setCursorCatched(true);
        }

        switch (cursorType) {
            case 1 -> {
                cursorPoint.setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
                rectHit = MathUtils.hit(cursorPoint, staticRect);
                circHit = MathUtils.hit(cursorPoint, staticCirc);
            }
            case 2 -> {
                cursorRect.setPosition(Gdx.input.getX() - cursorRect.getWidth() / 2, Gdx.graphics.getHeight() - Gdx.input.getY() - cursorRect.getWidth() / 2);
                rectHit = MathUtils.hit(staticRect, cursorRect);
                circHit = MathUtils.hit(cursorRect, staticCirc);
            }
            case 3 -> {
                cursorCirc.setPosition(Gdx.input.getX() - cursorCirc.getRadius(), Gdx.graphics.getHeight() - Gdx.input.getY() - cursorCirc.getRadius());
                rectHit = MathUtils.hit(staticRect, cursorCirc);
                circHit = MathUtils.hit(cursorCirc, staticCirc);

            }
        }
    }

    @Override
    public void render () {
        update(Gdx.graphics.getDeltaTime());

        ScreenUtils.clear(1f, 1f, 1f, 1f);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0f, 0f, 0f, 1f);

        switch (cursorType) {
            case 2 -> shapeRenderer.rect(cursorRect.getX(), cursorRect.getY(), cursorRect.getWidth(), cursorRect.getHeight());
            case 3 -> shapeRenderer.circle(cursorCirc.getX() + cursorCirc.getRadius(), cursorCirc.getY() + cursorCirc.getRadius(), cursorCirc.getRadius());
        }

        if (rectHit) shapeRenderer.setColor(1f, .5f, 0f, 1f);
        else shapeRenderer.setColor(0f, .5f, 1f, 1f);
        shapeRenderer.rect(staticRect.getX(), staticRect.getY(), staticRect.getWidth(), staticRect.getHeight());

        if (circHit) shapeRenderer.setColor(1f, .5f, 0f, 1f);
        else shapeRenderer.setColor(0f, .5f, 1f, 1f);
        shapeRenderer.circle(staticCirc.getX() + staticCirc.getRadius(), staticCirc.getY() + staticCirc.getRadius(), staticCirc.getRadius());

        shapeRenderer.end();
    }

    @Override
    public void dispose () {
        shapeRenderer.dispose();
    }
}
