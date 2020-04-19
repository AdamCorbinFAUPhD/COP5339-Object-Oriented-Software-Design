package com.pathfinding.algorithms;

import com.pathfinding.model.GridModel;
import com.pathfinding.model.GridTile;
import com.pathfinding.model.Path;
import com.pathfinding.model.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This Algorithm will implment the A* path finding method. Its suppose to be the most efficent of the set.
 */
public class AStar implements Algorithm {

    ArrayList<AStarGridTile> openList = new ArrayList<>();
    ArrayList<AStarGridTile> closedList = new ArrayList<>();
    ArrayList<GridTile> path = new ArrayList<>();
    AStarGridTile currentTile;
    Tile end;

    /**
     * Looks in a list to see if tile is found
     *
     * @param array list of tiles
     * @param tile  request tile to see if in list
     * @return true == in list, false == not in list
     */
    private static boolean findNeighborInList(List<AStarGridTile> array, AStarGridTile tile) {
        for (AStarGridTile listTile : array) {
            if (listTile.x == tile.x && listTile.y == tile.y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return "A*";
    }

    /**
     * This method will find the path between start and end tiles
     * <p>
     * Reference to this source: https://rosettacode.org/wiki/A*_search_algorithm#Java
     *
     * @param start     - which tile to start from
     * @param end       - which tile to go to and finish
     * @param gridModel - The predefined model that the algo will run on
     * @return - The path between start and end. If no path found it will return an empty list
     * @precondition - gridModel is expected to be already initialized.
     */
    @Override
    public Path computeOptimalPath(Tile start, Tile end, GridModel gridModel) {
        //Clear out all instance variables between different runs
        openList.clear();
        closedList.clear();
        path.clear();
        gridModel.resetGraph();

        this.end = end;
        currentTile = new AStarGridTile(null, gridModel.tiles.get(start.getID()), 0, 0);
        closedList.add(currentTile);
        addNeighborsToOpenList(gridModel);

        while (this.currentTile.x != this.end.x || this.currentTile.y != this.end.y) {
            if (this.openList.isEmpty()) { // Nothing to examine
                return new Path();
            }
            this.currentTile = this.openList.get(0); // get first node (lowest f score)
            this.openList.remove(0); // remove it
            this.closedList.add(this.currentTile); // and add to the closed
            addNeighborsToOpenList(gridModel);
        }
        this.path.add(0, this.currentTile);
        while (this.currentTile.x != start.x || this.currentTile.y != start.y) {
            this.currentTile = this.currentTile.parent;
            this.path.add(0, this.currentTile);
        }
        return new Path(this.path);

    }

    /**
     * This method will add all the tiles around the current tile
     *
     * @param gridModel used to look at dimentions of the graph to ensure we dont go out of bounds
     */
    private void addNeighborsToOpenList(GridModel gridModel) {
        AStarGridTile gridTile;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                int observedX = x + currentTile.x;
                int observedY = y + currentTile.y;

                if (x != 0 && y != 0) {
                    continue; // skip if diagonal movement
                }

                if (((x != 0 || y != 0) // not this.currentTile
                        && this.currentTile.x + x >= 0 && this.currentTile.x + x < gridModel.widthSize // check maze boundaries
                        && this.currentTile.y + y >= 0 && this.currentTile.y + y < gridModel.heightSize)) {
                    gridTile = new AStarGridTile(currentTile, gridModel.tiles.get(observedX + "," + observedY), currentTile.g, distance(x, y));

                    if (gridTile.collisionFlag == GridTile.FREE // check if square is walkable
                            && !findNeighborInList(this.openList, gridTile) && !findNeighborInList(this.closedList, gridTile)) { // if not already done

                        gridTile.g = gridTile.parent.g + 1.; // Horizontal/vertical cost = 1.0
                        gridModel.tiles.get(observedX + "," + observedY).visited = true;
                        this.openList.add(gridTile);
                    }
                }
            }
        }
        Collections.sort(this.openList);
    }

    /**
     * Calculate distance between this.currentTile and xend/yend
     *
     * @param dx destination x
     * @param dy destination y
     * @return the distance between tile(dx,dy) and the current tile
     */
    private double distance(int dx, int dy) {
        return Math.abs(this.currentTile.x + dx - this.end.x) + Math.abs(this.currentTile.y + dy - this.end.y);
    }

    /**
     * Wrapper class to GridTile to support A* computations to save off g and h
     */
    static class AStarGridTile extends GridTile implements Comparable {
        public AStarGridTile parent;
        public double g;
        public double h;

        public AStarGridTile(AStarGridTile parent, GridTile tile, double g, double h) {
            super(tile);
            this.collisionFlag = tile.collisionFlag;
            this.parent = parent;
            this.g = g;
            this.h = h;
        }

        /**
         * Compare by f value (g + h)
         *
         * @param o input tile to compute if its a good tile to look at
         * @return - f
         */
        //
        @Override
        public int compareTo(Object o) {
            AStarGridTile that = (AStarGridTile) o;
            return (int) ((this.g + this.h) - (that.g + that.h));
        }
    }
}


