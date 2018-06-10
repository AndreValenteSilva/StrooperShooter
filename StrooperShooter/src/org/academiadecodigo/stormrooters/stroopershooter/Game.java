package org.academiadecodigo.stormrooters.stroopershooter;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Grid;
import org.academiadecodigo.stormrooters.stroopershooter.Field.SimplegfxGrid;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Enemy;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Target;
import org.academiadecodigo.stormrooters.stroopershooter.Timer.CountDownTimer;

public class Game {

    private CountDownTimer timer; //the type must be changed
    private Player player;
    private Grid grid;
    private Target objects;
    private Weapon sniper;
    //private GameObjects[] objects;
    //private Target[] objects;
    private boolean gameInit;
    private boolean gameOn = true;

    //public static final int BULLET_DAMAGE = 1;


    public Game(int objectsNumber) {
        this.sniper = new Weapon();
        this.grid = new SimplegfxGrid(124, 78);
        this.player = new Player("Batata", sniper);
        //this.objects = new Enemy[objectsNumber];
    }

    public void init() throws InterruptedException {

        grid.init();

        //for loop to check if there two objects on the same position
        //not working
        //they would need to be in the exact x and y to accept it as same position
        //we need to find a way to create a range
/*        for (int i = 0; i < objects.length; i++) {
            objects[i] = new Enemy(grid.makeGridPosition());

            if (i != 0) {
                checkPosition(i);
            }
        }

*/
        objects = new Enemy(grid.makeGridPosition());

        start();
    }

    private void checkPosition(int arrayPosition) {


/*        for (int j = 0; arrayPosition >= j; j++) {

>>>>>>> feature
            if (objects[arrayPosition].getPos().equals(objects[arrayPosition].getPos()) && arrayPosition != j) {
                objects[arrayPosition] = new Enemy(grid.makeGridPosition());
            }
        }
 */   }

    public void start() throws InterruptedException {

        // timer = new CountDownTimer(31);
        // timer.startCountTimer();

//        CountDownTimer objectTimer = new CountDownTimer(6);
//        objectTimer.countdownObject();


/*

        player.shootWeapon(objects[0]);
        if (objects[0].isHitted()) {
            player.setScore(givePoints(0));
        }
*/
        while (gameOn) {
            Thread.sleep(1000);
        System.out.println("X:" + player.getX() + "; Y:" + player.getY());
            if (player.getX() >= objects.getX() && player.getX() <= ( objects.getX() + objects.getWidth() ) &&
                    player.getY() >= objects.getY() && player.getY() <= ( objects.getY() + objects.getHeigth() ) ) {
                player.shootWeapon(objects);
                objects.hit();
                player.setScore(objects.getPoints());
                System.out.println("hit");
            }
        }
//        System.out.println("object----" + objects[0].getX() + "..." + objects[0].getY());

    }

    public int givePoints(int position) {
        return objects/*[position]*/.getPoints();
    }


    public void moveTarget() {
    }


    public String gameOver() {
        return "Game Over";
    }

}
