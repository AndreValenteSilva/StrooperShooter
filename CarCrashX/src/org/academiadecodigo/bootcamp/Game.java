package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.car.Car;
import org.academiadecodigo.bootcamp.car.CarFactory;
import org.academiadecodigo.bootcamp.grid.*;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

/**
 * The game logic
 */
public class Game extends GameKeyboardHandler {


    /**
     * Graphical Car field
     */
    private Grid grid;

    /**
     * Container of Cars
     */
    private Car[] cars;

    /**
     * Animation delay
     */
    private int delay;

    /**
     * The collision detector
     */
    private CollisionDetector collisionDetector;

    /**
     * Number of cars to manufacture
     */
    private int manufacturedCars = 15;

    private Car controllableCar;
    private Car controllableCar2;


    /**
     * Constructs a new game
     *
     * @param gridType which grid type to use
     * @param cols     number of columns in the grid
     * @param rows     number of rows in the grid
     * @param delay    animation delay
     */
    Game(GridType gridType, int cols, int rows, int delay) {

        grid = GridFactory.makeGrid(gridType, cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        grid.init();

        cars = new Car[manufacturedCars];
        collisionDetector = new CollisionDetector(cars);

        for (int i = 0; i < manufacturedCars; i++) {

            cars[i] = CarFactory.getNewCar(grid);
            cars[i].setCollisionDetector(collisionDetector);
            cars[i].setGrid(grid);

        }

        controllableCar = CarFactory.getNewCar(grid);
        controllableCar.setCollisionDetector(collisionDetector);
        controllableCar.setGrid(grid);
        controllableCar.getPos().setColor(GridColor.MAGENTA);

        controllableCar2 = CarFactory.getNewCar(grid);
        controllableCar2.setCollisionDetector(collisionDetector);
        controllableCar2.setGrid(grid);
        controllableCar2.getPos().setColor(GridColor.MAGENTA);

        controls();

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            moveAllCars();

        }

    }

    /**
     * Moves all cars
     */
    public void moveAllCars() {

        for (Car c : cars) {
            c.move();
            collisionDetector.check(c);
        }

        collisionDetector.check(controllableCar);
        collisionDetector.check(controllableCar2);
    }

    public void moveControllableCar1(KeyboardEvent keyboardEvent) {

        if (controllableCar.isCrashed()){
            return;
        }

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                controllableCar.getPos().moveInDirection(GridDirection.LEFT, 1);
                break;
            case KeyboardEvent.KEY_RIGHT:
                controllableCar.getPos().moveInDirection(GridDirection.RIGHT, 1);
                break;
            case KeyboardEvent.KEY_UP:
                controllableCar.getPos().moveInDirection(GridDirection.UP, 1);
                break;
            case KeyboardEvent.KEY_DOWN:
                controllableCar.getPos().moveInDirection(GridDirection.DOWN, 1);
                break;
        }

    }

    public void moveControllableCar2(KeyboardEvent keyboardEvent) {

        if (controllableCar2.isCrashed()){
            return;
        }

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_A:
                controllableCar2.getPos().moveInDirection(GridDirection.LEFT, 1);
                break;
            case KeyboardEvent.KEY_D:
                controllableCar2.getPos().moveInDirection(GridDirection.RIGHT, 1);
                break;
            case KeyboardEvent.KEY_W:
                controllableCar2.getPos().moveInDirection(GridDirection.UP, 1);
                break;
            case KeyboardEvent.KEY_S:
                controllableCar2.getPos().moveInDirection(GridDirection.DOWN, 1);
                break;
        }

    }
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (controllableCar.getPos().equals(controllableCar2.getPos())){
            controllableCar.crash();
            controllableCar2.crash();
        }

        moveControllableCar1(keyboardEvent);
        moveControllableCar2(keyboardEvent);
    }
}
