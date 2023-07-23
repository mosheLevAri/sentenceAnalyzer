package Medaware.src;

import java.util.ArrayList;
import java.util.List;

public class SentenceGroupModel {
    private String key;
    private List<String> data;
    private List<String> changingWords;

    public SentenceGroupModel(String key) {
        this.key = key;
        this.data = new ArrayList<>();
        this.changingWords = new ArrayList<>();
    }

    public void addSentence(String sentence) {
        data.add(sentence);
    }

    public void addChangingWord(String word) {
        changingWords.add(word);
    }

    public String getKey() {
        return key;
    }

    public String[] getData() {
        return data.toArray(new String[0]);
    }

    public String[] getChangingWords() {
        return changingWords.toArray(new String[0]);
    }
}
