package com.jing.gdx.game;

public class World {
    private PacmanGame pacmanGame;
    private Maze maze;
    private int score;
    
    private Player player;
    private Boss boss;
    private Map map;
    private Brick brick;
    private BrickRenderer brickRenderer;
    private GameState gamestate;
    
    World(PacmanGame pacmanGame) {
    	maze = new Maze();
        this.pacmanGame = pacmanGame;
        score = 0;
        
        map = new Map();
        player = new Player(3,1,pacmanGame.batch,this);
        boss = new Boss(200,650,pacmanGame.batch,this);

        
        brickRenderer = new BrickRenderer(pacmanGame.batch,this);
        gamestate = new GameState(pacmanGame.batch);
    }
 

    Player getPlayer() {
    	return player;
    }
    Maze getMaze() {
        return maze;
    }
    Map getMap() {
    	return map;
    }
    Boss getBoss() {
    	return boss;
    }

    BrickRenderer getBrickRenderer() {
    	return brickRenderer;
    }
    GameState getGameState() {
    	return gamestate;
    }
    public void update(float delta) {
    	if (gamestate.getState() == "RUN") {
	        boss.update();
	        brickRenderer.update();
	        player.update();
    	}
    }
    public int getScore() {
        return score;
    }
    public void increaseScore() {
        score += 10;
        checkWin();
    }
    public void checkWin() {
    	System.out.println(map.getTotalBroke());
    	if (map.getTotalBroke()*10 == score) {
    		gamestate.win();
    	}
    }
  
}