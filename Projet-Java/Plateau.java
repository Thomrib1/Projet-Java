public class Plateau {
    private static final int TAILLE = 10;
    private Case[][] cases;

    public Plateau() {
        initialiserPlateau();
    }

    private void initialiserPlateau() {
        cases = new Case[TAILLE][TAILLE];
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                cases[i][j] = new Case(i, j);
                if (i < 4 && (i + j) % 2 == 1) { // Les pions noirs sont placés sur les cases noires 0 à 3
                    cases[i][j].setPiece(new Pion(false)); // Pions noirs
                } else if (i > 5 && (i + j) % 2 == 1) { // Les pions blanc sont placés sur les cases noires 6 à 9
                    cases[i][j].setPiece(new Pion(true)); // Pions blancs
                }
            }
        }
    }

    public void afficher() {
        // Affiche les numéros des colonnes
        System.out.print("    "); // Espaces pour aligner avec les numéros de ligne
        for (int j = 1; j <= TAILLE; j++) {
            if (j < 10) {
                System.out.print(j + "  ");
            } else {
                System.out.print(j + " ");
            }
        }
        System.out.println();
        
        System.out.print("   ");
        for (int j = 0; j < TAILLE * 3 + 1; j++) {
            System.out.print("-");
        }
        System.out.println();

        // Affiche le plateau avec les numéros de ligne
        for (int i = 0; i < TAILLE; i++) {
            if (i + 1 < 10) {
                System.out.print(" " + (i + 1) + " |");
            } else {
                System.out.print((i + 1) + " |");
            }
            
            for (int j = 0; j < TAILLE; j++) {
                if (cases[i][j].estVide()) {
                    System.out.print(" . "); //Affiche un "." pour une case vide.
                } else {
                    Piece piece = cases[i][j].getPiece();
                    System.out.print(" " + (piece.estBlanc() ? "O" : "X") + " "); // Affiche O pour un pion blanc et X pour un pion noir.
                }
            }
            System.out.println();
        }
    }

    public boolean deplacerPiece(int ligneDep, int colonneDep, int ligneArr, int colonneArr, Joueur joueur) {
        if (!estDansLesPlateau(ligneDep, colonneDep) || !estDansLesPlateau(ligneArr, colonneArr)) {
            return false; // Déplace un pion si le mouvement est valide.
        }
        Case caseDepart = cases[ligneDep][colonneDep];
        Case caseArrivee = cases[ligneArr][colonneArr];
        if (caseDepart.estVide() || !caseArrivee.estVide()) {
            return false;
        }
        Piece piece = caseDepart.getPiece();
        if (piece.estBlanc() != joueur.estBlanc()) {
            return false;
        }
        int deltaLigne = ligneArr - ligneDep;
        int deltaColonne = colonneArr - colonneDep;
        if (Math.abs(deltaLigne) != Math.abs(deltaColonne)) {
            return false;// Vérification pour le mouvement en diagonale
        }
        if (Math.abs(deltaLigne) == 1) { //Vérifie que le joueur déplace bien un pion de sa couleur
            caseArrivee.setPiece(piece);
            caseDepart.setPiece(null);
            return true;
        }
        // Capture
        if (Math.abs(deltaLigne) == 2) { 
            int milieuLigne = (ligneDep + ligneArr) / 2;
            int milieuColonne = (colonneDep + colonneArr) / 2;
            Case caseMilieu = cases[milieuLigne][milieuColonne];
            
            if (!caseMilieu.estVide() && caseMilieu.getPiece().estBlanc() != piece.estBlanc()) { //Vérifie si la case intermédiaire n'est pas vide et si la pièce sur cette case est de couleur opposée à celle de la pièce qui se déplace.
                caseArrivee.setPiece(piece); // Déplace la pièce sur la case d'arrivée.
                caseDepart.setPiece(null); // Vide la case de départ.
                caseMilieu.setPiece(null); // Vide la case intermédiaire.
                return true;
            }
        }
        return false;
    }

    private boolean estDansLesPlateau(int ligne, int colonne) {// Vérifie que les coordonnées sont dans les limites du plateau
        return ligne >= 0 && ligne < TAILLE && colonne >= 0 && colonne < TAILLE;
    }
}
