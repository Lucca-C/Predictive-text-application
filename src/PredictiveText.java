import java.util.ArrayList;
import java.util.List;

public class PredictiveText {
    //-----FIELDS-----
    private Trie trie;
    private int listMax;


    //-----CONSTRUCTORS-----

    /**
     *
     * @param trie data structure containing nodes, which contain hashmaps
     * @param listMax integer which dictates max number of words output
     */
    public PredictiveText(Trie trie, int listMax){
        this.listMax = listMax;
        this.trie = trie;
    }

    //-----METHODS-----

    /**
     * Takes every letter of target and appends it to a StringBuffer
     * Traverses down nodes
     * Calls recursive method
     * @param target word to compare trie words with
     * @return arrayList, containing the words most similar to target
     */
    public List<String> prediction(String target) {
        List<String> list = new ArrayList<>();
        Node lastNode = trie.getRoot();
        StringBuffer current = new StringBuffer();
        for (char c : target.toCharArray()) {
            lastNode = lastNode.getChildren().get(c);
            if (lastNode == null)
                return list;
            current.append(c);
        }
        recursiveTraversal(lastNode, list, current);
        return list;
    }

    /**
     * Recursively traverses the trie and appends words to current
     * Calls isWord
     * @param root node of the trie
     * @param list list of similar words
     * @param current StringBuffer that contains the letters of target
     */
    private void recursiveTraversal(Node root, List<String> list, StringBuffer current) {
        isWord(root, list, current);
        if (root.getChildren() == null || root.getChildren().isEmpty() || list.size() == listMax)
            return;
        for (Node child : root.getChildren().values()) {
            recursiveTraversal(child, list, current.append(child.getC()));
            current.setLength(current.length() - 1);
        }
    }

    /**
     * Adds words to list, if the list isn't full
     * @param root node of trie
     * @param list containing words
     * @param current StringBuffer of letters
     */
    private void isWord(Node root, List<String> list, StringBuffer current){
        if (root.isWord()) {
            if (list.size() < listMax){
                list.add(current.toString());
            }
        }
    }
    //-----ACCESSORS & MUTATORS-----
    public Trie getTrie() {
        return trie;
    }
    public void setTrie(Trie trie) {
        this.trie = trie;
    }
    public int getListMax() {
        return listMax;
    }
    public void setListMax(int listMax) {
        this.listMax = listMax;
    }
}
