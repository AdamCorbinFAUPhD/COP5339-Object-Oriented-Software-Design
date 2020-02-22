import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This program implements an animation that moves 5 different cars staggered where
 * the first car is the slowest, the folling cars are 2x faster than the previous
 */
public class AnimationTester {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        //Create 5 movable shapes and start them staggered apart
        // on the y coordinate
        final MoveableShape[] shapes = new MoveableShape[5];
        for (int i = 0; i < 5; i++) {
            shapes[i] = new CarShape(0, 0, CAR_WIDTH);
            shapes[i].translate(0, i * 50);
        }

        ShapeIcon icon = new ShapeIcon((MoveableShape[]) shapes,
                ICON_WIDTH, ICON_HEIGHT);

        final JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        final int DELAY = 100;
        // Milliseconds between timer ticks
        Timer t = new Timer(DELAY, new
                ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //Ensure that each car following is 2x as the previous so using i^2
                        for (int i = 0; i < shapes.length; i++) {
                            int speed = i+1;
                            shapes[i].translate(speed * speed, 0);
                        }
                        label.repaint();
                    }
                });
        t.start();

        frame.setSize(750, 400);

    }

    private static final int ICON_WIDTH = 50;
    private static final int ICON_HEIGHT = 50;
    private static final int CAR_WIDTH = 50;
}