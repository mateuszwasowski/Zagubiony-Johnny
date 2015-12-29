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
	private String[] r_pytania = {"Pytanie1","Pytanie2","Pytanie3","Pytanie4","Pytanie5","Pytanie6","Pytanie7"};
	private String[] b_pytania  = {"Pytanie1","Pytanie2","Pytanie3","Pytanie4","Pytanie5","Pytanie6","Pytanie7"};
	private String[] g_pytania  = {"Pytanie1","Pytanie2","Pytanie3","Pytanie4","Pytanie5","Pytanie6","Pytanie7"};
	private String[] r_odpowiedzi  = {"OdpowiedzNaPytanie1","OdpowiedzNaPytanie2","OdpowiedzNaPytanie3","OdpowiedzNaPytanie4","OdpowiedzNaPytanie5","OdpowiedzNaPytanie6","OdpowiedzNaPytanie7"};
	private String[] b_odpowiedzi = {"OdpowiedzNaPytanie1","OdpowiedzNaPytanie2","OdpowiedzNaPytanie3","OdpowiedzNaPytanie4","OdpowiedzNaPytanie5","OdpowiedzNaPytanie6","OdpowiedzNaPytanie7"};
	private String[] g_odpowiedzi = {"OdpowiedzNaPytanie1","OdpowiedzNaPytanie2","OdpowiedzNaPytanie3","OdpowiedzNaPytanie4","OdpowiedzNaPytanie5","OdpowiedzNaPytanie6","OdpowiedzNaPytanie7"};
	
	private String q1;
	private String q2;
	private String q3;
	
	//poprawnoœæi odpowiedzi
	private boolean a1;
	private boolean a2;
	private boolean a3;
	
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public Straznik(String s)
	{	
		a1 = false;
		a2 = false;
		a3 = false;
		
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
			q1 = r_pytania[temp1];
			
			while (temp1 >= 0){
				temp2 = rn.nextInt(7);
				if (temp2 != temp1 ){
					break;
				}
			}
			
			q2 = r_pytania[temp2];
			
			while (temp1 >= 0){
				temp3 = rn.nextInt(7);
				if ((temp3 != temp2) && (temp3 != temp1)){
					break;
				}
			}
			q3 = r_pytania[temp3];
		}
		
		else if (s == "niebieski")
		{
			map.put(497, 200);
			map.put(597, 250);
			map.put(547, 250);
			map.put(547, 200);
			
			temp1 = rn.nextInt(7);
			q1 = b_pytania[temp1];
			
			while (temp1 >= 0){
				temp2 = rn.nextInt(7);
				if (temp2 != temp1 ){
					break;
				}
			}
			
			q2 = b_pytania[temp2];
			
			while (temp1 >= 0){
				temp3 = rn.nextInt(7);
				if ((temp3 != temp2) && (temp3 != temp1)){
					break;
				}
			}
			q3 = b_pytania[temp3];
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
			q1 = g_pytania[temp1];
			
			while (temp1 >= 0){
				temp2 = rn.nextInt(7);
				if (temp2 != temp1 ){
					break;
				}
			}
			
			q2 = g_pytania[temp2];
			
			while (temp1 >= 0){
				temp3 = rn.nextInt(7);
				if ((temp3 != temp2) && (temp3 != temp1)){
					break;
				}
			}
			q3 = g_pytania[temp3];
		}
		
		int random = rn.nextInt(map.size());
		// System.out.println(random);
		
		List<Map.Entry<Integer, Integer>> randAccess = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		// System.out.println(randAccess.get(random).getKey());
		
		System.out.println(q1);
		System.out.println(q2);
		System.out.println(q3);
		
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
	
	public boolean success(){
		return (a1 && a2 && a3);
	}

	public String rozmowa(int r)
	{	
		String ret = "";

		//przywitanie:
		if (r == 1){
		ret  = "Hacker: Johnny, porozmawiaj z tym czymœ\nJohnny: Spróbujê! ... ... .. Czym jesteœ?";
		}
		else if ( r == 2)
		{
		
			if (kolor == "czerwony"){
				ret =  " ???: Witaj jestem stra¿nikiem czerwonego klucza!\n Tylko on umo¿liwi Ci przejœcie przez\n czerwone dzrzwi!";			
			}
			else if (kolor =="niebieski"){
				ret = " ???: Witaj jestem stra¿nikiem niebieskiego klucza!\nTylko on umo¿liwi Ci przejœcie przez\n niebieskie dzrzwi!";
			}
			else {
				ret =  "???: Witaj jestem stra¿nikiem zielonego klucza!\n Tylko on umo¿liwi Ci przejœcie przez\n zielone dzrzwi!";
			}
			
		}
		else if ( r == 3)
		{
				ret =  " Stra¿nik: Zadam Ci 3 zagadki\n Bêdziesz musia³ odpowiedzieæ na nie wszystkie,..";			
		}
		else if ( r == 4)
		{
				ret =  ",..jeœli chcesz zdobyæ mój klucz!";			
		}
		else if ( r == 5)
		{
				ret =  q1;			
		}
		else if ( r == 6)
		{
				ret =  q2;			
		}
		else if ( r == 7)
		{
				ret =  q3;			
		}
		
		return ret;

	}
}