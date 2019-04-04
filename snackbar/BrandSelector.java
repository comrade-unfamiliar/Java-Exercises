import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Object;
import java.util.Random;

public class BrandSelector extends JFrame implements ActionListener {
	private VendingMachine machine1, machine2, machine3, machine4, machine5, machine6;
	private JButton brand1, brand2, brand3, brand4, brand5, brand6, brand7;
	private int brand = 1;

	public BrandSelector() {
		brand1 = new JButton("CONTENT REMOVED");
		brand1.addActionListener(this);
		brand2 = new JButton("[/redacted/]");
		brand2.addActionListener(this);
		brand3 = new JButton("Shady Stuff");
		brand3.addActionListener(this);
		brand4 = new JButton("Dankest Meme Bay");
		brand4.addActionListener(this);
		brand5 = new JButton("\"Healthy\" Stuff");
		brand5.addActionListener(this);
		brand6 = new JButton("Health is for noobs");
		brand6.addActionListener(this);
		brand7 = new JButton("North Korea");
		brand7.addActionListener(this);
		// brand# = new JButton("Button Name");
		// brand#.addActionListener(this);

		Box brandBox = Box.createVerticalBox();
		JPanel buttons = new JPanel(new GridLayout(7, 1, 5, 0));
		buttons.setBackground(Color.YELLOW);
		buttons.add(brand1);
		buttons.add(brand2);
		buttons.add(brand3);
		buttons.add(brand4);
		buttons.add(brand5);
		buttons.add(brand6);
		buttons.add(brand7);
		// buttons.add(brand#);
		brandBox.add(buttons);
		add(brandBox);

	}

	public void actionPerformed(ActionEvent e) {
		SnackBar bar;
		JButton b = (JButton) e.getSource();
		System.out.println("Button: " + b);
		if (b == brand1)
			bar = new SnackBar(1, 1, "CONTENT REMOVED");
		else if (b == brand2)
			bar = new SnackBar(2, 1, "[/redacted/]");
		else if (b == brand3)
			bar = new SnackBar(3, 1, "Shady Snack Bar");
		else if (b == brand4)
			bar = new SnackBar(4, 1, "Dankest Meme Bay Exclusive Snack Bar");
		else if (b == brand5)
			bar = new SnackBar(5, 1, "Healthiest Snack Bar");
		else if (b == brand6)
			bar = new SnackBar(6, 1, "Not the Healthiest Snack Bar");
		else if (b == brand7)
			JOptionPane.showMessageDialog(null, "Sorry, we have no food today", "Message from Supreme Leader",
					JOptionPane.PLAIN_MESSAGE);
	

	// else if (b == brand#) bar = new SnackBar(brand#, yPos, WindowName);
	}

	public void setBrand(int n) {
		brand = n;
	}

	public int getBrand() {
		return brand;
	}

	public static void main(String[] args) {
		BrandSelector window = new BrandSelector();
		window.setBounds(100, 50, 150, 300);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
	}
}
