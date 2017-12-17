package com.jing.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	public static final int BLOCK_SIZE = 40;
	private PacmanGame pacmanGame;
	private Texture pacmanImg;
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
		mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
		font = new BitmapFont();
	}
	public void render(float delta) {
		//System.out.println(count);
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mazeRenderer.render();
        SpriteBatch batch = pacmanGame.batch;
        batch.begin();
        Vector2 pos = world.getPacman().getPosition();
        batch.draw(pacmanImg, pos.x - BLOCK_SIZE/2, 
                PacmanGame.HEIGHT - pos.y - BLOCK_SIZE/2);
        font.draw(batch, "" + world.getScore(), 700, 60);
        batch.end();
        count++;
    }
	
}