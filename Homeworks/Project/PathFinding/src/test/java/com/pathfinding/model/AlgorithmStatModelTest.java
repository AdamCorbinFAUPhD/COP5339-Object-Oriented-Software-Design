package com.pathfinding.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlgorithmStatModelTest {

    AlgorithmStatModel algorithmStatModel;

    /**
     * This is the set up for the algorithmStatModel which will be used in all of the test below. We are formatting
     * on 3 Algorithms
     */
    @Before
    public void setUp() {
        String[] headers = {"col1", "algo1", "algo2", "algo3"};
        algorithmStatModel = new AlgorithmStatModel(headers);
    }

    /**
     * Simple check to see that result got added to the list
     */
    @Test
    public void addAlgorithm() {
        AlgorithmResult algorithmResult = new AlgorithmResult("algo1", 111, 50, true, 222);
        algorithmStatModel.addAlgorithm(algorithmResult);
        assertEquals(algorithmStatModel.latestAlgorithmStats.size(), 1);

    }

    /**
     * The idea behind this test will populated 2 runs for each algo. Only testing the first algo for
     * all of the rows after the computeStatistic are called.
     */
    @Test
    public void computeStatistic() {
        AlgorithmResult algorithmResult = new AlgorithmResult("algo1", 111, 50, true, 222);
        algorithmStatModel.addAlgorithm(algorithmResult);
        AlgorithmResult algorithmResult2 = new AlgorithmResult("algo1", 222, 100, true, 500);
        algorithmStatModel.addAlgorithm(algorithmResult2);
        AlgorithmResult algorithmResult3 = new AlgorithmResult("algo2", 123, 345, true, 567);
        algorithmStatModel.addAlgorithm(algorithmResult3);
        AlgorithmResult algorithmResult4 = new AlgorithmResult("algo2", 123, 345, true, 567);
        algorithmStatModel.addAlgorithm(algorithmResult4);
        AlgorithmResult algorithmResult5 = new AlgorithmResult("algo3", 321, 543, true, 765);
        algorithmStatModel.addAlgorithm(algorithmResult5);
        AlgorithmResult algorithmResult6 = new AlgorithmResult("algo3", 321, 543, true, 765);
        algorithmStatModel.addAlgorithm(algorithmResult6);

        algorithmStatModel.computeStatistic();
        assertEquals(6, algorithmStatModel.latestAlgorithmStats.size());

        // Total run time checks
        assertEquals("333", algorithmStatModel.getValueAt(1, 1));
        assertEquals("111", algorithmStatModel.getValueAt(2, 1));
        assertEquals("222", algorithmStatModel.getValueAt(3, 1));
        assertEquals("166.5", algorithmStatModel.getValueAt(4, 1));
        assertEquals("55.5", algorithmStatModel.getValueAt(5, 1));

        //Path length cheks
        assertEquals("150", algorithmStatModel.getValueAt(6, 1));
        assertEquals("50", algorithmStatModel.getValueAt(7, 1));
        assertEquals("100", algorithmStatModel.getValueAt(8, 1));
        assertEquals("75", algorithmStatModel.getValueAt(9, 1));
        assertEquals("25", algorithmStatModel.getValueAt(10, 1));

        // Visited tiles check
        assertEquals("722", algorithmStatModel.getValueAt(11, 1));
        assertEquals("222", algorithmStatModel.getValueAt(12, 1));
        assertEquals("500", algorithmStatModel.getValueAt(13, 1));
        assertEquals("361", algorithmStatModel.getValueAt(14, 1));
        assertEquals("139", algorithmStatModel.getValueAt(15, 1));

        //Number of paths found
        assertEquals(4, algorithmStatModel.getValueAt(16, 1));
    }

    /**
     * check to make sure the column names can be retrieved correctly
     */
    @Test
    public void getColumnName() {
        assertEquals("col1", algorithmStatModel.getColumnName(0));
        assertEquals("algo1", algorithmStatModel.getColumnName(1));
        assertEquals("algo2", algorithmStatModel.getColumnName(2));
        assertEquals("algo3", algorithmStatModel.getColumnName(3));
    }

    /**
     * Check to make sure the table size can be accessed
     */
    @Test
    public void getRowCount() {
        //The data object is predefined and doesnt change is size. Only the content changes
        assertEquals(17, algorithmStatModel.getRowCount());
    }

    /**
     * Check to make sure the columns are correct
     */
    @Test
    public void getColumnCount() {
        assertEquals(4, algorithmStatModel.getColumnCount());
    }

    /**
     * Simple check of the first row since its predefined
     */
    @Test
    public void getValueAt() {
        assertEquals("Total Run Time", algorithmStatModel.getValueAt(1, 0));
        assertEquals("Min Run Time", algorithmStatModel.getValueAt(2, 0));
        assertEquals("Max Run Time", algorithmStatModel.getValueAt(3, 0));
    }
}