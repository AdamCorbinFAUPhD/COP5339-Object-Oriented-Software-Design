import java.util.ArrayList;

/**
 * This class is used to represent if a word is spelled correctly and if not a list of
 * suggested words that might be the correct spelling
 */
public class SpellCheckerResults {

    Boolean isValid;
    ArrayList<String> suggestedWords;

    SpellCheckerResults(Boolean isValid, ArrayList<String> suggestedWords){
        this.isValid = isValid;
        this.suggestedWords = suggestedWords;
    }
}
