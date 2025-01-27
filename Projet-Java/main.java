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
}
