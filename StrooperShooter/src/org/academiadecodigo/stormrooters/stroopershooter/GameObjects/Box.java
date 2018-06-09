package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.GridPosition;

public abstract class Box extends GameObjects {

    private int timer; //var type might need to be changed
    private int hitCounter;

    public Box(GridPosition gridPosition) {
        super(gridPosition);
        this.hitCounter = 0;
    }

    //gives bonus when destroyed
    public abstract int getBonus();


    public void hit() {

        if (hitCounter <= GameObjectFactory.BOX_ARMOUR) {

            hitCounter++;

            System.out.println("[BOX] Box was isHitted: " + hitCounter + "\n");

        } else {
            getBonus();

            System.out.println("[BOX] box explode \n");

            setHitted();
        }
    }
}
