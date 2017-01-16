import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
public class Customization extends JFrame implements ActionListener{
    private Container pane;
    private JButton Initializer;
    private JLabel colLabel, rowLabel, winLabel;
    private JTextField colCount, rowCount, winCount;
    private Connect4 derp;
    public Customization(){
	this.setTitle("Connect4!!!!!");
	this.setSize(800, 100);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	Initializer = new JButton("Initialize");
	colLabel = new JLabel("Columns");
	rowLabel = new JLabel("Rows");
        winLabel = new JLabel("Pieces needed");
	colCount = new JTextField(12);
	rowCount = new JTextField(12);
	winCount = new JTextField(12);
        
	Initializer.addActionListener(this);
	Initializer.setActionCommand("Initialize");
	pane.add(rowLabel);
	pane.add(rowCount);
	pane.add(colLabel);
	pane.add(colCount);
	pane.add(winLabel);
	pane.add(winCount);
	pane.add(Initializer);
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	int r, c, w;
	Object[] flerp = {"Yes", "No"};
	if(event.equals("Initialize")){
	    try{
	    r = Integer.parseInt(rowCount.getText());
            c = Integer.parseInt(colCount.getText());
	    w = Integer.parseInt(winCount.getText());
	    if (checkWinnable(r, c, w)){
            derp = new Connect4(r, c, w);
	    derp.setVisible(true);
	    }else {
		int result = JOptionPane.showOptionDialog(null, "This board is most likely UNWINNABLE, do you still want to start the game with these options?", "Unwinnable", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, flerp, null);
		if (result == JOptionPane.YES_OPTION){
		    derp = new Connect4(r, c, w);
		    derp.setVisible(true);
	    }
	    }
	    }catch(NumberFormatException j){
		JOptionPane.showMessageDialog(null, "Please enter valid integers higher than 0.", "Invalid Arguments", JOptionPane.INFORMATION_MESSAGE);
	    }
}
    }
    
    

    


    public static boolean checkWinnable(int x, int y, int z){
	boolean winnable = true;
	if ((z == 1) || (y == 1)){
	    winnable = false;
	    return winnable;
	}
	else if((x * y) < (z * z)){
	    winnable = false;
	    return winnable;
       
	} else{
	return winnable;
	    }

    }

    public static void main(String[]args){
	Customization d = new Customization();
	d.setVisible(true);
    }
}
