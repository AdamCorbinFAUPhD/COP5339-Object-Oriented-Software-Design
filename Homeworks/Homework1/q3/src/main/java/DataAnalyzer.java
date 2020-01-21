import java.util.LinkedList;

/**
 * The DataAnalyzer class is expected to compute some simple statistics given a list of integers.
 */
public class DataAnalyzer {
    private LinkedList<Integer> numList;

    DataAnalyzer(LinkedList<Integer> list) {
        numList = list;
    }

    /**
     * This method will loop over the numList trying to find the smallest number which will then be returned
     *
     * @return min number in numList
     */
    public Integer min() {
        Integer minVal = Integer.MAX_VALUE;
        for (Integer num : numList) {
            if (num < minVal) {
                minVal = num;
            }
        }
        return minVal;
    }

    /**
     * This method will loop over the numList trying to find the largest number which will then be returned
     *
     * @return max number in numList
     */
    public Integer max() {
        Integer maxVal = Integer.MIN_VALUE;
        for (Integer num : numList) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        return maxVal;
    }

    /**
     * This method will loop over numList to compute the total, divide by the size to compute the average which will
     * then be return
     *
     * @return average of the numList
     */
    public Double average() {
        Integer total = 0;
        for (Integer num : numList) {
            total += num;
        }
        return total / (double)numList.size();
    }
}
