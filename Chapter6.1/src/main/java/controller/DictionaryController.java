package controller;

import model.Dictionary;

public class DictionaryController {
    private final Dictionary dictionary;

    public DictionaryController() {
        dictionary = new Dictionary();

        dictionary.addWord("banana", "A fruit that grows on tress and gorws in a cold place");
        dictionary.addWord("programming", "A programming language and computing platform");
        dictionary.addWord("python", "A set of written or printed pages.");
    }

    public String searchWord(String word){
        try {
            return dictionary.getMeaning(word);
        }
        catch(IllegalArgumentException e){
            return "Please enter a word";
        }
        catch (Dictionary.WordNotFoundException e){
            return "Word not found in dictionary";
        }
    }

    // Add new words dynamically
    public void addWord(String word, String meaning){
        dictionary.addWord(word, meaning);
    }
}