package org.academiadecodigo.stormrooters.stroopershooter;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.stormrooters.stroopershooter.Field.Grid;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Enemy;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Friend;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.GameObjects;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Bonus;
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
    private int gameRound;
    private int enemyCounter;
    private int friendCounter;
    private int bonusCounter;
    private Menu menu = new Menu();


    public Game(int objectsNumber) {
        this.sniper = new Weapon();
        this.grid = new Grid(124, 78);
        this.player = new Player(sniper);
        this.objects = new GameObjects[objectsNumber];
        this.gameRound = 1;
    }

    public void menu() throws InterruptedException {
        //menu.menuOption(this);
        init();
    }

    public void init() throws InterruptedException {

        //menu.exitMainMenu();
        grid.init();

        for (int i = 0; i < objects.length; i++) {

            int warrior = (int) (Math.random() * 100);

            if (warrior < 11) {
                objects[i] = new Bonus(grid.makeGridPosition(2));
                objects[i].setGrid(grid);
            } else if (warrior > 65) {
                objects[i] = new Friend(grid.makeGridPosition(1));
                objects[i].setGrid(grid);
            } else {
                objects[i] = new Enemy(grid.makeGridPosition(0));
                objects[i].setGrid(grid);
            }
        }
        player.drawAim();
        start();
    }

    public void start() throws InterruptedException {

        timer = new CountDownTimer(30);
        timer.startCountTimer();

        while (gameOn) {
            Thread.sleep(500);

            gameRound();

            moveTarget();

            checkHits();

        }
    }

    public void moveTarget() {
        for (GameObjects c : objects) {
            c.move();
        }
    }

    public void gameRound() throws InterruptedException {
        if (gameRound < 5 && timer.getSeconds() == 1) {
            gameRound++;
            System.out.println("round: " + gameRound);
            init();
        }
        if (gameRound == 5 || player.getScore() < 0) {
            gameOn = false;

            System.out.println("Game Over");
            System.out.println("Enemies: " + enemyCounter + "; friends: " + friendCounter + "; bonus: " + bonusCounter);
        }
    }

    public void checkHits() {
        for (GameObjects object : objects) {

            if (player.getX() >= object.getX() && player.getX() <= object.getX() + object.getWidth() &&
                    player.getY() >= object.getY() && player.getY() <= object.getY() + object.getHeigth()
                    && player.getBulletNumber() > 0) {
                object.hit();
                if (object.isHitted()) {
                    player.setScore(object.getPoints());
                    if (object instanceof Enemy) {
                        enemyCounter++;
                    } else if (object instanceof Friend) {
                        friendCounter++;
                    } else {
                        bonusCounter++;
                    }
                }
                player.reset();
            }
        }
    }
}
