package org.academiadecodigo.stormrooters.stroopershooter.Field;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.GridPosition;
import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.SimplegfxGridPosition;

public interface Grid {

    void init();

    public SimplegfxGridPosition makeGridPosition();

    public GridPosition makeGridPosition(int col, int row);

}
