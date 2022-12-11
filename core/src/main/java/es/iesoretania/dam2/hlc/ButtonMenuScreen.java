package es.iesoretania.dam2.hlc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class ButtonMenuScreen extends ScreenAdapter {
    private final TheCircleGame game;
    private Stage stage;

    public ButtonMenuScreen(TheCircleGame game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());

        Label title = new Label("The Circle Game", game.gameSkin, "default");
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight() * 2 / 3);
        title.setWidth(Gdx.graphics.getWidth());
        stage.addActor(title);

        TextButton playButton = new TextButton("Jugar!", game.gameSkin);
        playButton.setWidth(Gdx.graphics.getWidth() / 2);
        playButton.setPosition(
                Gdx.graphics.getWidth() / 2 - playButton.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - playButton.getHeight() / 2
        );
        playButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameScreen(game));
            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(playButton);

        TextButton exitButton = new TextButton("Salir", game.gameSkin);
        exitButton.setWidth(Gdx.graphics.getWidth() / 2);
        exitButton.setPosition(
                Gdx.graphics.getWidth() / 2 - exitButton.getWidth() / 2,
                Gdx.graphics.getHeight() / 4 - exitButton.getHeight() / 2
        );
        exitButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(exitButton);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }
    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
    @Override
    public void dispose() {
        stage.dispose();
    }
}
