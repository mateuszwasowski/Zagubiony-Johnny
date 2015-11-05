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
		setIconImage(Toolkit.getDefaultToolkit().getImage("ikonka.png"));
		setTitle("Twórcy");
		setSize(870, 750);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
			
		JLabel ZasadyGry = new JLabel("");
		//ZasadyGry.setIcon(new ImageIcon("Tworcy.png"));
		ZasadyGry.setBounds(0, 0, 870, 710);
		getContentPane().add(ZasadyGry);
	}
}
