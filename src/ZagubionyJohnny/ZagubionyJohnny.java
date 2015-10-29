package ZagubionyJohnny;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ZagubionyJohnny {
	
	public ZagubionyJohnny() {
		
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