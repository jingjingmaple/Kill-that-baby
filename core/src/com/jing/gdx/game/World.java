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
    
    World(PacmanGame pacmanGame) {
    	maze = new Maze();
        pacman = new Pacman(60,60,this);
        this.pacmanGame = pacmanGame;
        score = 0;
        registerDotEattenListener();
        
        map = new Map();
        player = new Player(0,1,this);
        boss = new Boss(200,600,this);
        brick = new Brick(200,600,this);
        System.out.println(map.getBlock()[0][0][0]);
        System.out.println(map.getBlock()[0][0][1]);
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
    Brick getBrick() {
    	return brick;
    }
    public void update(float delta) {
        pacman.update();
        boss.update();
        brick.update();
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