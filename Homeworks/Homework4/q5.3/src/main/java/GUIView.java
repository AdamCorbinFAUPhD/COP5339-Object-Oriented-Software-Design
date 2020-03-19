import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUIView {
    JFrame frame = new JFrame();
    JPanel masterPanel = new JPanel(new GridLayout(2,3));
    JPanel textPanel = new JPanel(new GridLayout(3,1));
    JPanel barPanel = new JPanel(new GridLayout(3,1));
    ArrayList<JTextField> textFields = new ArrayList();
    ArrayList<BarIcon> barIcons = new ArrayList();

    /**
     * This is the view of the MVC. It handles holding the text panel and the bar panel and laying out the pieces
     */
    GUIView(){
        JLabel label = new JLabel("Keep numbers [0,100]");
        masterPanel.add(label);
        JLabel label2 = new JLabel(""); // This is only needed because of the Grid layout
        masterPanel.add(label2);


        masterPanel.add(textPanel);
        masterPanel.add(barPanel);
        frame.add(masterPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(750, 400);
    }

    /**
     * After new items get added to the frame its good to repack and set the size back to default
     */
    public void repack(){
        frame.pack();
        frame.setSize(750,400);
    }
}
