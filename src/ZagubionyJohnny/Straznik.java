package ZagubionyJohnny;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Straznik
{
	Random rn = new Random();
	private int x;
	private int y;
	private boolean started;
	private String kolor;

	// tu s� pytania i odpowiedzi poszczeg�lnych stra�nik�w (r g b - odpowiadaj�
	// ich kolorom), poprawne odpowiedzi na pytania s� odseparowane '|'
	private String[] pytaniaRed = {
			"Nie je, nie pije, a chodzi i bije?",
			"Bywa siwy, gniady, kary, wozi ludzi i towary.\nCo to?",
			"W szklanej rurce cienki pr�cik. To wyd�u�a si�, to\nskraca � i to ca�a jego praca. Co to?",
			"Co to za zwierz�, kt�re rano chodzi na czterech\nnogach, w po�udnie na dw�ch, a wieczorem\nna trzech?"};
	private String[] pytaniaBlue = {
			"Jest kr�lem, lecz nie w koronie, ma grzyw�,\ncho� nie jest koniem. Co to?",
			"Cho� ma pancerz, to nie wojuje, cho� ma cztery\nnogi � wolno spaceruje. Co to?",
			"Dwa cia�a ma, cho� jedna w niej dusza. Im d�u�ej\nstoi w miejscu, tym szybciej si� porusza",
			"Co otrzymasz, gdy usuniesz co� z nico�ci?"};
	private String[] pytaniaGreen = {
			"Pierwsze znaczy d�, drugie � przeczenie. Wszystko\nrazem kortowe odzienie. Co to?",
			"Rankiem srebrzy si� na ��ce, potem wysuszy j�\ns�o�ce. Co to?",
			"Jeszcze na koniec �atwa zagadka � krzes�o dla\ndziadka?",
			"Kto m�wi wszystkimi j�zykami �wiata?"};
	private String[] odpowiedziRed = {"zegar", "kon", "termometr", "czlowiek"};
	private String[] odpowiedziBlue = {"lew", "zolw", "klepsydra", "nici"};
	private String[] odpowiedziGreen = {"spodnie", "rosa", "fotel", "echo"};

	private String q;

	// poprawno��i odpowiedzi
	private boolean a;
	
	// straznik zakonczony
	private boolean done;
	
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public Straznik(String s)
	{
		a = false;
		started = false;
		done = false;
		int temp1 = 0;

		kolor = s;

		if (s == "czerwony")
		{
			map.put(597, 50);
			map.put(497, 100);
			map.put(547, 100);

			temp1 = rn.nextInt(4);
			System.out.println("RED: " + temp1);
			q = pytaniaRed[temp1];
		}

		else if (s == "niebieski")
		{
			map.put(497, 200);
			map.put(597, 250);
			map.put(547, 250);
			map.put(547, 200);

			temp1 = rn.nextInt(4);
			System.out.println("BLUE: " + temp1);
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

			temp1 = rn.nextInt(4);
			System.out.println("GREEN: " + temp1);
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

	public int setStarted()
	{
		started = true;
		return 0;
	}

	public int setDone()
	{
		done = true;
		return 0;
	}
	
	public boolean getStarted()
	{
		return started;
	}

	public boolean success()
	{
		return (a);
	}
	
	public boolean finished()
	{
		return (done);
	}

	public boolean odpowiedz(String komenda)
	{	
		boolean ret = false;
		
		if(kolor == "czerwony")
		{
			//debug dla rozmowy
			System.out.println("KOMENDA: "+komenda);
			System.out.println("INDEX: "+Arrays.asList(pytaniaRed).indexOf(q));
			System.out.println("POPRAWNA ODP: "+odpowiedziRed[Arrays.asList(pytaniaRed).indexOf(q)]);
			System.out.println("ROWNA SIE?: "+komenda.equals(odpowiedziRed[Arrays.asList(pytaniaRed).indexOf(q)]));
			//koniec debugu
			
			if(komenda.equals(odpowiedziRed[Arrays.asList(pytaniaRed).indexOf(q)]))
			{
				a = true;
				ret = true;
			}
			
			else
			{
				a = false;
				ret = false;
			}
		}
		
		if(kolor == "niebieski")
		{
			if(komenda.equals(odpowiedziBlue[Arrays.asList(pytaniaBlue).indexOf(q)]))
			{
				a = true;
				ret = true;
			}
			
			else
			{
				a = false;
				ret = false;
			}
		}
		
		if(kolor == "zielony")
		{
			if(komenda.equals(odpowiedziGreen[Arrays.asList(pytaniaGreen).indexOf(q)]))
			{
				a = true;
				ret = true;
			}
			
			else
			{
				a = false;
				ret = false;
			}
		}
		
		return ret;
	}

	public String rozmowa(int r) 
	{
		String ret = "";
		
		if (started == true) 
		{
			r = 5;
		}
		
		// przywitanie:
		if (r == 1) 
		{
			if (kolor == "czerwony") 
			{
				ret = "Hacker: Johnny, porozmawiaj z tym czym�\nJohnny: Spr�buj�! Ekhm... Czym jeste�?\n(naci�nij enter)\n                                              ->";
			} 
			
			else 
			{
				ret = "Hacker: Johnny, porozmawiaj z tym stra�nikiem!\n(naci�nij enter)\n                                              ->";
			}
		}

		else if (r == 2) 
		{
			if (kolor == "czerwony")
			{
				ret = "???: Witaj, jestem stra�nikiem czerwonego klucza!\nTylko on umo�liwi Ci przej�cie przez czerwone\ndrzwi!\n                                              ->";
			}

			else if (kolor == "niebieski")
			{
				ret = "Stra�nik: Witaj, jestem stra�nikiem niebieskiego\nklucza! Tylko on umo�liwi Ci przej�cie przez\nniebieskie drzwi!\n                                              ->";
			}

			else
			{
				ret = "Stra�nik: Witaj, jestem stra�nikiem zielonego\nklucza! Tylko on umo�liwi Ci przej�cie przez\nzielone drzwi!\n                                              ->";
			}
		}

		else if (r == 3)
		{
			ret = "Stra�nik: Zadam Ci zagadk�\nB�dziesz musia� na ni� poprawnie odpowiedzie�...\n\n                                              ->";
		}

		else if (r == 4)
		{
			ret = "je�li chcesz zdoby� m�j klucz!\n\n\n                                              ->";
		}

		else if (r == 5)
		{
			ret = q;
		}

		return ret;
	}
}