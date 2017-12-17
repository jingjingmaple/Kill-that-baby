package com.jing.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class PlayerControl {
	private boolean keyPress;
	private String keyDirection;
	private World world;
	public PlayerControl(World world) {
		this.world = world;
		keyPress = false;
		keyDirection = "None";
	}
	private void process() {
		if (!keyPress) {
			if (keyDirection == "UP") {
				world.getPlayer().SetPosition(-1, 0);
			}
			if (keyDirection == "DOWN") {
				world.getPlayer().SetPosition(1, 0);
			}
			if (keyDirection == "LEFT") {
				world.getPlayer().SetPosition(0, -1);
			}
			if (keyDirection == "RIGHT") {
				world.getPlayer().SetPosition(0, 1);
			}
			if (keyDirection == "SPACE") {
				world.getPlayer().fixThis();
			}
			keyDirection = "None";
		}
	}
	public void updateKey() {
		process();
		if(Gdx.input.isKeyPressed(Keys.UP)) {
			keyPress = true;
			keyDirection = "UP";
	    } else if(Gdx.input.isKeyPressed(Keys.DOWN)) {
	    	keyPress = true;
			keyDirection = "DOWN";
	    } else if(Gdx.input.isKeyPressed(Keys.LEFT)) {
	    	keyPress = true;
			keyDirection = "LEFT";
	    } else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
	    	keyPress = true;
			keyDirection = "RIGHT";
	    } else if(Gdx.input.isKeyPressed(Keys.SPACE)) {
	    	keyPress = true;
			keyDirection = "SPACE";	
	    } else {
	    	keyPress = false;
	    }
	}
}
