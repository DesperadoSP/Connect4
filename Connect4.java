import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
public class Connect4 extends JFrame implements ActionListener{
    private Container pane;
    private JButton[] a;
    private JLabel[][] ary;
    private JLabel turnLabel;
    public String turn;
    private JTextField turnCount;
    private boolean win;
    private int boardColumn, boardRow, winNeed;	
    public Connect4(int x, int y, int z){
	winNeed = z;
        boardRow = x;
	boardColumn = y;
	win = false;
	turn = "Blue";
        this.setTitle("Connect4");
        this.setSize(600, 400);
        this.setLocation(100, 200);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

        addChip(Integer.parseInt(event) - 1);

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
    Object[] newgame = {"New Game"};
    if (getRow(col) != -1){
	if (turn.equals("Blue")){
	    ary[getRow(col)][col].setBackground(Color.blue);
	    turn = "Red";
	    turnCount.setText(""+turn+"");
	    winCheck();
	    if (win == true){
		if (winCheck() == Color.blue){
		    int result = JOptionPane.showOptionDialog(null, "Player 1 (Blue) has won!", "Winner!", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, newgame, null);
		if (result == JOptionPane.YES_OPTION){
		    clearBoard();
		    turn = "Blue";
                    turnCount.setText(""+turn+"");
		    win = false;
		}
		}
	        
		
	    }
	    if (drawCheck()){
		int result = JOptionPane.showOptionDialog(null, "Draw game!", "Draw", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, newgame, null);
		if (result == JOptionPane.YES_OPTION){
		    clearBoard();
		    turn = "Blue";
                     turnCount.setText(""+turn+"");
		    win = false;
		}

	    }
	}
	
	else{
            ary[getRow(col)][col].setBackground(Color.red);
		turn = "Blue";
		turnCount.setText(""+turn+"");
		winCheck();
		if (win == true){
		    if (winCheck() == Color.red){
                        int result = JOptionPane.showOptionDialog(null, "Player 2 (Red) has won!", "Winner", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, newgame, null);
		if (result == JOptionPane.YES_OPTION){
		    clearBoard();
		    turn = "Blue";
                    turnCount.setText(""+turn+"");
		    win = false;
		}
			
		    }}
		if (drawCheck()){
        int result = JOptionPane.showOptionDialog(null, "Draw game!", "Draw", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, newgame, null);
		if (result == JOptionPane.YES_OPTION){
		    clearBoard();
		    turn = "Blue";
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
	    for (int c = 0; c < boardColumn - (winNeed - 1); c++){
		if(ary[r][c].getBackground() != Color.white){
		    karma = ary[r][c].getBackground();
		    win = true;
		    for (int w = 1; w < winNeed; w++){
			if (ary[r][c + w].getBackground() != karma){
			    win = false;
		   }
	          }
		    if (win == true){
			return karma;
		    }
	}
	    }
	}
	for (int r = 0; r < boardRow - (winNeed - 1); r++){
	    for (int c = 0; c < boardColumn; c++){
		if (ary[r][c].getBackground() != Color.white){
		    karma = ary[r][c].getBackground();
		    win = true;
		    for (int w = 1; w < winNeed; w++){
			if (ary[r + w][c].getBackground() != karma){
			    win = false;
			}
		    }
		    if (win == true){
			return karma;
		    }
		}
	    }
	}
	for (int r = 0; r < boardRow - (winNeed - 1); r++){
	    for (int c = 0; c < boardColumn - (winNeed - 1); c++){
		if (ary[r][c].getBackground() != Color.white){
		    karma = ary[r][c].getBackground();
		    win = true;
		    for (int w = 1; w < winNeed; w++){
			if (ary[r + w][c + w].getBackground() != karma){
			    win = false;
			}
		    }
		    if (win == true){
			return karma;
		    }
		   
		}
	    }
	}
	for (int r = (winNeed - 1); r < boardRow; r++){
	    for (int c = 0; c < boardColumn - (winNeed - 1); c++){
		if (ary[r][c].getBackground() != Color.white){
		    karma = ary[r][c].getBackground();
		    win = true;
		    for (int w = 1; w < winNeed; w++){
			if (ary[r - w][c + w].getBackground() != karma){
			    win = false;
			}
		    }
		    if (win == true){
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



}

    


















