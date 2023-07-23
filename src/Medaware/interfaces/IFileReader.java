package Medaware.interfaces;

import java.io.IOException;
import java.util.List;

public interface IFileReader {
    List<String> readSentences(String filePath) throws IOException;
}