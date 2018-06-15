package org.academiadecodigo.stormrooters.stroopershooter.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadets on 09/06/2018.
 */
public class Grid {

    private int cols;
    private int rows;
    public static final int PADDING = 10;
    public static final int CELLSIZE = 10;
    private Picture grid;

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public void init() {
        this.grid = new Picture(PADDING, PADDING, "resources/field.png");
        this.grid.draw();
    }

    public GridPosition makeGridPosition(int warrior) {
        return new GridPosition(this, warrior);
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int rowToY(int row) {
        return PADDING + CELLSIZE * row;
    }

    public int columnToX(int column) {
        return PADDING + CELLSIZE * column;
    }
}
