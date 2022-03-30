public class Tester {
    public static void main(String[] args){
       testPrediction();
    }
    public static void testPrediction(){
//        Dictionary d = new Dictionary();
//        d.selectDictionary(1);
//        Trie t = new Trie(d.getWords());
//        PredictiveText p = new PredictiveText(t, 1);
//        d.print();
        testGUI();

    }
    public static void testGUI(){

        GUI gui = new GUI();
        gui.createMainMenu();
        gui.createDictionary();
        gui.createSettings();
        gui.createLanguageSettings();
        gui.createAddToDictionary();

    }
}
