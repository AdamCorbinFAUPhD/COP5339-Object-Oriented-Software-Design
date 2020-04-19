package com.pathfinding.algorithms;

import com.pathfinding.model.GridModel;
import com.pathfinding.model.Path;
import com.pathfinding.model.Tile;

/**
 * This interface is use to set the infrastructure for all Algorithm types
 */
public interface Algorithm {
    String getName();

    Path computeOptimalPath(Tile start, Tile end, GridModel gridModel);
}
