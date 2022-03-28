import java.util.List;

public class Tester {
    public static void main(String[] args){
        FileReadWrite FileReadWrite = new FileReadWrite();
//        FileReadWrite.FileWrite("test", "src/TextFiles/words.txt");
//        FileReadWrite.FileRead("src/TextFiles/words.txt");
        FileReadWrite.FileToArray("src/TextFiles/words.txt");
//        Dictionary dictionary = new Dictionary();
//        Trie trie = new Trie(dictionary.getWords());
//        System.out.println(trie.prediction("po"));
    }
}
