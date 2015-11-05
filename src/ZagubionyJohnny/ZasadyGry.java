package ZagubionyJohnny;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Toolkit;

public class ZasadyGry extends JFrame
{
	public ZasadyGry()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("ikonka.png"));
		setTitle("Zasady gry");
		setSize(870, 750);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JLabel ZasadyGry = new JLabel("");
		//ZasadyGry.setIcon(new ImageIcon("Zasady.png"));
		ZasadyGry.setBounds(0, 0, 870, 710);
		getContentPane().add(ZasadyGry);
	}
}