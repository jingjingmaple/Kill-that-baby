package com.jing.gdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BrickRenderer {
	private Brick brick;
	private SpriteBatch batch;
	private World world;
	private Texture brickImg;
	private ArrayList<Brick> bricklist = new ArrayList<Brick>();
	public BrickRenderer(SpriteBatch batch,World world) {
		this.batch = batch;
		this.world = world;
		brickImg = new Texture("brick.png");
	}
	public void addBrick(int x, int y) {
		bricklist.add(new Brick(x+31,y, world));
	}
	public void update() {
		for (int n=0; n<bricklist.size(); n++) {
			bricklist.get(n).update();
		}
	}
	public void render() {
		batch.begin();
		for (int n=0; n<bricklist.size(); n++) {
			batch.draw(brickImg,bricklist.get(n).pos_x,bricklist.get(n).pos_y);
		}
		batch.end();
	}
}
