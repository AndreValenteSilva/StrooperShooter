package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.GridPosition;

public abstract class Target extends GameObjects {

    private int points;
    private Rectangle target;


    public Target(GridPosition gridPosition) {

        super(gridPosition);
        /*target = new Rectangle(g, 40, 30);
        target.fill();
        target.setColor(Color.BLUE);*/
    }

    public void hit() {
        setHitted();

    }
}
