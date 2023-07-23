package Medaware.src;

import java.io.IOException;
import java.util.List;

public class SentenceAnalyzer {
    private SentanceFileReader sentenceReader = new SentanceFileReader();
    private SentanceFileWriter outputSaver = new SentanceFileWriter();
    private SentenceGrouper sentenceGrouper = new SentenceGrouper();

    private String inputFilePath = null;
    private String outputFilePath = null;

    public SentenceAnalyzer(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    public void run() {
        try {
            List<String> sentences = sentenceReader.readSentences(inputFilePath);
            sentenceGrouper.groupSimilarSentences(sentences);
            List<SentenceGroupModel> sentenceGroups = sentenceGrouper.getSentenceGroups();
            outputSaver.saveOutputToFile(sentenceGroups, outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


