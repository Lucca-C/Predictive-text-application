public class Tester {
    public static void main(String[] args){
       testPrediction();
    }
    public static void testPrediction(){
        Dictionary d = new Dictionary(1);
        Trie t = new Trie(d.getWords());
        PredictiveText p = new PredictiveText(t, 1);
        System.out.println(p.prediction("p"));
    }
    public static void testGUI(){
        GUI gui = new GUI();
        gui.createMainMenu();
        gui.createDictionary();
        gui.createOptions();
    }
}
