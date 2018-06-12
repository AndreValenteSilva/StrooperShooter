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
    private Picture object;

    public SimplegfxGridPosition(SimplegfxGrid grid, int warrior) {

        int size = (int) (Math.random() * 3 + 1); //generate a random number to change the objects size

        this.grid = grid;
        this.col = (int) (Math.random() * (grid.getCols() - 10));
        this.row = (int) (Math.random() * (grid.getRows() - 26));
        this.height = 120;
        this.width = 78;

        int x = grid.columnToX(getCol());
        int y = grid.rowToY(getRow());

        switch (warrior) {
            case 0:
                this.object = new Picture(x,y,"char3Small.png");
                break;
            case 1:
                this.object = new Picture(x,y,"char2Small.png");
                break;
        }
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

        switch (direction) {

            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
        }

        int dx = grid.columnToX(getCol()) - grid.columnToX(x);
        int dy = grid.rowToY(getRow()) - grid.rowToY(y);

        object.translate(dx, dy);
    }

    private void moveUp(int dist) {

        int maxRowsUp = Math.min(dist, getRow());
        setPos(getCol(), getRow() - maxRowsUp);

    }

    private void moveDown(int dist) {

        int maxRowsDown = Math.min(getGrid().getRows() - (getRow() + 1), dist);
        setPos(getCol(), getRow() + maxRowsDown);

    }

    private void moveLeft(int dist) {

        int maxRowsLeft = Math.min(dist, getCol());
        setPos(getCol() - maxRowsLeft, getRow());

    }

    private void moveRight(int dist) {

        int maxRowsRight = Math.min(getGrid().getCols() - (getCol() + 1), dist);
        setPos(getCol() + maxRowsRight, getRow());
    }
}
