package org.academiadecodigo.stormrooters.stroopershooter;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Grid;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Enemy;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Friend;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.GameObjects;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.TimeBox;
import org.academiadecodigo.stormrooters.stroopershooter.Menus.Menu;
import org.academiadecodigo.stormrooters.stroopershooter.Timer.CountDownTimer;

public class Game {

    private CountDownTimer timer;
    private Player player;
    private Grid grid;
    private Weapon sniper;
    private GameObjects[] objects;
    private boolean gameInit;
    private boolean gameOn = true;
    private Menu menu = new Menu();


    public Game(int objectsNumber) {
        this.sniper = new Weapon();
        this.grid = new Grid(124, 78);
        this.player = new Player("Batata", sniper);
        this.objects = new GameObjects[objectsNumber];
    }

    public void menu() throws InterruptedException {
        menu.menuOption(this);
    }

    public void init() throws InterruptedException {

        menu.exitMainMenu();
        grid.init();

        for (int i = 0; i < objects.length; i++) {
            int warrior = (int) (Math.random() * 3);

            switch (warrior) {
                case 0:
                    objects[i] = new Enemy(grid.makeGridPosition(0));
                    objects[i].setGrid(grid);
                    break;
                case 1:
                    objects[i] = new TimeBox(grid.makeGridPosition(0));
                    objects[i].setGrid(grid);
                    break;
                case 2:
                    objects[i] = new Friend(grid.makeGridPosition(1));
                    objects[i].setGrid(grid);
                    break;
            }
        }
        start();
    }

    public void start() throws InterruptedException {

        timer = new CountDownTimer(30);
        timer.startCountTimer();

        while (gameOn) {
            Thread.sleep(500);

            gameOver();

            moveTarget();

            checkHits();

        }
    }

    public void moveTarget() {
            for (GameObjects c : objects) {
                c.move();
        }
    }

    public String gameOver() {
        if (timer.getSeconds() == 0 || player.getScore() < 0) {
            gameOn = false;
        }
        return "Game Over";
    }

    public void checkHits() {
        for (GameObjects object : objects) {

            if (player.getX() >= object.getX() && player.getX() <= object.getX() + object.getWidth() &&
                    player.getY() >= object.getY() && player.getY() <= object.getY() + object.getHeigth()
                    && player.getBulletNumber() > 0) {
                object.hit();
                if (object.isHitted()) {
                    player.setScore(object.getPoints());
                }
                player.reset();
            }
        }
    }

}
