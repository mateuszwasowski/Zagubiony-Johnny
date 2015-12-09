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
		if  (last.equals("wyjscie") == true)
		{
			return 1;
		}
		else if (last.equals("idz do przodu") == true)
		{
			return 2;
		}
        else if (last.equals("idz do tylu") == true)
        {
			return 3;
		}
        else if (last.equals("idz w lewo") == true)
        {
			return 4;
		}
        else if (last.equals("idz w prawo") == true)
        {
			return 5;
		}
        else if (last.equals("pomoc") == true)
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

	return s.replace('π', 'a')
	
	  .replace('Ê', 'c')
	
	  .replace('Í', 'e')
	
	  .replace('≥', 'l')
	
	  .replace('Ò', 'n')
	
	  .replace('Û', 'o')
	
	  .replace('ú', 's')
	
	  .replace('ü', 'z')
	
	  .replace('ø', 'z')
	
	  .replace('•', 'A')
	
	  .replace('∆', 'C')
	
	  .replace(' ', 'E')
	
	  .replace('£', 'L')
	
	  .replace('—', 'N')
	
	  .replace('”', 'O')
	
	  .replace('å', 'S')
	
	  .replace('è', 'Z')
	
	  .replace('Ø', 'Z');
	}
}
