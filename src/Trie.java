import java.util.List;

public class Trie {
    //-----FIELDS-----
    private Node root;

    //-----CONSTRUCTORS-----
    /**
     * Constructor for Trie.
     * Populates the Trie with the words from the dictionary.
     * @param words arrayList of Strings. These are the dictionary words.
     */
    public Trie(List<String> words) {
        root = new Node();
        for (String word : words)
            root.insert(word);
    }

    //-----ACCESSORS & MUTATORS
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
}