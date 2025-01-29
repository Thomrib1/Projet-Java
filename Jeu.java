import java.util.Scanner;

public class Jeu { // on déclare les attributs de la classe Jeu : plateau, joueur1, joueur2, joueurActuel et scanner (5 variables d'instances )
    private Plateau plateau;
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueurActuel; //le joueur actuel 
    private Scanner scanner;

    public Jeu() {
        this.plateau = new Plateau();
        this.joueur1 = new Joueur("Joueur 1", true); // Les blancs sont : (O)
        this.joueur2 = new Joueur("Joueur 2", false); // Les noirs sont : (X)
        this.joueurActuel = joueur1;
        this.scanner = new Scanner(System.in);
    }

    public void jouer() {
        while (true) {
            plateau.afficher();
            
            if (joueurActuel.estBlanc()) {// Vérifie si le joueur actuel est blanc, si pas blanc : else noir 
                System.out.println("Tour des blancs (O)");
            } else {
                System.out.println("Tour des noirs (X)");
            }

            demanderEtDeplacerPion();
            changerJoueur();
        }
    }
    private void demanderEtDeplacerPion() {
        boolean mouvementValide = false;
        while (!mouvementValide) {
            System.out.println("Entrez la ligne et la colonne du pion a deplacer (ex: 5 2): ");
            int ligneDep = scanner.nextInt() - 1;
            int colonneDep = scanner.nextInt() - 1;

            System.out.println("Entrez la ligne et la colonne de la destination (ex: 4 3): ");
            int ligneArr = scanner.nextInt() - 1;
            int colonneArr = scanner.nextInt() - 1;

            if (plateau.deplacerPiece(ligneDep, colonneDep, ligneArr, colonneArr, joueurActuel)) {
                mouvementValide = true;
            } else {
                System.out.println("Mouvement pas bon. Ressaie.");
            }
        }
    }

    private void changerJoueur() {
        joueurActuel = (joueurActuel == joueur1) ? joueur2 : joueur1;
    }
}
