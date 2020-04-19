package com.pathfinding.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TileTest {

    /**
     * Testing the format of the ID which will be "x,y"
     */
    @Test
    public void getID() {

        Tile t = new Tile(1, 5);

        assertEquals("1,5", t.getID());

    }
}