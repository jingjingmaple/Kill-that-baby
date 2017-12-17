package com.jing.gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameState {
	private Texture gameoverImg;
	private Texture gamewinImg;
	private String state;
	private SpriteBatch batch;
	public GameState(SpriteBatch batch) {
		this.batch = batch;
		gameoverImg = new Texture("gameover.png");
		gamewinImg = new Texture("win.png");
		state = "RUN";
	}
	public void over() {
		state = "OVER";
	}
	public void win() {
		state = "WIN";
	}
	public String getState() {
		return state;
	}
	public void render() {
		if (state == "OVER") {
			batch.begin();		
			batch.draw(gameoverImg,280,280);
			batch.end();
		} else if (state == "WIN") {
			batch.begin();		
			batch.draw(gamewinImg,80,240);
			batch.end();
		}
	}
}
