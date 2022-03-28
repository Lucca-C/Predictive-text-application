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

    //-----METHODS-----

    /**
     * Prefix is target.
     * For every letter in target,
     * get the node paired with that letter, in the children hashmap.
     * Make that node ^ the current node.
     * @param prefix
     * @param exact
     * @return boolean !exact or true, if lastNode is a word.
     */
    private boolean find(String prefix, boolean exact) {
        TrieNode lastNode = root;
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.getChildren().get(c);
            if (lastNode == null)
                return false;
        }
        return !exact || lastNode.isWord();
    }
    private boolean find(String prefix) {
        return find(prefix, false);
    }
    private void helper(TrieNode root, List<String> list, StringBuffer curr) {
        if (root.isWord()) {
            list.add(curr.toString());
        }
        if (root.getChildren() == null || root.getChildren().isEmpty())
            return;
        for (TrieNode child : root.getChildren().values()) {
            helper(child, list, curr.append(child.getC()));
            curr.setLength(curr.length() - 1);
        }
    }
    public List<String> prediction(String prefix) {
        List<String> list = new ArrayList<>();
        TrieNode lastNode = root;
        StringBuffer curr = new StringBuffer();
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.getChildren().get(c);
            if (lastNode == null)
                return list;
            curr.append(c);
        }
        helper(lastNode, list, curr);
        return list;
    }
    //-----ACCESSORS & MUTATORS
    public TrieNode getRoot() {
        return root;
    }
    public void setRoot(TrieNode root) {
        this.root = root;
    }
}