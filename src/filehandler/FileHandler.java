package filehandler;

import java.io.*;

public class FileHandler {

    /**
     * Constructor to set up the object
     */
    public FileHandler() {

    }

    /**
     * Function writeFile()
     * <p>
     *     Takes a filePath and a string and writes the string to the
     *     given file
     * </p>
     * @param filePath is the location of the file to write to
     * @param text is the text to write to the file
     */
    public void writeFile(String filePath, String text) {
        // Try
        try {
            // Open/Create the file
            File file = new File(filePath);
            // Create a FileWriter
            FileWriter fileWriter = new FileWriter(file);
            // Create a BufferedWriter
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // Write the text to the file
            bufferedWriter.write(text);
            // Flush
            bufferedWriter.flush();
            // Close the BufferedWriter
            bufferedWriter.close();
            // Close the FileWriter
            fileWriter.close();
        }
        // Catch
        catch(Exception e) {
            // Output error
            System.err.println("Failed to write to file");
        }
    }

    /**
     * Function readFile()
     * <p>
     *     Reads and returns the String contents of a file at the given filePath
     * </p>
     * @param filePath is the location of the file to open
     * @return the String contents
     */
    public String readFile(String filePath) {
        // Declare an empty string
        String tmp = "";
        // Try
        try {
            // Open/Create the file
            File file = new File(filePath);
            // Create a FileReader
            FileReader fileReader = new FileReader(file);
            // Create a BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // Create a StringBuilder
            StringBuilder sb = new StringBuilder();
            // Create a dummy variable
            String line = "";
            // While there are still lines in the file
            while((line = bufferedReader.readLine()) != null) {
                // Append the line to the StringBuilder
                sb.append(line);
            }
            // Set the empty String to the String built by the StringBuilder
            tmp = sb.toString();
        }
        // Catch
        catch (Exception e) {
            // Output an error message
            System.err.println("Failed to read file");
        }
        // Return the tmp
        return tmp;
    }
}

