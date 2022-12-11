package es.iesoretania.dam2.hlc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

//Esta clase solo se usaba cuando no teniamos aplicado un skin!!

public class MenuScreen extends ScreenAdapter {
    private final TheCircleGame game;

    public MenuScreen(TheCircleGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                    game.setScreen(new GameScreen(game));
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, .25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        float x = Gdx.graphics.getWidth() * .25f;
        int height = Gdx.graphics.getHeight();
        game.font.draw(game.batch, "¡Menú principal!", x, height * .75f);
        game.font.draw(game.batch, "Haz clic en el círculo para ganar.", x, height * .5f);
        game.font.draw(game.batch, "Presiona espacio para empezar...", x, height * .25f);
        game.batch.end();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}
