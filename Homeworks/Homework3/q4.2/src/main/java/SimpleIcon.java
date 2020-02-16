import javax.swing.*;
import java.awt.*;

public class SimpleIcon implements Icon {
    private int width = 0;
    private int height = 0;
    private Color color = Color.RED;

    /**
     * Main constructor which height its heigth and width
     * @param width Size in pixels
     * @param height Size in pixels
     */
    SimpleIcon(int width, int height){
        this.width = width;
        this.height = height;
    }

    /**
     * @param color Updates the color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * This method will generate the circle and fill it will the provided color
     * @param c
     * @param g
     * @param x position x
     * @param y position y
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fillOval(x,y,this.width, this.height);

    }

    /**
     * @return returns the Width which was based on the constructor
     */
    @Override
    public int getIconWidth() {
        return this.width;
    }

    /**
     * @return returns the Height which was based on the constructor
     */
    @Override
    public int getIconHeight() {
        return this.height;
    }

}
