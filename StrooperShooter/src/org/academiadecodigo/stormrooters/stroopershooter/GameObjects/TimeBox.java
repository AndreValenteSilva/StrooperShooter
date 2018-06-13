package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;


import org.academiadecodigo.stormrooters.stroopershooter.Field.GridPosition;

public class TimeBox extends GameObjects {

    private int points;
    private int boxArmour;
    private int hitCounter;

    public TimeBox(GridPosition gridPosition) {
        super(gridPosition);
        this.points = 10;
        this.boxArmour = 2;
        this.hitCounter = 0;
    }

    public void hit() {

        if (hitCounter < boxArmour) {

            hitCounter++;

            System.out.println("[BOX] hitted");

        } else {
            getPoints();

            System.out.println("[BOX] box explode");

            setHitted();

            hide();
        }
    }

    public int getPoints() {
        return this.points;
    }

}
