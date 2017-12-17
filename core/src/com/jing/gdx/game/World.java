package com.jing.gdx.game;

public class World {
    private Pacman pacman;
    private PacmanGame pacmanGame;
    private Maze maze;
    private int score;
    
    private Player player;
    
    World(PacmanGame pacmanGame) {
    	maze = new Maze();
        pacman = new Pacman(60,60,this);
        this.pacmanGame = pacmanGame;
        score = 0;
        registerDotEattenListener();
        player = new Player(170,170);
        
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
    public void update(float delta) {
        pacman.update();
    }
    public int getScore() {
        return score;
    }
    public void increaseScore() {
        score += 1;
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