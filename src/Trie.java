import java.util.ArrayList;
import java.util.List;

public class Trie {
    //-----FIELDS-----
    private TrieNode root;

    //-----CONSTRUCTORS-----
    /**
     * Constructor for Trie.
     * Populates the Trie with the words from the dictionary.
     * @param words arrayList of Strings. These are the dictionary words.
     */
    public Trie(List<String> words) {
        root = new TrieNode();
        for (String word : words)
            root.insert(word);
    }

    //-----ACCESSORS & MUTATORS
    public TrieNode getRoot() {
        return root;
    }
    public void setRoot(TrieNode root) {
        this.root = root;
    }
}