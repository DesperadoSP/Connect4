import javax.swing.*;
import java.awt.*;
public class Connect4 extends JFrame {
    private Container pane;
    private JButton a,b,c,d,e,f,g;
    private int[][] ary;
    public int turn;
    public Connect4(){
	turn = 1;
	ary = new int[7][6];
	this.setTitle("Connect4");
        this.setSize(600, 400);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
        a = new JButton("1");
	b = new JButton("2");
	c = new JButton("3");
	d = new JButton("4");
	e = new JButton("5");
	f = new JButton("6");
	g = new JButton("7");
	pane.add(a);
	pane.add(b);
	pane.add(c);
	pane.add(d);
	pane.add(e);
	pane.add(f);
	pane.add(g);
    }

    public 
    public static void main(String[]args){
	Connect4 z = new Connect4();
	z.setVisible(true);
    }
}

















