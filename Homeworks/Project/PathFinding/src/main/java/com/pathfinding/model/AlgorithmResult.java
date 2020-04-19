package com.pathfinding.model;

/**
 * Simple class to represent the data to be collected when comparing Algorithms
 */
public class AlgorithmResult {
    public String algorithmName;
    public int runtime;
    public int pathLength;
    public boolean pathFound;
    public int visitedTileCount;

    public AlgorithmResult(String algorithmName, int runtime, int pathLength, boolean pathFound, int visitedTileCount) {

        this.algorithmName = algorithmName;
        this.runtime = runtime;
        this.pathLength = pathLength;
        this.pathFound = pathFound;
        this.visitedTileCount = visitedTileCount;
    }

}
