public abstract class Piece {
    protected boolean estBlanc; // Cette variable indique si la pièce est blanche (true) ou noire (false).

    public Piece(boolean estBlanc) {
        this.estBlanc = estBlanc;// initialise la couleur de la pièce.
    }

    public boolean estBlanc() {
        return estBlanc; // Retourne la couleur de la pièce.
    }
}
