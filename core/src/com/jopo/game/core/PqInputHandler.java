package com.jopo.game.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Cursor;
import com.jopo.utils.MathUtils;

import java.util.HashMap;
import java.util.Map;

public class PqInputHandler implements InputProcessor {

    private final boolean[] keys;
    private final boolean[] mouseButtons;
    private float scroll;
    private final MathUtils.Point mouse;
    private final MathUtils.Point lastMouse;
    private final MathUtils.Point deltaMouse;

    public static final class CursorType {
        public static final byte DEFAULT = 0;
        public static final byte POINTER = 1;
        public static final byte TEXT = 2;
        public static final byte CROSSHAIR = 3;
        public static final byte NOT_ALLOWED = 4;
    }

    private static final HashMap<Byte, Cursor.SystemCursor> toGdxCursor = new HashMap<>() {
        {
            put(CursorType.DEFAULT, Cursor.SystemCursor.Arrow);
            put(CursorType.POINTER, Cursor.SystemCursor.Hand);
            put(CursorType.TEXT, Cursor.SystemCursor.Ibeam);
            put(CursorType.CROSSHAIR, Cursor.SystemCursor.Crosshair);
            put(CursorType.NOT_ALLOWED, Cursor.SystemCursor.NotAllowed);
        }
    };

    public PqInputHandler() {
        keys =  new boolean[Input.Keys.MAX_KEYCODE + 1];
        mouseButtons = new boolean[5];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = false;
            if (i < mouseButtons.length) {
                mouseButtons[i] = false;
            }
        }
        scroll = 0f;
        mouse = new MathUtils.Point(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
        lastMouse = new MathUtils.Point(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
        deltaMouse = new MathUtils.Point(0, 0);
    }

    public boolean isKeyDown(int keycode) {
        return keys[keycode];
    }

    public boolean isKeyTapped(int keycode) {
        return Gdx.input.isKeyJustPressed(keycode);
    }

    public boolean isLeftMouseButtonPressed()  {
        return mouseButtons[Input.Buttons.LEFT];
    }

    public boolean isLeftMouseButtonTapped()  {
        return Gdx.input.isButtonJustPressed(Input.Buttons.LEFT);
    }

    public boolean isRightMouseButtonPressed()  {
        return mouseButtons[Input.Buttons.RIGHT];
    }

    public boolean isRightMouseButtonTapped()  {
        return Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT);
    }

    public boolean isMiddleMouseButtonPressed()  {
        return mouseButtons[Input.Buttons.MIDDLE];
    }

    public boolean isMiddleMouseButtonTapped()  {
        return Gdx.input.isButtonJustPressed(Input.Buttons.MIDDLE);
    }

    public boolean isFrontMouseSideButtonPressed()  {
        return mouseButtons[Input.Buttons.FORWARD];
    }

    public boolean isFrontMouseSideButtonTapped()  {
        return Gdx.input.isButtonJustPressed(Input.Buttons.FORWARD);
    }

    public boolean isBackMouseSideButtonPressed()  {
        return mouseButtons[Input.Buttons.BACK];
    }

    public boolean isBackMouseSideButtonTapped()  {
        return Gdx.input.isButtonJustPressed(Input.Buttons.BACK);
    }

    public static void setCursor(byte cursorType) {
        Gdx.graphics.setSystemCursor(toGdxCursor.get(cursorType));
    }

    public float getScroll() {
        float tmp = scroll;
        scroll = 0f;
        return tmp;
    }

    public MathUtils.Point getMouse() {
        return mouse;
    }

    public MathUtils.Point getDeltaMouse() {
        return deltaMouse;
    }

    public int getMouseX() {
        return (int)mouse.getX();
    }

    public int getMouseY() {
        return (int)mouse.getY();
    }

    public int getDeltaMouseX() {
        return (int)deltaMouse.getX();
    }

    public int getDeltaMouseY() {
        return (int)deltaMouse.getY();
    }

    public void update() {
        int x = Gdx.input.getX();
        int y = Gdx.graphics.getHeight() - Gdx.input.getY();
        mouse.setPosition(x, y);
        deltaMouse.setPosition(x - lastMouse.getX(), y - lastMouse.getY());
        lastMouse.setPosition(x, y);
    }

    @Override
    public boolean keyDown(int keycode) {
        keys[keycode] = true;
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        keys[keycode] = false;
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        mouseButtons[button] = true;
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        mouseButtons[button] = false;
        return true;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        mouseButtons[button] = false;
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        scroll = amountY;
        return true;
    }
}
