package com.jing.gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MazeRenderer {
	 
    private Maze maze;
    private SpriteBatch batch;
    private Texture wallImage;
    private Texture dotImage;
    
    private Texture windowFull;
    private Texture windowBroke;
 
    private Window window;
    
    private String[] MAP2 = new String [] {
            "####",
            "####",
            "####",
            "####"
    };
    
   
    
    private Window[][] windowList = new Window [MAP2.length][MAP2[0].length()];
    private void initWindow() {
        for(int r = 0; r < MAP2.length; r++) {
            for(int c = 0; c < MAP2[0].length(); c++) {
	            if (MAP2[r].charAt(c) == '#') {
	                window = new Window(c, r, false);
	                windowList[r][c] = window;
	            } else {
	            	window = new Window(c, r, true);
	                windowList[r][c] = window;
	            }
            }
        }
    }
    public MazeRenderer(SpriteBatch batch, Maze maze) {
        this.maze = maze;
        this.batch = batch;
        wallImage = new Texture("wall.png");
        dotImage = new Texture("dot.png");
        
        windowFull = new Texture("window_full.png");
        windowBroke = new Texture("window_crack.png");
        initWindow();
        System.out.println(windowList[0][0]);
        System.out.println(windowList[0][1]);
    }
 
    public void render() {
        batch.begin();
        int y= -360 + PacmanGame.HEIGHT;
        for(int r = 0; r < maze.getHeight(); r++) {
        	int x=190;
        	if (r!=0) {
        		 y-=WorldRenderer.BLOCK_SIZE +7;
        	}
            for(int c = 0; c < maze.getWidth(); c++) {
            	if (c!=0) {
            
            		x += WorldRenderer.BLOCK_SIZE+7;
            	}

                if(maze.hasWallAt(r, c)) {
                    batch.draw(windowFull, x, y);
                } else if(maze.hasDotAt(r, c)) {
                    batch.draw(windowBroke, x, y);
                }
                //System.out.println(y);
            }
        }
        batch.end();
    }
}
