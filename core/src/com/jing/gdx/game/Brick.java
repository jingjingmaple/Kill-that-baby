package com.jing.gdx.game;

public class Brick {
	public int pos_x;
	public int pos_y;
	private Player player;
	public Brick (int x, int y,World world) {
		pos_x = x;
		pos_y = y;
		player = world.getPlayer();
	}
	public void update() {
		pos_y -=3;
		
	}
	public void isKillPlayer() {

		if (pos_x <= player.getX() && pos_x >= player.getX()+100 && pos_y <= player.getY()) {
			System.out.println("Fuck");
		}
	}
}
