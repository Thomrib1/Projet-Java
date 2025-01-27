import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon; // classe pour charger une image
import javax.swing.WindowConstants;

public class InterfaceGraphique {

  public static void main(String[] args) {
    JFrame window = new JFrame("Jeu de dames");

    ImageIcon imageIcon = new ImageIcon("pictures/34466997-conseil-aux-dames-vecteur.jpg");
    JLabel imageLabel = new JLabel(imageIcon); // on crée un label pour afficher l'image

    window.add(imageLabel);

    window.setSize(300, 300);
    window.setLocation(100, 100);
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}
