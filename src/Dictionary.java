import java.util.ArrayList;

public class Dictionary {
    //-----FIELDS-----
    private FileReadWrite fRW = new FileReadWrite();
    private ArrayList<String> words;

    //-----CONSTRUCTORS-----
    /**
     * Method to select which dictionary is being utilised.
     *
     * @param selection Correlates to a numbered dictionary and is passed through from the gui
     * @param filePath  The file path of the custom dictionary
     */
    public Dictionary(int selection) {
        //Default file path (so it doesn't throw errors
        String filePath = "src/TextFiles/Dictionaries/en.txt";
        if (1 == selection) {
            words = fRW.FileToArray("src/TextFiles/Dictionaries/en.txt");
        } else if (2 == selection) {
            words = fRW.FileToArray("src/TextFiles/Dictionaries/en2.txt");
        } else if (3 == selection) {
            words = fRW.FileToArray("src/TextFiles/Dictionaries/de.txt");
        } else if (4 == selection) {
            words = fRW.FileToArray("src/TextFiles/Dictionaries/es.txt");
        } else if (5 == selection) {
            words = fRW.FileToArray("src/TextFiles/Dictionaries/fr.txt");
        } else if (6 == selection) {
            words = fRW.FileToArray(filePath);
        } else {
            System.err.println("This dictionary does not exist. Defaulting to English");
            words = fRW.FileToArray("src/TextFiles/Dictionaries/en.txt");
        }
    }
    //-----METHODS-----
    /**
     * Method to print all the words in the "words" array
     */
    public void print() {
        for (String word : words) {
            System.out.print(word);
            System.out.print(", ");
        }
    }

    //-----ACCESSORS & MUTATORS-----
    /**
     * accessor method for words array
     *
     * @return the words array
     */
    public ArrayList<String> getWords() {
        return words;
    }

    /**
     * mutator method for words array
     *
     * @param words the words array
     */
    public void setWords(ArrayList<String> words) {
        this.words = words;
    }
}
