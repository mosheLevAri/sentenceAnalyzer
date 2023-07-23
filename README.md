# Sentence Analyzer

The application designed to analyze sentences and group similar sentences based on their content.
It provides functionalities to read sentences from a file,
group them, and save the results to an output file.


### **Please note that the project files are located in the src/Medawere directory.**


![image](https://github.com/mosheLevAri/sentenceAnalyzer/assets/95866297/67f81810-d14b-4fa2-89c8-7eee3cba3d89)


## Project Structure

The project is organized into the following directories and files:


- **medawere**
    - **data**: Contains the input data file `data.csv`, which contains sentences to be analyzed.
    - **interfaces**: Contains interfaces used for maintainability, Object-Oriented Programming (OOP) principles, scalability, and adherence to SOLID design principles.
    - **src**: Contains the main Java source code for the Medaware application.
        - `SentenceAnalyzer.java`: Analyzes and groups sentences based on their content.
        - `Main.java`: The main class to execute the SentenceAnalyzer and run the entire process.
        - `FileReader.java`: Implements the `IFileReader` interface and reads sentences from a file.
        - `FileWriter.java`: Implements the `IFileWriter` interface and saves the output to a file.
        - `SentenceGrouper.java`: Implements the `ISentenceGrouper` interface and groups similar sentences.
        - `SentenceGroupModel.java`: Represents a group of sentences sharing similar content.
    - `Dockerfile`: Dockerfile used to build the Docker image for the Medaware application.



## Modules


### `FileReader` Module

The `FileReader` module implements the `IFileReader` interface, responsible for reading sentences from a given file path (`data.csv`). It processes the file and returns a list of sentences.

### `FileWriter` Module

The `FileWriter` module implements the `IFileWriter` interface, responsible for saving the output of the sentence analysis to a specified output file (`result.txt`). It takes a list of `SentenceGroupModel` objects, extracts relevant information, and writes the results to the output file.

### `Main` Module

The `Main` module contains the entry point of the Medaware application. It sets up the input and output file paths and initializes the `SentenceAnalyzer` to perform the sentence analysis and grouping.

### `SentenceAnalyzer` Module

The `SentenceAnalyzer` module orchestrates the entire sentence analysis process. It uses the `FileReader` to read sentences, `SentenceGrouper` to group similar sentences, and `FileWriter` to save the results to an output file.

### `SentenceGrouper` and `SentenceGroupModel` Modules

The `SentenceGrouper` and `SentenceGroupModel` modules work together to group similar sentences based on their content. The `SentenceGrouper` implements the `ISentenceGrouper` interface and groups sentences with similar content into `SentenceGroupModel` objects.

## Building and Running the Project

To build and run the application, follow these steps:

1. Ensure you have Java and Docker installed on your system.

2. Navigate to the root directory of the project.

3. Build the Docker image using the provided Dockerfile:

   ```bash
   docker build -t app-name .
   ```
4. Run the Docker container and execute the application:

   ```bash
   docker run -it medaware
   ```
