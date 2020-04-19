package com.pathfinding.view;

import com.pathfinding.algorithms.Algorithm;
import com.pathfinding.model.AlgorithmStatModel;
import com.pathfinding.model.GridModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This is the main View that all the base components are created and positioned.
 */
public class GUIView {
    private static GUIView guiView;
    public JComponent grid;
    public JButton buttonGenerateRandomStartEndPositions;
    public JButton buttonGenerateRandomGrid;
    public JComboBox<String> algorithmDropdown, dropdownGridSize;
    public JTable tableComparisonTable;
    public JTextField textFieldStartPosition, textFieldEndPosition;
    public GridModel gridModel;
    public ArrayList<Algorithm> algorithms;
    public JRadioButton radioButton20x20, radioButton100x100;
    AlgorithmStatModel algorithmStatModel;
    private JFrame mainContainer;
    private JButton buttonGeneratePath;
    private JButton buttonRunComparison;
    private ActionListener actionListener;


    /**
     * This is the main View that has buttons, tables, labels, JComponents, Dropdown options
     *
     * @param gridModel          reference to the GridModel used to create the GridView
     * @param algorithms         - list of algorithms used to populate JComboboxes
     * @param algorithmStatModel - reference to the model for the Algorithm comparison JTable
     */
    private GUIView(GridModel gridModel, ArrayList<Algorithm> algorithms, AlgorithmStatModel algorithmStatModel) {
        this.gridModel = gridModel;
        this.algorithms = algorithms;
        this.algorithmStatModel = algorithmStatModel;
        int yPos = 0;
        mainContainer = new JFrame();
        GridBagConstraints c = new GridBagConstraints();
        mainContainer.setLayout(new GridBagLayout());
        mainContainer.setPreferredSize(new Dimension(900, 1000));

        buttonGenerateRandomGrid = new JButton("New Graph");
        c.fill = GridBagConstraints.NONE;
        c.weightx = 1;
        c.weighty = 0.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = yPos++;
        int pad = 10;
        c.insets = new Insets(pad, pad, pad, pad);
        mainContainer.add(buttonGenerateRandomGrid, c);

        radioButton20x20 = new JRadioButton("20x20");
        radioButton20x20.setActionCommand("20");
        radioButton100x100 = new JRadioButton("100x100");
        radioButton20x20.setActionCommand("100");

        String[] sizeList = new String[2];
        sizeList[0] = "20x20";
        sizeList[1] = "100x100";
        dropdownGridSize = new JComboBox<>(sizeList);
        c.gridy = yPos++;
        c.gridx = 0;
        c.fill = GridBagConstraints.NONE;
        mainContainer.add(dropdownGridSize, c);


        grid = new GridView(this.gridModel);
        c.fill = GridBagConstraints.BOTH;

        c.weighty = .3;
        c.weightx = 1;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = yPos++;
        grid.setVisible(true);
        mainContainer.add(grid, c);
        grid.setVisible(true);

        String[] list = new String[algorithms.size()];
        for (int j = 0; j < algorithms.size(); j++) {
            list[j] = algorithms.get(j).getName();
        }
        algorithmDropdown = new JComboBox<>(list);
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = yPos++;
        mainContainer.add(algorithmDropdown, c);

        buttonGenerateRandomStartEndPositions = new JButton("Generate Random Path");
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = yPos++;
        mainContainer.add(buttonGenerateRandomStartEndPositions, c);

        buttonGeneratePath = new JButton("Generate Path");
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = yPos++;
        mainContainer.add(buttonGeneratePath, c);

        textFieldStartPosition = new JTextField("0,0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = yPos;
        mainContainer.add(textFieldStartPosition, c);

        textFieldEndPosition = new JTextField("0,0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = yPos++;
        mainContainer.add(textFieldEndPosition, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = yPos++;

        buttonRunComparison = new JButton("Compute Comparison");
        c.gridy = yPos++;
        mainContainer.add(buttonRunComparison, c);

        c.gridy = yPos++;
        JLabel comparisonResultsLabel = new JLabel("Comparison Results");
        comparisonResultsLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        mainContainer.add(comparisonResultsLabel, c);

        c.gridx = 1;
        JLabel comparisonResultsLabelDetail = new JLabel("Simulating 5 random graphs(100x100) for 10 random start end pairs");
        comparisonResultsLabelDetail.setFont(new Font("Verdana", Font.PLAIN, 12));
        mainContainer.add(comparisonResultsLabelDetail, c);
        c.gridx = 0;


        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());

        tableComparisonTable = new JTable(algorithmStatModel);
        tablePanel.add(tableComparisonTable.getTableHeader(), BorderLayout.PAGE_START);
        tablePanel.add(tableComparisonTable, BorderLayout.CENTER);
        c.gridy = yPos;
        mainContainer.add(tablePanel, c);

        mainContainer.setTitle("Path Finding Algorithm tester");
        mainContainer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainContainer.pack();
        mainContainer.setVisible(true);
        grid.setVisible(true);

    }

    /**
     * Singelton to get the GUI View
     *
     * @param gridModel          reference to the main gridmodel
     * @param algorithms         referene to the lsit og algorithms
     * @param algorithmStatModel reference to the model for the Stastics table
     * @return instance of the GUIView
     */
    public static GUIView getInstance(GridModel gridModel, ArrayList<Algorithm> algorithms, AlgorithmStatModel algorithmStatModel) {
        if (guiView == null) {
            guiView = new GUIView(gridModel, algorithms, algorithmStatModel);
        }
        return guiView;
    }


    /**
     * @param actionListener used to add action listner to a button
     */
    public void addALForNewGrid(ActionListener actionListener) {
        buttonGenerateRandomGrid.addActionListener(actionListener);
    }

    /**
     * @param actionListener used to add action listner to a button
     */
    public void addALForGenerateRandomStartEndPositions(ActionListener actionListener) {
        this.actionListener = actionListener;
        buttonGenerateRandomStartEndPositions.addActionListener(actionListener);
    }

    /**
     * @param actionListener used to add action listner to a button
     */
    public void addALForButtonGeneratePath(ActionListener actionListener) {
        buttonGeneratePath.addActionListener(actionListener);
    }

    /**
     * @param actionListener used to add action listner to a button
     */
    public void addALForButtonRunComparison(ActionListener actionListener) {
        buttonRunComparison.addActionListener(actionListener);
    }
}
