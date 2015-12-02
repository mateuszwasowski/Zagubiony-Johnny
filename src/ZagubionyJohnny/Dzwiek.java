package ZagubionyJohnny;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Dzwiek
{
	static File plik = new File("song.wav");
	static Clip clip;
	
	public static void odtworzDzwiek()
	{
            try
            {
                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(plik));                   
                clip.start();
            } catch (Exception e)
            {
                System.err.println(e.getMessage());
            }
	}
}
