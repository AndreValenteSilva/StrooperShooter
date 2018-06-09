package org.academiadecodigo.stormrooters.stroopershooter.Field;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.GridPosition;
import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.SimplegfxGridPosition;

/**
 * Created by codecadets on 09/06/2018.
 */
public class SimplegfxGrid implements Grid {

    private int cols;
    private int rows;
    public static final int PADDING = 10;
    public static final int CELLSIZE = 10;
    private Rectangle grid;

    public SimplegfxGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    @Override
    public void init() {
        this.grid = new Rectangle(PADDING, PADDING, cols * CELLSIZE, rows * CELLSIZE);
        this.grid.draw();
    }

    @Override // creates a random SimplegfxGridPosition
    public GridPosition makeGridPosition() {
        return new SimplegfxGridPosition(this);
    }

    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return new SimplegfxGridPosition(col, row, this);
    }

    public int getCellsize() {
        return CELLSIZE;
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
