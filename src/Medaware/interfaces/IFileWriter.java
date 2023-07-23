package Medaware.interfaces;

import Medaware.src.SentenceGroupModel;
import java.io.IOException;
import java.util.List;

public interface IFileWriter {
    void saveOutputToFile(List<SentenceGroupModel> sentenceGroups, String outputFilePath) throws IOException;
}