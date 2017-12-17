package com.jing.gdx.game;

public class Map {
	private String[] MAP = new String [] {
            "#--#",
            "-###",
            "###-",
            "#-##"
    };
	private int height;
    private int width;
    private Window window;
	public Window[][] windowList = new Window [MAP.length][MAP[0].length()];
	public int[][][] mapPos = new int [MAP.length][MAP[0].length()][2];
	public Map() {
        height = MAP.length;
        width = MAP[0].length();
        initWindow();
    }
	private void initWindow() {
    	int y= -360 + PacmanGame.HEIGHT;
        for(int r = 0; r < MAP.length; r++) {
        	int x=190;
        	if (r!=0) {
        		 y-=WorldRenderer.BLOCK_SIZE +7;
        	}
            for(int c = 0; c < MAP[0].length(); c++) {
            	if (c!=0) {
                    
            		x += WorldRenderer.BLOCK_SIZE+7;
            	}
	            if (MAP[r].charAt(c) == '#') {
	                window = new Window(x, y, true);
	                windowList[r][c] = window;
	            } else {
	            	window = new Window(x, y, false);
	                windowList[r][c] = window;
	            }
	            mapPos[r][c][0] = x;
	            mapPos[r][c][1] = y;
            }
        }

    }
	Window[][] getWindow() {
		return windowList;
	}
	int[][][] getBlock() {
		return mapPos;
	}
	public int getWidth() {
		return width;
		
	}
	public int getHeight() {
		return height;
	}
}
