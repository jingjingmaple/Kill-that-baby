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
    private Texture tower;
    private Window window;
    private Map map;
   

    public MazeRenderer(SpriteBatch batch, Maze maze, Map map) {
        this.maze = maze;
        this.map = map;
        this.batch = batch;
        wallImage = new Texture("wall.png");
        dotImage = new Texture("dot.png");
        
        windowFull = new Texture("window_full.png");
        windowBroke = new Texture("window_crack.png");
        tower = new Texture("tower.png");
    }
 
    public void render() {
        batch.begin();
        batch.draw(tower, 160, 0);
        for(int r = 0; r < map.getWindow().length; r++) {        
            for(int c = 0; c < map.getWindow()[0].length; c++) {

                if(map.getWindow()[r][c].state) {
                    batch.draw(windowFull, map.getWindow()[r][c].pos_x, map.getWindow()[r][c].pos_y);
                } else  {
                    batch.draw(windowBroke, map.getWindow()[r][c].pos_x, map.getWindow()[r][c].pos_y);
                }
                //System.out.println(y);
            }
        }
        
        /*
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
        }*/
        batch.end();
    }
}
