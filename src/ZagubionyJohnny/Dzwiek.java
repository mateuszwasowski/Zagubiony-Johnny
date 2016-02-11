package ZagubionyJohnny;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Dzwiek
{
	static File plik = new File("Muzyka/startSong.wav");
	static File plik2 = new File("Muzyka/song.wav");
	static File plik3 = new File("Muzyka/finalSong.wav");
	static File plik4 = new File("Muzyka/door.wav");
	static Clip clip;
	static Clip clip2;
	static Clip clip3;
	static Clip clip4;

	public static void odtworzDzwiekMenu()
	{
		try
		{
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(plik));
			clip.start();
		}

		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static void odtworzDzwiekGra()
	{
		try
		{
			clip2 = AudioSystem.getClip();
			clip2.open(AudioSystem.getAudioInputStream(plik2));
			clip2.loop(clip2.LOOP_CONTINUOUSLY);
			clip2.start();
		}

		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static void odtworzDzwiekExit()
	{
		try
		{
			clip3 = AudioSystem.getClip();
			clip3.open(AudioSystem.getAudioInputStream(plik3));
			clip3.start();
		}

		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static void odtworzDrzwi()
	{
		try
		{
			clip4 = AudioSystem.getClip();
			clip4.open(AudioSystem.getAudioInputStream(plik4));
			clip4.start();
		}

		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}