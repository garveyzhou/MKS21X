import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Temp extends JFrame implements ActionListener{
    private Container pane;
    private JTextField t;
    private JCheckBox c;
    
    public void actionPerformed(ActionEvent e){
    }
    public Temp(){
	this.setTitle("Temperature converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	t = new JTextField();
	c = new JCheckBox("Celius to Farenheight");
	pane.add(t);
	pane.add(c);
    }
    public static double CtoF(double cel){
	return (cel *9.0/5.0)+32.0;
    }
    public static double FtoC(double Far){
	return (Far - 32.0)*5.0/9.0;
    }
    public static void main (String[] args){
	System.out.println(CtoF(100));
	System.out.println(FtoC(212));
    }
}
