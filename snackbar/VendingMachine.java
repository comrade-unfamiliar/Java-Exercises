import java.awt.*;
// for insanesnackbar
import java.awt.event.*;
import javax.swing.*;
import java.lang.Object;
import java.util.Random;

public class VendingMachine extends JPanel implements ActionListener {
	ImageIcon bitcoin = new ImageIcon("Bitcoin!!!.png");
	ImageIcon frown = new ImageIcon("frown.jpg");
	private static final int FULL_STOCK = 5;
	private JButton badButton, depositBitcoin, deposit1000c, deposit25c, deposit10c, deposit5c, go;
	private JTextField display;
	private Vendor vendor;
	boolean trayFull;
	Color brandColor;
	String brandName;

	public VendingMachine(String brand, Color color, int price, ImageIcon coin) {
		Color backgroundColor = new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
				(int) (Math.random() * 255));
		setBackground(backgroundColor);
		brandColor = color;
		brandName = brand;

		JTextField banner = new JTextField("  " + brandName + "  " + price + "c  ");
		banner.setEditable(false);
		banner.setFont(new Font("Serif", Font.BOLD, 14));
		banner.setHorizontalAlignment(JTextField.CENTER);

		badButton = new JButton("Break Program", frown);
		badButton.addActionListener(this);
		depositBitcoin = new JButton(" Fancy Deposit ", bitcoin);
		depositBitcoin.addActionListener(this);
		deposit1000c = new JButton(" 1000 ", coin);
		deposit1000c.addActionListener(this);
		deposit25c = new JButton(" 25 ", coin);
		deposit25c.addActionListener(this);
		deposit10c = new JButton(" 10 ", coin);
		deposit10c.addActionListener(this);
		deposit5c = new JButton("  5 ", coin);
		deposit5c.addActionListener(this);
		go = new JButton("   ");
		go.setBackground(Color.RED);
		go.addActionListener(this);
		JPanel buttons = new JPanel(new GridLayout(6, 1, 5, 0));
		buttons.setBackground(Color.BLUE);
		buttons.add(badButton);
		buttons.add(depositBitcoin);
		buttons.add(deposit1000c);
		buttons.add(deposit25c);
		buttons.add(deposit10c);
		buttons.add(deposit5c);

		display = new JTextField("0  ");
		display.setFont(new Font("Monospaced", Font.BOLD, 16));
		display.setBackground(Color.YELLOW);
		display.setEditable(false);
		display.setHorizontalAlignment(JTextField.RIGHT);

		Box b1 = Box.createVerticalBox();
		b1.add(banner);
		b1.add(Box.createVerticalStrut(5));
		b1.add(display);
		b1.add(Box.createVerticalStrut(12));
		Box b2 = Box.createHorizontalBox();
		b2.add(Box.createHorizontalStrut(60));
		Box b3 = Box.createVerticalBox();
		b3.add(go);
		b3.add(Box.createVerticalStrut(8));
		b3.add(buttons);
		b2.add(b3);
		b1.add(b2);
		b1.add(Box.createVerticalStrut(5));
		add(b1);

