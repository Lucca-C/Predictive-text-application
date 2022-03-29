import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args){
        testPrediction();
    }

    public static void testPrediction(){
        Dictionary d = new Dictionary();
        Trie t = new Trie(d.getWords());
        PredictiveText p = new PredictiveText(t);
        System.out.println(p.prediction("p"));
    }
}
