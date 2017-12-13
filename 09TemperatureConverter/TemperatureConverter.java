import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TemperatureConverter extends JFrame implements ActionListener{
    private Container pane;
    private JTextField t;
    private JCheckBox c;
    
    public void actionPerformed(ActionEvent e){
    }
    public TemperatureConverter(){
	this.setTitle("Temperature converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	t = new JTextField(10);
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
	TemperatureConverter a = new TemperatureConverter();
	a.setVisible(true);
    }
}
