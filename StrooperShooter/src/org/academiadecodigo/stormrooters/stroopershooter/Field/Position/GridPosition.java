package org.academiadecodigo.stormrooters.stroopershooter.Field.Position;

public interface GridPosition {

    int getCol();

    int getRow();

    void setPos(int col, int row);

    void show();

    void hide();

    boolean equals (GridPosition position);

}
