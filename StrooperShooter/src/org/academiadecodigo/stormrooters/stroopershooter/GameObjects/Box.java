package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.Position;

public class Box extends GameObjects {

    private int timer; //var type might need to be changed
    private int hitCounter;

    public Box(int size, Position position) {

        super(size, position);
        this.hitCounter = 0;
    }

    public void giveTime() { //kind of a time setter??

        //time.delayTime;

    }


    @Override
    public boolean isHitted() {

        if (hitCounter <= GameObjectFactory.BOX_ARMOUR) {

            hitCounter++;
            giveTime();
            System.out.println("[BOX] Box was hit: " + hitCounter + "\n");
        }

        hitCounter = 0;
        System.out.println("[BOX] box explode \n");

        return super.isHitted();
    }
}
