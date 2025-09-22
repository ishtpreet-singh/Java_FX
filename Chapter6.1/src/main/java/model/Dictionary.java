package model;

import java.util.HashMap;

public class Dictionary {
    private final HashMap<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    // Add a word and its meaning
    public void addWord(String word, String meaning) {
        dictionary.put(word.toLowerCase(), meaning);
    }

    // Search for a word
    public String getMeaning(String word){
        if(word == null || word.isEmpty()){
            throw new IllegalArgumentException("Word cannot be empty");
        }
        String meaning = dictionary.get(word.toLowerCase());
        if(meaning == null){
            throw new WordNotFoundException("Word not found: " + word);
        }
        return meaning;
    }

    // Custom exception for word not found
    public static class WordNotFoundException extends RuntimeException {
        public WordNotFoundException(String message) {
            super(message);
        }
    }
}