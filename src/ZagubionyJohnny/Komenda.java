package ZagubionyJohnny;

import javax.swing.JTextArea;

public class Komenda {
	
	private JTextArea kons;
	private String last;
	
	public Komenda(JTextArea k)
	{
		kons = k;
	}
	
	public String getText (){
		return kons.getText();
	}

	
	public String get(){
		String s =kons.getText();
		kons.setText(null);
		s = s.toLowerCase();
		s = RemoveAccent(s);
		s.replace("\n", "");
		last = s;
		return s;
		
	}
	public int check(){
		if  (last.equals("\nwyjscie") == true){
			return 1;
		}
		else if (last.equals("\nidz do przodu") == true){
			return 2;
		}
		else{
		return 0;
		}
	}
	public String getLast(){
		return last;
	}
	
	public String RemoveAccent(String s)

	{

	return s.replace('�', 'a')
	
	  .replace('�', 'c')
	
	  .replace('�', 'e')
	
	  .replace('�', 'l')
	
	  .replace('�', 'n')
	
	  .replace('�', 'o')
	
	  .replace('�', 's')
	
	  .replace('�', 'z')
	
	  .replace('�', 'z')
	
	  .replace('�', 'A')
	
	  .replace('�', 'C')
	
	  .replace('�', 'E')
	
	  .replace('�', 'L')
	
	  .replace('�', 'N')
	
	  .replace('�', 'O')
	
	  .replace('�', 'S')
	
	  .replace('�', 'Z')
	
	  .replace('�', 'Z');
		

	}
}
