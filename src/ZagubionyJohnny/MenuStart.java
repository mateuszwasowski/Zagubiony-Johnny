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

import static ZagubionyJohnny.Dzwiek.clip;

public class MenuStart extends JFrame
{
	private JPanel panel;
	private ZagubionyJohnny gra;
	private Dzwiek dzwiek;

	public MenuStart(ZagubionyJohnny gra)
	{
		this.gra = gra;

		setIconImage(Toolkit.getDefaultToolkit().getImage("Menu/ikonka.png"));
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

		Icon nowaGra = new ImageIcon("Buttony/nowaGra.png");
		Icon nowaGraHover = new ImageIcon("Buttony/nowaGraHover.png");
		JButton NowaGra = new JButton(nowaGra);
		Icon zasady = new ImageIcon("Buttony/zasady.png");
		Icon zasadyHover = new ImageIcon("Buttony/zasadyHover.png");
		JButton Zasady = new JButton(zasady);
		Icon tworcy = new ImageIcon("Buttony/tworcy.png");
		Icon tworcyHover = new ImageIcon("Buttony/tworcyHover.png");
		JButton Tworcy = new JButton(tworcy);
		Icon wyjscie = new ImageIcon("Buttony/wyjscie.png");
		Icon wyjscieHover = new ImageIcon("Buttony/wyjscieHover.png");
		JButton Wyjscie = new JButton(wyjscie);

		// NOWA GRA
		NowaGra.setBounds(275, 415, 250, 50);
		panel.add(NowaGra);
		NowaGra.setBorder(BorderFactory.createEmptyBorder());
		NowaGra.setContentAreaFilled(false);

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
				dispose();
				gra.show();
				clip.stop();
				dzwiek.odtworzDzwiekGra();
			}
		});

		// ZASADY
		Zasady.setBounds(275, 475, 250, 50);
		panel.add(Zasady);
		Zasady.setBorder(BorderFactory.createEmptyBorder());
		Zasady.setContentAreaFilled(false);

		Zasady.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				Zasady.setRolloverIcon(zasadyHover);
			}

			public void mouseExited(MouseEvent e)
			{
				Zasady.setRolloverIcon(zasady);
			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				ZasadyGry zasadyGry = new ZasadyGry();
				zasadyGry.setVisible(true);
			}
		});

		// TW�RCY
		Tworcy.setBounds(275, 535, 250, 50);
		panel.add(Tworcy);
		Tworcy.setBorder(BorderFactory.createEmptyBorder());
		Tworcy.setContentAreaFilled(false);

		Tworcy.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				Tworcy.setRolloverIcon(tworcyHover);
			}

			public void mouseExited(MouseEvent e)
			{
				Tworcy.setRolloverIcon(tworcy);
			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				Tworcy tworcy = new Tworcy();
				tworcy.setVisible(true);
			}
		});

		// WYJ�CIE
		Wyjscie.setBounds(275, 595, 250, 50);
		panel.add(Wyjscie);
		Wyjscie.setBorder(BorderFactory.createEmptyBorder());
		Wyjscie.setContentAreaFilled(false);

		Wyjscie.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				Wyjscie.setRolloverIcon(wyjscieHover);
			}

			public void mouseExited(MouseEvent e)
			{
				Wyjscie.setRolloverIcon(wyjscie);
			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				System.exit(0);
			}
		});

		// T�O
		JLabel label1 = new JLabel();
		label1.setIcon(new ImageIcon("Menu/tlo.png"));
		label1.setBounds(0, -50, 800, 800);
		panel.add(label1);
		dzwiek.odtworzDzwiekMenu();
	}
}