package ZagubionyJohnny;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuStart extends JFrame
{
	private JPanel panel;
	private ZagubionyJohnny gra;

	public MenuStart(ZagubionyJohnny gra) 
	{		
		this.gra = gra;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("ikonka.png"));
		setTitle("Zagubiony Johnny");
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JButton NowaGra = new JButton("Nowa gra");
		JButton Zasady = new JButton("Zasady gry");
		JButton Tworcy = new JButton("Twórcy");
		JButton Wyjscie = new JButton("Wyjście");
		
		NowaGra.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				NowaGra nowaGra = new NowaGra();
				nowaGra.setVisible(true);	
			}
		});
		NowaGra.setBounds(570, 400, 140, 40);
		panel.add(NowaGra);
		
		Zasady.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{			
				ZasadyGry zasadyGry = new ZasadyGry();
				zasadyGry.setVisible(true);
			}
		});
		Zasady.setBounds(570, 450, 140, 40);
		panel.add(Zasady);

		Tworcy.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{				
				Tworcy tworcy = new Tworcy();
				tworcy.setVisible(true);
			}
		});
		Tworcy.setBounds(570, 500, 140, 40);
		panel.add(Tworcy);

		Wyjscie.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.exit(0);
			}
		});
		Wyjscie.setBounds(570, 550, 140, 40);
		panel.add(Wyjscie);
		
		JLabel label1 = new JLabel("");
		label1.setIcon(new ImageIcon("tlo.png"));
		label1.setBounds(0, 0, 1280, 720);
		panel.add(label1);
	}
}
