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
		String x = s;
		x = x.substring(0, 1).toUpperCase() + x.substring(1);
		s = RemoveAccent(s);
		s.replace("\n", "");
		last = s;

		return x;
	}

	public int check()
	{
		if (last.equals("wyjscie") || last.equals("wyjdz") || last.equals("exit") || last.equals("zakoncz gre")
				|| last.equals("koniec") || last.equals("menu glowne") || last.equals("menu") || last.equals("wychodze")
				|| last.equals("nie chce mi sie") == true)
		{
			return 1;
		}

		else if (last.equals("idz do przodu") || last.equals("pojdz do przodu") || last.equals("idz naprzod")
				|| last.equals("pojdz naprzod") || last.equals("idz w przod") || last.equals("pojdz w przod")
				|| last.equals("idz prosto") || last.equals("pojdz prosto") || last.equals("idz przed siebie")
				|| last.equals("pojdz przed siebie") || last.equals("prosto") || last.equals("do przodu")
				|| last.equals("naprzod") || last.equals("w przod") == true)
		{
			return 2;
		}

		else if (last.equals("idz do tylu") || last.equals("pojdz do tylu") || last.equals("idz w tyl")
				|| last.equals("pojdz w tyl") || last.equals("idz wstecz") || last.equals("pojdz wstecz")
				|| last.equals("cofnij sie") || last.equals("wroc sie") || last.equals("zawroc") || last.equals("wroc")
				|| last.equals("cofnij") || last.equals("wstecz") || last.equals("w tyl")
				|| last.equals("do tylu") == true)
		{
			return 3;
		}

		else if (last.equals("idz w lewo") || last.equals("pojdz w lewo") || last.equals("skrec w lewo")
				|| last.equals("w lewo") || last.equals("lewo") == true)
		{
			return 4;
		}

		else if (last.equals("idz w prawo") || last.equals("pojdz w prawo") || last.equals("skrec w prawo")
				|| last.equals("w prawo") || last.equals("prawo") == true)
		{
			return 5;
		}

		else if (last.equals("kto to") || last.equals("co to") || last.equals("kto to jest")
				|| last.equals("co to jest") || last.equals("kim jestes") || last.equals("czym jestes")
				|| last.equals("rozmowa") || last.equals("straznik") || last.equals("witaj") || last.equals("czesc")
				|| last.equals("hej") == true)
		{
			return 6;
		}

		else if (last.equals("co tam") || last.equals("jaka pogoda") || last.equals("co slychac")
				|| last.equals("jak sie masz") || last.equals("co u Ciebie") == true)
		{
			return 7;
		}

		else if (last.equals("frajer") || last.equals("debil") || last.equals("swinia") || last.equals("pajac"))
		{
			return 8;
		}

		else if (last.equals("ktora godzina") || last.equals("ktora na osi") || last.equals("ktora jest godzina"))
		{
			return 9;
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