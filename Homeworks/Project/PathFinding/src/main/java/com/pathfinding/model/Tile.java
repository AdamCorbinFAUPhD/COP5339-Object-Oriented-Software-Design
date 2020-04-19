package com.pathfinding.model;

/**
 * Base of the GridTile to implemnt a basic 2d point on a grid
 */
public class Tile implements Cloneable {
    public int x, y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return simple unique identifier for a tile used in hash sets
     */
    public String getID() {
        return x + "," + y;
    }

}
