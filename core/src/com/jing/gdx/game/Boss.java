package com.jing.gdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Boss {

	public int pos_x;
	public int pos_y;
	private World world;
	private Map map;
	public Boss(int x, int y,World world) {
		this.world = world;
		this.map = world.getMap();
		pos_x = x;
		pos_y = y;
	}
	public void update( ) {
		if (pos_x+1 < map.getBlock()[0][map.getWidth()-1][0]) {
			pos_x +=1;
		}
	}
	
  
}