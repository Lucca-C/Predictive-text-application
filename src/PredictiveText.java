import java.util.ArrayList;
import java.util.List;

public class PredictiveText {
    //-----FIELDS-----
    private Trie trie;


    //-----CONSTRUCTORS-----
    public PredictiveText(Trie trie){
        this.trie = trie;
    }

    //-----METHODS-----
    private boolean find(String target, boolean specific) {
        TrieNode lastNode = trie.getRoot();
        for (char c : target.toCharArray()) {
            lastNode = lastNode.getChildren().get(c);
            if (lastNode == null)
                return false;
        }
        return !specific || lastNode.isWord();
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
    public List<String> prediction(String target) {
        List<String> list = new ArrayList<>();
        TrieNode lastNode = trie.getRoot();
        StringBuffer curr = new StringBuffer();
        for (char c : target.toCharArray()) {
            lastNode = lastNode.getChildren().get(c);
            if (lastNode == null)
                return list;
            curr.append(c);
        }
        helper(lastNode, list, curr);
        return list;
    }
    //-----ACCESSORS & MUTATORS-----
    public Trie getTrie() {
        return trie;
    }
    public void setTrie(Trie trie) {
        this.trie = trie;
    }
}
