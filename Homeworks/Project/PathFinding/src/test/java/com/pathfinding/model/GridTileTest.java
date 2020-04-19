package com.pathfinding.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class GridTileTest {

    /**
     * Testing to make sure resetTile will clear out the history info such as visited and parent
     */
    @Test
    public void resetTile() {
        GridTile gt = new GridTile(1, 3);
        gt.visited = true;
        gt.parent = new GridTile(9, 9);
        gt.resetTile();
        assertFalse(gt.visited);
        assertNull(gt.parent);
    }
}