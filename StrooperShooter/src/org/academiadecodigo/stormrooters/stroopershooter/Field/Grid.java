package org.academiadecodigo.stormrooters.stroopershooter.Field;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.GridPosition;

public interface Grid {

    void init();

    public GridPosition makeGridPosition();

    public GridPosition makeGridPosition(int col, int row);

}
