import javax.swing.*;
import java.awt.*;

/**
 * This class is used as way to display objects on the screen with a color.
 */
public class BarIcon implements Icon {

    int x,y,width, height;
    Color color;

    BarIcon(int x, int y, int width, int height, Color color){
        System.out.println(y );
        this.width = width;
        this.height = height;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle rect2 = new Rectangle(this.x,this.y,width,height);
        g2.setColor(color);
        g2.fill(rect2);
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }
}
