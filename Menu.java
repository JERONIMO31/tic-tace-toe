import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * A class modelling a Menu using a GUI.
 *
 * @author Jeronimo Cumming
 * @version April 07, 2024
 */
public class Menu  implements ActionListener
{
    // instance variables - replace the example below with your own
    JFrame frame = new JFrame();
    public String State;
    public JMenuBar Bar = new JMenuBar();
    public JMenuItem[] Item = new JMenuItem[2];
    public JMenu Menu = new JMenu("Menu");
    public TicTacToe I ;
    /**
     * Constructor for objects of class Menu
     */
    public Menu()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        Bar = new JMenuBar();
        Bar.add(Menu);
        frame.setJMenuBar(Bar);
        for (int i =0 ; i<2 ;i++){
            Item[i] = new JMenuItem();
            Item[i].addActionListener(this);
            Item[i].setFocusable(false);
            Item[i].setFont(new Font("Times New Roman", Font.BOLD, 10));
            if (i ==0){
                Item[i].setText("New");
            }
            else{
                Item[i].setText("Quit");
            }
            Menu.add(Item[i]);
        }
    }
    @Override
    public void actionPerformed(ActionEvent Act){
        JMenuItem clicked = (JMenuItem)Act.getSource(); 
        if (clicked.getText().equals("New")){
            new TicTacToe(); 
        }
        else{
             System. exit(0);
        }
    }
}
