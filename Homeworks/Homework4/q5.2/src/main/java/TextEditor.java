import java.util.ArrayList;
import java.util.HashMap;

public class TextEditor {
    HashMap<String,SpellChecker> spellCheckers = new HashMap<>();
    String text = "";
    ArrayList<SpellCheckerResults> SpellingErrors = new ArrayList<>();
    String languageUsed = "English";

    /**
     * This class will create 2 spell checkers where they are indexed by the english language string
     * This class would be used by using a specific spell checker by iterating over the text string
     * to check a single word
     * */
    TextEditor(){
        spellCheckers.put("English",new EnglishSpellChecker("English"));
        spellCheckers.put("Spanish",new SpanishSpellChecker("Spanish"));
    }
}
