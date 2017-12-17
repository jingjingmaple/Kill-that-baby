package com.jing.gdx.game;


public class Window {
	public boolean state;
	public int pos_x;
	public int pos_y;
	public Window(int x, int y,boolean state) {
        this.state = state;
        pos_x = x;
        pos_y = y;
    }
	public boolean FixWindow() {
		if (!state) {
			state = true;
			return true;
		} else {
			return false;
		}
	}
	public void BrokeWindow() {
		state = false;
	}
	
}
