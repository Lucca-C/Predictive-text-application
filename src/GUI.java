import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class GUI {

    private final JButton goBackFromDictionary = new JButton("Go Back");
    private final JButton goBackFromOptions = new JButton("Go Back");
    private final JTextField textBox = new JTextField(30);
    private final JFrame window = new JFrame("Predictive Text");
    private final JPanel mainMenuPanel = new JPanel();
    private final JPanel dictionaryPanel = new JPanel();
    private final JPanel optionsPanel = new JPanel();
    JButton firstPrediction = new JButton();
    JButton secondPrediction = new JButton();

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
        window.setLocationRelativeTo(null);
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
                dictionaryPanel.add(goBackFromDictionary);
                textBox.setAlignmentX(Component.LEFT_ALIGNMENT);
                dictionaryPanel.add(textBox);
                window.add(dictionaryPanel);
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

    }

    /*
     * Method to create the Dictionary window
     */
    public void createDictionary(){
        /*
         * Setting "Go Back" button position and adding it to the frame
         */


        goBackFromDictionary.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dictionaryPanel.setVisible(false);
                mainMenuPanel.setVisible(true);

            }
        });

        textBox.getDocument().addDocumentListener(new MyDocumentListener());



    }

    class MyDocumentListener implements DocumentListener {

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

        String string = textBox.getText();
        Dictionary dictionary = new Dictionary();
        Trie t = new Trie(dictionary.getWords());
        PredictiveText predictive = new PredictiveText(t);
        System.out.println(predictive.prediction(string));

        firstPrediction.setText(predictive.prediction(string).get(0));
        secondPrediction.setText(predictive.prediction(string).get(1));
        firstPrediction.setAlignmentX(Component.LEFT_ALIGNMENT);
        secondPrediction.setAlignmentX(Component.RIGHT_ALIGNMENT);
        dictionaryPanel.add(firstPrediction);
        dictionaryPanel.add(secondPrediction);
        dictionaryPanel.setVisible(true);

    }

}