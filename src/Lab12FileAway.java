
import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lab12FileAway {
    public static void main(String[] args) {

        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                processFile(selectedFile);
            } catch (IOException e) {
                System.err.println("Error processing the file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }

    private static void processFile(File file) throws IOException {
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                wordCount += countWords(line);
                charCount += line.length();
            }
        }
        printSummaryReport(file.getName(), lineCount, wordCount, charCount);
    }

    private static int countWords(String line) {
        return line.split("\\s+").length;
    }

    private static void printSummaryReport(String fileName, int lineCount, int wordCount, int charCount) {
        System.out.println("File Name: " + fileName);
        System.out.println("Number of Lines: " + lineCount);
        System.out.println("Number of Words: " + wordCount);
        System.out.println("Number of Characters: " + charCount);
    }
}
