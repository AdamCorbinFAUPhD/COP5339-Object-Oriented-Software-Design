import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ToolBox {
    ArrayList<Tool> tools = new ArrayList();

    /**
     * @param tool too be added to the list of tools
     */
    public void addTool(Tool tool){
        tools.add(tool);
    }

    /**
     * Search for the tool with a matching name
     * @param name to search in the list of tools
     * @return returns the found tool in the list
     * @throws NoSuchElementException - when the tool was not found
     */
    public Tool get(String name) throws NoSuchElementException {
        for(Tool tool: tools){
            if(tool.getName().equals(name)){
                return tool;
            }
        }
        throw new NoSuchElementException();
    }
}
