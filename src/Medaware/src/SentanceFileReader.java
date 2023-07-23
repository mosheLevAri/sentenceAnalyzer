
package Medaware.src;

import Medaware.interfaces.IFileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SentanceFileReader implements IFileReader {
    @Override
    public List<String> readSentences(String filePath) throws IOException {
        List<String> sentences = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    sentences.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sentences;
    }
}
