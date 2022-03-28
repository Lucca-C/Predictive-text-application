import java.util.List;

public class Tester {
    public static void main(String[] args){
        Dictionary dictionary = new Dictionary();
        Trie trie = new Trie(dictionary.getWords());
        System.out.println(trie.prediction("po"));
    }
}
