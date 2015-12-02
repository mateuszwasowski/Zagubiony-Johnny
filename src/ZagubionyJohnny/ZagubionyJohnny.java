package ZagubionyJohnny;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ZagubionyJohnny extends JFrame
{	
    private static final int fieldWidth = 5;
    private static final int fieldHeight = 5;
    private final Room[][] fieldButtons;
    
    JLabel korytarz;
    JLabel johnny;
    JLabel ekwipunek;
    JTextArea konsola;
    JPanel pole;
    
    String komendy;
    
	public ZagubionyJohnny() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("ikonka.png"));
		setTitle("Zagubiony Johnny");
		setSize(800, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		korytarz = new JLabel();
		johnny = new JLabel();
		korytarz.setIcon(new ImageIcon("hallwayfilter.png"));
		korytarz.setBounds(0, 0, 500, 500);
		johnny.setIcon(new ImageIcon("johnnybackhall.png"));
		johnny.setBounds(0, 0, 500, 500);
		getContentPane().add(johnny);
		getContentPane().add(korytarz);
		
		/*JLabel mapa = new JLabel();
		mapa.setIcon(new ImageIcon("mapa.png"));
		mapa.setBounds(497, 0, 300, 300);
		getContentPane().add(mapa);*/
		
		ekwipunek = new JLabel();
		ekwipunek.setIcon(new ImageIcon("ekwipunek.png"));
		ekwipunek.setBounds(497, 305, 300, 200);
		getContentPane().add(ekwipunek);
		
		pole = new JPanel();
		pole.setBounds(525, 10, fieldWidth * 50, fieldHeight * 50);
		pole.setLayout(new GridLayout(fieldHeight, fieldWidth, 0, 0));
        	fieldButtons = new Room[fieldWidth][fieldHeight];
        
	        for (int j = 0; j < fieldHeight; j++)
	        {    
	            for (int i = 0; i < fieldWidth; i++)
	            {
	                fieldButtons[i][j] = new Room(i, j);
	                fieldButtons[i][j].setBackground(Color.gray);
	                pole.add(fieldButtons[i][j]);
	            }
	        }
	        getContentPane().add(pole);
		
		konsola = new JTextArea(komendy);
		konsola.setFont(new Font("Monospaced", Font.BOLD, 25));
		konsola.setForeground(Color.GREEN);
		konsola.setBackground(Color.BLACK);
		konsola.setBounds(10, 530, 780, 150);
		konsola.setLineWrap(true);
		
	        konsola.addKeyListener(new KeyAdapter()
	        {
	            public void keyPressed(KeyEvent e)
	            {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER)
	                {
	                    komendy = konsola.getText();
	                    Pattern r = Pattern.compile("wyj\\w+", Pattern.CASE_INSENSITIVE);
	                    Matcher m = r.matcher(komendy);
	                    if(m.find())
	                    {
	                        ZagubionyJohnny gra = new ZagubionyJohnny();
	                        MenuStart menu = new MenuStart(gra);
	                        menu.show();
	                        setVisible(false);
	                        dispose();
	                        clip.stop();
	                    }
	                    System.out.println(komendy);
	                    konsola.setText(null);
	                }
	            }
	        });
	        
		getContentPane().add(konsola);
	}

	public static void main(String[] args) 
	{	
		ZagubionyJohnny gra = new ZagubionyJohnny();
		MenuStart menu = new MenuStart(gra);
		menu.show();
	}
}
