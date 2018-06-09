package org.academiadecodigo.stormrooters.stroopershooter;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Grid;
import org.academiadecodigo.stormrooters.stroopershooter.Field.SimplegfxGrid;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Enemy;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.GameObjects;

public class Game {

    private int timer; //the type must be changed
    private Player player;
    private Grid grid;
    private GameObjects gameObjects;
    private Weapon sniper;
    private Enemy objects;
    private boolean gameInit;

    public static final int BULLET_DAMAGE = 1;


    public Game(int objectsNumber) {
        this.sniper = new Weapon();
        grid = new SimplegfxGrid(124, 86);
        //this.gameObjects = new Enemy();
        this.gameObjects = createObjects(objectsNumber);
        this.player = new Player("Batata", sniper);

    }

    public void init() {

        grid.init();

        for (int i = 0; i < 5; i++) {
            objects = new Enemy(grid.makeGridPosition());
            System.out.println(objects.getPos().toString());
        }

        start();
    }

    public void start() {

        //objects = new Target(grid.makeGridPosition(20, 20));
        System.out.println("out while");

        player.shootWeapon(gameObjects);
        if (gameObjects.isHitted()) {
            player.setScore(givePoints());
        }

        player.shootWeapon(gameObjects);
        if (gameObjects.isHitted()) {
            player.setScore(givePoints());
        }

    }

    public GameObjects createObjects(int objectsNumber) {
        return null;
    }


    public int givePoints() {
        return gameObjects.getPoints();
    }


    public void moveTarget() {
    }


    public String gameOver() {
        return "Game Over";
    }

}
