package com.pathfinding.algorithms;

import com.pathfinding.model.GridModel;
import com.pathfinding.model.GridTile;
import com.pathfinding.model.Path;
import com.pathfinding.model.Tile;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Implementation of Depth First Search
 */
public class DFS implements Algorithm {

    @Override
    public String getName() {
        return "Depth First Search";
    }

    /**
     * Another resource: https://medium.com/omarelgabrys-blog/path-finding-algorithms-f65a8902eb40
     * 1. Add root node to the stack.
     * 2. Loop on the stack as long as it's not empty.
     * 1. Get the node at the top of the stack(current), mark it as visited, and remove it.
     * 2. For every non-visited child of the current node, do the following:
     * 1. Check if it's the goal node, If so, then return this child node.
     * 2. Otherwise, push it to the stack.
     * 3. If stack is empty, then goal node was not found!
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
        boolean[][] visited = new boolean[gridModel.heightSize][gridModel.widthSize];

        Stack<Tile> stack = new Stack<>();
        stack.push(start);

        while (!stack.empty()) {
            Tile pos = stack.pop();
            int row = pos.x;
            int col = pos.y;

            if (row < 0 || col < 0 || row >= gridModel.heightSize || col >= gridModel.widthSize || visited[row][col])
                continue;

            visited[row][col] = true;
            GridTile currentTile = gridModel.tiles.get(row + "," + col);


            //Break out of loop if we found our end tile
            if (currentTile.x == end.x && currentTile.y == end.y) {
                ArrayList<GridTile> tilesForPath = new ArrayList<>();
                GridTile parent = currentTile.parent;
                tilesForPath.add(currentTile);
                while (parent != null) {
                    tilesForPath.add(parent);
                    parent = parent.parent;
                }
                stack.clear();
                return new Path(tilesForPath);
            }
            //Ensure to not set visited on start or end tiles
            if (currentTile.collisionFlag == GridTile.FREE && (currentTile.x != start.x && currentTile.y != start.y))
                currentTile.visited = true;


            // Only push items on the stack if they are free
            if (col > 0) {
                GridTile left = gridModel.tiles.get(row + "," + (col - 1));
                if (left.collisionFlag == GridTile.FREE) {
                    try {
                        left.parent = currentTile.clone();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    stack.push(left); //go left
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
                    stack.push(right); //go right
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
                    stack.push(up); //go up

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
                    stack.push(down); //go down
                }
            }


        }
        return null;
    }

}
