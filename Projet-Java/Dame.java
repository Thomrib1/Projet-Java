public class Dame extends Piece {
    public Dame(boolean estBlanc) {
        super(estBlanc);// Appel du constructeur de la classe mère
    }

    @Override
    public String toString() {
        return estBlanc ? "OD" : "XD";// Return la string représentant la pièce
    }
}
