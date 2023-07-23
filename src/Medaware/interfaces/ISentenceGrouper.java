package Medaware.interfaces;
import Medaware.src.SentenceGroupModel;

import java.util.List;

public interface ISentenceGrouper {
    void groupSimilarSentences(List<String> sentences);
    List<SentenceGroupModel> getSentenceGroups();
}