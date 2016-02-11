package ZagubionyJohnny;

import java.util.Random;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import static ZagubionyJohnny.Dzwiek.clip;
import static ZagubionyJohnny.Dzwiek.clip2;
import static ZagubionyJohnny.Dzwiek.clip3;
import static ZagubionyJohnny.Dzwiek.clip4;

public class ZagubionyJohnny extends JFrame
{
	Dzwiek dzwiek = new Dzwiek();

	private static final int fieldWidth = 6;
	private static final int fieldHeight = 6;
	private final Room[][] fieldButtons;

	int k = 0;
	int l = 0;
	int m = 497;
	int n = 0;
	int g1, g2, g3, g4;
	int rozmowa = 0;

	boolean kluczRed = false;
	boolean kluczBlue = false;
	boolean kluczGreen = false;

	JLabel korytarz;
	JLabel johnny;
	JLabel ekwipunek;
	JLabel buttonjohnny;
	JLabel buttonActive;
	JLabel buttonActive2;
	JLabel mapa;
	JLabel straznikRed;
	JLabel straznikBlue;
	JLabel straznikGreen;
	JLabel koniec;
	JLabel koniec2;

	JTextField konsola;
	JTextArea konsola2;
	JPanel pole;

	String komendy;
	String turn = "north";

	Random randomGenerator = new Random();

