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
    public List<String> prediction(String target) {
        List<String> list = new ArrayList<>();
        TrieNode lastNode = trie.getRoot();
        StringBuffer current = new StringBuffer();
        for (char c : target.toCharArray()) {
            lastNode = lastNode.getChildren().get(c);
            if (lastNode == null)
                return list;
            current.append(c);
        }
        helper(lastNode, list, current);
        return list;
    }

    private boolean find(String target, boolean specific) {
        TrieNode lastNode = trie.getRoot();
        for (char c : target.toCharArray()) {
            lastNode = lastNode.getChildren().get(c);
            if (lastNode == null)
                return false;
        }
        return !specific || lastNode.isWord();
    }

    public boolean find(String target) {
        return find(target, false);
    }

    private void helper(TrieNode root, List<String> list, StringBuffer current) {
        if (root.isWord()) {
            list.add(current.toString());
        }
        if (root.getChildren() == null || root.getChildren().isEmpty())
            return;
        for (TrieNode child : root.getChildren().values()) {
            helper(child, list, current.append(child.getC()));
            current.setLength(current.length() - 1);
        }
    }
    //-----ACCESSORS & MUTATORS-----
    public Trie getTrie() {
        return trie;
    }
    public void setTrie(Trie trie) {
        this.trie = trie;
    }
}
