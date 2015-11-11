package ZagubionyJohnny;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ZagubionyJohnny extends JFrame
{	
	public ZagubionyJohnny() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("ikonka.png"));
		setTitle("Zagubiony Johnny");
		setSize(800, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JLabel korytarz = new JLabel();
		korytarz.setIcon(new ImageIcon("hallwayfilter.png"));
		korytarz.setBounds(0, 0, 500, 500);
		getContentPane().add(korytarz);
		
		JTextArea konsola = new JTextArea();
		konsola.setForeground(Color.GREEN);
		konsola.setFont(new Font("Monospaced", Font.PLAIN, 30));
		konsola.setBackground(Color.BLACK);
		konsola.setBounds(10, 510, 780, 300);
		konsola.setLineWrap(true);
		getContentPane().add(konsola);
	}

	public static void main(String[] args) 
	{	
		ZagubionyJohnny gra = new ZagubionyJohnny();
		MenuStart menu = new MenuStart(gra);
		Dzwiek dzwiek = new Dzwiek();
		
		menu.show();
		dzwiek.otworzDzwiek();
	}
}