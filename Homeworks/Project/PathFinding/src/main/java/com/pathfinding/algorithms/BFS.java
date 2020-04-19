package com.pathfinding.algorithms;

import com.pathfinding.model.GridModel;
import com.pathfinding.model.GridTile;
import com.pathfinding.model.Path;
import com.pathfinding.model.Tile;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation of Breadth First Search
 */
public class BFS implements Algorithm {

    @Override
    public String getName() {
        return "Breadth First Search";
    }

    /**
     * BFS takes a look at all the squares around given square before looking at any deeper squares.
     *
     * @param start     - which tile to start from
     * @param end       - which tile to go to and finish
     * @param gridModel - The predefined model that the algo will run on
     * @return - The path between start and end. If no path found it will return an empty list
     * @precondition - gridModel is expected to be already initialized.
     */
    @Override
    public Path computeOptimalPath(Tile start, Tile end, GridModel gridModel) {

        gridModel.resetGraph();
        Queue<GridTile> queue = new LinkedList<>();
        queue.add(gridModel.tiles.get(start.getID()));
        int level = 0;

        while (!queue.isEmpty()) {
            Tile pos = queue.remove();
            int row = pos.x;
            int col = pos.y;

            GridTile currentTile = gridModel.tiles.get(row + "," + col);
            if (row < 0 || col < 0 || row >= gridModel.heightSize || col >= gridModel.widthSize || currentTile.visited)
                continue;

            //Break out of loop if we found our end tile
            if (currentTile.x == end.x && currentTile.y == end.y) {
                ArrayList<GridTile> tilesForPath = new ArrayList<>();
                GridTile parent = currentTile.parent;
                tilesForPath.add(currentTile);
                while (parent != null) {
                    tilesForPath.add(parent);
                    parent = parent.parent;
                }
                queue.clear();
                return new Path(tilesForPath);
            }
            //Ensure to not set visited on start or end tiles
            if (currentTile.collisionFlag == GridTile.FREE && !(currentTile.x == start.x && currentTile.y == start.y)) {
                currentTile.visited = true;
            }

            // Only push items on the stack if they are free
            if (col > 0) {
                GridTile left = gridModel.tiles.get(row + "," + (col - 1));
                if (left.collisionFlag == GridTile.FREE) {
                    try {
                        left.parent = currentTile.clone();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    queue.add(left); //go left

                }
            }

            if (col + 1 < gridModel.widthSize) {
                GridTile right = gridModel.tiles.get(row + "," + (col + 1));
                if (right.collisionFlag == GridTile.FREE) {
                    try {
                        right.parent = currentTile.clone();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    queue.add(right); //go right
                }
            }

            if (row > 0) {
                GridTile up = gridModel.tiles.get((row - 1) + "," + col);
                if (up.collisionFlag == GridTile.FREE) {
                    try {
                        up.parent = currentTile.clone();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    queue.add(up); //go up
                }
            }

            if (row + 1 < gridModel.heightSize) {
                GridTile down = gridModel.tiles.get((row + 1) + "," + col);
                if (down.collisionFlag == GridTile.FREE) {
                    try {
                        down.parent = currentTile.clone();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    queue.add(down); //go down
                }
            }
        }
        return new Path(new ArrayList<>());
    }

}
