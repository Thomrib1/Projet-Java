import java.util.Scanner;

public class JeuDeLaDame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //plateau de 10x10
        char[][] plateau = new char[10][10];

        //plateau avec des pions blancs (B) et noirs (N)
        initialiserPlateau(plateau);

        //afficher le plateau
        afficherPlateau(plateau);

        while (true) {
            System.out.println("Tour des blancs (O)");
            deplacerPion(scanner, plateau, 'O');
            afficherPlateau(plateau);

            System.out.println("Tour des noirs (X)");
            deplacerPion(scanner, plateau, 'X');
            afficherPlateau(plateau);
        }
    }

    //initialiser le plateau
    public static void initialiserPlateau(char[][] plateau) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i < 3 && (i + j) % 2 == 1) {
                    plateau[i][j] = 'X'; //les pions noirs
                } else if (i > 4 && (i + j) % 2 == 1) {
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
    public static void deplacerPion(Scanner scanner, char[][] plateau, char pion) {
        System.out.println("Entrez la ligne et la colonne du pion à déplacer (ex: 5 2): ");
        int ligne = scanner.nextInt() - 1;
        int colonne = scanner.nextInt() - 1;
        System.out.println("Entrez la ligne et la colonne de la destination (ex: 4 3): ");
        int nouvelleLigne = scanner.nextInt() - 1;
        int nouvelleColonne = scanner.nextInt() - 1;

        //mouvement si valide ?
        if (plateau[ligne][colonne] == pion) {
            int deltaLigne = nouvelleLigne - ligne;
            int deltaColonne = nouvelleColonne - colonne;

            //mouvement si en diagonale ?
            if (Math.abs(deltaLigne) == Math.abs(deltaColonne)) {
                //déplacement
                if (Math.abs(deltaLigne) == 1 && plateau[nouvelleLigne][nouvelleColonne] == '.') {
                    plateau[nouvelleLigne][nouvelleColonne] = pion;
                    plateau[ligne][colonne] = '.';
                }
                //capture d'un pion
                else if (Math.abs(deltaLigne) == 2 && plateau[nouvelleLigne][nouvelleColonne] == '.') {
                    int milieuLigne = (ligne + nouvelleLigne) / 2;
                    int milieuColonne = (colonne + nouvelleColonne) / 2;
                    if ((pion == 'O' && plateau[milieuLigne][milieuColonne] == 'X') || 
                        (pion == 'X' && plateau[milieuLigne][milieuColonne] == 'O')) {
                        plateau[nouvelleLigne][nouvelleColonne] = pion;
                        plateau[ligne][colonne] = '.';
                        plateau[milieuLigne][milieuColonne] = '.';
                    } else {
                        System.out.println("Mouvement pas bon. Ressaie.");
                    }
                } else {
                    System.out.println("Mouvement pas bon. Ressaie.");
                }
            } else {
                System.out.println("Mouvement pas bon. Ressaie.");
            }
        } else {
            System.out.println("Mouvement pas bon. Ressaie.");
        }
    }
}