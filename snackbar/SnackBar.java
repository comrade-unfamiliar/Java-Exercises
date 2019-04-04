import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//for insanesnackbar
public class SnackBar extends JFrame
                      implements ActionListener
{
  public static double sales = 0;
  private static final String MY_PASSWORD = "Fancy Stuff";
  private VendingMachine machine1, machine2, machine3, machine4, machine5, machine6;
  public static final int million = 1000000;
  
  public SnackBar(int brand, String name)
  {
    super(name);

    Color brandColor1 = new Color(130, 30, 10); // r, g, b
    Color brandColor2 = new Color(255, 180, 0);
    Color brandColor3 = new Color(90, 180, 0);
    Color brandColor4 = new Color(240, 180, 10);
    Color brandColor5 = new Color(200, 200, 200);
    Color brandColor6 = new Color(100, 0, 0);

    // Load the coin icon for the vending machine buttons:
    ImageIcon coin = new ImageIcon("coin.gif");
    if(brand == 1)
    {
    		machine1 = new VendingMachine("Java", brandColor1, 45, coin);
    		machine2 = new VendingMachine("JApple", brandColor2, 50, coin);
    		machine3 = new VendingMachine("Jinx", brandColor3, 35, coin);
    		machine4 = new VendingMachine("You won't find fancier", brandColor4, 1000000, coin);
    		machine5 = new VendingMachine("Free Bottle", brandColor5, 0, coin);
    		machine6 = new VendingMachine("Totally Not A Spooky Bottle", brandColor6, -100, coin);
    }
    else if(brand == 2)
    {
    		machine1 = new VendingMachine("SpaceX FalconX Heavy", brandColor1, 10*million, coin);
    		machine2 = new VendingMachine("Fancy CanCans", brandColor2, million, coin);
    		machine3 = new VendingMachine("Not a Scam", brandColor3, (0-1)*million, coin);
    		machine4 = new VendingMachine("Spam", brandColor4, Integer.MAX_VALUE, coin);
    		machine5 = new VendingMachine("Up for Grabs", brandColor5, 0, coin);
    		machine6 = new VendingMachine("Spooky Stuff", brandColor6, 1, coin);
    }
    else if(brand == 3)
    {
    		machine1 = new VendingMachine("Free Money", Color.GREEN, 0, coin);
    		machine2 = new VendingMachine("Free Bitcoin", Color.ORANGE, 0, coin);
    		machine3 = new VendingMachine("We will pay you to take this", brandColor3, (0-1)*million, coin);
    		machine4 = new VendingMachine("Spam", brandColor4, Integer.MAX_VALUE, coin);
    		machine5 = new VendingMachine("Shady Can", brandColor5, 1000, coin);
    		machine6 = new VendingMachine("Don't Buy This", brandColor6, Integer.MAX_VALUE-1, coin);
    }
    else if(brand == 4)
    {
    		machine1 = new VendingMachine("Java", brandColor1, 45, coin);
    		machine2 = new VendingMachine("JApple", brandColor2, 50, coin);
    		machine3 = new VendingMachine("JPen", brandColor3, 35, coin);
    		machine4 = new VendingMachine("Tide Pods", brandColor4, million, coin);
    		machine5 = new VendingMachine("Daily Free Loot Box", brandColor5, 0, coin);
    		machine6 = new VendingMachine("SpAgHeT", brandColor6, -100, coin);
    }
    else if(brand == 5)
    {
    		machine1 = new VendingMachine("Colyflower", brandColor1, 10*million, coin);
    		machine2 = new VendingMachine("Spinach", brandColor2, million, coin);
    		machine3 = new VendingMachine("Spaghetti", brandColor3, (0-1)*million, coin);
    		machine4 = new VendingMachine("Croissant Sandwich", brandColor4, Integer.MAX_VALUE, coin);
    		machine5 = new VendingMachine("McDonalds", brandColor5, 5, coin);
    		machine6 = new VendingMachine("Healthy Organic Free-Ranged Hand-Made Drink", brandColor6, 500, coin);
    }
    else if(brand == 6)
    {
    		machine1 = new VendingMachine("Unhealthy Non-Organic Caged Factory-Made Drink", brandColor1, 10*million, coin);
    		machine2 = new VendingMachine("Brick", brandColor2, million, coin);
    		machine3 = new VendingMachine("Touched Spaghets", brandColor3, 803840, coin);
    		machine4 = new VendingMachine("Boiga", brandColor4, Integer.MAX_VALUE, coin);
    		machine5 = new VendingMachine("High Fructose Corn Syrup", brandColor5, 0, coin);
    		machine6 = new VendingMachine("Unhealthy Stuff", brandColor6, 1, coin);
    }
        //More Machines can be added here, follow the above format
    Box wall = Box.createHorizontalBox();
    wall.add(Box.createHorizontalStrut(5));
    wall.add(machine1);
    wall.add(Box.createHorizontalStrut(5));
    wall.add(machine2);
    wall.add(Box.createHorizontalStrut(5));
    wall.add(machine3);
    wall.add(Box.createHorizontalStrut(5));
    wall.add(machine4);
    wall.add(Box.createHorizontalStrut(5));
    wall.add(machine5);
    wall.add(Box.createHorizontalStrut(5));
    wall.add(machine6);
    wall.add(Box.createHorizontalStrut(5));

    JPanel service = new JPanel();
    service.add(new JLabel(" Service login: "));
    JPasswordField password = new JPasswordField("", 5);
    password.addActionListener(this);
    service.add(password);

    Container c = getContentPane();
    c.setBackground(Color.GRAY);
    c.add(wall, BorderLayout.CENTER);
    c.add(service, BorderLayout.SOUTH);
  }

  /**
   *  Password field: user strikes <Enter>
   */
  public void actionPerformed(ActionEvent e)
  {
    JPasswordField password = (JPasswordField)e.getSource();
    String word = new String(password.getPassword());
    password.setText("");
    if (MY_PASSWORD.equals(word))
    {
      double amt = Vendor.getTotalSales();
      sales = 0;
      machine1.reload();
      machine2.reload();
      machine3.reload();
      machine4.reload();
      machine5.reload();
      machine6.reload();
      JOptionPane.showMessageDialog(null,
        String.format("Total sales: $%.2f\n", amt) + 
        "These fancy vending machines were restocked",
        "A. Troll", JOptionPane.INFORMATION_MESSAGE);
    }
    else
    {
      JOptionPane.showMessageDialog(null,
        "Ha you thought", "The NKVD", JOptionPane.ERROR_MESSAGE);
    }
  }

  // *****************************************************

  public SnackBar(int brand, int yPos, String name)
  {
    SnackBar window = new SnackBar(brand, name);
    window.setBounds(0, yPos * 50, 1360, 350);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setVisible(true);
  }
  
}

