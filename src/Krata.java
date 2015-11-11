import java.awt.Color;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class Krata
{
  private JFrame frame;
  private static final int fieldWidth=5;
  private static final int fieldHeight=4;
  private Room[][] fieldButtons;
    
  public static void main(String[] args)
  {
    Krata window = new Krata();
    window.frame.setVisible(true);	
  }
    
  public Krata()
  {
    initialize();
  }
  
  private void initialize()
  {
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(100, 100, fieldWidth*50, fieldHeight*50);
    frame.getContentPane().setLayout(new GridLayout(fieldHeight, fieldWidth, 0, 0));
    fieldButtons=new Room[fieldWidth][fieldHeight];
    for (int j=0; j<fieldHeight; j++)
    {    
      for (int i=0; i<fieldWidth; i++)
      {
        fieldButtons[i][j] = new Room(i,j);
        fieldButtons[i][j].setBackground(Color.gray);
        frame.getContentPane().add(fieldButtons[i][j]);
      }
    }
  }
    
}
