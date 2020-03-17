import javax.swing.*;

public class GUIView {
    JFrame frame = new JFrame();
    JPanel textPanel = new JPanel();
    JPanel barPanel = new JPanel();
    GUIView(){
        JLabel bar1 = new JLabel(new BarIcon(0,0,10,10));
        barPanel.add(bar1);
        frame.add(barPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(750, 400);
    }

    public static void main(String[] args) {

    }
}
