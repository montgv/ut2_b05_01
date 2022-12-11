package es.iesoretania.dam2.hlc;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class TheCircleGame extends Game {
	BitmapFont font;
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	public Skin gameSkin;

	@Override
	public void create() {
		font = new BitmapFont();
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		gameSkin = new Skin(Gdx.files.internal("glassy/skin/glassy-ui.json"));
		setScreen(new ButtonMenuScreen(this));
	}
	@Override
	public void dispose() {
		font.dispose();
		batch.dispose();
	}
}