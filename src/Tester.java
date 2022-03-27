import java.util.List;

public class Tester {
    public static void main(String[] args){
        List<String> words = List.of("w", "hello", "dog", "hell", "cat", "a", "hel","help","helps","helping",
                "potato", "porr", "wack");
        Trie trie = new Trie(words);

        System.out.println(trie.prediction("w"));
    }
}
