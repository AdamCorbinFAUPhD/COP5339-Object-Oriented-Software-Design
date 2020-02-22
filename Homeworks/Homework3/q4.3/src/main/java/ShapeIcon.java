import javax.swing.*;
import java.awt.*;

/**
 An icon that contains multiple moveable shapes.
 */
public class ShapeIcon implements Icon
{
    public ShapeIcon(MoveableShape[] shapes,
                     int width, int height)
    {
        this.shapes = shapes;
        this.width = width;
        this.height = height;
    }

    public int getIconWidth()
    {
        return width;
    }

    public int getIconHeight()
    {
        return height;
    }

    /**
     * This method will handel drawing all of the movableShapes on the screen
     */
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2 = (Graphics2D) g;
        for (MoveableShape shape : shapes) {
            shape.draw(g2);
        }
    }

    private int width;
    private int height;
    private MoveableShape[] shapes;
}