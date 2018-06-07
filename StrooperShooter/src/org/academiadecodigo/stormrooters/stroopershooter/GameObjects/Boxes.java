package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Position;

public class Boxes extends GameObjects{

    private int timer; //var type might need to be changed
    private int hitCounter;

    public Boxes(int size, Position position) {
        super(size, position);
    }

    public void giveTime() { //kind of a time setter??

    }

    @Override
    public boolean isHitted() {
        return super.isHitted();
    }
}
