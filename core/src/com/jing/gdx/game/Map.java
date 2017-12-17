package com.jing.gdx.game;

import java.util.Random;

public class Map {
	/*private String[] MAP = new String [] {
            "#--#",
            "-###",
            "###-",
            "#-##"
    };*/
	private String[] MAP = new String [4];
	
	private int height;
    private int width;
    private Window window;
    private int totalBroke = 0;
	public Window[][] windowList = new Window [MAP.length][4];
	public int[][][] mapPos = new int [MAP.length][4][2];
	public Map() {
        height = MAP.length;
        width = 4;
        
        for (int i=0 ; i<4; i++) {
	        MAP[i]="";
	        for (int y=0; y<4; y++) {	
	        	if (getRandomBoolean()) {
	        		MAP[i] = MAP[i]+ "#";
	        	} else {
	        		MAP[i]= MAP[i]+"-";
	        	}
	        }
        }
        initWindow();
    }
	public boolean getRandomBoolean() {
	    Random random = new Random();
	    return random.nextBoolean();
	}
	private void initWindow() {
    	int y= -360 + PacmanGame.HEIGHT;
        for(int r = 0; r < MAP.length; r++) {
        	int x=190;
        	if (r!=0) {
        		 y-=WorldRenderer.BLOCK_SIZE +7;
        	}
            for(int c = 0; c < 4; c++) {
            	if (c!=0) {
                    
            		x += WorldRenderer.BLOCK_SIZE+7;
            	}
	            if (MAP[r].charAt(c) == '#') {
	                window = new Window(x, y, true);
	                windowList[r][c] = window;
	            } else {
	            	window = new Window(x, y, false);
	                windowList[r][c] = window;
	                totalBroke +=1;
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
	public int getTotalBroke() {
		return totalBroke;
	}
}
