public class main {
    private Plateau plateau; // on crée 4 variables privées (ne peut être accèder que de puis le main ) servant à stocker les objets Plateau et Joueurs 
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueurCourant; // permet de suivre quel joueur doit jouer à tel moment dans la partie
    private InterfaceGraphique interfaceGraphique;

    public Jeu() {
        this.plateau = new Plateau(); // on crée un plateau
        this.joueur1 = new Joueur("Joueur 1", true);  // joueur 1 utilisera les pièces blanches
        this.joueur2 = new Joueur("Joueur 2", false); // joueur 2 utilisera les pièces noires
        this.joueurCourant = joueur1;
        this.gui = new InterfaceGraphique(this); // lie l'interface graphique à la partie 
    }

public void changerJoueur() {
    joueurCourant = (joueurCourant == joueur1) ? joueur2 : joueur1;
}


    public boolean deplacerPiece(int startX, int startY, int endX, int endY) { // méthode permettant de déplacer une pièce

        if (estMouvementValide(startX, startY, endX, endY)) { // si le mouvement est valide alors on peut déplacer la pièce

            plateau.deplacerPiece(startX, startY, endX, endY);

            verifierPromotion(endX, endY); // vérifie si la pièce doit être promue par exemple au rang de reine
            return true;
        }
        return false;
}
}
