import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyGUI {

    /**
     * Initialising the buttons
     */
    private JButton start = new JButton("Start");
    private JButton options = new JButton("Options");
    private JButton exit = new JButton("Exit");

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String args[]) {

        new MyGUI();

    }

    /**
     * Constructor for frame and its components
     */
    public MyGUI() {

        /**
         * Creating the Main Menu Frame
         */
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        /**
         * Creating the Dictionary Program Frame
         */
        JFrame frame2 = new JFrame("Dictionary");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(800, 600);

        /**
         * Handling when "start" button is clicked
         */
        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                frame2.setLocationRelativeTo(null);
                frame.setVisible(false);
                frame2.setVisible(true);

            }

        });

        /**
         * Setting its position and add it to the frame
         */
        start.setBounds(360, 190, 80, 40);
        frame.add(start);

        /**
         * Handling when "options" button is clicked
         */
        options.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Options");

            }

        });

        /**
         * Setting its position and add it to the frame
         */
        options.setBounds(360, 240, 80, 40);
        frame.add(options);

        /**
         * Handling when "exit" button is clicked
         */
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }

        });

        /**
         * Setting its position and add it to the frame
         */
        exit.setBounds(360, 290, 80, 40);
        frame.add(exit);

        /**
         * Set GUI to open in the centre of the screen and make it visible
         */
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}