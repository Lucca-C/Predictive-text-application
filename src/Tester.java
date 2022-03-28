import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args){
        FileReadWrite FileReadWrite = new FileReadWrite();
        FileReadWrite.FileWrite("Jessio", "src/TextFiles/words.txt");
//        FileReadWrite.FileRead("src/TextFiles/words.txt");

//        ArrayList<String> stick;
//        stick=FileReadWrite.FileToArray("src/TextFiles/words.txt");
//        System.out.println(stick);

//        Dictionary dictionary = new Dictionary();
//        Trie trie = new Trie(dictionary.getWords());
//        System.out.println(trie.prediction("po"));
    }
}
