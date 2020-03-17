import java.util.ArrayList;
import java.util.HashMap;
/**
 * This class will handle the English version of a spell checker.
 * In general the test word will be checked if it lives in the Dictionary. If not
 * we have a misspelling in where we will keep track of a common misspellings. If not
 * in either then the results will be invalid spelling and no suggestions
 */
public class EnglishSpellChecker implements SpellChecker  {

    String language;
    HashMap<String,Boolean> dictionary = new HashMap();
    HashMap<String, ArrayList<String>> commonMisspellings = new HashMap();
    EnglishSpellChecker(String language){
        this.language = language;
    }

    @Override
    public SpellCheckerResults checkWord(String testWord) {

        if(this.dictionary.containsKey(testWord)){
            return new SpellCheckerResults(true,new ArrayList());
        }
        else if(this.commonMisspellings.containsKey(testWord)){
            return new SpellCheckerResults(false,this.commonMisspellings.get(testWord));
        }else{
            return new SpellCheckerResults(false,new ArrayList());
        }
    }
}
