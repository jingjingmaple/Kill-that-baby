package com.jing.gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
	private SpriteBatch batch;
	private int row;
	private int col;
	public int pos_x;
	public int pos_y;
	private World world;
	private Map map;
	private Texture playerIdle;
	private Texture playerFix;
	private boolean playerState;
	private int count;
	public Player(int r, int c,SpriteBatch batch,World world) {
		this.world = world;
		this.batch = batch;
		this.map = world.getMap();
		row = r;
		col = c;
		pos_x = map.getBlock()[row][col][0];
		pos_y = map.getBlock()[row][col][1];
		playerIdle = new Texture("player_idle.png");
		playerFix = new Texture("player_action.png");
		playerState = false;
		count = 0;
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
		playerState = true;
		count++;
	}
	public void update() {
		if (playerState) {
			count++;
		}
		if (count == 20) {
			count = 0;
			playerState = false;
		}
		if (map.getBlock()[row][col][0] != pos_x) {
			if (map.getBlock()[row][col][0] < pos_x) {
				if (pos_x-10 < map.getBlock()[row][col][0]) {
					pos_x = map.getBlock()[row][col][0];
				} else {
					pos_x -=10;
				}
			} else {
				if (pos_x+10 > map.getBlock()[row][col][0]) {
					pos_x = map.getBlock()[row][col][0];
				} else {
					pos_x +=10;
				}
			}
		}
		if (map.getBlock()[row][col][1] != pos_y) {
			if (map.getBlock()[row][col][1] < pos_y) {
				if (pos_y-10 < map.getBlock()[row][col][1]) {
					pos_y = map.getBlock()[row][col][1];
				} else {
					pos_y -=10;
				}
			} else {
				if (pos_y+10 > map.getBlock()[row][col][1]) {
					pos_y = map.getBlock()[row][col][1];
				} else {
					pos_y +=10;
				}
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
	public void render() {
		batch.begin();
		if (playerState) {
			batch.draw(playerFix,pos_x,pos_y);
		} else {
			batch.draw(playerIdle,pos_x,pos_y);
		}
		batch.end();
	}
  
}