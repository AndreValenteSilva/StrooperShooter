package org.academiadecodigo.stormrooters.stroopershooter;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Grid;
import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.GridPosition;
import org.academiadecodigo.stormrooters.stroopershooter.Field.SimplegfxGrid;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Enemy;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.GameObjects;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Target;
import org.academiadecodigo.stormrooters.stroopershooter.Timer.CountDownTimer;

public class Game {

    private CountDownTimer timer; //the type must be changed
    private Player player;
    private Grid grid;
    private GameObjects gameObjects;
    private Weapon sniper;
    //private GameObjects[] objects;
    private Target[] objects;
    private boolean gameInit;

    //public static final int BULLET_DAMAGE = 1;


    public Game(int objectsNumber) {
        this.sniper = new Weapon();
        this.grid = new SimplegfxGrid(124, 78);
        this.player = new Player("Batata", sniper);
        this.objects = new Enemy[objectsNumber];
    }

    public void init() {

        grid.init();

        //for loop to check if there two objects on the same position
        //not working
        //they would need to be in the exact x and y to accept it as same position
        //we need to find a way to create a range
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new Enemy(grid.makeGridPosition());

            if (i != 0) {
                checkPosition(i);
            }
        }
        start();
    }

    private void checkPosition(int arrayPosition) {

        for (int j = 0; arrayPosition >= j; j++) {
            if (objects[arrayPosition].getPos().equals(objects[arrayPosition].getPos()) && arrayPosition != j) {
                objects[arrayPosition] = new Enemy(grid.makeGridPosition());
            }
        }
    }

    public void start() {

        timer = new CountDownTimer(30);
        timer.startCountTimer();

        CountDownTimer objectTimer = new CountDownTimer(5);
        objectTimer.countdownObject();

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


    public String gameOver(int seconds) {
        if (seconds == 0) {

        }
        return "Game Over";
    }

}
