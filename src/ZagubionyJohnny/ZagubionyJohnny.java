package ZagubionyJohnny;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ZagubionyJohnny extends JFrame
{	
	private static final int fieldWidth=5;
    private static final int fieldHeight=5;
    private final Room[][] fieldButtons;
    
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
		
		JLabel korytarz = new JLabel();
		JLabel johnny = new JLabel();
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
		
		JLabel ekwipunek = new JLabel();
		ekwipunek.setIcon(new ImageIcon("ekwipunek.png"));
		ekwipunek.setBounds(497, 305, 300, 200);
		getContentPane().add(ekwipunek);
		
		JTextArea konsola = new JTextArea();
		String komendy = konsola.getText();
		konsola.setForeground(Color.GREEN);
		konsola.setBackground(Color.BLACK);
		konsola.setBounds(10, 530, 780, 150);
		konsola.setLineWrap(true);
		getContentPane().add(konsola);
		
		JPanel field = new JPanel();
        field.setBounds(525, 10, fieldWidth*50, fieldHeight*50);
        field.setLayout(new GridLayout(fieldHeight, fieldWidth, 0, 0));
        fieldButtons=new Room[fieldWidth][fieldHeight];
        
        for (int j=0; j<fieldHeight; j++)
        {    
            for (int i=0; i<fieldWidth; i++)
            {
                fieldButtons[i][j] = new Room(i,j);
                fieldButtons[i][j].setBackground(Color.gray);
                field.add(fieldButtons[i][j]);
            }
        }
        getContentPane().add(field);
	}

	public static void main(String[] args) 
	{	
		ZagubionyJohnny gra = new ZagubionyJohnny();
		MenuStart menu = new MenuStart(gra);
		Dzwiek dzwiek = new Dzwiek();
		
		menu.show();
		dzwiek.otworzDzwiek();
	}
}