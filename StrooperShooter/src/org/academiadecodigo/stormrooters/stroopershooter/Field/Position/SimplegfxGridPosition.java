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
    private Picture object;
    private String [] warriors = {"chewie.png", "luke.png", "obi.png" };
    private String [] friendsImg = {"vader.png", "storm.png", "tasker.png"};

    public SimplegfxGridPosition(SimplegfxGrid grid, int warrior) {

        this.grid = grid;
        this.col = (int) (Math.random() * (grid.getCols() - 10));
        this.row = (int) (Math.random() * (grid.getRows() - 26));
        this.height = 120;
        this.width = 78;

        int x = grid.columnToX(getCol());
        int y = grid.rowToY(getRow());

        int warriorImg = (int) (Math.random() * 3);

        switch (warrior) {
            case 0:
                this.object = new Picture(x,y,warriors[warriorImg]);
                break;
            case 1:
                this.object = new Picture(x,y,friendsImg[warriorImg]);
                break;
        }

        show();
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
