package es.iesoretania.dam2.hlc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
    private final TheCircleGame game;

    float circleX;
    float circleY;
    float circleRadius = 50;

    float xSpeed = 4;
    float ySpeed = 3;

    public GameScreen(TheCircleGame game) {
        this.game = game;
        circleX = MathUtils.random(800);
        circleY = MathUtils.random(480);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int x, int y, int pointer, int button) {
                int renderY = Gdx.graphics.getHeight() - y;
                if (Vector2.dst(circleX, circleY, x, renderY) < circleRadius) {
                    game.setScreen(new TheEndScreen(game));
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        circleX += xSpeed;
        circleY += ySpeed;

        if (circleX < 0 || circleX > Gdx.graphics.getWidth()) {
            xSpeed *= -1;
        }

        if (circleY < 0 || circleY > Gdx.graphics.getHeight()) {
            ySpeed *= -1;
        }

        Gdx.gl.glClearColor(0,0, .25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        game.shapeRenderer.setColor(0,1,0,1);
        game.shapeRenderer.circle(circleX, circleY, 75);
        game.shapeRenderer.end();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}
