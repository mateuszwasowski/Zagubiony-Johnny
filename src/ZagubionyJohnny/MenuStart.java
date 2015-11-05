package ZagubionyJohnny;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.Icon;
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
		setSize(800, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
<<<<<<< HEAD
		Icon nowaGra = new ImageIcon("nowaGra.png");
		Icon nowaGraHover = new ImageIcon("nowaGraHover.png");
		JButton NowaGra = new JButton(nowaGra);
		Icon zasady = new ImageIcon("nowaGra.png");
		JButton Zasady = new JButton(zasady);
		Icon tworcy = new ImageIcon("nowaGra.png");
		JButton Tworcy = new JButton(tworcy);
		Icon wyjscie = new ImageIcon("nowaGra.png");
		JButton Wyjscie = new JButton(wyjscie);
		
		NowaGra.setBounds(275, 415, 250, 50);
		panel.add(NowaGra);
		NowaGra.setBorder(BorderFactory.createEmptyBorder());
		NowaGra.setContentAreaFilled(false);
=======
		JButton NowaGra = new JButton("Nowa gra");
		JButton Zasady = new JButton("Zasady gry");
		JButton Tworcy = new JButton("Twórcy");
		JButton Wyjscie = new JButton("Wyjście");
>>>>>>> 840faeccb65776d7690986df136d90fbf63172e5
		
		NowaGra.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				NowaGra.setRolloverIcon(nowaGraHover);
			}
			
			public void mouseExited(MouseEvent e)
			{
				NowaGra.setRolloverIcon(nowaGra);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
<<<<<<< HEAD
				setVisible(false);
				gra.setVisible(true);
=======
				NowaGra nowaGra = new NowaGra();
				nowaGra.setVisible(true);	
>>>>>>> 840faeccb65776d7690986df136d90fbf63172e5
			}
		});
		
		Zasady.setBounds(275, 475, 250, 50);
		panel.add(Zasady);
		Zasady.setBorder(BorderFactory.createEmptyBorder());
		Zasady.setContentAreaFilled(false);
		
		Zasady.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				Zasady.setRolloverIcon(nowaGraHover);
			}
			
			public void mouseExited(MouseEvent e)
			{
				Zasady.setRolloverIcon(nowaGra);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{			
				ZasadyGry zasadyGry = new ZasadyGry();
				zasadyGry.setVisible(true);
			}
		});

		Tworcy.setBounds(275, 535, 250, 50);
		panel.add(Tworcy);
		Tworcy.setBorder(BorderFactory.createEmptyBorder());
		Tworcy.setContentAreaFilled(false);
		
		Tworcy.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				Tworcy.setRolloverIcon(nowaGraHover);
			}
			
			public void mouseExited(MouseEvent e)
			{
				Tworcy.setRolloverIcon(nowaGra);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{				
				Tworcy tworcy = new Tworcy();
				tworcy.setVisible(true);
			}
		});
		
		Wyjscie.setBounds(275, 595, 250, 50);
		panel.add(Wyjscie);
		Wyjscie.setBorder(BorderFactory.createEmptyBorder());
		Wyjscie.setContentAreaFilled(false);

		Wyjscie.addMouseListener(new MouseAdapter() 
		{
			public void mouseEntered(MouseEvent e)
			{
				Wyjscie.setRolloverIcon(nowaGraHover);
			}
			
			public void mouseExited(MouseEvent e)
			{
				Wyjscie.setRolloverIcon(nowaGra);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.exit(0);
			}
		});
		
		JLabel label1 = new JLabel();
		label1.setIcon(new ImageIcon("tlo.png"));
		label1.setBounds(0, -50, 800, 800);
		panel.add(label1);
	}
}
