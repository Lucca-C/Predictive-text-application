import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    //-----FIELDS-----
    private Map<Character, TrieNode> children;
    private char c;
    private boolean isWord;

    //-----CONSTRUCTORS-----

    /**
     * Constructor that is called recursively .
     * @param c
     */
    public TrieNode(char c) {
        this.c = c;
        children = new HashMap<>();
    }

    /**
     * Constructor that is called once to make the root.
     */
    public TrieNode() {
        children = new HashMap<>();
    }

    //-----METHODS-----
    /**
     * Saves first letter of string.
     * Checks if said letter is in the node's hashmap.
     * If not, make a new node and save it in the hashmap,
     * with the letter as the key.
     * If yes, and if the word is not 1 character long,
     * recursively call this method for the child.
     * If it is 1 character long,
     * Set "isWord" to true.
     * @param word
     */
    public void insert(String word) {
        if (word == null || word.isEmpty())
            return;
        char firstChar = word.charAt(0);
        TrieNode child = children.get(firstChar);
        if (child == null) {
            child = new TrieNode(firstChar);
            children.put(firstChar, child);
        }
        if (word.length() > 1)
            child.insert(word.substring(1));
        else
            child.isWord = true;
    }

    //-----ACCESSORS & MUTATORS-----
    public Map<Character, TrieNode> getChildren() {
        return children;
    }
    public void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }
    public char getC() {
        return c;
    }
    public void setC(char c) {
        this.c = c;
    }
    public boolean isWord() {
        return isWord;
    }
    public void setWord(boolean word) {
        isWord = word;
    }
}