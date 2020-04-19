package com.pathfinding.simulation;

import com.pathfinding.algorithms.Algorithm;
import com.pathfinding.model.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class is responsible for running the simulation against the different Algorithm.
 * Note: When running large graphs the simulation could take a long time. For better results it would be possible
 * to create multiple threads since they can be run in parallel but that might also tarnish the run times.
 */
public class Simulation {
    ArrayList<Algorithm> algorithms;
    int iterations;
    int widthSize;
    int heightSize;
    AlgorithmStatModel algorithmStatModel;

    public Simulation(int iterations, ArrayList<Algorithm> algorithms, int widthSize, int heightSize, AlgorithmStatModel algorithmStatModel) {
        this.algorithms = algorithms;
        this.iterations = iterations;
        this.heightSize = heightSize;
        this.widthSize = widthSize;
        this.algorithmStatModel = algorithmStatModel;
    }

    /**
     * The run method will execute the simulation. The following steps happen in this method
     * 1. Generate random start and end paris
     * 2. Create a new graph to be used in the simulation
     * 3. execute algorithms on the graph
     * 4. collection the results
     *
     * @preconditon - Ensure that the width and height are greater than 0, more than 1 algorithm in the list, and that the algorithmStatModel != null
     * @postcondition - all of the results will be stored in algorithmStatModel
     */
    public void run() {
        ArrayList<Tile[]> randomTilePairs = new ArrayList<>();
        Random rand = new Random();
        //Create a list of random start and end
        for (int i = 0; i < iterations; i++) {
            Tile[] pair = new Tile[2];
            pair[0] = new Tile(rand.nextInt(widthSize), rand.nextInt(heightSize));
            pair[1] = new Tile(rand.nextInt(widthSize), rand.nextInt(heightSize));
            randomTilePairs.add(pair);
        }
        GridModel gridModel = new GridModel(this.widthSize, this.heightSize);
        //Run over 10 different grid models
        for (int i = 0; i < 5; i++) {
            gridModel.newRandomGraph();
            for (Algorithm algorithm : algorithms) {
                for (Tile[] pair : randomTilePairs) {
                    long startTime = System.currentTimeMillis();
                    Path path = algorithm.computeOptimalPath(pair[0], pair[1], gridModel);
                    long endTime = System.currentTimeMillis();
                    int visitedCount = 0;
                    for (GridTile tile : gridModel.tiles.values()) {
                        visitedCount += tile.visited ? 1 : 0;
                    }
                    int pathLen = 0;
                    if (path != null) {
                        pathLen = path.getSize();
                    }
                    AlgorithmResult algorithmResult =
                            new AlgorithmResult(algorithm.getName(),
                                    (int) (endTime - startTime),
                                    pathLen,
                                    pathLen > 0,
                                    visitedCount);
                    this.algorithmStatModel.addAlgorithm(algorithmResult);
                }
            }
        }
    }
}