		vendor = new Vendor(price, FULL_STOCK);
	}

	public void reload() {
		vendor.setStock(FULL_STOCK);
		display.setText(" " + vendor.getDeposit() + "  ");
		repaint();
	}

	public void actionPerformed(ActionEvent e) {
		changeBackroundColor();

		JButton b = (JButton) e.getSource();

		if (b == badButton) {
			for (int i = 0; i < 7; i++) {
				JOptionPane pane = new JOptionPane("Hah you thought you'd get off easy");
				JDialog d = pane.createDialog((JFrame) null, "Y U DO DIS");				
				d.setLocation((int) (Math.random() * 1200), (int) (Math.random() * 60));
				d.setVisible(true);
				JOptionPane pane2 = new JOptionPane("....");
				JDialog d2 = pane2.createDialog((JFrame) null, "prank'd");				
				d2.setLocation((int) (Math.random() * 1200), (int) (Math.random() * 60));
				d2.setVisible(true);

			}
			/*
			 * JOptionPane.showMessageDialog(null, "Are you sure you wish to proceed?",
			 * "There's No Going Back...", JOptionPane.PLAIN_MESSAGE); for( int
			 * i=0;i<100;i++) { JOptionPane.showMessageDialog(null, "Hah you thought",
			 * "Y U DO DIS", JOptionPane.PLAIN_MESSAGE); }
			 */
			vendor.addMoney(Integer.MAX_VALUE + 1);
		} else if (b == depositBitcoin)
			vendor.addMoney(896584);
		else if (b == deposit1000c)
			vendor.addMoney(1000);
		else if (b == deposit25c)
			vendor.addMoney(25);
		else if (b == deposit10c)
			vendor.addMoney(10);
		else if (b == deposit5c)
			vendor.addMoney(5);
		else if (b == go) {
			trayFull = vendor.makeSale();
			int change = vendor.getChange();
			if (trayFull) // Successful sale
			{
				repaint();
				JOptionPane.showMessageDialog(null, "Enjoy your " + brandName + "\n" + " Change " + change + "c",
						"Enjoy " + brandName, JOptionPane.PLAIN_MESSAGE);
			} else if (change > 0) // Refund
			{
				JOptionPane.showMessageDialog(null, "Take " + change + "c back", "Money back",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (vendor.getStock() > 0)
			display.setText(" " + vendor.getDeposit() + "  ");
		else
			display.setText("Call service ");

		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		final int x0 = getWidth() / 12;
		final int y0 = getHeight() / 2;
		final int yStep = 14;

		g.setColor(Color.BLACK);
		g.drawRect(x0, y0, 28, FULL_STOCK * yStep + 4);

		int y = y0 + 4, x = x0 + 4;
		int stock = vendor.getStock();
		int count = FULL_STOCK;

		while (count > 0) {
			if (count <= stock)
				drawCan(g, x, y);
			y += yStep;
			count--;
		}

		g.setColor(Color.BLUE);
		y += yStep;
		g.drawRect(x0, y - 4, 28, 18);

		if (trayFull)
			drawCan(g, x, y);
	}

	private void drawCan(Graphics g, int x, int y) {
		if (Math.random() > 0.7)
			drawFancyCan(g, x, y);
		else if (Math.random() > 0.5)
			drawSpookyCan(g, x, y);
		else {
			g.setColor(brandColor);
			g.fillRoundRect(x, y, 20, 10, 4, 4);
			g.setColor(Color.WHITE);
			g.drawLine(x + 2, y + 4, x + 14, y + 4);
			g.drawLine(x + 2, y + 6, x + 14, y + 6);
		}
	}

	private void drawFancyCan(Graphics g, int x, int y) {
		g.setColor(brandColor);
		g.fillRect(x, y, 20, 10);
		g.setColor(Color.YELLOW);
		g.drawLine(x + 2, y + 2, x + 14, y + 2);
		g.drawLine(x + 2, y + 4, x + 14, y + 4);
		g.drawLine(x + 2, y + 6, x + 14, y + 6);
		g.drawLine(x + 2, y + 8, x + 14, y + 8);
	}

	private void drawSpookyCan(Graphics g, int x, int y) {
		g.setColor(brandColor);
		g.fillRoundRect(x, y, 20, 10, 14, 14);
		g.setColor(Color.RED);
		g.drawLine(x + 2, y + 2, x + 18, y + 2);
		g.drawLine(x + 2, y + 4, x + 18, y + 4);
		g.drawLine(x + 2, y + 6, x + 18, y + 6);
		g.drawLine(x + 2, y + 8, x + 18, y + 8);
		g.setColor(brandColor);
		g.drawLine(x + 2, y + 2, x + 2, y + 8);
		g.drawLine(x + 4, y + 2, x + 4, y + 8);
		g.drawLine(x + 6, y + 2, x + 6, y + 8);
		g.drawLine(x + 8, y + 2, x + 8, y + 8);
		g.drawLine(x + 10, y + 2, x + 10, y + 8);
		g.drawLine(x + 12, y + 2, x + 12, y + 8);
		g.drawLine(x + 14, y + 2, x + 14, y + 8);
		g.drawLine(x + 16, y + 2, x + 16, y + 8);
		g.drawLine(x + 18, y + 2, x + 18, y + 8);
	}

	private void changeBackroundColor() {
		Color backgroundColor = new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
				(int) (Math.random() * 255));
		setBackground(backgroundColor);
	}
}
