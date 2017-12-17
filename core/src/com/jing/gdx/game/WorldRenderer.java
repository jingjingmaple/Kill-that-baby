package com.jing.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	public static final int BLOCK_SIZE = 100;
	private PacmanGame pacmanGame;
	private Texture pacmanImg;
	private Texture playerImg;
	World world;
	SpriteBatch batch;
	private MazeRenderer mazeRenderer;
	private BitmapFont font;
	public static int count = 0;
		

	public WorldRenderer(PacmanGame pacmanGame, World world) {
		
		this.pacmanGame = pacmanGame;
		batch = pacmanGame.batch;
		this.world = world;
		pacmanImg = new Texture("pacman.png");
		mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze(), world.getMap());
		font = new BitmapFont();
		playerImg = new Texture("player_idle.png");
		
	}
	public void render(float delta) {
		//System.out.println(count);
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        
        SpriteBatch batch = pacmanGame.batch;
        mazeRenderer.render();
        batch.begin();
        
        Vector2 pos = world.getPacman().getPosition();
        batch.draw(pacmanImg, pos.x - BLOCK_SIZE/2, 
                PacmanGame.HEIGHT - pos.y - BLOCK_SIZE/2);
        font.draw(batch, "" + world.getScore(), 700, 60);
        batch.draw(playerImg, world.getPlayer().getX(), world.getPlayer().getY());
        batch.end();
        
       
        count++;
    }
	
}