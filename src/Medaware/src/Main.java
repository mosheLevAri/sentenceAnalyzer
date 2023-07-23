
package Medaware.src;

import static java.lang.Thread.sleep;

public class Main {


    public static void main(String[] args) {

        String inputFilePath = "Medaware/data/filtered_output.csv";
        String outputFilePath = "result.txt";
        SentenceAnalyzer sentenceAnalyzer = new SentenceAnalyzer(inputFilePath, outputFilePath);
        sentenceAnalyzer.run();

        try {
            sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
