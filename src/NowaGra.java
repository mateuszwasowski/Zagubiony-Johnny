package ZagubionyJohnny;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Toolkit;

public class NowaGra extends JFrame
{
        public NowaGra()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("Ikonka.png"));
		setTitle("Nowa gra");
		setSize(870, 750);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JLabel NowaGra = new JLabel("");
		NowaGra.setIcon(new ImageIcon("nowagra.png"));
		NowaGra.setBounds(0, 0, 870, 710);
		getContentPane().add(NowaGra);
	}    
}
