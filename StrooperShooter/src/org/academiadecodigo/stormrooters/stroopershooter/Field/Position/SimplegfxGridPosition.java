package org.academiadecodigo.stormrooters.stroopershooter.Field.Position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.stormrooters.stroopershooter.Field.SimplegfxGrid;

public class SimplegfxGridPosition implements GridPosition {

    private int col;
    private int row;
    private SimplegfxGrid grid;
    private Rectangle object;

    public SimplegfxGridPosition(SimplegfxGrid grid) {
        this.col = (int) (Math.random() * grid.getCols());
        this.row = (int) (Math.random() * grid.getRows());
        this.grid = grid;
        this.object = new Rectangle(col * grid.getCellsize(), row * grid.getCellsize(), grid.getCellsize(), grid.getCellsize());
    }

    public SimplegfxGridPosition(int col, int row, SimplegfxGrid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
        this.object = new Rectangle();
    }

    @Override
    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
    }

/*    @Override
    public int getCol() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }*/

    @Override
    public void show() {
        object.fill();
        object.setColor(Color.BLUE);
    }

    @Override
    public void hide() {
        object.delete();
    }

    @Override
    public boolean equals(GridPosition position) {
        return false;
    }
}
