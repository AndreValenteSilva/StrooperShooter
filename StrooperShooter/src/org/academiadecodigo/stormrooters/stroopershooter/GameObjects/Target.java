package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.GridPosition;
import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.SimplegfxGridPosition;
import org.academiadecodigo.stormrooters.stroopershooter.Field.SimplegfxGrid;

public abstract class Target extends GameObjects {

    private int points;
    private Rectangle target;


    public Target(SimplegfxGridPosition gridPosition) {

        super(gridPosition);
        /*target = new Rectangle(g, 40, 30);
        target.fill();
        target.setColor(Color.BLUE);*/
    }

    public abstract int getPoints();

    public void hit() {
        setHitted();
    }
}
