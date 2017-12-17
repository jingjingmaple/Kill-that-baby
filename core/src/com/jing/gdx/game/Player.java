package com.jing.gdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Player {

	private int row;
	private int col;
	private World world;
	private Map map;
	public Player(int r, int c,World world) {
		this.world = world;
		row = r;
		col = c;
	}
	private int[] getPos() {
		Map map = world.getMap();
		int[] realpos = map.getBlock()[row][col];
		return realpos;
	}
	public int getX() {
		return getPos()[0];
	}
	public int getY() {
		return getPos()[1];
	}
	
	
	public void SetPosition(int r, int c) {
		row += r;
		col += c;
	}
  
}