package com.jing.gdx.game;

public class Brick {
	public int pos_x;
	public int pos_y;
	private Player player;
	private World world;
	private boolean active=true;
	public Brick (int x, int y,World world) {
		this.world = world;
		pos_x = x;
		pos_y = y;
		player = world.getPlayer();
	}
	public void update() {
		checkActive();
		if (active) {
			pos_y -=3;
			isKillPlayer();
			/*System.out.print(pos_x);
			System.out.print(",");
			System.out.println(pos_y);*/
		}
	}
	private void checkActive() {
		if (pos_y < -30) {
			active = false;
		}
	}
	public void isKillPlayer() {

		if ((pos_x >= player.getX() && pos_x <= player.getX()+100) && (pos_y-60 <= player.getY() && pos_y+30>= player.getY() )) {
			world.getGameState().over();;
		}
	}
}
