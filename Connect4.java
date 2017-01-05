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
    private boolean win;
    private int boardColumn, boardRow;
    public Connect4(){
        boardRow = 10;
	boardColumn = 10;
	win = false;
	turn = 1;
        this.setTitle("Connect4");
        this.setSize(600, 400);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new GridLayout(boardRow + 2, boardColumn - 1));
        a = new JButton[boardColumn];
	for (int i = 0; i < boardColumn; i++){
	    a[i] = new JButton(""+(i + 1)+"");
            a[i].addActionListener(this);
            a[i].setActionCommand(""+(i + 1)+"");
	    pane.add(a[i]);
	}
        ary = new JLabel[boardRow][boardColumn];
	for (int r = 0; r < boardRow; r++){
	    for (int c = 0; c < boardColumn; c++){
		ary[r][c] = new JLabel();
		ary[r][c].setOpaque(true);
		ary[r][c].setHorizontalAlignment(SwingConstants.CENTER);
		ary[r][c].setBorder(new LineBorder(Color.black));
		ary[r][c].setBackground(Color.white);
		pane.add(ary[r][c]);
	    }  
    }
	turnLabel = new JLabel("Turn");
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
        for (int r = boardRow - 1; r >= 0; r--){
	    if (ary[r][co].getBackground() == Color.white){
		r0w = r;
		break;
	    }
	}
	return r0w;
    }

    public void clearBoard(){
	for (int r = 0; r < boardRow; r++){
	    for (int c = 0; c < boardColumn; c++){
		ary[r][c].setBackground(Color.white);
	    }
	}
    }
    
public void addChip(int col){
    Object[] newgame = {"New Game", "OK"};
    if (getRow(col) != -1){
	if (turn == 1){
	    ary[getRow(col)][col].setBackground(Color.blue);
	    turn = 2;
	    turnCount.setText(""+turn+"");
	    winCheck();
	    if (win == true){
		if (winCheck() == Color.blue){
		    int result = JOptionPane.showOptionDialog(null, "Player 1 (Blue) has won!", "Winner!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, newgame, null);
		if (result == JOptionPane.YES_OPTION){
		    clearBoard();
		    turn = 1;
                    turnCount.setText(""+turn+"");
		    win = false;
		}
		}
	        
		
	    }
	    if (drawCheck()){
		int result = JOptionPane.showOptionDialog(null, "Draw game!", "Draw", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, newgame, null);
		if (result == JOptionPane.YES_OPTION){
		    clearBoard();
		    turn = 1;
                     turnCount.setText(""+turn+"");
		    win = false;
		}

	    }
	}
	
	else{
            ary[getRow(col)][col].setBackground(Color.red);
		turn = 1;
		turnCount.setText(""+turn+"");
		winCheck();
		if (win == true){
		    if (winCheck() == Color.red){
                        int result = JOptionPane.showOptionDialog(null, "Player 2 (Red) has won!", "Winner", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, newgame, null);
		if (result == JOptionPane.YES_OPTION){
		    clearBoard();
		    turn = 1;
                    turnCount.setText(""+turn+"");
		    win = false;
		}
			
		    }}
		if (drawCheck()){
        int result = JOptionPane.showOptionDialog(null, "Draw game!", "Draw", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, newgame, null);
		if (result == JOptionPane.YES_OPTION){
		    clearBoard();
		    turn = 1;
                    turnCount.setText(""+turn+"");
		    win = false;
		}
	    }
	}
    }else{
	JOptionPane.showMessageDialog(null, "The column is full! Please pick another one.");
	    }
}

    public Color winCheck(){
	Color karma = Color.black;
	for (int r = 0; r < boardRow; r++){
	    for (int c = 0; c < boardColumn - 3; c++){
		if(ary[r][c].getBackground() != Color.white){
		    karma = ary[r][c].getBackground();
		    if ((ary[r][c + 1].getBackground() == karma) && (ary[r][c+2].getBackground() == karma) && (ary[r][c+3].getBackground() == karma)){
			win = true;
			return karma;
		    }
		}
	    }
	}
	for (int r = 0; r < boardRow - 3; r++){
	    for (int c = 0; c < boardColumn; c++){
		if (ary[r][c].getBackground() != Color.white){
		    karma = ary[r][c].getBackground();
		    if ((ary[r + 1][c].getBackground() == karma) && (ary[r+2][c].getBackground() == karma) && (ary[r+3][c].getBackground() == karma)){
			win = true;
			return karma;
		    }
		}
	    }
	}
	for (int r = 0; r < boardRow - 3; r++){
	    for (int c = 0; c < boardColumn - 3; c++){
		if (ary[r][c].getBackground() != Color.white){
		    karma = ary[r][c].getBackground();
		    if ((ary[r+1][c+1].getBackground() == karma) && (ary[r+2][c+2].getBackground() == karma) && (ary[r+3][c+3].getBackground() == karma)){
			win = true;
			return karma;
		    }
		}
	    }
	}
	for (int r = 3; r < boardRow; r++){
	    for (int c = 0; c < boardColumn - 3; c++){
		if (ary[r][c].getBackground() != Color.white){
		    karma = ary[r][c].getBackground();
		    if ((ary[r-1][c+1].getBackground() == karma) && (ary[r-2][c+2].getBackground() == karma) && (ary[r-3][c+3].getBackground() == karma)){
			win = true;
			return karma;
		    }
		}
	    }
	}
	return karma;
    }
			
    public boolean drawCheck(){
	boolean hi = true;
	for (int r = 0; r < boardRow; r++){
	    for (int c = 0; c < boardColumn; c++){
		if (ary[r][c].getBackground() == Color.white){
		    hi = false;
		}
	    }
	}
	return hi;
    }



     
    public static void main(String[]args){
	Connect4 z = new Connect4();
        z.setVisible(true);
    }

    
}

















