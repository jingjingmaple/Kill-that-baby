package com.jing.gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Boss {
	private SpriteBatch batch;
	private Texture left2;
	private Texture left3;
	private Texture right2;
	private Texture right3;
	private Texture normalImg;
	private Texture now;
	public int pos_x;
	public int pos_y;
	private World world;
	private Map map;
	private String direction;
	private int count;
	private int count2;
	private boolean isReleaseBrick;
	private int last_decision;
	public Boss(int x, int y, SpriteBatch batch, World world) {
		this.world = world;
		this.batch = batch;
		this.map = world.getMap();
		pos_x = x;
		pos_y = y;
		direction = "RIGHT";
		left2 = new Texture("left2.png");
		left3 = new Texture("left3.png");
		right2 = new Texture("right2.png");
		right3 = new Texture("right3.png");
		normalImg = new Texture("boss_down.png");
		now = right2;
		count = 0;
		isReleaseBrick = false;
		last_decision = 0;
	}
	public void update( ) {
		count2++;
		count++;
		if (count2 % 10 == 0) {
			if (now == left2) {
				now = left3;
			} else if (now == left3) {
				now = left2;
			}
		}
		if (count2 % 10 == 0) {			
			if (now == right2) {
				now = right3;
			} else if (now == right3) {
				now = right2;
			}
		}
		if (pos_x == map.getBlock()[0][map.getWidth()-1][0]) {
			direction = "LEFT";
			now = left2;
		} 
		if (pos_x == map.getBlock()[0][0][0]) {
			direction = "RIGHT";
			now = right2;
			
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
		if (pos_x != last_decision) {
			for (int c=0; c<map.getWidth(); c++) {
				if (pos_x == map.getBlock()[0][c][0]) {
					System.out.println("fuck");
					if (!rand()) {
						releaseBrick();
						
					}
					last_decision = pos_x;
				}
			}
		}
	}
	private void releaseBrick() {

		world.getBrickRenderer().addBrick(pos_x, pos_y);
		
		isReleaseBrick = false;
		if (rand()) {
			direction = "LEFT";
			now = left2;
		} else {
			direction = "RIGHT";
			now = right2;
		}
		count = 0;

		
	}
	public void render() {
		batch.begin();
		batch.draw(now,pos_x,pos_y);
		batch.end();
	}
	
  
}