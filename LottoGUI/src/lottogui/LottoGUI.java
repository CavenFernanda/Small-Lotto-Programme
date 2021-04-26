/**
 * LottoGUI.java
 * Small Lotto programme that saves generated numbers into text file
 * @author Caven Fernanda
 * Date: Monday, 20 April 2021
 */

package lottogui;

// STEP 0: Add relevant packages only
import java.awt.*;	// use the wildcard * to include all subclasses
import javax.swing.*;	
import java.awt.event.*;    // for event handlers
import java.util.Arrays;

public class LottoGUI implements ActionListener {
    // STEP 1: Declare variables
    private final Frame f;
    private final Panel pW, pE, pS, pC;
    private final Button bR, bS, bC;
    private final TextField w1, w2, w3, w4, w5, w6, e1, e2, e3, e4, e5, e6;
    private final JLabel j;
    private final Font ft, ft2;
    private final MenuBar mb;
    private final Menu mO, mH;
    private final MenuItem miR, miS, miC;
    
    // STEP 2: Instantiate all the instance variables in the constructor
    public LottoGUI() {
        f = new Frame("Java Lotto");
        pW = new Panel();
        pE = new Panel();
        pS = new Panel();
        pC = new Panel();
        bR = new Button("RUN");
        bS = new Button("SAVE");
        bC = new Button("CLEAR");
        w1 = new TextField();
        w2 = new TextField();
        w3 = new TextField();
        w4 = new TextField();
        w5 = new TextField();
        w6 = new TextField();
        e1 = new TextField();
        e2 = new TextField();
        e3 = new TextField();
        e4 = new TextField();
        e5 = new TextField();
        e6 = new TextField();
        j = new JLabel(new ImageIcon("duke.running.gif"));
        ft = new Font("Arial", Font.BOLD | Font.ITALIC, 16);
        ft2 = new Font("Arial", Font.BOLD, 14);         // We will use this font later
        
        mb = new MenuBar();
        mO = new Menu("Options");
        mH = new Menu("Help");
        
        miR = new MenuItem("RUN");
        miS = new MenuItem("SAVE");
        miC = new MenuItem("CLEAR");
        
        
        //fonts
        bR.setForeground(Color.yellow);
        bR.setBackground(Color.blue);
        bR.setFont(ft);
        bS.setForeground(Color.yellow);
        bS.setBackground(Color.red);
        bS.setFont(ft);
        bC.setForeground(Color.black);
        bC.setBackground(Color.green);
        bC.setFont(ft);
    }
    
    // STEP 3: Now lets set up the GUI
    public void setGUI() {
        pW.setLayout(new GridLayout(6, 1));
        pE.setLayout(new GridLayout(6, 1));
        pS.setLayout(new GridLayout(1, 3));
        pS.add(bR);
        pS.add(bS);
        pS.add(bC);
        pW.add(w1);
        pW.add(w2);
        pW.add(w3);
        pW.add(w4);
        pW.add(w5);
        pW.add(w6);
        pE.add(e1);
        pE.add(e2);
        pE.add(e3);
        pE.add(e4);
        pE.add(e5);
        pE.add(e6);
        pC.add(j);
        mb.add(mO);
        mb.setHelpMenu(mH);
        mO.add(miR);
        mO.add(miS);
        mO.addSeparator();
        mO.add(miC);
        f.setMenuBar(mb);
        f.add(pW, BorderLayout.WEST);
        f.add(pE, BorderLayout.EAST);
        f.add(pS, BorderLayout.SOUTH);
        f.add(pC, BorderLayout.CENTER);
        
        // STEP 4: Lets add action listeners onto our gui components
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });

        // To get the random numbers printed
        bR.addActionListener(this);
        bC.addActionListener(this);
        bS.addActionListener(this);
        miR.addActionListener(this);
        miS.addActionListener(this);
        miC.addActionListener(this);
        f.pack();	// f.setSize(400, 400);
        f.show();	// f.setVisible(true);
    }
    
    // STEP 5: Almost done: Writing code for the button when events are triggered
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("RUN")) {
            GenerateNumbers.populateValues();
            // u can change the text color, font, style, etc
            w1.setBackground(Color.orange);
            w2.setBackground(Color.orange);
            w3.setBackground(Color.orange);
            w4.setBackground(Color.orange);
            w5.setBackground(Color.orange);
            w6.setBackground(Color.orange);
            e1.setBackground(Color.yellow);
            e2.setBackground(Color.yellow);
            e3.setBackground(Color.yellow);
            e4.setBackground(Color.yellow);
            e5.setBackground(Color.yellow);
            e6.setBackground(Color.yellow);

            w1.setFont(ft2);
            w2.setFont(ft2);
            w3.setFont(ft2);
            w4.setFont(ft2);
            w5.setFont(ft2);
            w6.setFont(ft2);
            e1.setFont(ft2);
            e2.setFont(ft2);
            e3.setFont(ft2);
            e4.setFont(ft2);
            e5.setFont(ft2);
            e6.setFont(ft2);
            
            w1.setText(String.valueOf(GenerateNumbers.numbers[0]));
            w2.setText(String.valueOf(GenerateNumbers.numbers[1]));
            w3.setText(String.valueOf(GenerateNumbers.numbers[2]));
            w4.setText(String.valueOf(GenerateNumbers.numbers[3]));
            w5.setText(String.valueOf(GenerateNumbers.numbers[4]));
            w6.setText(String.valueOf(GenerateNumbers.numbers[5]));
            Arrays.sort(GenerateNumbers.numbers);
            e1.setText(String.valueOf(GenerateNumbers.numbers[0]));
            e2.setText(String.valueOf(GenerateNumbers.numbers[1]));
            e3.setText(String.valueOf(GenerateNumbers.numbers[2]));
            e4.setText(String.valueOf(GenerateNumbers.numbers[3]));
            e5.setText(String.valueOf(GenerateNumbers.numbers[4]));
            e6.setText(String.valueOf(GenerateNumbers.numbers[5]));
        }
        else if (e.getActionCommand().equals("CLEAR")) {
            w1.setText("");
            w2.setText("");
            w3.setText("");
            w4.setText("");
            w5.setText("");
            w6.setText("");
            e1.setText("");
            e2.setText("");
            e3.setText("");
            e4.setText("");
            e5.setText("");
            e6.setText("");
        }
        else if (e.getActionCommand().equals("SAVE")) {
            SaveNumbers.storeValues(GenerateNumbers.numbers);
        }
    }

    // STEP 8: Coding the main function
    public static void main(String[] args) {
        /* LottoGUI y = new LottoGUI();
        y.setGUI(); */
        new LottoGUI().setGUI();             // calling an anonymous object
    }
    
    // STEP 9: Final step, hit 'Run Project' in Netbeans
}
