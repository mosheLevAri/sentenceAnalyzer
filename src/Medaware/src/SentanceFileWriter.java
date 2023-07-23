
package Medaware.src;

import Medaware.interfaces.IFileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class SentanceFileWriter implements IFileWriter {
    @Override
    public void saveOutputToFile(List<SentenceGroupModel> sentenceGroups, String outputFilePath) throws IOException {

        try (java.io.FileWriter writer = new java.io.FileWriter(outputFilePath)) {
            for (SentenceGroupModel group : sentenceGroups) {

                String[] entryKeyList = group.getKey().split(" ");
                String[] entryData = group.getData();
                String[] dataToComperWithKey = entryData.length > 1 ? entryData[1].split(" ", 3)[2].split(" ") : entryKeyList;

                Set<String> findMissingWord = SentenceGrouper.findNonCommonWords(entryKeyList, dataToComperWithKey);

                String changingWordsString = String.join(", ", group.getChangingWords());
                String extractMissingWord = findMissingWord.iterator().next();

                for (String sentence : group.getData()) {
                    writer.write(sentence + "\n");
                }

                writer.write("The changing word was: " + extractMissingWord + ", " + changingWordsString + "\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
