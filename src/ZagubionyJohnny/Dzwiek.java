package ZagubionyJohnny;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Dzwiek
{
	public static void otworzDzwiek()
	{
		try
		{
			File plik = new File("song.wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(plik));
			clip.start();
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}
