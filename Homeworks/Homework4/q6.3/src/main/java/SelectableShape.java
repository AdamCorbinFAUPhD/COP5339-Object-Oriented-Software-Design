import java.awt.*;

/**
   A shape that manages its selection state.
*/
public abstract class SelectableShape implements SceneShape
{
   public void setSelected(boolean b)
   {
      selected = b;
   }

   public boolean isSelected()
   {
      return selected;
   }

   public void drawSelection(Graphics2D g2)
   {
      //Capture the default stroke to be used to reset after the dashed objects get drawn
      g2.setColor(Color.black);
      Stroke defaultStroke = g2.getStroke();
      draw(g2);

      if(this.isSelected()){
         g2.setColor(Color.BLUE);
         float[] dash1 = { 5.0f };
         g2.setStroke(new BasicStroke(2.0f,
                 BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash1, 0.0f));
         //Get the bounds of the object, make it a little bit larger and align up to boarder to be at the
         // bottom right corner
         Rectangle rect = this.getPath().getBounds();
         rect.height = rect.height + 5;
         rect.width = rect.width + 5;
         rect.x = rect.x - 4;
         rect.y = rect.y - 4;
         g2.draw(rect);

         //Create the 4 corners
         Rectangle rect1 = new Rectangle(rect.x-3,rect.y-3,6,6);
         g2.fill(rect1);
         Rectangle rect2 = new Rectangle(rect.x-3,rect.y-3 + rect.height,6,6);
         g2.fill(rect2);
         Rectangle rect3 = new Rectangle(rect.x-3  + rect.width,rect.y-3 + rect.height,6,6);
         g2.fill(rect3);
         Rectangle rect4 = new Rectangle(rect.x-3 + rect.width,rect.y-3,6,6);
         g2.fill(rect4);
      }

      //Reset the color and stroke back to normal. Without this you might cause subsequent objects
      // that might not be selected to use the selected color and stroke.
      g2.setColor(Color.black);
      g2.setStroke(defaultStroke);
   }

   private boolean selected;
}
