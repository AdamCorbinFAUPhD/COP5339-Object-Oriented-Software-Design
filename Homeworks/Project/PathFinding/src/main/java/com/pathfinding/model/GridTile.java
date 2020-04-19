package com.pathfinding.model;

/**
 * This class is to represent the base tile in a Grid Model. It will have information that might be used for algorithms
 * such as visited or parents.
 */
public class GridTile extends Tile implements Cloneable {
    public static final int BLOCKED = 1;
    public static final int FREE = 0;
    public int collisionFlag = 0;

    //Historical data used for algorithms
    public GridTile parent = null;
    public boolean visited = false;

    public GridTile(int x, int y, int collisionFlag) {
        super(x, y);
        this.collisionFlag = collisionFlag;
    }

    public GridTile(int x, int y) {
        super(x, y);
    }

    public GridTile(Tile tile) {
        super(tile.x, tile.y);
    }

    /**
     * @return Shallow copy of a GridTie
     * @throws CloneNotSupportedException - possible the object might have an issue cloning
     */
    public GridTile clone() throws CloneNotSupportedException {
        return (GridTile) super.clone();
    }

    /**
     * @postcondition - Clears out historical data for a specific tile
     */
    public void resetTile() {
        parent = null;
        visited = false;
    }
}
