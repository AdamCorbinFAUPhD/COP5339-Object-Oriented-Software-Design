/**
 * This interfaced is designed to be a base of any kind of spellchecker. Each class that
 * implements the check word would use their own implementation of how to check if the word is spelled correctly
 */
public interface SpellChecker {
    public SpellCheckerResults checkWord(String word);
}
