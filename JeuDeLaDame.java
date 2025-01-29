import java.util.Scanner;

public class JeuDeLaDame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] plateau = new char[10][10];
        initialiserPlateau(plateau);
        afficherPlateau(plateau);

        // Simuler quelques mouvements
        while (true) {
            System.out.println("Tour des blancs (O)");
            while (!deplacerPion(scanner, plateau, 'O')) {
                System.out.println("Mouvement pas bon. Ressaie.");
            }
            afficherPlateau(plateau);

            System.out.println("Tour des noirs (X)");
            while (!deplacerPion(scanner, plateau, 'X')) {
                System.out.println("Mouvement pas bon. Ressaie.");
            }
            afficherPlateau(plateau);
        }
    }

    //initialiser le plateau
    public static void initialiserPlateau(char[][] plateau) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i < 4 && (i + j) % 2 == 1) {
                    plateau[i][j] = 'X'; //les pions noirs
                } else if (i > 5 && (i + j) % 2 == 1) {
                    plateau[i][j] = 'O'; //les pions blancs
                } else {
                    plateau[i][j] = '.'; //les cases vides
                }
            }
        }
    }

    //afficher le plateau
    public static void afficherPlateau(char[][] plateau) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(plateau[i][j] + " ");
            }
            System.out.println();
        }
    }

    //déplacer un pion
    public static boolean deplacerPion(Scanner scanner, char[][] plateau, char pion) {
        System.out.println("Entrez la ligne et la colonne du pion à déplacer : ");
        int ligne = scanner.nextInt();
        int colonne = scanner.nextInt();
        System.out.println("Entrez la ligne et la colonne de la destination : ");
        int nouvelleLigne = scanner.nextInt();
        int nouvelleColonne = scanner.nextInt();

        return effectuerMouvement(plateau, ligne, colonne, nouvelleLigne, nouvelleColonne, pion);
    }

    //effectuer un mouvement
    public static boolean effectuerMouvement(char[][] plateau, int ligne, int colonne, int nouvelleLigne, int nouvelleColonne, char pion) {
        int deltaLigne = nouvelleLigne - ligne;
        int deltaColonne = nouvelleColonne - colonne;

        //vérifier si le mouvement est valide
        if (Math.abs(deltaLigne) == Math.abs(deltaColonne)) {
            //déplacement
            if (Math.abs(deltaLigne) == 1 && plateau[nouvelleLigne][nouvelleColonne] == '.') {
                plateau[nouvelleLigne][nouvelleColonne] = pion;
                plateau[ligne][colonne] = '.'; // libérer l'emplacement précédent
                return true;
            }
            //capture d'un pion
            else if (Math.abs(deltaLigne) == 2 && plateau[nouvelleLigne][nouvelleColonne] == '.') {
                int milieuLigne = (ligne + nouvelleLigne) / 2;
                int milieuColonne = (colonne + nouvelleColonne) / 2;
                if ((pion == 'O' && plateau[milieuLigne][milieuColonne] == 'X') || 
                    (pion == 'X' && plateau[milieuLigne][milieuColonne] == 'O')) {
                    plateau[nouvelleLigne][nouvelleColonne] = pion;
                    plateau[ligne][colonne] = '.'; // libérer l'emplacement précédent
                    plateau[milieuLigne][milieuColonne] = '.'; // capturer le pion
                    return true;
                }
            }
        }
        return false;
    }
}