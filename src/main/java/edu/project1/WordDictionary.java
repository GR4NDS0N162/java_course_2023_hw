package edu.project1;

import java.util.List;
import java.util.Random;

public class WordDictionary {

    private final List<String> words;
    private final Random random;

    public WordDictionary(List<String> words) {
        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException("Словарь не должен быть пустым.");
        }
        this.words = words;
        this.random = new Random();
    }

    public String getRandomWord() {
        int index = random.nextInt(words.size());
        return words.get(index);
    }
}
