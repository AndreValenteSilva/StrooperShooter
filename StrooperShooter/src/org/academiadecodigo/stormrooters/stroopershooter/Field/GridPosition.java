package org.academiadecodigo.stormrooters.stroopershooter.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GridPosition {

    private int col;
    private int row;
    private int width;
    private int height;
    private Grid grid;
    private Picture object;
    private String[] warriors = {"chewie.png", "luke.png", "obi.png"};
    private String[] friendsImg = {"vader.png", "storm.png", "tasker.png"};
    private String[] timeBox = {"c3po.png"};

    public GridPosition(Grid grid, int warrior) {

        this.grid = grid;
        this.col = (int) (Math.random() * (grid.getCols() - 10));
        this.row = (int) (Math.random() * (grid.getRows() - 26));
        this.height = 120;
        this.width = 78;

        int x = grid.columnToX(getCol());
        int y = grid.rowToY(getRow());

        int randomImg = (int) (Math.random() * 3);

        switch (warrior) {
            case 0:
                this.object = new Picture(x, y, warriors[randomImg]);
                break;
            case 1:
                this.object = new Picture(x, y, friendsImg[randomImg]);
                break;
            case 2:
                this.object = new Picture(x, y, timeBox[0]);   
                break;
        }

        show();
    }

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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Grid getGrid() {
        return grid;
    }


    public void show() {
        object.draw();
    }


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
