import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class GUI {

    private final JButton goBack = new JButton("Go Back");
    private final JPanel dictionaryPanel = new JPanel();
    private final JTextField textBox = new JTextField(30);

    /*
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {

        new GUI();

    }

    /*
     * Constructor for frame and its components
     */
    public GUI() {

        /*
         * Creating the different frames within GUI
         */
        JFrame mainMenuFrame = new JFrame("Main Menu");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(800, 600);

        JFrame dictionaryFrame = new JFrame("Dictionary");
        dictionaryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dictionaryFrame.setSize(800, 600);

        JFrame optionsFrame = new JFrame("Options");
        optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        optionsFrame.setSize(800, 600);

        /*
         * Handling when "Go Back" button is pressed
         */
        goBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dictionaryFrame.setLocationRelativeTo(null);
                mainMenuFrame.setVisible(true);
                dictionaryFrame.setVisible(false);

            }
        });

        /*
         * Setting "Go Back" button position and adding it to the frame
         */
        goBack.setBounds(10, 10, 80, 40);


        /*
         * Handling when "Start" button is clicked
         */
        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dictionaryFrame.setLocationRelativeTo(null);
                mainMenuFrame.setVisible(false);
                dictionaryFrame.add(goBack);
                dictionaryPanel.add(textBox);
                dictionaryFrame.add(dictionaryPanel);
                dictionaryFrame.setVisible(true);

            }
        });

        /*
         * Setting "Start" button position and adding it to the frame
         */
        start.setBounds(360, 190, 80, 40);
        mainMenuFrame.add(start);

        /*
         * Handling when "Options" button is clicked
         */
        JButton options = new JButton("Options");
        options.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                optionsFrame.setLocationRelativeTo(null);
                mainMenuFrame.setVisible(false);
                optionsFrame.add(goBack);
                optionsFrame.setVisible(true);

            }
        });

        /*
         * Setting "Options" button position and adding it to the frame
         */
        options.setBounds(360, 240, 80, 40);
        mainMenuFrame.add(options);

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
        mainMenuFrame.add(exit);

        /*
         * Set GUI to open in the centre of the screen and make it visible
         */
        mainMenuFrame.setLayout(null);
        mainMenuFrame.setLocationRelativeTo(null);
        mainMenuFrame.setVisible(true);

    }
}