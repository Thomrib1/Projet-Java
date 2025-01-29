public class Case { // Classe qui représente une case du plateau de jeu
    private int ligne;
    private int colonne;
    private Piece piece;

    public Case(int ligne, int colonne) {// Constructeur de la classe Case
        this.ligne = ligne;
        this.colonne = colonne;
        this.piece = null;
    }
