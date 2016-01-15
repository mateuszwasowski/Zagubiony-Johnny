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
	private String kolor;
	
	//tu s¹ pytania i odpowiedzi poszczególnych stra¿ników (r g b - odpowiadaj¹ ich kolorom), poprawne odpowiedzi na pytania s¹ odseparowane '|'
	private String[] pytaniaRed = {"Pytanie1", "Pytanie2", "Pytanie3", "Pytanie4", "Pytanie5", "Pytanie6"};
	private String[] pytaniaBlue = {"Pytanie1", "Pytanie2", "Pytanie3", "Pytanie4", "Pytanie5", "Pytanie6"};
	private String[] pytaniaGreen = {"Pytanie1", "Pytanie2", "Pytanie3", "Pytanie4", "Pytanie5", "Pytanie6"};
	private String[] odpowiedziRed = {"OdpowiedzNaPytanie1", "OdpowiedzNaPytanie2", "OdpowiedzNaPytanie3", "OdpowiedzNaPytanie4", "OdpowiedzNaPytanie5", "OdpowiedzNaPytanie6"};
	private String[] odpowiedziBlue = {"OdpowiedzNaPytanie1", "OdpowiedzNaPytanie2", "OdpowiedzNaPytanie3", "OdpowiedzNaPytanie4", "OdpowiedzNaPytanie5", "OdpowiedzNaPytanie6"};
	private String[] odpowiedziGreen = {"OdpowiedzNaPytanie1", "OdpowiedzNaPytanie2", "OdpowiedzNaPytanie3", "OdpowiedzNaPytanie4", "OdpowiedzNaPytanie5", "OdpowiedzNaPytanie6"};
	
	private String q;

	//poprawnoœæi odpowiedzi
	private boolean a;

	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public Straznik(String s)
	{	
		a = false;
		
		int temp1 = 0;
		int temp2 = 0;
		int temp3 = 0;
		
		kolor = s;
		
		if (s == "czerwony")
		{
			map.put(597, 50);
			map.put(497, 100);
			map.put(547, 100);
			
			temp1 = rn.nextInt(7);
			q = pytaniaRed[temp1];
		}
		
		else if (s == "niebieski")
		{
			map.put(497, 200);
			map.put(597, 250);
			map.put(547, 250);
			map.put(547, 200);
			
			temp1 = rn.nextInt(7);
			q = pytaniaBlue[temp1];
		}
		
		else if (s == "zielony")
		{
			map.put(747, 200);
			map.put(747, 100);
			map.put(697, 100);
			map.put(647, 100);
			map.put(647, 50);
			map.put(647, 0);
			
			temp1 = rn.nextInt(7);
			q = pytaniaGreen[temp1];
		}
		
		int random = rn.nextInt(map.size());
		
		List<Map.Entry<Integer, Integer>> randAccess = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		
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
	
	public boolean success()
	{
		return (a);
	}

	public String rozmowa(int r)
	{	
		String ret = "";

		//przywitanie:
		if (r == 1)
		{
			ret = "Hacker: Johnny, porozmawiaj z tym czymœ\nJohnny: Spróbujê! Ekhm... Czym jesteœ?\n(naciœnij enter)\n                                              ->";
		}
		
		else if (r == 2)
		{
			if (kolor == "czerwony")
			{
				ret = "???: Witaj, jestem stra¿nikiem czerwonego klucza!\nTylko on umo¿liwi Ci przejœcie przez czerwone\ndzrzwi!\n                                              ->";			
			}
			
			else if (kolor == "niebieski")
			{
				ret = "???: Witaj, jestem stra¿nikiem niebieskiego klucza!\nTylko on umo¿liwi Ci przejœcie przez niebieskie\ndzrzwi!\n                                              ->";
			}
			
			else
			{
				ret = "???: Witaj, jestem stra¿nikiem zielonego klucza!\nTylko on umo¿liwi Ci przejœcie przez zielone\ndzrzwi!\n                                              ->";
			}	
		}
		
		else if (r == 3)
		{
			ret = "Stra¿nik: Zadam Ci 3 zagadki\nBêdziesz musia³ odpowiedzieæ na nie wszystkie...\n\n                                              ->";			
		}
		
		else if (r == 4)
		{
			ret = "jeœli chcesz zdobyæ mój klucz!\n\n\n                                              ->";			
		}
		
		else if (r == 5)
		{
			ret = q;
		}
		
		return ret;
	}
}