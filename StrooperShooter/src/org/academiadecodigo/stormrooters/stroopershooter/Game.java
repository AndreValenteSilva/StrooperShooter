package org.academiadecodigo.stormrooters.stroopershooter;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Grid;
import org.academiadecodigo.stormrooters.stroopershooter.Field.SimplegfxGrid;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Enemy;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Target;
import org.academiadecodigo.stormrooters.stroopershooter.Timer.CountDownTimer;

public class Game {

    private CountDownTimer timer;
    private Player player;
    private Grid grid;
    private Weapon sniper;
    private Target[] objects;
    private boolean gameInit;
    private boolean gameOn = true;


    public Game(int objectsNumber) {
        this.sniper = new Weapon();
        this.grid = new SimplegfxGrid(124, 78);
        this.player = new Player("Batata", sniper);
        this.objects = new Target[objectsNumber];
    }

    public void init() throws InterruptedException {

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


/*        for (int j = 0; arrayPosition >= j; j++) {

            if (objects[arrayPosition].getPos().equals(objects[arrayPosition].getPos()) && arrayPosition != j) {
                objects[arrayPosition] = new Enemy(grid.makeGridPosition());
            }
        }
 */
    }

    public void start() throws InterruptedException {

        timer = new CountDownTimer(30);
        timer.startCountTimer();

        CountDownTimer objectTimer = new CountDownTimer(5);
        objectTimer.countdownObject();


        while (gameOn) {
            Thread.sleep(500);

            for (Target object : objects) {

                if (player.getX() >= object.getX() && player.getX() <= object.getX() + object.getWidth() &&
                        player.getY() >= object.getY() && player.getY() <= object.getY() + object.getHeigth()) {
                    player.shootWeapon(object);
                    //object.hit();
                    player.setScore(object.getPoints());
                    player.reset();
                }
            }
        }
//        System.out.println("object----" + objects[0].getX() + "..." + objects[0].getY());

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
