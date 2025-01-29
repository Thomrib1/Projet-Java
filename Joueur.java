public class Joueur {
    private String nom;
    private boolean estBlanc;

    public Joueur(String nom, boolean estBlanc) { //
        this.nom = nom; // Initialise le nom du joueur
        this.estBlanc = estBlanc; // Initialise la couleur du joueur
    }

    public boolean estBlanc() { // Return si le joueur est blanc
        return estBlanc;
    }

    public String getNom() {
        return nom; // Retourne le nom du joueur
    }
}
