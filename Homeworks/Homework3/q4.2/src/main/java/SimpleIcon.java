import javax.swing.*;
import java.awt.*;

public class SimpleIcon implements Icon {
    private int width = 0;
    private int height = 0;
    private Color color = Color.RED;

    SimpleIcon(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        double width = getIconWidth();
        g2.setColor(color);
        g2.fillOval(x,y,this.width, this.height);

    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }

    public Color getColor() {
        return color;
    }
}
