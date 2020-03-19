public class BarModel {
    int barWidth = 0;

    /**
     * This class is used to keep track of the width of the Bar
     * @param barWidth initialized value to how big the Bar should be
     */
    BarModel(int barWidth){
        this.barWidth = barWidth;
    }

    /**
     * @param updatedWidth - value to update the internal barWidth
     */
    public void updateWidth(int updatedWidth){
        this.barWidth = updatedWidth;
    }
}
