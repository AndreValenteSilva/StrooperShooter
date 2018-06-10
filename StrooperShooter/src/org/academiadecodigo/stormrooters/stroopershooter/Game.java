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
    private Enemy[] objects;
    private boolean gameInit;

    public static final int BULLET_DAMAGE = 1;


    public Game(int objectsNumber) {
        this.sniper = new Weapon();
        grid = new SimplegfxGrid(124, 86);
        //this.gameObjects = new Enemy();
        //this.gameObjects = createObjects(objectsNumber);
        this.player = new Player("Batata", sniper);
        this.objects = new Enemy[objectsNumber];
    }

    public void init() {

        grid.init();

        for (int i = 0; i < objects.length; i++) {
            objects[i] = new Enemy(grid.makeGridPosition());
            //System.out.println(objects.getPos().toString());
        }

        start();
    }

    public void start() {

        //objects = new Target(grid.makeGridPosition(20, 20));
        System.out.println("out while");

        player.shootWeapon(objects[0]);
        if (objects[0].isHitted()) {
            player.setScore(givePoints(0));
        }

        player.shootWeapon(objects[1]);
        if (objects[1].isHitted()) {
            player.setScore(givePoints(1));
        }

        System.out.println("object----" + objects[0].getX() + "..." + objects[0].getY());

    }

    public int givePoints(int position) {
        return objects[position].getPoints();
    }


    public void moveTarget() {
    }


    public String gameOver() {
        return "Game Over";
    }

}
