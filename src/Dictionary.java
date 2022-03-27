import java.util.List;

public class Dictionary {
    //-----FIELDS-----
   private  List<String> words = List.of("w", "hello", "dog", "hell", "cat", "a", "hel","help","helps","helping",
            "potato", "porr", "wack");
    //-----CONSTRUCTORS-----
    //-----METHODS-----
    public void print(){
        for (String word : words){
            System.out.print(word);
            System.out.print(", ");
        }
    }
    //-----ACCESSORS & MUTATORS-----
    public List<String> getWords() {
        return words;
    }
    public void setWords(List<String> words) {
        this.words = words;
    }

}
