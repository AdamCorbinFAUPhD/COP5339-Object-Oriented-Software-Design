import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class GUIController {
    /**
     * In the GUI Controller it will create 3 JTextField, and 3 BarIcons to be added to the GUIView
     * It will also create 3 BarModels which store the value of the bar height
     */
    public static void main(String[] args) {
        GUIView guiView = new GUIView();
        Random rand = new Random();
        ArrayList<BarModel> barModelArray = new ArrayList<>();
        for (int i = 0; i < 3 ; i++) {
            barModelArray.add(new BarModel(rand.nextInt(100)));
        }

        int height = 50;

        createBarRow(guiView, barModelArray.get(0), height, 1, Color.red);
        createBarRow(guiView, barModelArray.get(1), height, 2, Color.green);
        createBarRow(guiView, barModelArray.get(2), height, 3, Color.blue);

        guiView.repack();
    }

    /**
     * This function will create and add JTextFields and BarIcons to the GUIView
     * There will also have some KeyListners when the JTExtFields are edited. When that occurs
     * the BarModle will update. From that value, the BarIcon will update its width and tell the GUIView to refresh
     *
     * @param guiView  - the view to add the JTextFields and BarIcons to
     * @param barModel - the mode where the BarIcon heigths and text values are stored
     * @param height - The height of how big the BarIcons should be
     * @param index - index used to edit the holders within the GuiView
     * @param color - The color of the BarIcon should be when created
     */
    static void createBarRow(GUIView guiView, BarModel barModel, int height, int index, Color color) {
        int maxWidth = 250;
        BarIcon barIcon = new BarIcon(15,0,maxWidth,height, color);
        guiView.barIcons.add(barIcon);
        barIcon.width = (int) (barModel.barWidth/100.0 * maxWidth);
        JLabel jLabel = new JLabel(barIcon);
        JTextField textField = new JTextField(3);
        textField.setPreferredSize(new Dimension(50,50));
        Border empty = new EmptyBorder(10, 10, 10, 10);
        Border compound = new CompoundBorder(textField.getBorder(), empty);
        textField.setEnabled(true);
        textField.setBorder(compound);
        textField.setText(String.valueOf(barModel.barWidth));
        guiView.textFields.add(textField);

        final int localIndex = index - 1; // Index 0 is the label for the range 0-100
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                updateBarIcon(guiView, barModel, localIndex, maxWidth);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                updateBarIcon(guiView, barModel, localIndex, maxWidth);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                updateBarIcon(guiView, barModel, localIndex, maxWidth);
            }
        });

        guiView.textPanel.add(textField);

        guiView.barPanel.add(jLabel);
        guiView.frame.repaint();
    }

    /**
     * This function will retrieve the text value and update the BarModel object. There is also a test to ensure that
     * the values are numeric and between 0 and 100(inclusive)
     * @param guiView - Used to find the text value within the text fields
     * @param barModel - Used to update the barWidth value
     * @param localIndex - Used to index into the correct BarIcons and TextField arrays in the GUIView
     * @param maxWidth - Used to come up with the scaled value to display on the screen. Values from 0-100 was too small
     *                 on the screen so we have a max size to compute based on the percentage of how big it should be
     */
    private static void updateBarIcon(GUIView guiView, BarModel barModel, int localIndex, int maxWidth) {
        try {
            int size = Integer.parseInt(guiView.textFields.get(localIndex).getText());
            if (0 <= size && size <= 100) {
                barModel.updateWidth(size);
                guiView.barIcons.get(localIndex).width = (int) (((double) barModel.barWidth / 100.0) * maxWidth);
                guiView.frame.repaint();
            }
        }catch (Exception e){
            System.out.println("ERROR: Parsing Int failed. Be sure to only use integers");
        }
    }
}
