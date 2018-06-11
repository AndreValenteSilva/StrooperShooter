package org.academiadecodigo.stormrooters.stroopershooter.Field.Position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.stormrooters.stroopershooter.Field.GridDirection;
import org.academiadecodigo.stormrooters.stroopershooter.Field.SimplegfxGrid;

public class SimplegfxGridPosition implements GridPosition {

    private int col;
    private int row;
    private int width;
    private int height;
    private SimplegfxGrid grid;
    //private Rectangle object;
    private Picture picture;
    private Picture object;

    public SimplegfxGridPosition(SimplegfxGrid grid) {

        int size = (int) (Math.random() * 3 + 1); //generate a random number to change the objects size

        this.grid = grid;
        this.col = (int) (Math.random() * (grid.getCols() - 10));
        this.row = (int) (Math.random() * (grid.getRows() - 26));
        this.height = 30 * size;
        this.width = 30 * size;

        int x = grid.columnToX(getCol());
        int y = grid.rowToY(getRow());



        //x ternary verifying that the object is not created closer to the edge
        //this.object = new Rectangle(x < 125 ? 100 : x, y, height, width);


        /** this set character pictues. needs to insert a math random to choose a pick
         *
         */
        this.object = new Picture(x,y,"char3Small.png");
        System.out.println(getX() + "......" + getY());

        show();
    }

    public SimplegfxGridPosition(int col, int row, SimplegfxGrid grid) {
        this.col = col;
        this.row = row;

        int x = grid.columnToX(getCol() - 10);
        int y = grid.rowToY(getRow() - 20);


        /**set postion of the characters on the grid
         *
         */
        //this.object = new Rectangle(x, y, grid.getCellsize(), grid.getCellsize());
        this.object = new Picture(x,y,"char3Small.png");
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

    public SimplegfxGrid getGrid() {
        return grid;
    }

    @Override
    public void show() {
        //object.fill();
        //object.setColor(Color.BLUE);
        object.draw();
    }

    @Override
    public void hide() {
        object.delete();
    }

    public void moveInDirection(GridDirection direction, int distance) {
        int x = getCol();
        int y = getRow();

        System.out.println("X " + x + " Y " + y + " MOVE IN DIRECTION");

        switch (direction) {
            case LEFT:
                moveLeft(distance);
                System.out.println("Left - MoveInDirection");
                break;
            case RIGHT:
                moveRight(distance);
                System.out.println("Right - MoveInDirection");
                break;
        }

        int dx = grid.columnToX(getCol()) - grid.columnToX(x);
        int dy = grid.rowToY(getRow()) - grid.rowToY(y);

        System.out.println("Translate");

        object.translate(dx, dy);

    }

    public void moveLeft(int dist) {

        System.out.println("<------------------>---------------------->" + getCol());
        int maxRowsLeft = dist < getCol() ? dist : getCol();
        setPos(getCol() - maxRowsLeft, getRow());
        System.out.println(maxRowsLeft + "----------->" + getCol() + " " + dist);
    }

    public void moveRight(int dist) {
       int maxRowsRight = dist > getGrid().getCols() - (getCol() + 1) ? getGrid().getCols() - (getCol() + 1) : dist;
        setPos(getCol() + maxRowsRight, getRow());
        System.out.println(maxRowsRight + "---------->");
    }
}
