package com.jing.gdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Boss {
	public int pos_x;
	public int pos_y;
	private World world;
	private Map map;
	private String direction;
	public Boss(int x, int y,World world) {
		this.world = world;
		this.map = world.getMap();
		pos_x = x;
		pos_y = y;
		direction = "RIGHT";
	}
	public void update( ) {
		if (pos_x == map.getBlock()[0][map.getWidth()-1][0]) {
			direction = "LEFT";
		} 
		if (pos_x == map.getBlock()[0][0][0]) {
			direction = "RIGHT";
		} 
		updatePos();
		checkDecision();
	}
	private void updatePos() {
		if (direction == "RIGHT") {
			pos_x +=1;
		} else if (direction == "LEFT") {
			pos_x -=1;
		}
	}
	private boolean rand()
	{
		if ((int)(Math.random() * 2)==0) {
			return true;
		} else {
			return false;
		}
	}
	private void checkDecision() {
		for (int c=0; c<map.getWidth(); c++) {
			if (pos_x == map.getBlock()[0][c][0]) {
				if (rand()) {
					releaseBrick();
				}
			}
		}
	}
	private void releaseBrick( ) {
		world.getBrickRenderer().addBrick(pos_x, pos_y);
	}
	
  
}