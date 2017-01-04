import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
public class Connect4 extends JFrame {
    private Container pane;
    private JButton[] a;
    private JLabel[][] ary;
    private JLabel turnLabel;
    public int turn;
    private JTextField turnCount;
    public Connect4(){
	turn = 1;
        this.setTitle("Connect4");
        this.setSize(600, 400);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new GridLayout(8, 6));
        a = new JButton[7];
	for (int i = 0; i < 7; i++){
	    a[i] = new JButton(""+(i + 1)+"");
	    pane.add(a[i]);
	}
        ary = new JLabel[6][7];
	for (int r = 0; r < 6; r++){
	    for (int c = 0; c < 7; c++){
		ary[r][c] = new JLabel();
		ary[r][c].setHorizontalAlignment(SwingConstants.CENTER);
		ary[r][c].setBorder(new LineBorder(Color.black));
		pane.add(ary[r][c]);
	    }  
    }
	turnLabel = new JLabel("Player Turn");
	pane.add(turnLabel);
	turnCount = new JTextField(turn);
	pane.add(turnCount);
    }

     
    public static void main(String[]args){
	Connect4 z = new Connect4();
	z.setVisible(true);
    }
}

















