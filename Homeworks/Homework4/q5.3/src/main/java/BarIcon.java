import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class BarIcon implements Icon {

    int x,y,width, height;

    BarIcon(int x, int y, int width, int height){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public void setWidth(int width){
        this.width = width;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D.Double rect
                = new Rectangle2D.Double(this.x, this.y, width , width);

        g2.draw(rect);

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
