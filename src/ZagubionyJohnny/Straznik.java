package ZagubionyJohnny;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Straznik
{
	Random rn = new Random();
	private int x;
	private int y;
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public Straznik(String s)
	{
		// System.out.println(s);
		if (s == "czerwony")
		{
			map.put(597, 50);
			map.put(497, 100);
			map.put(547, 100);
		}
		
		else if (s == "niebieski")
		{
			map.put(497, 200);
			map.put(597, 250);
			map.put(547, 250);
			map.put(547, 200);
		}
		
		else if (s == "zielony")
		{
			map.put(747, 200);
			map.put(747, 100);
			map.put(697, 100);
			map.put(647, 100);
			map.put(647, 50);
			map.put(647, 0);
		}
		
		int random = rn.nextInt(map.size());
		// System.out.println(random);
		
		List<Map.Entry<Integer, Integer>> randAccess = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		// System.out.println(randAccess.get(random).getKey());
		
		x = randAccess.get(random).getKey();
		y = map.get(randAccess.get(random).getKey());
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public void rozmowa()
	{

	}
}