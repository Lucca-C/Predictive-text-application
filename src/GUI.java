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
    private final JTextField textBox = new JTextField(70);
    private final JFrame window = new JFrame("Predictive Text");
    private final JPanel mainMenuPanel = new JPanel();
    private final JPanel dictionaryPanel = new JPanel();
    private final JPanel settingsPanel = new JPanel();
    private final JPanel languageSettingsPanel = new JPanel();
    JButton firstPrediction;
    JButton secondPrediction;
    JButton thirdPrediction;
    JButton selectLanguage;
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
        settingsPanel.setVisible(false);
        mainMenuPanel.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);


        window.add(dictionaryPanel);

        window.add(settingsPanel);


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
        mainMenuPanel.add(start);

        /*
         * Handling when "Settings" button is clicked
         */
        JButton options = new JButton("Settings");
        options.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                mainMenuPanel.setVisible(false);
                textBox.setAlignmentX(Component.LEFT_ALIGNMENT);
                window.add(settingsPanel);
                settingsPanel.setVisible(true);

            }
        });

        /*
         * Setting "Settings" button position and adding it to the frame
         */
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

        dictionaryPanel.add(goBackFromDictionary, BorderLayout.NORTH);
        dictionaryPanel.add(textBox, BorderLayout.CENTER);

        firstPrediction = new JButton(" ");
        secondPrediction = new JButton(" ");
        thirdPrediction = new JButton(" ");

        dictionaryPanel.add(firstPrediction, BorderLayout.SOUTH);
        dictionaryPanel.add(secondPrediction, BorderLayout.SOUTH);
        dictionaryPanel.add(thirdPrediction, BorderLayout.SOUTH);

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

        selectLanguage = new JButton("Select Language");
        settingsPanel.add(goBackFromOptions);
        settingsPanel.add(selectLanguage);
        window.add(dictionaryPanel);
        window.setVisible(true);

        goBackFromOptions.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                settingsPanel.setVisible(false);
                mainMenuPanel.setVisible(true);

            }
        });

        selectLanguage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            settingsPanel.setVisible(false);
            languageSettingsPanel.setVisible(true);

            }
        });

    }

    public void createLanguageSettings(){

        Dictionary dictionary = new Dictionary();

        JButton english, englishExtended, german, spanish, french;
        english = new JButton("English");
        englishExtended = new JButton("English Extended");
        german = new JButton("German");
        spanish = new JButton("Spanish");
        french = new JButton("French");

        languageSettingsPanel.add(english);
        languageSettingsPanel.add(english);
        languageSettingsPanel.add(english);
        window.add(dictionaryPanel);
        window.setVisible(true);

        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               dictionary.selectDictionary(1,"0");

            }
        });

        englishExtended.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dictionary.selectDictionary(2,"0");

            }
        });

        german.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dictionary.selectDictionary(3,"0");

            }
        });

        spanish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dictionary.selectDictionary(4,"0");

            }
        });

        french.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dictionary.selectDictionary(5,"0");

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
}