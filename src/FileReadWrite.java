import java.io.*;
import java.util.ArrayList;

/**
 * A class that handles the reading and writing of text files such as the dictionary file and the tester file.
 *
 * @author Finnbar Home :)
 * @version 1.0
 */
public class FileReadWrite {
    /**
     * A method to read and print out the contents of a text file.
     *
     * @param filePath Defines the path of the targeted text file.
     */
    public void FileRead(String filePath) {
        String read;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((read = br.readLine()) != null) {
                System.out.println(read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * A method to compare an input to the dictionary and compare it to the current entries in the text file.
     *
     * @param input    The input to be added to the text file, so it can be checked against current entries to the text file.
     * @param filePath Defines the path of the targeted text file.
     * @return boolean returns the value of whether the text input is a duplicate or not.
     */
    public boolean CheckDuplicates(String input, String filePath) {
        boolean duplicate = false;
        ArrayList<String> words = FileToArray(filePath);
        int count = 0;
        String currentWord;

        while (count < words.size()) {
            currentWord = words.get(count).toLowerCase();
            input = input.toLowerCase();

            if (currentWord.equals(input)) {
                duplicate = true;
            }
            count++;
        }
        return duplicate;
    }

    /**
     * Method that writes to the text file.
     *
     * @param input    The input to be added to the text file.
     * @param filePath Defines the path of the targeted text file.
     */
    public void FileWrite(String input, String filePath) {
        boolean duplicate;

        try {
            duplicate = CheckDuplicates(input, filePath);
            FileWriter fw = new FileWriter(filePath, true); //the true will append the new data
            if (duplicate == true) {
                System.err.println("This input is a duplicate");
            } else {
                fw.write(input + "\n");//appends the string to the file
                System.out.println("Successfully added word");
            }
            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    /**
     * Method to convert a text file of entries into an array.
     *
     * @param filePath Defines the path of the targeted text file.
     * @return ArrayList<String> This is returning the array of the values included in the text files.
     */
    public ArrayList<String> FileToArray(String filePath) {
        String read;
        ArrayList<String> values = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((read = br.readLine()) != null) {
                values.add(read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;
    }
}
