import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class GUI {

    /*
     * Initialise variables
     */
    private final JButton goBackFromDictionary = new JButton("Go Back");
    private final JButton goBackFromOptions = new JButton("Go Back");
    private final JTextField textBox = new JTextField(50);
    private final JFrame window = new JFrame("Predictive Text");
    private final JPanel mainMenuPanel = new JPanel();
    private final JPanel dictionaryPanel = new JPanel();
    private final JPanel optionsPanel = new JPanel();
    JButton firstPrediction;
    JButton secondPrediction;
    JButton thirdPrediction;
    int index = 0;

    /*
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {

        GUI gui = new GUI();
        gui.createMainMenu();
        gui.createDictionary();
        gui.createOptions();

    }

    /*
     * Method to create the Main Menu Frame
     */
    public void createMainMenu(){

        /*
         * Setting size and default close operation
         */
        dictionaryPanel.setVisible(false);
        optionsPanel.setVisible(false);
        mainMenuPanel.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);


        window.add(dictionaryPanel);

        window.add(optionsPanel);


        /*
         * Handling when "Start" button is clicked
         */
        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                /*
                 * Make the Main Menu invisible
                 */
                mainMenuPanel.setVisible(false);
                dictionaryPanel.setVisible(true);

            }
        });

        /*
         * Setting "Start" button position and adding it to the frame
         */
        start.setBounds(360, 190, 80, 40);
        mainMenuPanel.add(start);

        /*
         * Handling when "Options" button is clicked
         */
        JButton options = new JButton("Options");
        options.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                mainMenuPanel.setVisible(false);
                optionsPanel.add(goBackFromOptions);
                textBox.setAlignmentX(Component.LEFT_ALIGNMENT);
                window.add(optionsPanel);
                optionsPanel.setVisible(true);

            }
        });

        /*
         * Setting "Options" button position and adding it to the frame
         */
        options.setBounds(360, 240, 80, 40);
        mainMenuPanel.add(options);


        /*
         * Handling when "Exit" button is clicked
         */
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }
        });

        /*
         * Setting "Exit" button position and adding it to the frame
         */
        exit.setBounds(360, 290, 80, 40);
        mainMenuPanel.add(exit);
        mainMenuPanel.setVisible(true);
        window.add(mainMenuPanel);
        window.setVisible(true);
        window.setLocationRelativeTo(null);

    }

    /*
     * Method to create the Dictionary window
     */
    public void createDictionary(){

        dictionaryPanel.setLayout(new BorderLayout());
        dictionaryPanel.add(goBackFromDictionary, BorderLayout.NORTH);
        dictionaryPanel.add(textBox, BorderLayout.SOUTH);
        //dictionaryPanel.add(textArea);
        //textArea.setAlignmentX(300);
        //textArea.setAlignmentY(300);

        firstPrediction = new JButton(" ");
        secondPrediction = new JButton(" ");
        thirdPrediction = new JButton(" ");

        dictionaryPanel.add(firstPrediction, BorderLayout.CENTER);
        dictionaryPanel.add(secondPrediction, BorderLayout.WEST);
        dictionaryPanel.add(thirdPrediction, BorderLayout.EAST);

        window.add(dictionaryPanel);
        window.setVisible(true);

        goBackFromDictionary.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dictionaryPanel.setVisible(false);
                mainMenuPanel.setVisible(true);

            }
        });

        textBox.getDocument().addDocumentListener(new MyDocumentListener());

        firstPrediction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index = 0;
                completeWord(index);
            }
        });

        secondPrediction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index = 1;
                completeWord(index);
            }
        });

        thirdPrediction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index = 2;
                completeWord(index);
            }
        });

    }

    class MyDocumentListener implements DocumentListener {

        /*
         * Continuous check for if a letter is added or removed in the text field
         * @param e
         */
        public void insertUpdate(DocumentEvent e) {
            checkTextBox();
        }
        public void removeUpdate(DocumentEvent e) {
            checkTextBox();
        }
        public void changedUpdate(DocumentEvent e) {

        }

    }

    public void createOptions(){

        goBackFromOptions.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                optionsPanel.setVisible(false);
                mainMenuPanel.setVisible(true);

            }
        });

    }

    public void checkTextBox(){

        /*
         * Get the contents of the text-box as a String
         */
        String text = textBox.getText();

        /*
         * Split the string by blank spaces
         */
        String[] splitString = text.split(" ");

        /*
         * lastWord here is the uncompleted word we want
         * to check against the dictionary of completed words
         */
        String lastWord = splitString[splitString.length - 1];
        Dictionary dictionary = new Dictionary();
        Trie t = new Trie(dictionary.getWords());
        PredictiveText predictive = new PredictiveText(t);


        try {

            /*
             * Set the button label to the predicted word
             */
            firstPrediction.setText(predictive.prediction(lastWord).get(0));

        }

        catch (IndexOutOfBoundsException e){

        }

        try {

            secondPrediction.setText(predictive.prediction(lastWord).get(1));

        }

        catch (IndexOutOfBoundsException e){

        }

        try {

            thirdPrediction.setText(predictive.prediction(lastWord).get(2));

        }

        catch (IndexOutOfBoundsException e){

        }
        dictionaryPanel.setVisible(true);

    }

    public void completeWord(int index){

        /*
         * Get two strings from the text-box, one will be to find the
         * last word (uncompleted word) in the text field, the other the
         * contents of the text-box without the last word
         */
        String textBoxOne = textBox.getText();
        String textBoxTwo = textBox.getText();

        /*
         * Split the string into an array using blank spaces
         */
        String[] splitString = textBoxOne.split(" ");

        /*
         * lastWord is the last element in the array
         */
        String lastWord = splitString[splitString.length - 1];

        /*
         * Using the found last word, replace this with nothing so
         * when the text-box text is set, it doesn't contain an
         * uncompleted word
         */
        textBoxTwo = textBoxTwo.replaceAll(lastWord, "");
        Dictionary dictionary = new Dictionary();
        Trie t = new Trie(dictionary.getWords());
        PredictiveText predictive = new PredictiveText(t);

        try{

            /*
             * Set the text-box to be all words already contained in it,
             * plus the new completed word
             */
        textBox.setText(textBoxTwo + predictive.prediction(lastWord).get(index) + " ");
            /*
             * Return focus to the text-box so user doesn't have to
             * click it every time
             */
        textBox.requestFocus();

        } catch (IndexOutOfBoundsException e) {

        }

    }
    public void completeWord2(){

        String textBoxOne = textBox.getText();
        String textBoxTwo = textBox.getText();

        String[] splitString = textBoxOne.split(" ");

        String lastWord = splitString[splitString.length - 1];

        textBoxTwo = textBoxTwo.replaceAll(lastWord, "");
        Dictionary dictionary = new Dictionary();
        Trie t = new Trie(dictionary.getWords());
        PredictiveText predictive = new PredictiveText(t);

        try{

            textBox.setText(textBoxTwo + predictive.prediction(lastWord).get(1) + " ");
            textBox.requestFocus();

        } catch (IndexOutOfBoundsException e) {

        }

    }
    public void completeWord3(){

        String textBoxOne = textBox.getText();
        String textBoxTwo = textBox.getText();

        String[] splitString = textBoxOne.split(" ");

        String lastWord = splitString[splitString.length - 1];

        textBoxTwo = textBoxTwo.replaceAll(lastWord, "");
        Dictionary dictionary = new Dictionary();
        Trie t = new Trie(dictionary.getWords());
        PredictiveText predictive = new PredictiveText(t);

        try{

            textBox.setText(textBoxTwo + predictive.prediction(lastWord).get(2) + " ");
            textBox.requestFocus();

        } catch (IndexOutOfBoundsException e) {

        }
    }
}