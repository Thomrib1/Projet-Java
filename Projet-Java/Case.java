public class Case { // Classe qui représente une case du plateau de jeu
    private int ligne;
    private int colonne;
    private Piece piece;

    public Case(int ligne, int colonne) {// Constructeur de la classe Case
        this.ligne = ligne;
        this.colonne = colonne;
        this.piece = null;
    }

    public boolean estVide() { // Méthode qui permet de savoir si la case est vide
        return piece == null;
    }

    public Piece getPiece() {// Méthode qui permet de récupérer la pièce sur la case
        return piece;
    }
