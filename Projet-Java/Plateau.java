public class Plateau {
    private Case[][] cases;
    private static final int TAILLE = 10;

    public Plateau() {
        cases = new Case[TAILLE][TAILLE];
        initialiserPlateau();
    }

    private void initialiserPlateau() { //on crée les cases et on place les pions
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                cases[i][j] = new Case(i, j);
                if ((i + j) % 2 != 0) {  // Cases noires uniquement (les cases blanches sont ignorées)
                    if (i < 4) {  // Pour les pièces noires
                        cases[i][j].setPiece(new Pion(false));
                    } else if (i > 5) {  // Pour les pièces blanches
                        cases[i][j].setPiece(new Pion(true));
                    }
                }
            }
        }
    }

    public void deplacerPiece(int startX, int startY, int endX, int endY) {
        Case start = cases[startX][startY];
        Case end = cases[endX][endY];
        end.setPiece(start.getPiece());
        start.setPiece(null);
    }
}
