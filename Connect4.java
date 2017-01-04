import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
public class Connect4 extends JFrame implements ActionListener{
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
            a[i].addActionListener(this);
            a[i].setActionCommand(""+(i + 1)+"");
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
	turnCount = new JTextField(""+turn+"");
	pane.add(turnCount);
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
        if(event.equals("1")){
	    addChip(0);
		}
	else if(event.equals("2")){
	    addChip(1);
	}else if (event.equals("3")){
	    addChip(2);
	}else if (event.equals("4")){
	    addChip(3);
	}else if (event.equals("5")){
	    addChip(4);
	}else if (event.equals("6")){
	    addChip(5);
	}else if (event.equals("7")){
	    addChip(6);
	}
    }



		

    public int getRow(int co){
	int r0w = -1;
        for (int r = 0; r < 6; r++){
	    if (ary[r][co].getBackground() == null){
		r0w = r;
		break;
	    }
	}
	return r0w;
    }


    
public void addChip(int col){
    if (getRow(col) != -1){
	if (turn == 1){
	    this.ary[getRow(col)][col].setBackground(Color.blue);
		turn = 2;}
	else{
            this.ary[getRow(col)][col].setBackground(Color.red);
		turn = 1;}
    }else{
	JOptionPane.showMessageDialog(null, "The column is full");
	    }
}



     
    public static void main(String[]args){
	Connect4 z = new Connect4();
	z.setVisible(true);
    }

    
}

















