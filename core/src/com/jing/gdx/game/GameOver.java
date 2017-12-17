package com.jing.gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOver {
	private Texture gameoverImg;
	private boolean state;
	private SpriteBatch batch;
	public GameOver(SpriteBatch batch) {
		this.batch = batch;
		gameoverImg = new Texture("gameover.png");
		state = false;
	}
	public void start() {
		state = true;
	}
	public boolean getState() {
		return state;
	}
	public void render() {
		if (state) {
			batch.begin();		
			batch.draw(gameoverImg,280,280);
			batch.end();
		}
	}
}
