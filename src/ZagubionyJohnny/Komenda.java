package ZagubionyJohnny;

import javax.swing.JTextField;

public class Komenda
{
	private JTextField kons;
	private String last;

	public Komenda(JTextField k)
	{
		kons = k;
	}

	public String getText()
	{
		return kons.getText();
	}

	public String get()
	{
		String s = kons.getText();
		kons.setText(null);
		s = s.toLowerCase();
		s = RemoveAccent(s);
		s.replace("\n", "");
		last = s;
		return s;
	}

	public int check()
	{
		if (last.equals("wyjscie") || last.equals("wyjdz") == true)
		{
			return 1;
		}
		
		else if (last.equals("idz do przodu") || last.equals("idz prosto") || last.equals("idz przed siebie")
				|| last.equals("idz naprzod") || last.equals("idz w przod") || last.equals("pojdz do przodu")
				|| last.equals("pojdz prosto") || last.equals("pojdz przed siebie") || last.equals("pojdz naprzod") || last.equals("prosto")
				|| last.equals("pojdz w przod") == true)
		{
			return 2;
		}
		
		else if (last.equals("idz do tylu") || last.equals("idz wstecz") || last.equals("idz w tyl")
				|| last.equals("pojdz do tylu") || last.equals("pojdz wstecz") || last.equals("pojdz w tyl")
				|| last.equals("cofnij sie") || last.equals("wroc sie") || last.equals("zawroc")
				|| last.equals("wroc") == true)
		{
			return 3;
		}
		
		else if (last.equals("idz w lewo") || last.equals("pojdz w lewo") || last.equals("w lewo") 
				|| last.equals("lewo") == true)
		{
			return 4;
		}
		
		else if (last.equals("idz w prawo") || last.equals("pojdz w prawo") || last.equals("w prawo") 
				|| last.equals("prawo") == true)
		{
			return 5;
		}
		
		else if (last.equals("rozmowa") || last.equals("kto to") || last.equals("kim jestes") || last.equals("czym jestes") == true)
		{
			return 6;
		}	
		
		else
		{
			return 0;
		}
	}

	public String getLast()
	{
		return last;
	}

	public String RemoveAccent(String s)
	{
		return s.replace('¹', 'a')

				.replace('æ', 'c')

				.replace('ê', 'e')

				.replace('³', 'l')

				.replace('ñ', 'n')

				.replace('ó', 'o')

				.replace('œ', 's')

				.replace('Ÿ', 'z')

				.replace('¿', 'z');
	}
}