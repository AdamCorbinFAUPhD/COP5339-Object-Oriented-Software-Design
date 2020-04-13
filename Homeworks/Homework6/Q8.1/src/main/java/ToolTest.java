import java.util.NoSuchElementException;

public class ToolTest {

    public static void main(String[] args) {
        ToolBox toolBox = new ToolBox();

        toolBox.addTool(new Eraser());
        toolBox.addTool(new Paper());
        toolBox.addTool(new Pencil());
        toolBox.addTool(new Protractor());
        toolBox.addTool(new Ruler());

        Tool eraser = toolBox.get("Eraser");
        eraser.use();
        Tool paper = toolBox.get("Paper");
        paper.use();
        Tool pencil = toolBox.get("Pencil");
        pencil.use();
        Tool protractor = toolBox.get("Protractor");
        protractor.use();
        Tool ruler = toolBox.get("Ruler");
        ruler.use();
        try{
            toolBox.get("Tape");
        }catch (NoSuchElementException e){
            System.out.println("Caught expected NoSuchElementException for Tape tool");
        }


    }
}
