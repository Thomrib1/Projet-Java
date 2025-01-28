public class Plateau {
    private Case[][] cases;
    private static final int TAILLE = 10;

    public Plateau() {
        cases = new Case[TAILLE][TAILLE];
        initialiserPlateau();
    }
