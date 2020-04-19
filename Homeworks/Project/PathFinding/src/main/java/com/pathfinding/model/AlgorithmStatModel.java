package com.pathfinding.model;

import javax.swing.table.AbstractTableModel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class to represent the model to compare the different algorithms. This is a Model in the MVC pattern
 * when an update occurs, the GUI Jtable will automatically update
 * Pattern : Adapter pattern
 */
public class AlgorithmStatModel extends AbstractTableModel {
    public HashMap<String, Integer> totalRunTime = new HashMap<>(); // Key is the algorithm name
    public HashMap<String, Integer> minRunTime = new HashMap<>();
    public HashMap<String, Integer> maxRunTime = new HashMap<>();
    public HashMap<String, Double> meanRunTime = new HashMap<>();
    public HashMap<String, Double> stdDevRunTime = new HashMap<>();

    public HashMap<String, Integer> totalPathLength = new HashMap<>();
    public HashMap<String, Integer> maxPathLength = new HashMap<>();
    public HashMap<String, Integer> minPathLength = new HashMap<>();
    public HashMap<String, Double> meanPathLength = new HashMap<>();
    public HashMap<String, Double> stdDevPathLength = new HashMap<>();

    public HashMap<String, Integer> totalVisitedTileCount = new HashMap<>();
    public HashMap<String, Integer> minVisitedTileCount = new HashMap<>();
    public HashMap<String, Integer> maxVisitedTileCount = new HashMap<>();
    public HashMap<String, Double> meanVisitedTileCount = new HashMap<>();
    public HashMap<String, Double> stdDevVisitedTileCount = new HashMap<>();

    public HashMap<String, Integer> totalPathFound = new HashMap<>();

    ArrayList<AlgorithmResult> latestAlgorithmStats = new ArrayList<>();

    String[] headers;
    private Object[][] data = {
            {"Iterations", "5*10", "5*10", "5*10", "10*100"},

            {"Total Run Time", "", "", "", ""},
            {"Min Run Time", "", "", "", ""},
            {"Max Run Time", "", "", "", ""},
            {"Mean Run Time", "", "", "", ""},
            {"Standard Deviation Run Time", "", "", "", ""},

            {"Total Path length", "", "", "", ""},
            {"Min Path length", "", "", "", ""},
            {"Max Path length", "", "", "", ""},
            {"Mean Path length", "", "", "", ""},
            {"Standard Deviation Path length", "", "", "", ""},

            {"Total Visited Tiles", "", "", "", ""},
            {"Min Visited Tiles", "", "", "", ""},
            {"Max Visited Tiles", "", "", "", ""},
            {"Mean Visited Tiles", "", "", "", ""},
            {"Standard Deviation Visited Tiles", "", "", "", ""},

            {"Path Found Count", "", "", "", ""},

    };

    public AlgorithmStatModel(String[] headers) {
        this.headers = headers;
    }

    public void addAlgorithm(AlgorithmResult algorithmResult) {
        latestAlgorithmStats.add(algorithmResult);
    }

