import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * A class modelling a tic-tac-toe game using a GUI.
 *
 * @author Jeronimo Cumming
 * @version April 07, 2024
 */
public class TicTacToe implements ActionListener {
    // instance variables - replace the example below with your own
    private int Numfree;
    public String State;
    public static final String PlayerX = "X";
    public static final String PlayerO = "O";
    public static final String Empty = " ";  // empty cell
    public static final String Tie = "T";// game ended in a tie
    private String current_player;
    private String winner;
    JFrame frame = new JFrame();
    JPanel game_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JPanel menu_button_panel = new JPanel();
    JPanel state_panel = new JPanel();
    JLabel game_title = new JLabel();
    JLabel game_state = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton[] menu_buttons = new JButton[2];
    public boolean Gameover ;
    private JMenuItem newMenuItem;
    private JMenuItem quitMenuItem;
    /**
     * Constructor for objects of class TicTacToe
     */
    public TicTacToe()
    {
        winner = Empty;
        current_player = PlayerX;
        Numfree = 9;
        Gameover = false;
        
        /**if (GameMenu()){*/
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600,600);
            frame.getContentPane().setBackground(new Color(0,153,153));
            frame.setLayout(new BorderLayout());
            frame.setVisible(true);
            game_state.setBackground(new Color(255,255,255));
            game_state.setForeground(new Color(0,153,153));
            game_state.setFont(new Font("Times New Roman",Font.BOLD,15));
            game_state.setHorizontalAlignment(JLabel.CENTER);
            game_state.setText(toString());
            game_panel.setLayout(new BorderLayout());
            game_panel.setBounds(0,0,400,100);
            game_title.setBackground(new Color(255,255,255));
            game_title.setForeground(new Color(0,153,153));
            game_title.setFont(new Font("Times New Roman",Font.BOLD,40));
            game_title.setHorizontalAlignment(JLabel.CENTER);
            game_title.setText("TicTacToe");
            state_panel.setLayout(new BorderLayout());
            game_panel.setBounds(0,0,400,100);
            button_panel.setLayout(new GridLayout(3,3));
            button_panel.setBackground(new Color(0,153,153));
            for(int i = 0; i<9; i++){
                buttons[i] = new JButton();
                button_panel.add(buttons[i]);
                buttons[i].addActionListener(this);
                buttons[i].setFocusable(false);
                buttons[i].setFont(new Font("Times New Roman", Font.BOLD, 140));
                buttons[i].setText(Empty);
            }
            game_panel.add(game_title);
            state_panel.add(game_state);
            frame.add(game_panel,BorderLayout.NORTH);
            frame.add(state_panel, BorderLayout.SOUTH);
            frame.add(button_panel);
    }
    @Override
    public void actionPerformed(ActionEvent Action) {
        JButton clicked = (JButton)Action.getSource();
        if (current_player.equals(PlayerX)){
            if (clicked.getText().equals(Empty)){
                clicked.setText(PlayerX);
                Numfree -= 1;
                Win(PlayerX);
                current_player = PlayerO; // Switches to next player
                game_state.setText(GameState()); //Display's turn
            }
        }
        else  if (current_player.equals(PlayerO)){
            if (clicked.getText().equals(Empty)){
                clicked.setText(PlayerO);
                Numfree -= 1;
                Win(PlayerX);
                current_player = PlayerX; // Switches to next player
                game_state.setText(GameState()); //Display's turn
            }
        }
    }
    private void Win(String PLAYER){
        // unless at least 5 squares have been filled, we don't need to go any further
        
        // (the earliest we can have a winner is after player X's 3rd move).
        
        // check row 1
        if (buttons[0].getText() == buttons[1].getText() &&buttons[1].getText() == buttons[2].getText() &&!buttons[0].getText().equals(Empty)){
            Gameover  = true;}
        // check row 2
        if (buttons[3].getText() == buttons[4].getText() &&buttons[4].getText() == buttons[5].getText() &&!buttons[3].getText().equals(Empty)) {
            Gameover =  true; }   
        // check row 3
        if (buttons[6].getText() == buttons[7].getText() &&buttons[7].getText() == buttons[8].getText() &&!buttons[6].getText().equals(Empty)) { 
            Gameover =  true;}
        // check column 1
        if (buttons[0].getText() == buttons[3].getText() &&buttons[3].getText() == buttons[6].getText() &&!buttons[0].getText().equals(Empty)) {
            Gameover =  true;}
        // check column 2
        if (buttons[1].getText() == buttons[4].getText() &&buttons[4].getText() == buttons[7].getText() &&!buttons[1].getText().equals(Empty)) {
            Gameover =  true;}
        // check column 3
        if (buttons[2].getText() == buttons[5].getText() &&buttons[5].getText() == buttons[8].getText() &&!buttons[2].getText().equals(Empty)) {
            Gameover = true;}
        // check a diagonal
        if (buttons[0].getText() == buttons[4].getText() &&buttons[4].getText() == buttons[8].getText() &&!buttons[0].getText().equals(Empty)) {
            Gameover = true;}
        // check the other diagonal
        if (buttons[2].getText() == buttons[4].getText() && buttons[4].getText() == buttons[6].getText() &&!buttons[2].getText().equals(Empty)) {
            Gameover =  true;}
        // no winner yet
        if (Gameover == true){
            winner = PLAYER;
                    for (int i=0; i<9; i++) {
                        buttons[i].setEnabled(false);
                    }
        } else if (Numfree == 0) {
                winner = Tie;
                for (int i=0; i<9; i++) {
                    buttons[i].setEnabled(false);
                }
            }
    }
    public String GameState () 
    {
        if(winner.equals(Empty) && Numfree != 0) {
            State = "Games is in progress: it's player " + current_player + "'s turn.";
        } else if(!winner.equals(Empty)) {
            if(winner.equals(Tie)) {
                State = "Game Over No One Won WOMP WOMP!!!!!!";
            } else {
                State = "Game Over Player " + current_player + " Won!!!!"; 
            }
        }
        return State;
    }
}
