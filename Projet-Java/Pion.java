public class Pion extends Piece {
    public Pion(boolean estBlanc) { // Constructeur de la classe Pion
        super(estBlanc); // Appel du constructeur de la classe mère
    }

    @Override // Indique que la méthode redéfinit une méthode de la classe mère
    public String toString() {// Méthode qui retourne une représentation en chaîne de caractères de l'objet
        return estBlanc ? "O" : "X";
    }
}
