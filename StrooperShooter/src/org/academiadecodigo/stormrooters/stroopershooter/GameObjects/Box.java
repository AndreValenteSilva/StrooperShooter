package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.GridPosition;

public abstract class Box extends GameObjects {

    private int hitCounter;
    private int boxArmour = 2;

    public Box(GridPosition gridPosition) {
        super(gridPosition);
        this.hitCounter = 0;
    }

    public abstract int getPoints();

    public void hit() {

        if (hitCounter <= boxArmour) {

            hitCounter++;

            System.out.println("[BOX] Box was isHitted: " + hitCounter + "\n");

        } else {
            getPoints();

            System.out.println("[BOX] box explode \n");

            setHitted();

            hide();
        }
    }

}