    /**
     * This will run all the computations for the given algorithm results for the following
     * 1. Total runtime
     * 2. min runtime
     * 3. max runtime
     * 4. mean runtime
     * 5. standard deviation runtime
     * <p>
     * 1. Total Path length
     * 2. min Path length
     * 3. max Path length
     * 4. mean Path length
     * 5. standard deviation Path length
     * <p>
     * 1. Total Tiles visited
     * 2. min Tiles visited
     * 3. max Tiles visited
     * 4. mean Tiles visited
     * 5. standard deviation Tiles visited
     *
     * @Precondition - Expected to have at least 1 algorithm results
     * @Postcondition - the results will be computed and stored in the hashmaps. The JTable which this model is
     * adapted too will also update automatically.
     */
    public void computeStatistic() {

        for (AlgorithmResult algorithmResult : latestAlgorithmStats) {
            String algorithmName = algorithmResult.algorithmName;

            //update totals, ensure they exist first
            if (!totalPathFound.containsKey(algorithmName)) {
                totalPathFound.put(algorithmName, algorithmResult.pathFound ? 1 : 0);
                totalVisitedTileCount.put(algorithmName, algorithmResult.visitedTileCount);
                totalPathLength.put(algorithmName, algorithmResult.pathLength);
                totalRunTime.put(algorithmName, algorithmResult.runtime);
            } else {
                totalPathFound.put(algorithmName, totalPathFound.get(algorithmName) + (algorithmResult.pathFound ? 1 : 0));
                totalVisitedTileCount.put(algorithmName, totalVisitedTileCount.get(algorithmName) + algorithmResult.visitedTileCount);
                totalPathLength.put(algorithmName, totalPathLength.get(algorithmName) + algorithmResult.pathLength);
                totalRunTime.put(algorithmName, totalRunTime.get(algorithmName) + algorithmResult.runtime);
            }

            //Update min
            if (!minRunTime.containsKey(algorithmName)) {
                minRunTime.put(algorithmName, algorithmResult.runtime);
                minPathLength.put(algorithmName, algorithmResult.pathLength);
                minVisitedTileCount.put(algorithmName, algorithmResult.visitedTileCount);

            } else {
                if (minRunTime.get(algorithmName) > algorithmResult.runtime) {
                    minRunTime.put(algorithmName, algorithmResult.runtime);
                }
                if (minPathLength.get(algorithmName) > algorithmResult.pathLength) {
                    minPathLength.put(algorithmName, algorithmResult.pathLength);
                }
                if (minVisitedTileCount.get(algorithmName) > algorithmResult.visitedTileCount) {
                    minVisitedTileCount.put(algorithmName, algorithmResult.visitedTileCount);
                }
            }

            //update max
            if (!maxRunTime.containsKey(algorithmName)) {
                maxRunTime.put(algorithmName, algorithmResult.runtime);
                maxPathLength.put(algorithmName, algorithmResult.pathLength);
                maxVisitedTileCount.put(algorithmName, algorithmResult.visitedTileCount);

            } else {
                if (maxRunTime.get(algorithmName) < algorithmResult.runtime) {
                    maxRunTime.put(algorithmName, algorithmResult.runtime);
                }
                if (maxPathLength.get(algorithmName) < algorithmResult.pathLength) {
                    maxPathLength.put(algorithmName, algorithmResult.pathLength);
                }
                if (maxVisitedTileCount.get(algorithmName) < algorithmResult.visitedTileCount) {
                    maxVisitedTileCount.put(algorithmName, algorithmResult.visitedTileCount);
                }
            }

            if (!totalPathFound.containsKey(algorithmName)) {
                if (algorithmResult.pathFound) {
                    totalPathFound.put((algorithmName), 1);
                }
            } else {
                if (algorithmResult.pathFound) {
                    totalPathFound.put(algorithmName, totalPathFound.get(algorithmName) + 1);
                }
            }
        }
        //Compute Statistic
        for (String algoName : totalRunTime.keySet()) {
            int currentAlgoTotalRunTime = totalRunTime.get(algoName);
            int numberOfIterations = latestAlgorithmStats.size() / totalRunTime.keySet().size();
            double meanRunTime = currentAlgoTotalRunTime / (double) numberOfIterations;
            this.meanRunTime.put(algoName, meanRunTime);

            int currentAlgoTotalPathLength = totalPathLength.get(algoName);
            double meanPathLength = currentAlgoTotalPathLength / (double) numberOfIterations;
            this.meanPathLength.put(algoName, meanPathLength);

            int currentAlgoTotalVisitedTileCount = totalVisitedTileCount.get(algoName);
            double meanVisitedTileCount = currentAlgoTotalVisitedTileCount / (double) numberOfIterations;
            this.meanVisitedTileCount.put(algoName, meanVisitedTileCount);

            //Compute standard deviation
            double standardDeviationRunTime = 0;
            double standardDeviationPathLength = 0;
            double standardDeviationVisitedCount = 0;
            for (AlgorithmResult algorithmResult : latestAlgorithmStats) {
                String algorithmName = algorithmResult.algorithmName;
                if (algoName.equals(algorithmName)) {
                    standardDeviationRunTime += Math.pow(algorithmResult.runtime - meanRunTime, 2);
                    standardDeviationPathLength += Math.pow(algorithmResult.pathLength - meanPathLength, 2);
                    standardDeviationVisitedCount += Math.pow(algorithmResult.visitedTileCount - meanVisitedTileCount, 2);
                }
            }
            stdDevPathLength.put(algoName, Math.sqrt(standardDeviationPathLength / numberOfIterations));
            stdDevRunTime.put(algoName, Math.sqrt(standardDeviationRunTime / numberOfIterations));
            stdDevVisitedTileCount.put(algoName, Math.sqrt(standardDeviationVisitedCount / numberOfIterations));
        }


        // Update the data which will then in turn update and adapted Jtables
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        for (int i = 0; i < headers.length - 1; i++) { // First header is just Statistics
            int row = 1;
            data[row++][i + 1] = decimalFormat.format(totalRunTime.get(headers[i + 1]));
            data[row++][i + 1] = decimalFormat.format(minRunTime.get(headers[i + 1]));
            data[row++][i + 1] = decimalFormat.format(maxRunTime.get(headers[i + 1]));
            data[row++][i + 1] = decimalFormat.format(meanRunTime.get(headers[i + 1]));
            data[row++][i + 1] = decimalFormat.format(stdDevRunTime.get(headers[i + 1]));

            data[row++][i + 1] = decimalFormat.format(totalPathLength.get(headers[i + 1]));
            data[row++][i + 1] = decimalFormat.format(minPathLength.get(headers[i + 1]));
            data[row++][i + 1] = decimalFormat.format(maxPathLength.get(headers[i + 1]));
            data[row++][i + 1] = decimalFormat.format(meanPathLength.get(headers[i + 1]));
            data[row++][i + 1] = decimalFormat.format(stdDevPathLength.get(headers[i + 1]));

            data[row++][i + 1] = decimalFormat.format(totalVisitedTileCount.get(headers[i + 1]));
            data[row++][i + 1] = decimalFormat.format(minVisitedTileCount.get(headers[i + 1]));
            data[row++][i + 1] = decimalFormat.format(maxVisitedTileCount.get(headers[i + 1]));
            data[row++][i + 1] = decimalFormat.format(meanVisitedTileCount.get(headers[i + 1]));
            data[row++][i + 1] = decimalFormat.format(stdDevVisitedTileCount.get(headers[i + 1]));

            data[row][i + 1] = totalPathFound.get(headers[i + 1]);
        }
    }

    @Override
    public String getColumnName(int col) {
        return headers[col];
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
}
