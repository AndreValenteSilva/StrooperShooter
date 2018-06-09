package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.GridPosition;

public class Target extends GameObjects {

    private Rectangle target;

    public Target(GridPosition gridPosition) {

        super(gridPosition);
        /*target = new Rectangle(g, 40, 30);
        target.fill();
        target.setColor(Color.BLUE);*/
    }

    @Override
    public boolean isHitted() {

        return super.isHitted();
    }
}
