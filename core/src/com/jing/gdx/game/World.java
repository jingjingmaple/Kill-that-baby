package com.jing.gdx.game;

public class World {
    private Pacman pacman;
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
        pacman = new Pacman(60,60,this);
        this.pacmanGame = pacmanGame;
        score = 0;
        registerDotEattenListener();
        
        map = new Map();
        player = new Player(3,1,this);
        boss = new Boss(200,650,this);

        
        brickRenderer = new BrickRenderer(pacmanGame.batch,this);
        gamestate = new GameState(pacmanGame.batch);
    }
 
    Pacman getPacman() {
        return pacman;
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
	        pacman.update();
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
    private void registerDotEattenListener() {
        pacman.registerDotEattenListener(new Pacman.DotEattenListener() {
            @Override
            public void notifyDotEatten() {
                score += 1;
            }
        });
    }
}