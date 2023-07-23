package Medaware.src;

import Medaware.interfaces.ISentenceGrouper;
import java.util.*;

public class SentenceGrouper implements ISentenceGrouper {
    private Map<String, SentenceGroupModel> sentenceGroups;

    public SentenceGrouper() {
        this.sentenceGroups = new HashMap<>();
    }

    @Override
    public void groupSimilarSentences(List<String> sentences) {

        boolean isNewGroup = false;
        for (String sentence : sentences) {
            String extractReleventData = sentence.split(" ", 3)[2];

            isNewGroup = fiilSentencesInGroupIfNeeded(extractReleventData, sentence);

            if (isNewGroup) {
                SentenceGroupModel newGroup = new SentenceGroupModel(extractReleventData);
                newGroup.addSentence(sentence);
                sentenceGroups.put(extractReleventData, newGroup);
            }
        }
    }

    @Override
    public List<SentenceGroupModel> getSentenceGroups() {
        return new ArrayList<>(sentenceGroups.values());
    }

    private boolean fiilSentencesInGroupIfNeeded(String releventData, String sentence) {
        boolean isNewGroup = true;

        for (SentenceGroupModel group : sentenceGroups.values()) {
            String[] sentenceList = releventData.split(" ");
            String[] groupKey = group.getKey().split(" ");

            Set<String> nonCommonWords = findNonCommonWords(sentenceList, groupKey);

            if (nonCommonWords.size() == 1) {
                group.addSentence(sentence);
                group.addChangingWord(nonCommonWords.iterator().next());
                isNewGroup = false;
                break;
            }
        }

        return isNewGroup;
    }

    public static Set<String> findNonCommonWords(String[] array1, String[] array2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(array1));
        Set<String> set2 = new HashSet<>(Arrays.asList(array2));

        set1.removeAll(set2);
        return set1;
    }
}