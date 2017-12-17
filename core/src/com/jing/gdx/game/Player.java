package com.jing.gdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Player {

	private int row;
	private int col;
	public int pos_x;
	public int pos_y;
	private World world;
	private Map map;
	public Player(int r, int c,World world) {
		this.world = world;
		this.map = world.getMap();
		row = r;
		col = c;
	}
	private int[] getPos() {
		
		int[] realpos = map.getBlock()[row][col];
		return realpos;
	}
	public int getX() {
		return getPos()[0];
	}
	public int getY() {
		return getPos()[1];
	}
	
	public void fixThis() {
		if (map.windowList[row][col].FixWindow()) {
			world.increaseScore();
		}
	}
	public void update() {
		if (map.getBlock()[row][col][0] != pos_x) {
			if (map.getBlock()[row][col][0] < pos_x) {
				pos_x -=10;
			} else {
				pos_x +=10;
			}
		}
	}
	public void SetPosition(int r, int c) {
		System.out.print(col+c);
		System.out.print(",");
		System.out.println(row+r);
		if (((row+r) < map.getHeight()) && ((row+r) >=0)) {
			row += r;
		}
		if (((col+c) < map.getWidth()) && ((col+c) >=0)) {
			col += c;
		}
	}
  
}