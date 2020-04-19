package com.pathfinding.view;

import com.pathfinding.model.GridModel;
import com.pathfinding.model.GridTile;

import javax.swing.*;
import java.awt.*;


/**
 * This is the View where the main visualization of the Grid will be used
 */
public class GridView extends JComponent {

    final Color COLOR_DEFAULT = Color.lightGray;
    final Color COLOR_BLOCKED = Color.black;
    final Color COLOR_START = Color.green;
    final Color COLOR_END = Color.RED;
    final Color COLOR_VISITED = Color.orange;
    final Color COLOR_PATH = Color.magenta;
    GridModel gridModel;

    GridView(GridModel gridModel) {
        this.gridModel = gridModel;

    }

    /**
     * This function is used to generate the grid. It will compute the columns and rows based on the size of the main
     * panel. It will also print the coordinates for a 20x20 graph. It will also display a graph
     *
     * @param g used to paint to the screen
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int i;
        int width, height;
        int rows = gridModel.heightSize;
        int cols = gridModel.widthSize;
        // -10 is to ensure we dont have any clipping into the next cell south
        width = getSize().width - 5;
        height = getSize().height - 33; // Save some space for the key at the bottom

        //draw rectangles
        Color prevColor;
        int rowHt = height / (rows);
        int rowWid = width / (cols);
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                prevColor = g.getColor();
                GridTile currentTile = gridModel.tiles.get(x + "," + y);
                g.setColor(getTileColor(currentTile, gridModel));
                g.fillRect(x * rowWid, y * rowHt, rowWid, rowHt);
                g.setColor(prevColor);
            }
        }

        // Draw outlines for the squares
        g.setColor(Color.BLACK);
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                g.drawRect(x * rowWid, y * rowHt, rowWid, rowHt);
            }
        }


        // Only print the text for the small graph
        if (rows < 21) {
            g.setFont(new Font("Verdana", Font.PLAIN, 8));
            // draw cords
            for (i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    g.drawString("(" + i + "," + j + ")", i * rowWid + rowWid / 4 - 1, j * rowHt + rowHt / 2 + 3);
                }
            }

        }

        g.setFont(new Font("Verdana", Font.PLAIN, 10));
        // Draw the key
        prevColor = g.getColor();

        int keySize = 49;
        int x = 1;
        //Setting rows and colums to set the key in the same location between
        rows = 20;
        cols = 18;
        rowHt = height / (rows);
        rowWid = width / (cols);
        g.setColor(COLOR_BLOCKED);
        g.fillRect(x * rowWid, (rows + 1) * rowHt, keySize, keySize);
        g.setColor(Color.white);
        g.drawString("Blocked", x * rowWid, (rows + 1) * rowHt + rowHt * 2);


        x = 2;
        g.setColor(COLOR_DEFAULT);
        g.fillRect(x * rowWid, (rows + 1) * rowHt, keySize, keySize);
        g.setColor(Color.BLACK);
        g.drawString("Open", x * rowWid, (rows + 1) * rowHt + rowHt * 2);

        x = 3;
        g.setColor(COLOR_START);
        g.fillRect(x * rowWid, (rows + 1) * rowHt, keySize, keySize);
        g.setColor(Color.BLACK);
        g.drawString("Start", x * rowWid, (rows + 1) * rowHt + rowHt * 2);

        x = 4;
        g.setColor(COLOR_END);
        g.fillRect(x * rowWid, (rows + 1) * rowHt, keySize, keySize);
        g.setColor(Color.BLACK);
        g.drawString("End", x * rowWid, (rows + 1) * rowHt + rowHt * 2);

        x = 5;
        g.setColor(COLOR_VISITED);
        g.fillRect(x * rowWid, (rows + 1) * rowHt, keySize, keySize);
        g.setColor(Color.BLACK);
        g.drawString("Visited", x * rowWid, (rows + 1) * rowHt + rowHt * 2);

        x = 6;
        g.setColor(COLOR_PATH);
        g.fillRect(x * rowWid, (rows + 1) * rowHt, keySize, keySize);
        g.setColor(Color.BLACK);
        g.drawString("Path", x * rowWid, (rows + 1) * rowHt + rowHt * 2);

        g.setColor(prevColor);
    }

    /**
     * @param tile      - used to look up the data to know what the color should be
     * @param gridModel - used to get the start and end positions to ensure they are not colored in. Also to used to make
     *                  sure the tile is not on the path, or if it is set its correct color.
     * @return the color the given tile should be colored to
     */
    Color getTileColor(GridTile tile, GridModel gridModel) {
        Color updatedColor = COLOR_DEFAULT;
        if (tile.collisionFlag == GridTile.BLOCKED) {
            updatedColor = COLOR_BLOCKED;
        } else if (tile.collisionFlag == GridTile.FREE) {
            if (!tile.visited) {
                updatedColor = COLOR_DEFAULT;
            } else {

                updatedColor = COLOR_VISITED;
            }
        }

        // Ensure that we set the start and end positions correctly
        if (tile.x == gridModel.startPosition.x && tile.y == gridModel.startPosition.y) {
            updatedColor = COLOR_START;
        }
        if (tile.x == gridModel.endPosition.x && tile.y == gridModel.endPosition.y) {
            updatedColor = COLOR_END;
        }

        if (gridModel.path != null) {
            for (GridTile pathTile : gridModel.path) {
                //Dont color the start and end tiles
                if (!(pathTile.x == gridModel.startPosition.x && pathTile.y == gridModel.startPosition.y)
                        && !(pathTile.x == gridModel.endPosition.x && pathTile.y == gridModel.endPosition.y)
                        && pathTile.x == tile.x && pathTile.y == tile.y) {
                    updatedColor = COLOR_PATH;
                }
            }
        }
        return updatedColor;
    }


    /**
     * @return base size requested for the GridView
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}
