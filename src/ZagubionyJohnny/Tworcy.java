package ZagubionyJohnny;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tworcy extends JFrame
{
	public Tworcy()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("Menu/ikonka.png"));
		setTitle("Twórcy");
		setSize(800, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);

		JLabel Tworcy = new JLabel();
		Tworcy.setIcon(new ImageIcon("Menu/tworcy.png"));
		Tworcy.setBounds(0, 0, 800, 800);
		getContentPane().add(Tworcy);
	}
}