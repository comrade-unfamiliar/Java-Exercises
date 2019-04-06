/*

Class for testing methods that work on Strings. Run this to see what it does, then find the commented section below!

*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StringTest extends JFrame
        implements ActionListener
{
  private JTextField input, result, chooseMethod;

  public StringTest()
  {
    super("String test");
    
    Box box1 = Box.createVerticalBox();
    box1.add(new JLabel("Input:"));
    box1.add(Box.createVerticalStrut(10));
    box1.add(new JLabel("Choose method:"));
    box1.add(Box.createVerticalStrut(20));
    box1.add(new JLabel("Type the exact name of the method"));
    box1.add(Box.createVerticalStrut(10));
    box1.add(new JLabel("Result:"));
    
    input = new JTextField(20);
    input.setBackground(Color.WHITE);
    input.addActionListener(this);
    input.selectAll();

    chooseMethod = new JTextField(20);
    chooseMethod.setBackground(Color.WHITE);
    chooseMethod.addActionListener(this);
    chooseMethod.selectAll();
    
    result = new JTextField(20);
    result.setBackground(Color.WHITE);
    result.setEditable(false);

    Box box2 = Box.createVerticalBox();
    box2.add(input);
    box2.add(Box.createVerticalStrut(10));
    box2.add(chooseMethod);
    box2.add(Box.createVerticalStrut(10));
    box2.add(result);
    

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.add(box1);
    c.add(box2);
    input.requestFocus();
  }

  public void actionPerformed(ActionEvent e)
  {
    
	 String str = input.getText();
	 String choice = chooseMethod.getText();
	 if (choice.equals("nameEcho")) str = "" + StringToolBox.nameEcho(str);
	 else if (choice.equals("endsWithStar")) str = "" + StringToolBox.endsWithStar(str);
	 else if (choice.equals("endsWithTwoStars")) str = "" + StringToolBox.endsWithTwoStars(str);
	 else if (choice.equals("removeDashes")) str = "" + StringToolBox.removeDashes(str);
	 else if (choice.equals("dateStr")) str = "" + StringToolBox.dateStr(str);
	 else if (choice.equals("negativeBits")) str = "" + StringToolBox.negativeBits(str);
	 else if (choice.equals("containsSameChar")) str = "" + StringToolBox.containsSameChar(str);
	 else if (choice.equals("removeComments")) str = " "+ StringToolBox.removeComments(str);
	 else if (choice.equals("last4")) str = "" + StringToolBox.last4(str);
	 else if (choice.equals("last5")) str = "" + StringToolBox.last5(str);
	 else if (choice.equals("scroll")) str = "" + StringToolBox.scroll(str);
	 else if (choice.equals("convertName")) str = "" + StringToolBox.convertName(str);
    // Uncomment and modify this code to easily test your methods!
    // str = "" + StringToolBox.convertName(str);

    result.setText(str);
    input.selectAll();
  }

  public static void main(String[] args)
  {
    StringTest window = new StringTest();
    window.setBounds(100, 100, 500, 200);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}

