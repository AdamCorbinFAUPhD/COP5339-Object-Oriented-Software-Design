import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    SimpleIcon sampleIcon = new SimpleIcon(150,150);
    JFrame frame = new JFrame();
    public GUI(){



        String[] colors = {"GREEN", "BLUE", "RED"};
        Color[] colorss = {Color.GREEN, Color.BLUE, Color.RED};

        frame.setLayout(new FlowLayout());
        for (int i = 0; i < colors.length; i++) {
            JButton helloButton = new JButton(colors[i]);
            helloButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Setting color");
                    sampleIcon.setColor(Color.CYAN);
                    frame.repaint();
                }
            });
            frame.add(helloButton);
        }

        JLabel label = new JLabel(sampleIcon);
        frame.add(label);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(200,300);
        //TODO - click listners to each on changing the color
    }
}
