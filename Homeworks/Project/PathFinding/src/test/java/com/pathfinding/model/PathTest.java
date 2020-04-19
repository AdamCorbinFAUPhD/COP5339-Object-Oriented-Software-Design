package com.pathfinding.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class PathTest {

    Path path;
    int numberOfInitialTiles = 10;

    /**
     * Initial set up will create some tiles that will have x and y as the same loop index.
     */
    @Before
    public void setUp() {
        ArrayList<GridTile> tiles = new ArrayList<>();
        for (int i = 0; i < numberOfInitialTiles; i++) {
            tiles.add(new GridTile(i, i));
        }

        path = new Path(tiles);
    }

    /**
     * Testing removing all the elements in the list 1 by 1 and using the getSize to ensure we drop by 1 each time
     */
    @Test
    public void remove() {
        int sizeTest = path.getSize();
        Iterator<GridTile> iterable = path.iterator();

        while (iterable.hasNext()) {
            path.remove();
            assertEquals(sizeTest - 1, path.getSize());
            sizeTest--;
        }
    }

    /**
     * Testing adding 1 tile and checking to see if the size increased by 1
     */
    @Test
    public void addTile() {
        int sizeTest = path.getSize();
        path.addTile(new GridTile(99, 99));
        assertEquals(sizeTest + 1, path.getSize());
    }

    /**
     * Testing to see if the path length using getSize is the same as the initialized on our setUp method.
     */
    @Test
    public void getSize() {
        assertEquals(numberOfInitialTiles, path.getSize());
    }

    /**
     * Testing out the iterator to ensure that we can loop over the internal list. Using the x and y coordinates
     * to ensure they are looping in the correct order
     */
    @Test
    public void iterator() {
        Iterator<GridTile> iterable = path.iterator();
        int tileIndex = 0;
        while (iterable.hasNext()) {
            GridTile tile = iterable.next();
            assertEquals(tile.x, tileIndex);
            assertEquals(tile.y, tileIndex);
            tileIndex++;
        }
    }

    /**
     * Testing out the clear method to ensure that the internal list gets cleared out and using getSize to test
     */
    @Test
    public void clear() {
        assertEquals(numberOfInitialTiles, path.getSize());
        path.clear();
        assertEquals(0, path.getSize());
    }
}