	public ZagubionyJohnny()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("Menu/ikonka.png"));
		setTitle("Zagubiony Johnny");
		setSize(800, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);

		korytarz = new JLabel();
		johnny = new JLabel();

		koniec = new JLabel();
		koniec.setBounds(0, 0, 800, 800);
		koniec.setIcon(new ImageIcon("Mapy/wyjszlem.png"));
		getContentPane().add(koniec);
		koniec.setVisible(false);

		koniec2 = new JLabel();
		koniec2.setBounds(0, 0, 800, 800);
		koniec2.setIcon(new ImageIcon("Mapy/koniec.png"));
		getContentPane().add(koniec2);
		koniec2.setVisible(false);

		korytarz.setIcon(new ImageIcon("Mapy/2.png"));
		korytarz.setBounds(0, 0, 500, 500);
		johnny.setIcon(new ImageIcon("Johnny/johnnyBackHall.png"));

		// straznicy
		straznikRed = new JLabel();
		straznikRed.setIcon(new ImageIcon("Straznik/straznikRed.png"));
		straznikRed.setBounds(0, 0, 500, 500);
		straznikRed.setVisible(false);

		straznikBlue = new JLabel();
		straznikBlue.setIcon(new ImageIcon("Straznik/straznikBlue.png"));
		straznikBlue.setBounds(0, 0, 500, 500);
		straznikBlue.setVisible(false);

		straznikGreen = new JLabel();
		straznikGreen.setIcon(new ImageIcon("Straznik/straznikGreen.png"));
		straznikGreen.setBounds(0, 0, 500, 500);
		straznikGreen.setVisible(false);

		johnny.setBounds(0, 0, 500, 500);
		getContentPane().add(johnny);
		getContentPane().add(straznikRed);
		getContentPane().add(straznikBlue);
		getContentPane().add(straznikGreen);
		getContentPane().add(korytarz);

		buttonjohnny = new JLabel();
		buttonjohnny.setIcon(new ImageIcon("Buttony/buttonJohnny.png"));
		buttonjohnny.setBounds(m, n, 50, 50);
		getContentPane().add(buttonjohnny);

		buttonActive = new JLabel();
		buttonActive.setIcon(new ImageIcon("Buttony/buttonActive.png"));
		buttonActive.setBounds(497, 0, 50, 50);
		getContentPane().add(buttonActive);

		buttonActive2 = new JLabel();
		buttonActive2.setIcon(new ImageIcon("Buttony/buttonActive.png"));
		buttonActive2.setBounds(497, 0, 50, 50);
		getContentPane().add(buttonActive2);

		mapa = new JLabel();
		mapa.setIcon(new ImageIcon("Mapy/mapa.png"));
		mapa.setBounds(497, 0, 300, 300);
		getContentPane().add(mapa);

		ekwipunek = new JLabel();
		ekwipunek.setIcon(new ImageIcon("Eq/ekwipunek.png"));
		ekwipunek.setBounds(-3, 300, 800, 500);

		pole = new JPanel();
		pole.setBounds(497, 0, fieldWidth * 50, fieldHeight * 50);
		pole.setLayout(new GridLayout(fieldHeight, fieldWidth, 0, 0));
		fieldButtons = new Room[fieldWidth][fieldHeight];

		Straznik r = new Straznik("czerwony");
		Straznik b = new Straznik("niebieski");
		Straznik g = new Straznik("zielony");

		for (int j = 0; j < fieldHeight; j++)
		{
			for (int i = 0; i < fieldWidth; i++)
			{
				fieldButtons[i][j] = new Room(i, j);
				pole.add(fieldButtons[i][j]);

				final int temp1 = i;
				final int temp2 = j;

				fieldButtons[temp1][temp2].addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent e)
					{
						// resetowanie stra¿ników przy klikniêciu myszy
						straznikRed.setVisible(false);
						straznikBlue.setVisible(false);
						straznikGreen.setVisible(false);

						buttonActive.setBounds(497 + (temp1 * 50), temp2 * 50, 50, 50);

						if ((temp1 == 4 && temp2 == 3) || (temp1 == 3 && temp2 == 4) || (temp1 == 4 && temp2 == 1))
						{
							korytarz.setIcon(new ImageIcon("Mapy/hallWayFilter.png"));
						}

						if ((temp1 == 1 && temp2 == 5) || (temp1 == 2 && temp2 == 5) || temp1 == 5 && temp2 == 0)
						{
							korytarz.setIcon(new ImageIcon("Mapy/1.png"));
						}

						if ((temp1 == 0 && temp2 == 0) || (temp1 == 0 && temp2 == 2) || (temp1 == 0 && temp2 == 4)
								|| (temp1 == 1 && temp2 == 3))
						{
							korytarz.setIcon(new ImageIcon("Mapy/2.png"));
						}

						if ((temp1 == 1 && temp2 == 0) || (temp1 == 2 && temp2 == 1) || (temp1 == 2 && temp2 == 2)
								|| (temp1 == 5 && temp2 == 2) || (temp1 == 5 && temp2 == 4))
						{
							korytarz.setIcon(new ImageIcon("Mapy/3.png"));
						}

						if ((temp1 == 2 && temp2 == 3) || (temp1 == 5 && temp2 == 1))
						{
							korytarz.setIcon(new ImageIcon("Mapy/4.png"));
						}

						if ((temp1 == 1 && temp2 == 1) || (temp1 == 3 && temp2 == 2) || (temp1 == 3 && temp2 == 1))
						{
							korytarz.setIcon(new ImageIcon("Mapy/5.png"));
						}

						if ((temp1 == 2 && temp2 == 4) || (temp1 == 4 && temp2 == 2))
						{
							korytarz.setIcon(new ImageIcon("Mapy/6.png"));
						}

						if ((temp1 == 1 && temp2 == 2) || (temp1 == 1 && temp2 == 4) || (temp1 == 4 && temp2 == 4))
						{
							korytarz.setIcon(new ImageIcon("Mapy/7.png"));
						}

						if (temp1 == 3 && temp2 == 0)
						{
							korytarz.setIcon(new ImageIcon("Mapy/8.png"));
						}

						if (temp1 != k || temp2 != l)
						{
							johnny.setVisible(false);
						}

						if (temp1 == k && temp2 == l)
						{
							johnny.setVisible(true);
						}

						//////////////////////////////////////////////////////////////////////////////////
						// sprawdzamy czy po zmianie kamery znajdujemy siê w pomieszczeniu ze stra¿nikiem
						//////////////////////////////////////////////////////////////////////////////////
						//////////////////////////////////////////////////////////////////////////////////
						//////////////////////////////////////////////////////////////////////////////////
						//////////////////////////////////////////////////////////////////////////////////
						//////////////////////////////////////////////////////////////////////////////////

						if ((497 + (temp1 * 50)) == r.getX() && (temp2 * 50) == r.getY())
						{
							straznikRed.setVisible(true);
						}

						else if ((497 + (temp1 * 50)) == g.getX() && (temp2 * 50) == g.getY())
						{
							straznikGreen.setVisible(true);
						}

						else if ((497 + (temp1 * 50)) == b.getX() && (temp2 * 50) == b.getY())
						{
							straznikBlue.setVisible(true);
						}
						//////////////////////////////////////////////////////////////////////////////////

						// Debug
						System.out.println(buttonActive.getX());
						System.out.println(buttonActive.getY());
						////////////////////////////////////////
					}

					public void mouseEntered(MouseEvent e)
					{
						buttonActive2.setBounds(497 + (temp1 * 50), temp2 * 50, 50, 50);
					}

					public void mouseExited(MouseEvent e)
					{
						buttonActive2.setBounds(0, 0, 0, 0);
					}
				});
			}
		}

		fieldButtons[0][0].setIcon(new ImageIcon("Buttony/button1.png"));
		fieldButtons[0][1].setVisible(false);
		fieldButtons[0][2].setIcon(new ImageIcon("Buttony/button1.png"));
		fieldButtons[0][3].setVisible(false);
		fieldButtons[0][4].setIcon(new ImageIcon("Buttony/button1.png"));
		fieldButtons[0][5].setVisible(false);

		fieldButtons[1][0].setIcon(new ImageIcon("Buttony/button2.png"));
		fieldButtons[1][1].setIcon(new ImageIcon("Buttony/button3.png"));
		fieldButtons[1][2].setIcon(new ImageIcon("Buttony/button4.png"));
		fieldButtons[1][3].setIcon(new ImageIcon("Buttony/button5.png"));
		fieldButtons[1][4].setIcon(new ImageIcon("Buttony/button7.png"));
		fieldButtons[1][5].setIcon(new ImageIcon("Buttony/button6.png"));

		fieldButtons[2][0].setVisible(false);
		fieldButtons[2][1].setIcon(new ImageIcon("Buttony/button8.png"));
		fieldButtons[2][2].setIcon(new ImageIcon("Buttony/button9.png"));
		fieldButtons[2][3].setIcon(new ImageIcon("Buttony/button10.png"));
		fieldButtons[2][4].setIcon(new ImageIcon("Buttony/button11.png"));
		fieldButtons[2][5].setIcon(new ImageIcon("Buttony/button6.png"));

		fieldButtons[3][0].setIcon(new ImageIcon("Buttony/button12.png"));
		fieldButtons[3][1].setIcon(new ImageIcon("Buttony/button3.png"));
		fieldButtons[3][2].setIcon(new ImageIcon("Buttony/button13.png"));
		fieldButtons[3][3].setVisible(false);
		fieldButtons[3][4].setIcon(new ImageIcon("Buttony/button14.png"));
		fieldButtons[3][5].setVisible(false);

		fieldButtons[4][0].setVisible(false);
		fieldButtons[4][1].setIcon(new ImageIcon("Buttony/button15.png"));
		fieldButtons[4][2].setIcon(new ImageIcon("Buttony/button11.png"));
		fieldButtons[4][3].setIcon(new ImageIcon("Buttony/button16.png"));
		fieldButtons[4][4].setIcon(new ImageIcon("Buttony/button4.png"));
		fieldButtons[4][5].setVisible(false);

		fieldButtons[5][0].setIcon(new ImageIcon("Buttony/button17.png"));
		fieldButtons[5][1].setIcon(new ImageIcon("Buttony/button10.png"));
		fieldButtons[5][2].setIcon(new ImageIcon("Buttony/button8.png"));
		fieldButtons[5][3].setVisible(false);
		fieldButtons[5][4].setIcon(new ImageIcon("Buttony/button8.png"));
		fieldButtons[5][5].setVisible(false);

		getContentPane().add(pole);

		konsola = new JTextField(komendy);
		konsola.setFont(new Font("Monospaced", Font.BOLD, 25));
		konsola.setForeground(Color.GREEN);
		konsola.setBackground(Color.BLACK);
		konsola.setBounds(20, 520, 760, 50);
		konsola.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		konsola2 = new JTextArea(komendy);
		konsola2.setFont(new Font("Monospaced", Font.BOLD, 25));
		konsola2.setForeground(Color.WHITE);
		konsola2.setBackground(Color.BLACK);
		konsola2.setBounds(20, 590, 760, 160);
		konsola2.setLineWrap(true);
		konsola2.setEditable(false);

		konsola.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				Komenda x = new Komenda(konsola);

				if (rozmowa == 0)
				{
					if (e.getKeyCode() == KeyEvent.VK_ENTER)
					{
						komendy = x.get();

						int randomInt = randomGenerator.nextInt(3);

						// numer losowej odpowiedzi
						System.out.println(randomInt);
						//////////////////////////////

						if (randomInt == 0)
						{
							konsola2.setText("Hacker: " + komendy + "\nJohnny: Okej, jestem. Gdzie mam iœæ dalej?");
						}

						if (randomInt == 1)
						{
							konsola2.setText("Hacker: " + komendy + "\nJohnny: Ju¿ jestem. Gdzie teraz?");
						}

						if (randomInt == 2)
						{
							konsola2.setText("Hacker: " + komendy + "\nJohnny: Dobra, dotar³em. Co dalej?");
						}

						// Debug
						System.out.println("K: " + k);
						System.out.println("L: " + l);
						//////////////////////////////

						if ("north".equals(turn))
						{
							g1 = 2;
							g2 = 3;
							g3 = 4;
							g4 = 5;
						}

						if ("south".equals(turn))
						{
							g1 = 3;
							g2 = 2;
							g3 = 5;
							g4 = 4;
						}

						if ("east".equals(turn))
						{
							g1 = 4;
							g2 = 5;
							g3 = 3;
							g4 = 2;
						}

						if ("west".equals(turn))
						{
							g1 = 5;
							g2 = 4;
							g3 = 2;
							g4 = 3;
						}

						int a = x.check();

						if (a == 1) // wyjscie
						{
							ZagubionyJohnny gra = new ZagubionyJohnny();
							MenuStart menu = new MenuStart(gra);
							menu.show();
							clip2.stop();
							clip.start();
							dispose();
						}

						else if (a == g1) // sciana na wprost
						{
							if (k == 0 && l == 0 || k == 1 && l == 0 || k == 3 && l == 0 || (k == 0 && l == 2)
									|| (k == 0 && l == 4) || (k == 1 && l == 3) || (k == 2 && l == 1)
									|| (k == 2 && l == 2) || (k == 2 && l == 4) || (k == 3 && l == 4)
									|| (k == 4 && l == 1) || (k == 4 && l == 2) || (k == 5 && l == 2)
									|| (k == 5 && l == 4))
							{
								if (randomInt == 0)
								{
									konsola2.setText("Hacker: " + komendy + "\nJohnny: Nie mogê tam iœæ!");
								}

								if (randomInt == 1)
								{
									konsola2.setText("Hacker: " + komendy + "\nJohnny: Tam nie ma drzwi!");
								}

								if (randomInt == 2)
								{
									konsola2.setText("Hacker: " + komendy + "\nJohnny: Nie przeniknê przez œcianê!");
								}
							}

							else
							{
								if (k == 5 && l - 1 == 0 && kluczGreen == false)
								{
									if (randomInt == 0)
									{
										konsola2.setText("Hacker: " + komendy + "\nJohnny: Drzwi s¹ zamkniête!");
									}

									if (randomInt == 1)
									{
										konsola2.setText("Hacker: " + komendy + "\nJohnny: Nie mogê otworzyæ tych drzwi!");
									}

									if (randomInt == 2)
									{
										konsola2.setText("Hacker: " + komendy + "\nJohnny: Ktoœ zamkn¹³ drzwi na klucz!");
									}
								}

								else
								{
									l = l - 1;
									buttonjohnny.setBounds(m, n = n - 50, 50, 50);
									johnny.setIcon(new ImageIcon("Johnny/johnnyBackHall.png"));
									turn = "north";
								}

								if (l == -1)
								{
									korytarz.setVisible(false);
									johnny.setVisible(false);
									konsola.setVisible(false);
									konsola2.setVisible(false);
									pole.setVisible(false);
									ekwipunek.setVisible(false);
									mapa.setVisible(false);
									buttonActive.setVisible(false);
									buttonActive2.setVisible(false);
									straznikRed.setVisible(false);
									straznikGreen.setVisible(false);
									straznikBlue.setVisible(false);
									requestFocus();

									clip2.stop();

									dzwiek.odtworzDrzwi();

									koniec2.setVisible(true);

									addKeyListener(new KeyAdapter()
									{
										public void keyPressed(KeyEvent e)
										{
											if (e.getKeyCode() == KeyEvent.VK_ENTER)
											{
												clip4.stop();

												dzwiek.odtworzDzwiekExit();

												konsola2.setVisible(false);
												koniec2.setVisible(false);
												koniec.setVisible(true);

												addKeyListener(new KeyAdapter()
												{
													public void keyPressed(KeyEvent e)
													{
														if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
														{
															ZagubionyJohnny gra = new ZagubionyJohnny();
															MenuStart menu = new MenuStart(gra);
															dispose();
															clip3.stop();
															clip.start();
															menu.show();
														}
													}
												});
											}
										}
									});
								}
							}
						}

						else if (a == g2) // sciana tylna (ta niewidoczna)
						{
							if (l == 5 || (k == 0 && l == 0) || (k == 0 && l == 2) || (k == 0 && l == 4)
									|| (k == 1 && l == 2) || (k == 2 && l == 1) || (k == 2 && l == 3)
									|| (k == 3 && l == 2) || (k == 3 && l == 4) || (k == 4 && l == 1)
									|| (k == 4 && l == 4) || (k == 5 && l == 1) || (k == 5 && l == 2)
									|| (k == 5 && l == 4))
							{
								if (randomInt == 0)
								{
									konsola2.setText("Hacker: " + komendy + "\nJohnny: Nie mogê tam iœæ!");
								}

								if (randomInt == 1)
								{
									konsola2.setText("Hacker: " + komendy + "\nJohnny: Tam nie ma drzwi!");
								}

								if (randomInt == 2)
								{
									konsola2.setText("Hacker: " + komendy + "\nJohnny: Nie przeniknê przez œcianê!");
								}
							}

							else
							{
								l = l + 1;
								buttonjohnny.setBounds(m, n = n + 50, 50, 50);
								johnny.setIcon(new ImageIcon("Johnny/johnny1.png"));
								turn = "south";

								if ((k == 4 && l == 3))
								{
									johnny.setIcon(new ImageIcon("Johnny/johnnyEnterHall.png"));
								}
							}
						}

						else if (a == g3) // lewa sciana
						{
							if (k == 0 || (k == 5 && l == 0) || (k == 1 && l == 1) || (k == 1 && l == 3)
									|| (k == 1 && l == 5) || (k == 2 && l == 5) || (k == 3 && l == 0)
									|| (k == 3 && l == 1) || (k == 3 && l == 2) || (k == 4 && l == 3))
							{
								if (randomInt == 0)
								{
									konsola2.setText("Hacker: " + komendy + "\nJohnny: Nie mogê tam iœæ!");
								}

								if (randomInt == 1)
								{
									konsola2.setText("Hacker: " + komendy + "\nJohnny: Tam nie ma drzwi!");
								}

								if (randomInt == 2)
								{
									konsola2.setText("Hacker: " + komendy + "\nJohnny: Nie przeniknê przez œcianê!");
								}
							}

							else
							{
								k = k - 1;
								buttonjohnny.setBounds(m = m - 50, n, 50, 50);
								johnny.setIcon(new ImageIcon("Johnny/johnny2.png"));
								turn = "west";
							}
						}

						else if (a == g4) // prawa sciana
						{
							if (k == 5 || (k == 1 && l == 0) || (k == 1 && l == 5) || (k == 2 && l == 1)
									|| (k == 2 && l == 2) || (k == 2 && l == 3) || (k == 2 && l == 5)
									|| (k == 3 && l == 0) || (k == 4 && l == 3))
							{
								if (randomInt == 0)
								{
									konsola2.setText("Hacker: " + komendy + "\nJohnny: Nie mogê tam iœæ!");
								}

								if (randomInt == 1)
								{
									konsola2.setText("Hacker: " + komendy + "\nJohnny: Tam nie ma drzwi!");
								}

								if (randomInt == 2)
								{
									konsola2.setText("Hacker: " + komendy + "\nJohnny: Nie przeniknê przez œcianê!");
								}
							}

							else
							{
								if (k + 1 == 2 && l == 2 && kluczRed == false)
								{
									if (randomInt == 0)
									{
										konsola2.setText("Hacker: " + komendy + "\nJohnny: Drzwi s¹ zamkniête!");
									}

									if (randomInt == 1)
									{
										konsola2.setText("Hacker: " + komendy + "\nJohnny: Nie mogê otworzyæ tych drzwi!");
									}

									if (randomInt == 2)
									{
										konsola2.setText("Hacker: " + komendy + "\nJohnny: Ktoœ zamkn¹³ drzwi na klucz!");
									}
								}

								else if (k + 1 == 3 && l == 4 && kluczBlue == false)
								{
									if (randomInt == 0)
									{
										konsola2.setText("Hacker: " + komendy + "\nJohnny: Drzwi s¹ zamkniête!");
									}

									if (randomInt == 1)
									{
										konsola2.setText("Hacker: " + komendy + "\nJohnny: Nie mogê otworzyæ tych drzwi!");
									}

									if (randomInt == 2)
									{
										konsola2.setText("Hacker: " + komendy + "\nJohnny: Ktoœ zamkn¹³ drzwi na klucz!");
									}
								}

								else
								{
									k = k + 1;
									buttonjohnny.setBounds(m = m + 50, n, 50, 50);
									johnny.setIcon(new ImageIcon("Johnny/johnny3.png"));
									turn = "east";
								}
							}
						}

						else if (a == 6) // johnny rozmawia ze straznikiem
						{
							// sprawdzamy czy johnny znajduje sie w tym samym
							// pomieszczeniu co straznik i aktywujemy rozmowe

							if (buttonjohnny.getX() == r.getX() && buttonjohnny.getY() == r.getY())
							{
								if (r.finished())
								{
									konsola2.setText("Hacker: " + komendy + "\nJohnny: Nic nie mówi. Normalnie skamienia³!");
									rozmowa = 0;
								}

								else
								{
									rozmowa = 1;
									konsola2.setText(r.rozmowa(rozmowa));

									if (r.getStarted() == true)
									{
										rozmowa = 5;
									}

									else
									{
										konsola.setEditable(false);
									}
								}
							}

							else if (buttonjohnny.getX() == g.getX() && buttonjohnny.getY() == g.getY())
							{
								if (g.finished())
								{
									konsola2.setText("Hacker: " + komendy + "\nJohnny: Hmm... te¿ skamienia³!");
									rozmowa = 0;
								}

								else
								{
									rozmowa = 1;
									konsola2.setText(g.rozmowa(rozmowa));

									if (g.getStarted() == true)
									{
										rozmowa = 5;
									}

									else
									{
										konsola.setEditable(false);
									}
								}
							}

							else if (buttonjohnny.getX() == b.getX() && buttonjohnny.getY() == b.getY())
							{
								if (b.finished())
								{
									konsola2.setText("Hacker: " + komendy + "\nJohnny: To nic nie da - skamienia³!");
									rozmowa = 0;
								}

								else
								{
									rozmowa = 1;
									konsola2.setText(b.rozmowa(rozmowa));

									if (b.getStarted() == true)
									{
										rozmowa = 5;
									}

									else
									{
										konsola.setEditable(false);
									}
								}
							}

							else
							{
								konsola2.setText("Nie ma tu nikogo");
							}
						}

						else if (a == 7)
						{
							if (randomInt == 0)
							{
								konsola2.setText("Hacker: " + komendy + "\nJohnny: Powiem Ci jak wyjdê");
							}

							if (randomInt == 1)
							{
								konsola2.setText("Hacker: " + komendy + "\nJohnny: \"Na £azarskim rejonie nie jest kolorowo\"");
							}

							if (randomInt == 2)
							{
								konsola2.setText("Hacker: " + komendy + "\nJohnny: Ciemno i zimno... nie to co u Ciebie");
							}
						}

						else if (a == 8)
						{
							if (randomInt == 0)
							{
								konsola2.setText("Hacker: " + komendy + "\nJohnny: " + komendy + "...");
							}

							if (randomInt == 1) 
							{
								konsola2.setText("Hacker: " + komendy + "\nJohnny: HA HA HA...");
							}

							if (randomInt == 2)
							{
								konsola2.setText("Hacker: " + komendy + "\nJohnny: Zero kultury...");
							}
						}

						else if (a == 9)
						{
							if (randomInt == 0)
							{
								konsola2.setText("Hacker: " + komendy + "\nJohnny: Nie mam zegarka");
							}

							if (randomInt == 1)
							{
								konsola2.setText("Hacker: " + komendy + "\nJohnny: Twoja ostatnia");
							}

							if (randomInt == 2)
							{
								konsola2.setText("Hacker: " + komendy + "\nJohnny: Godzina tortur!");
							}
						}

						else if (a == 0)
						{
							konsola2.setText("Drogi graczu, nie ma takiej komendy!\nAby wyœwietliæ dostêpne polecenia otwórz plik\n\"komendy.txt\"");
						}

						if (buttonActive.getX() == buttonjohnny.getX() && buttonActive.getY() == buttonjohnny.getY())
						{
							johnny.setVisible(true);
						}

						else
						{
							johnny.setVisible(false);
						}
					}

					if ((k == 3 && l == 4) && "west".equals(turn))
					{
						if (buttonActive.getX() == buttonjohnny.getX() && buttonActive.getY() == buttonjohnny.getY())
						{
							johnny.setVisible(true);
						}

						else
						{
							johnny.setVisible(false);
						}

						johnny.setIcon(new ImageIcon("Johnny/johnnyEnterHall.png"));
					}

					if ((k == 3 && l == 4) && "east".equals(turn))
					{
						if (buttonActive.getX() == buttonjohnny.getX() && buttonActive.getY() == buttonjohnny.getY())
						{
							johnny.setVisible(true);
						}

						else
						{
							johnny.setVisible(false);
						}

						johnny.setIcon(new ImageIcon("Johnny/johnnyBackHall.png"));
					}

					if ((k == 4 && l == 1) && "west".equals(turn))
					{
						if (buttonActive.getX() == buttonjohnny.getX() && buttonActive.getY() == buttonjohnny.getY())
						{
							johnny.setVisible(true);
						}

						else
						{
							johnny.setVisible(false);
						}

						johnny.setIcon(new ImageIcon("Johnny/johnnyEnterHall.png"));
					}

					if ((k == 4 && l == 1) && "east".equals(turn))
					{
						if (buttonActive.getX() == buttonjohnny.getX() && buttonActive.getY() == buttonjohnny.getY())
						{
							johnny.setVisible(true);
						}

						else
						{
							johnny.setVisible(false);
						}

						johnny.setIcon(new ImageIcon("Johnny/johnnyBackHall.png"));
					}
				}

				else // rozmowa true
				{
					if (e.getKeyCode() == KeyEvent.VK_ENTER)
					{
						if (rozmowa < 5)
						{
							if (buttonjohnny.getX() == r.getX() && buttonjohnny.getY() == r.getY())
							{
								rozmowa++;
								konsola2.setText(r.rozmowa(rozmowa));
							}

							else if (buttonjohnny.getX() == g.getX() && buttonjohnny.getY() == g.getY())
							{
								rozmowa++;
								konsola2.setText(g.rozmowa(rozmowa));
							}

							else if (buttonjohnny.getX() == b.getX() && buttonjohnny.getY() == b.getY())
							{
								rozmowa++;
								konsola2.setText(b.rozmowa(rozmowa));
							}

							if (rozmowa == 5)
							{
								konsola.setEditable(true);

								if (buttonjohnny.getX() == r.getX() && buttonjohnny.getY() == r.getY())
								{
									r.setStarted();
								}

								else if (buttonjohnny.getX() == g.getX() && buttonjohnny.getY() == g.getY())
								{
									g.setStarted();
								}

								else if (buttonjohnny.getX() == b.getX() && buttonjohnny.getY() == b.getY())
								{
									b.setStarted();
								}
							}
						}

						else if (rozmowa == 5) // pytanie
						{
							if (buttonjohnny.getX() == r.getX() && buttonjohnny.getY() == r.getY())
							{
								komendy = x.get();
								rozmowa++;
								konsola2.setText(r.rozmowa(rozmowa));
								r.odpowiedz(komendy);
							}

							else if (buttonjohnny.getX() == g.getX() && buttonjohnny.getY() == g.getY())
							{
								komendy = x.get();
								rozmowa++;
								konsola2.setText(g.rozmowa(rozmowa));
								g.odpowiedz(komendy);
							}

							else if (buttonjohnny.getX() == b.getX() && buttonjohnny.getY() == b.getY())
							{
								komendy = x.get();
								rozmowa++;
								konsola2.setText(b.rozmowa(rozmowa));
								b.odpowiedz(komendy);
							}
						}

						if (rozmowa > 5)
						{
							if (buttonjohnny.getX() == r.getX() && buttonjohnny.getY() == r.getY())
							{
								if (r.success())
								{
									konsola2.setText("Stra¿nik: TAK, to jest to!!\nJohnny: Przyjacielu, mam klucz, zaprowadŸ mnie do\nczerwonych drzwi!");
									r.setDone();
									kluczRed = true;
									ekwipunek.setIcon(new ImageIcon("Eq/ekwipunek1.png"));
								}

								else
								{
									if (r.getPodpowiedz() == true)
									{
										if (r.tempR == 0)
										{
											konsola2.setText("Stra¿nik: Mierzy czas! Pomyœl...");
										}
										
										else if (r.tempR == 1)
										{
											konsola2.setText("Stra¿nik: Galopuje. I ja ha ha!");
										}
										
										else if (r.tempR == 2)
										{
											konsola2.setText("Stra¿nik: Mierzy temperaturê! U¿yj wyobraŸni!");
										}
										
										else if (r.tempR == 3)
										{
											konsola2.setText("Stra¿nik: Istota ¿ywa, bardzo inteligentny ssak");
										}
									}
									
									else
									{
										konsola2.setText("Stra¿nik: Cokolwiek powiedzia³eœ, to na pewno nie by³a ta odpowiedŸ na któr¹ czekam! Przemyœl to\ni przyjdŸ jeszcze raz!");
									}
								}
							}

							else if (buttonjohnny.getX() == g.getX() && buttonjohnny.getY() == g.getY())
							{
								if (g.success())
								{
									konsola2.setText("Stra¿nik: Gratulujê!! Poda³eœ prawid³ow¹ odpowiedŸ\nJohnny: Przyjacielu, mam klucz, powiedz gdzie\ns¹ zielone drzwi!");
									g.setDone();
									kluczGreen = true;
									ekwipunek.setIcon(new ImageIcon("Eq/ekwipunek3.png"));
								}

								else
								{
									if (g.getPodpowiedz() == true)
									{
										if (g.tempG == 0)
										{
											konsola2.setText("Stra¿nik: Nosisz na dupie!");
										} 
									
										else if (g.tempG == 1)
										{
											konsola2.setText("Stra¿nik: Wczeœnie rano, na trawie");
										}
										
										else if (g.tempG == 2)
										{
											konsola2.setText("Stra¿nik: Siedzisz na nim jak ogl¹dasz TV");
										}
										
										else if (g.tempG == 3)
										{
											konsola2.setText("Stra¿nik: Papuguje po tobie, szczególnie w jaskiniach!");
										}

									}
									
									else
									{
										konsola2.setText("Stra¿nik: Niestety towarzyszu, to nie jest\npoprawna odpowiedŸ! PrzyjdŸ do mnie, gdy\nprzemyœlisz sprawê!");
									}
								}
							}

							else if (buttonjohnny.getX() == b.getX() && buttonjohnny.getY() == b.getY())
							{
								if (b.success())
								{
									konsola2.setText("Stra¿nik: A oto Twój klucz!\nJohnny: Hurraa! Mam kolejny. ZaprowadŸ mnie do\nniebieskich drzwi!");
									b.setDone();
									kluczBlue = true;
									ekwipunek.setIcon(new ImageIcon("Eq/ekwipunek2.png"));
								}

								else
								{
									if (b.getPodpowiedz() == true)
									{
										if (b.tempB == 0)
										{
											konsola2.setText("Stra¿nik: Król afryki, SIMBAAA!! Zastanów siê...");
										}
										
										else if (b.tempB == 1)
										{
											konsola2.setText("Stra¿nik: Bardzo wolny stwór, jednak ciut szybszy od królika!");
										}
										
										else if (b.tempB == 2)
										{
											konsola2.setText("Stra¿nik: Przesypuje siê w niej piasek! Myœl towarzyszu!");
										}
										
										else if (b.tempB == 3)
										{
											konsola2.setText("Stra¿nik: Liczba mnoga s³owa niæ. No kurde, to jest proste!");
										}
									}
									
									else
									{
										konsola2.setText("Stra¿nik: Jestem rozczarowany Twoj¹ odpowiedzi¹...\nWróæ, gdy bêdziesz gotowy!");
									}
								}
							}

							rozmowa = 0;
						}
					}
				}
			}
		});

		getContentPane().add(konsola);
		getContentPane().add(konsola2);
		getContentPane().add(ekwipunek);
	}

	public static void main(String[] args)
	{
		ZagubionyJohnny gra = new ZagubionyJohnny();
		MenuStart menu = new MenuStart(gra);
		menu.show();
	}
}