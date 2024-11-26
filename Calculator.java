  import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Calculator extends JFrame implements ActionListener
{
  JLabel l1,l2,l3;
  JTextField t1,t2,t3;
  JButton b1,b2,b3,b4;
  double a,b,c;
  Calculator()
  {
    setLayout(new FlowLayout()); 
    l1=new JLabel("Enter A:");
    add(l1);
    t1=new JTextField(15);
    add(t1);

    l2=new JLabel("\nEnter B:");
    add(l2);
    t2=new JTextField(15);
    add(t2);

    l3=new JLabel("\nAnswer:");
    add(l3);
    t3=new JTextField(15);
    add(t3);

    b1=new JButton("Addition");
    b1.addActionListener(this);
    add(b1);
    b2=new JButton("Substraction");
    b2.addActionListener(this);
    add(b2);
    b3=new JButton("Multiplication");
    b3.addActionListener(this);
    add(b3);
    b4=new JButton("Division");
    b4.addActionListener(this);
    add(b4);
    
    
   }
   public void actionPerformed(ActionEvent ae)
   {
     a=Double.parseDouble(t1.getText());
     b=Double.parseDouble(t2.getText());
     if(ae.getSource()==b1)
     {
       c=a+b;
       
     }
     if(ae.getSource()==b2)
     {
      c=a-b;
     

     }
     if(ae.getSource()==b3)
     {
      c=a*b;
     }
    if(ae.getSource()==b4)
     {
      c=a/b;

     }
       t3.setText(""+c);
   }
  public static void main(String args[])
  {
    Calculator c=new Calculator();
    c.setSize(300,300);
    c.setVisible(true);
  }
}
