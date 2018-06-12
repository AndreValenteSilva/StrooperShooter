package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.SimplegfxGridPosition;

public abstract class Box extends GameObjects {

    private int timer; //var type might need to be changed
    private int hitCounter;

    public Box(SimplegfxGridPosition gridPosition) {
        super(gridPosition);
        this.hitCounter = 0;
    }

    public abstract int getPoints();

    //gives bonus when destroyed
    //public abstract int getBonus();


    public void hit() {

        if (hitCounter <= GameObjectFactory.BOX_ARMOUR) {

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
