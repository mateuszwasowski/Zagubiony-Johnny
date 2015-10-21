package ZagubionyJohnny;

public class ZagubionyJohnny {
	
	public ZagubionyJohnny() {
		
	}

	public static void main(String[] args) 
	{	
		ZagubionyJohnny gra = new ZagubionyJohnny();
		MenuStart menu = new MenuStart(gra);
		menu.setVisible(true);
	}
}