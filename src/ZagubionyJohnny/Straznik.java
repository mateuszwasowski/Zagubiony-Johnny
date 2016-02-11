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
	private boolean podpowiedz = false;
	private String kolor;
	
	int tempR = 0;
	int tempB = 0;
	int tempG = 0;
	
	// tu s� pytania i odpowiedzi poszczeg�lnych stra�nik�w (r g b - odpowiadaj�
	// ich kolorom), poprawne odpowiedzi na pytania s� odseparowane '|'
	private String[] pytaniaRed = { "Nie je, nie pije, a chodzi i bije?",
			"Bywa siwy, gniady, kary, wozi ludzi i towary.\nCo to?",
			"W szklanej rurce cienki pr�cik. To wyd�u�a si�, to\nskraca � i to ca�a jego praca. Co to?",
			"Co to za zwierz�, kt�re rano chodzi na czterech\nnogach, w po�udnie na dw�ch, a wieczorem\nna trzech?" };
	
	private String[] pytaniaBlue = { "Jest kr�lem, lecz nie w koronie, ma grzyw�,\ncho� nie jest koniem. Co to?",
			"Cho� ma pancerz, to nie wojuje, cho� ma cztery\nnogi � wolno spaceruje. Co to?",
			"Dwa cia�a ma, cho� jedna w niej dusza. Im d�u�ej\nstoi w miejscu, tym szybciej si� porusza",
			"Co otrzymasz, gdy usuniesz co� z nico�ci?" };
	
	private String[] pytaniaGreen = {
			"Pierwsze znaczy d�, drugie � przeczenie. Wszystko\nrazem kortowe odzienie. Co to?",
			"Rankiem srebrzy si� na ��ce, potem wysuszy j�\ns�o�ce. Co to?",
			"Jeszcze na koniec �atwa zagadka � krzes�o dla\ndziadka?", "Kto m�wi wszystkimi j�zykami �wiata?" };
	
	private String[] odpowiedziRed = { "Zegar", "Kon", "Termometr", "Czlowiek" };
	private String[] odpowiedziBlue = { "Lew", "Zolw", "Klepsydra", "Nici" };
	private String[] odpowiedziGreen = { "Spodnie", "Rosa", "Fotel", "Echo" };

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
		int temp = 0;

		kolor = s;

		if (s == "czerwony")
		{
			map.put(597, 50);
			map.put(497, 100);
			map.put(547, 100);

			temp = rn.nextInt(4);
			tempR = temp;
			
			// Debug
			System.out.println("RED: " + temp);
			////////////////////////////////////

			q = pytaniaRed[temp];
		}

		else if (s == "niebieski")
		{
			map.put(497, 200);
			map.put(597, 250);
			map.put(547, 250);
			map.put(547, 200);

			temp = rn.nextInt(4);
			tempB = temp;
			
			// Debug
			System.out.println("BLUE: " + temp);
			////////////////////////////////////

			q = pytaniaBlue[temp];
		}

		else if (s == "zielony")
		{
			map.put(747, 200);
			map.put(747, 100);
			map.put(697, 100);
			map.put(647, 100);
			map.put(647, 50);
			map.put(647, 0);

			temp = rn.nextInt(4);
			tempG = temp;
			
			// Debug
			System.out.println("GREEN: " + temp);
			////////////////////////////////////

			q = pytaniaGreen[temp];
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

	public boolean getPodpowiedz()
	{
		boolean dupa = podpowiedz;
		podpowiedz = false;
		return dupa;
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
		komenda = komenda.toLowerCase();
		komenda = RemoveAccent(komenda);
		komenda.replace("\n", "");
		
		if (kolor == "czerwony")
		{
			// debug dla rozmowy
			System.out.println("KOMENDA: " + komenda);
			System.out.println("INDEX: " + Arrays.asList(pytaniaRed).indexOf(q));
			System.out.println("POPRAWNA ODP: " + odpowiedziRed[Arrays.asList(pytaniaRed).indexOf(q)]);
			System.out.println("ROWNA SIE?: " + komenda.equals(odpowiedziRed[Arrays.asList(pytaniaRed).indexOf(q)]));
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			if ((komenda.contains("nie wiem") || komenda.contains("podpowiedz")))
			{
				a = false;
				ret = true;
				podpowiedz = true;
			} 
			
			else
			{
				if (tempR == 0)
				{
					if ((komenda.contains("zegar") || komenda.contains("zegarze")) && !komenda.contains("nie"))
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
				
				if (tempR == 1)
				{
					if ((komenda.contains("kon") || komenda.contains("koniu") || komenda.contains("konia"))
							&& !komenda.contains("nie"))
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
				
				if (tempR == 2)
				{
					if ((komenda.contains("termometrze") || komenda.contains("termometr"))
							&& !komenda.contains("nie"))
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
				
				if (tempR == 3)
				{
					if ((komenda.contains("czlowiek") || komenda.contains("czlowieka") || komenda.contains("czlowieku"))
							&& !komenda.contains("nie"))
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
			}
		}

		if (kolor == "niebieski")
		{
			if ((komenda.contains("nie wiem") || komenda.contains("podpowiedz")))
			{
				a = false;
				ret = true;
				podpowiedz = true;
			} 
			
			else
			{
				if (tempB == 0)
				{
					if ((komenda.contains("lew") || komenda.contains("lwie") || komenda.contains("lwa"))
							&& !komenda.contains("nie"))
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
				
				if (tempB == 1)
				{
					if ((komenda.contains("zolw") || komenda.contains("zolwiu") || komenda.contains("zolwia"))
							&& !komenda.contains("nie"))
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
				
				if (tempB == 2)
				{
					if ((komenda.contains("klepsydra") || komenda.contains("klepsydrze")
							|| komenda.contains("klepsydre")) && !komenda.contains("nie"))
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
				
				if (tempB == 3)
				{
					if (komenda.contains("nici") && !komenda.contains("nie"))
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
			}
		}

		if (kolor == "zielony")
		{
			if ((komenda.contains("nie wiem") || komenda.contains("podpowiedz")))
			{
				a = false;
				ret = true;
				podpowiedz = true;
			}
			
			else
			{
				System.out.println(komenda);
				
				if (tempG == 0)
				{
					if ((komenda.contains("spodnie") || komenda.contains("spodniach")) && !komenda.contains("nie"))
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
				
				if (tempG == 1)
				{
					if ((komenda.contains("rosa") || komenda.contains("rose") || komenda.contains("rosie"))
							&& !komenda.contains("nie"))
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
				
				if (tempG == 2)
				{
					if ((komenda.contains("fotel") || komenda.contains("fotelu")) && !komenda.contains("nie"))
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
				
				if (tempG == 3)
				{
					if (komenda.contains("echo") && !komenda.contains("nie"))
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
				ret = "Hacker: Johnny, porozmawiaj z tym stra�nikiem!\n(naci�nij enter)\n\n                                              ->";
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

	public String RemoveAccent(String komenda)
	{
		return komenda.replace('�', 'a')

				.replace('�', 'c')

				.replace('�', 'e')

				.replace('�', 'l')

				.replace('�', 'n')

				.replace('�', 'o')

				.replace('�', 's')

				.replace('�', 'z')

				.replace('�', 'z');
	}
}