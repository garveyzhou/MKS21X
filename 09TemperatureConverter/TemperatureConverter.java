import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TemperatureConverter extends JFrame implements ActionListener{
    private Container pane;
    private JTextField t;
    private JCheckBox c,c1;
    private JButton b;
    public void actionPerformed(ActionEvent e){
	String s = e.getActionCommand();
	if(s.equals("Submit") && c.isSelected() && c1.isSelected()){
	    System.out.println("Check one Box Not TWO");
	}
	else if(s.equals("Submit") && c.isSelected()){
		double F = CtoF(Integer.parseInt(t.getText()));
		System.out.println(t.getText() +" Celsius is " +F+" Fahrenheit");
	}
	else if (s.equals("Submit") && c1.isSelected()){
		double C = FtoC(Integer.parseInt(t.getText()));
		System.out.println(t.getText() +" Fahrenheit is " +C+" Celsius");	        
	}
    }
    public TemperatureConverter(){
	this.setTitle("Temperature converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	b = new JButton("Submit");
	t = new JTextField(10);
	c = new JCheckBox("Celsius to Fahrenheit");
	c1= new JCheckBox("Fahrenheit to Celsius");
	b.addActionListener(this);
	t.addActionListener(this);
	c.addActionListener(this);
	c1.addActionListener(this);
	pane.add(t);
	pane.add(c);
	pane.add(c1);
	pane.add(b);
    }
    public static double CtoF(int cel){
	return (cel *9.0/5.0)+32.0;
    }
    public static double FtoC(int Far){
	return (Far - 32.0)*5.0/9.0;
    }
    public static void main (String[] args){
	TemperatureConverter a = new TemperatureConverter();
	a.setVisible(true);
    }
}
