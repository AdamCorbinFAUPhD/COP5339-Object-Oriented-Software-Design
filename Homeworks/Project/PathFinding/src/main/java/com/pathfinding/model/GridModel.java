package com.pathfinding.model;

import java.util.HashMap;
import java.util.Random;

/**
 * This class is used to represent the Model for a 2d graph. It has the ability to generate random graphs
 * and random start and end positions
 */
public class GridModel {
    public GridTile startPosition = new GridTile(0, 0);
    public GridTile endPosition = new GridTile(0, 0);
    public int widthSize;
    public int heightSize;
    public HashMap<String, GridTile> tiles = new HashMap<>(); // Index will be position "x,y"
    public Path path = new Path();

    /**
     * Creates a new graph based on given params
     *
     * @param widthSize  - designated width to create graph
     * @param heightSize - designated height to create graph
     */
    public GridModel(int widthSize, int heightSize) {
        Random rand = new Random();
        for (int y = 0; y < heightSize; y++) {
            for (int x = 0; x < widthSize; x++) {
                GridTile newTile;
                if (rand.nextInt(10) > 2) {
                    newTile = new GridTile(x, y, GridTile.FREE);
                } else {
                    newTile = new GridTile(x, y, GridTile.BLOCKED);
                }
                tiles.put(x + "," + y, newTile);
            }

        }
        this.widthSize = widthSize;
        this.heightSize = heightSize;
    }

    /**
     * @postcondition - completely clears out the graph.
     */
    public void clearGraph() {
        this.tiles.clear();
    }

    /**
     * @Postcondition - updates graph to reshuffle all the tiles to be free or blocked.
     */
    public void newRandomGraph() {
        Random rand = new Random();
        for (int y = 0; y < heightSize; y++) {
            for (int x = 0; x < widthSize; x++) {
                String key = x + "," + y;
                //Add a new tile if we expand size
                if (tiles.get(key) == null) {
                    tiles.put(key, new GridTile(x, y, GridTile.FREE));
                }
                if (rand.nextInt(10) > 2) {
                    tiles.get(key).collisionFlag = GridTile.FREE;
                } else {
                    tiles.get(key).collisionFlag = GridTile.BLOCKED;

                }
                tiles.get(x + "," + y).resetTile();
            }
        }
        path.clear();
    }

    /**
     * @postcondition - will update the start and end position to ensure that the block was previously free
     */
    public void newRandomStartAndEndPositions() {
        Random random = new Random();
        int randStartX, randStartY, randEndX, randEndY;

        //Find free tiles
        do {
            randStartX = random.nextInt(widthSize);
            randStartY = random.nextInt(heightSize);
        } while (tiles.get(randStartX + "," + randStartY).collisionFlag == GridTile.BLOCKED);

        do {
            randEndX = random.nextInt(widthSize);
            randEndY = random.nextInt(heightSize);
        } while (tiles.get(randEndX + "," + randEndY).collisionFlag == GridTile.BLOCKED);


        //Update old model start and end with new positions
        startPosition.x = randStartX;
        startPosition.y = randStartY;
        endPosition.x = randEndX;
        endPosition.y = randEndY;

    }

    /**
     * @postcondition - updates the tiles to clear out historical data
     */
    public void resetGraph() {
        for (GridTile tile : tiles.values()) {
            if (!(tile == startPosition || tile == endPosition)) {
                tile.resetTile();
            }
        }
    }
}
