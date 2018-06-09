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

        int x = grid.columnToX(getCol());
        int y = grid.rowToY(getRow());

        System.out.println(x + " " + y);
        this.object = new Rectangle(x, y, 75, 75);

        show();
    }

    public SimplegfxGridPosition(int col, int row, SimplegfxGrid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;

        int x = grid.columnToX(getCol());
        int y = grid.rowToY(getRow());

        this.object = new Rectangle(x, y, grid.getCellsize(), grid.getCellsize());
    }

    @Override
    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

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
