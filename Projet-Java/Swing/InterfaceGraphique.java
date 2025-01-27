import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class InterfaceGraphique {

  public static void main(String[] args) {
    JFrame window = new JFrame("Jeu de dames");
    window.add(new JLabel("test  swing vierge"));
    window.setSize(300,100);
    window.setLocation(100, 100);
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}
