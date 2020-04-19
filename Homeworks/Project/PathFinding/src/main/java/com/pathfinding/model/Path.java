package com.pathfinding.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Path implements Iterable<GridTile> {
    int index = 0;
    private ArrayList<GridTile> tiles = new ArrayList<>();

    public Path(ArrayList<GridTile> tiles) {
        this.tiles.addAll(tiles);
    }

    public Path() {

    }

    /**
     * @param tile - to be added to the tiles list
     */
    public void addTile(GridTile tile) {
        tiles.add(tile);
    }

    /**
     * Removing the last item in the list
     */
    public void remove() {
        tiles.remove(tiles.size() - 1);
    }

    /**
     * Clear out all of the tiles with in the internal list
     */
    public void clear() {
        tiles.clear();
    }

    /**
     * @return the size of the path
     */
    public int getSize() {
        return tiles.size();
    }

    /**
     * @return the iterator which would be used to loop over the tiles.
     */
    @Override
    public Iterator<GridTile> iterator() {
        return tiles.iterator();
    }

}
