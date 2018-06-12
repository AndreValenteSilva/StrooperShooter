package org.academiadecodigo.stormrooters.stroopershooter;

import org.academiadecodigo.stormrooters.stroopershooter.Field.SimplegfxGrid;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Enemy;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Target;
import org.academiadecodigo.stormrooters.stroopershooter.Timer.CountDownTimer;

public class Game {

    private CountDownTimer timer;
    private Player player;
    private SimplegfxGrid grid;
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

        for (int i = 0; i < objects.length; i++) {
            objects[i] = new Enemy(grid.makeGridPosition());
            objects[i].setGrid(grid);
        }

        moveTarget();
        start();
    }

    public void start() throws InterruptedException {

        timer = new CountDownTimer(30);
        timer.startCountTimer();

        CountDownTimer objectTimer = new CountDownTimer(5);
        objectTimer.countdownObject();

        while (gameOn) {
            Thread.sleep(100);

            moveTarget();

            for (Target object : objects) {

                if (player.getX() >= object.getX() && player.getX() <= object.getX() + object.getWidth() &&
                        player.getY() >= object.getY() && player.getY() <= object.getY() + object.getHeigth()) {
                    //player.shootWeapon();
                    object.hit();
                    player.setScore(object.getPoints());
                    player.reset();
                }
            }
        }
    }

    public void moveTarget() {
            for (Target c : objects) {
                c.move();
        }
    }


    public String gameOver(int seconds) {
        if (seconds == 0) {

        }
        return "Game Over";
    }

}
