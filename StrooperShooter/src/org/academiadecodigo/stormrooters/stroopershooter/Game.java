package org.academiadecodigo.stormrooters.stroopershooter;

import org.academiadecodigo.stormrooters.stroopershooter.Field.SimplegfxGrid;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Enemy;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.GameObjects;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Target;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.TimeBox;
import org.academiadecodigo.stormrooters.stroopershooter.Timer.CountDownTimer;

public class Game {

    private CountDownTimer timer;
    private Player player;
    private SimplegfxGrid grid;
    private Weapon sniper;
    private GameObjects[] objects;
    private boolean gameInit;
    private boolean gameOn = true;


    public Game(int objectsNumber) {
        this.sniper = new Weapon();
        this.grid = new SimplegfxGrid(124, 78);
        this.player = new Player("Batata", sniper);
        this.objects = new GameObjects[objectsNumber];
    }

    public void init() throws InterruptedException {

        grid.init();

        for (int i = 0; i < objects.length; i++) {
            int warrior = (int) (Math.random() * 2);

            switch (warrior) {
                case 0:
                    objects[i] = new Enemy(grid.makeGridPosition(warrior));
                    objects[i].setGrid(grid);
                    break;
                case 1:
                    objects[i] = new TimeBox(grid.makeGridPosition(warrior));
                    objects[i].setGrid(grid);
                    break;
            }
        }

        moveTarget();
        start();
    }

    public void start() throws InterruptedException {

        timer = new CountDownTimer(30);
        timer.startCountTimer();

        while (gameOn) {
            Thread.sleep(500);

            moveTarget();

            for (GameObjects object : objects) {

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
            for (GameObjects c : objects) {
                c.move();
        }
    }


    public String gameOver(int seconds) {
        if (seconds == 0) {

        }
        return "Game Over";
    }

}
