package org.academiadecodigo.stormrooters.stroopershooter;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Grid;
import org.academiadecodigo.stormrooters.stroopershooter.Field.SimplegfxGrid;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Enemy;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.GameObjects;

import java.util.Iterator;

public class Game {

    private int timer; //the type must be changed
    private Player player;

    private Grid grid;
    private GameObjects gameObjects;
    private Weapon sniper;

    public static final int BULLET_DAMAGE = 1;


    public Game(int objectsNumber) {
        this.sniper = new Weapon();
        this.gameObjects = new Enemy();
        //this.gameObjects = createObjects(objectsNumber);
        this.player = new Player("Batata", sniper);
    }

    public void init() {
        grid = new SimplegfxGrid(124, 86);
    }

    public void start() {

        player.shootWeapon(gameObjects);
        if (gameObjects.isHitted()) {
            player.setScore(givePoints());
        }

        player.shootWeapon(gameObjects);
        if (gameObjects.isHitted()) {
            player.setScore(givePoints());
        }

    }

    public GameObjects createObjects(int numberObjects) {

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

