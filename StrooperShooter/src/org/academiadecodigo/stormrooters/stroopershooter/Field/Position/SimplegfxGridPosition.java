package org.academiadecodigo.stormrooters.stroopershooter.Field.Position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.stormrooters.stroopershooter.Field.SimplegfxGrid;

public class SimplegfxGridPosition implements GridPosition {

    private int col;
    private int row;
    private int width;
    private int height;
    private Rectangle object;

    public SimplegfxGridPosition(SimplegfxGrid grid) {

        int size = (int) (Math.random() * 3 + 1); //generate a random number to change the objects size

        this.col = (int) (Math.random() * (grid.getCols()-10));
        this.row = (int) (Math.random() * (grid.getRows()-26));
        this.height = 30 * size;
        this.width = 30 * size;

        int x = grid.columnToX(getCol());
        int y = grid.rowToY(getRow());

        this.object = new Rectangle(x < 125 ? 100 : x, y, height, width);
        System.out.println(getX() + "......" + getY());

        show();
    }

    public SimplegfxGridPosition(int col, int row, SimplegfxGrid grid) {
        this.col = col;
        this.row = row;

        int x = grid.columnToX(getCol()-10);
        int y = grid.rowToY(getRow()-20);

        this.object = new Rectangle(x, y, grid.getCellsize(), grid.getCellsize());
        System.out.println(getX());
    }

    @Override
    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getX() {
        return object.getX();
    }

    public int getY() {
        return object.getY();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
