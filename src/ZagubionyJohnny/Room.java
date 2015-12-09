package ZagubionyJohnny;

import javax.swing.JLabel;

public class Room extends JLabel
{
	private final int fieldX;
	private final int fieldY;
  
	public Room(int x, int y)
	{
		fieldX = x;
		fieldY = y;
	}
  
	public int getFieldX()
	{
		return fieldX;
	}
  
	public int getFieldY()
	{
		return fieldY;
	}
}
