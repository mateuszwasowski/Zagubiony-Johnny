package ZagubionyJohnny;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
		
		JLabel ZagubionyJohnny = new JLabel("");
		//ZagubionyJohnny.setIcon(new ImageIcon("Zasady.png"));
		ZagubionyJohnny.setBounds(0, 0, 800, 800);
		getContentPane().add(ZagubionyJohnny);
	}
	
	public static void otworzDzwiek()
	{
		try
		{
			File plik = new File("song.wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(plik));
			clip.start();
			Thread.sleep(clip.getMicrosecondLength());
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static void main(String[] args) 
	{	
		ZagubionyJohnny gra = new ZagubionyJohnny();
		MenuStart menu = new MenuStart(gra);
		menu.setVisible(true);
		otworzDzwiek();
	}
}