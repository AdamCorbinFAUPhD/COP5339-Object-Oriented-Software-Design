package com.pathfinding.controller;

import com.pathfinding.algorithms.AStar;
import com.pathfinding.algorithms.Algorithm;
import com.pathfinding.algorithms.BFS;
import com.pathfinding.algorithms.DFS;
import com.pathfinding.model.AlgorithmStatModel;
import com.pathfinding.model.GridModel;
import com.pathfinding.model.GridTile;
import com.pathfinding.simulation.Simulation;
import com.pathfinding.view.GUIView;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * This is the master controller in the MVC pattern
 * It will handle the Observer pasterns between the GUI and Model with the Action listeners
 * It will also handle the creation of all the Models and Views
 */
public class AlgorithmController {
    GridModel gridModel;

    ArrayList<Algorithm> algorithms = new ArrayList<>();
    GUIView guiView;
    AlgorithmStatModel algorithmStatModel;
    Simulation sim;

    int selectedAlgoIndex = 0;

    AlgorithmController() {
        //Create gridModel

        gridModel = new GridModel(20, 20);
        algorithms.add(new DFS());
        algorithms.add(new BFS());
        algorithms.add(new AStar());
        String[] columnNames = new String[algorithms.size() + 1];
        columnNames[0] = "Statistics";
        for (int i = 0; i < algorithms.size(); i++) {
            columnNames[i + 1] = algorithms.get(i).getName();
        }
        algorithmStatModel = new AlgorithmStatModel(columnNames);
        sim = new Simulation(10, algorithms, 100, 100, algorithmStatModel);
        guiView = GUIView.getInstance(gridModel, algorithms, algorithmStatModel);


        guiView.addALForNewGrid(e -> {
            guiView.gridModel.newRandomGraph();
            guiView.grid.invalidate();
            guiView.grid.validate();
            guiView.grid.repaint();

            //Reset start and end
            guiView.gridModel.startPosition.x = 0;
            guiView.gridModel.startPosition.y = 0;
            guiView.gridModel.endPosition.x = 0;
            guiView.gridModel.endPosition.y = 0;
            guiView.textFieldStartPosition.setText(0 + "," + 0);
            guiView.textFieldEndPosition.setText(0 + "," + 0);
        });

        guiView.algorithmDropdown.addActionListener(e -> selectedAlgoIndex = guiView.algorithmDropdown.getSelectedIndex());

        guiView.dropdownGridSize.addActionListener(e -> {
            if (guiView.dropdownGridSize.getSelectedIndex() == 0) {
                guiView.gridModel.heightSize = 20;
                guiView.gridModel.widthSize = 20;
            } else {
                guiView.gridModel.heightSize = 100;
                guiView.gridModel.widthSize = 100;
            }
            guiView.gridModel.newRandomGraph();
            guiView.grid.invalidate();
            guiView.grid.validate();
            guiView.grid.repaint();
        });

        guiView.textFieldStartPosition.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                checkTextFieldUpdate(guiView.textFieldStartPosition, guiView.gridModel.startPosition);
                gridModel.path = algorithms.get(selectedAlgoIndex).computeOptimalPath(gridModel.startPosition, gridModel.endPosition, gridModel);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                checkTextFieldUpdate(guiView.textFieldStartPosition, guiView.gridModel.startPosition);
                gridModel.path = algorithms.get(selectedAlgoIndex).computeOptimalPath(gridModel.startPosition, gridModel.endPosition, gridModel);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                checkTextFieldUpdate(guiView.textFieldStartPosition, guiView.gridModel.startPosition);
                gridModel.path = algorithms.get(selectedAlgoIndex).computeOptimalPath(gridModel.startPosition, gridModel.endPosition, gridModel);
                guiView.grid.invalidate();
            }
        });

        guiView.textFieldEndPosition.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                checkTextFieldUpdate(guiView.textFieldEndPosition, guiView.gridModel.endPosition);
                gridModel.path = algorithms.get(selectedAlgoIndex).computeOptimalPath(gridModel.startPosition, gridModel.endPosition, gridModel);
                guiView.grid.invalidate();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                checkTextFieldUpdate(guiView.textFieldEndPosition, guiView.gridModel.endPosition);
                gridModel.path = algorithms.get(selectedAlgoIndex).computeOptimalPath(gridModel.startPosition, gridModel.endPosition, gridModel);
                guiView.grid.invalidate();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                checkTextFieldUpdate(guiView.textFieldEndPosition, guiView.gridModel.endPosition);
                gridModel.path = algorithms.get(selectedAlgoIndex).computeOptimalPath(gridModel.startPosition, gridModel.endPosition, gridModel);
                guiView.grid.invalidate();
            }
        });

        guiView.addALForGenerateRandomStartEndPositions(e -> {
            gridModel.newRandomStartAndEndPositions();
            guiView.textFieldStartPosition.setText(gridModel.startPosition.x + "," + gridModel.startPosition.y);
            guiView.textFieldEndPosition.setText(gridModel.endPosition.x + "," + gridModel.endPosition.y);

            gridModel.path = algorithms.get(selectedAlgoIndex).computeOptimalPath(gridModel.startPosition, gridModel.endPosition, gridModel);
            //update view
            guiView.grid.invalidate();
            guiView.grid.validate();
            guiView.grid.repaint();
        });

        guiView.addALForButtonGeneratePath(e -> {
            gridModel.path = algorithms.get(selectedAlgoIndex).computeOptimalPath(gridModel.startPosition, gridModel.endPosition, gridModel);
            //update view
            guiView.grid.invalidate();
            guiView.grid.validate();
            guiView.grid.repaint();
        });

        guiView.addALForButtonRunComparison(e -> {
            sim.run();
            algorithmStatModel.computeStatistic();
            guiView.tableComparisonTable.invalidate();
            guiView.tableComparisonTable.validate();
            guiView.tableComparisonTable.repaint();
        });

    }

    public static void main(String[] args) {
        AlgorithmController algorithmController = new AlgorithmController();

    }

    /**
     * This parses the change from the text field, parses to make sure we have correct coordinates. It will catch any
     * incorrect patterns of "int,int" and print to the console. Once parsed it will then update the model and then
     * re-validate the View
     *
     * @param jTextField input filed to parse
     * @param position   the model to update
     */
    private void checkTextFieldUpdate(JTextField jTextField, GridTile position) {
        String fieldText = jTextField.getText();
        String[] split = fieldText.split(",");
        if (split.length == 2) {
            try {
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                position.x = x;
                position.y = y;
                guiView.grid.invalidate();
                guiView.grid.validate();
                guiView.grid.repaint();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Error: parsing integer");
            }
        } else {
            System.out.println("Error: parsing the text filed: " + fieldText);
        }
    }

}
