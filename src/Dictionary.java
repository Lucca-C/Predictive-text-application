import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    //-----FIELDS-----
   private FileReadWrite fRW = new FileReadWrite();
   private ArrayList<String> words = fRW.FileToArray("src/TextFiles/words.txt");
//   private  List<String> words = List.of("w", "hello", "dog", "hell", "cat", "a", "hel","help","helps","helping",
//            "potato", "porr", "wack");

    //-----CONSTRUCTORS-----
    //-----METHODS-----
    public void print(){
        for (String word : words){
            System.out.print(word);
            System.out.print(", ");
        }
    }
    //-----ACCESSORS & MUTATORS-----
    public ArrayList<String> getWords() {
        return words;
    }
    public void setWords(ArrayList<String> words) {
        this.words = words;
    }
}
