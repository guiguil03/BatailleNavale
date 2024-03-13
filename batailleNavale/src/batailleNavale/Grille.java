package batailleNavale;
import java.util.Random;
import java.util.Scanner;


class Grille {
    private Case[][] grille;
    private int nombreDePorteAvions;
    private int nombreDeTorpilleurs;
    private int nombreDeContreTorpilleur;
    public int getNombreDePorteAvions() {
        return nombreDePorteAvions;
    }

    public int getNombreDeTorpilleurs() {
        return nombreDeTorpilleurs;
    }

    public int getNombreDeContreTorpilleur() {
        return nombreDeContreTorpilleur;
    }

    public Grille() {
        grille = new Case[10][10];
        initialiserGrille();
        nombreDePorteAvions = 2; // Modifier selon le nombre souhaité
        nombreDeTorpilleurs = 2; // Modifier selon le nombre souhaité
        nombreDeContreTorpilleur = 3; // Modifier selon le nombre souhaité
    }

    public void initialiserGrille() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grille[i][j] = new Case(); // E pour Eau
            }
        }
    }
    public boolean caseEstLibre(int x, int y) {
        return grille[x][y].getContenu().equals("-");
    }

   

    public void ajouterNavire(Navire navire) {
        int x = navire.getPositionX();
        int y = navire.getPositionY();

        if(caseEstLibre(x,y)) {
    
         for (int i = 0; i < navire.getLongueur(); i++) {
            if (x >= 0 && x < grille.length && y >= 0 && y < grille[0].length ) {
                grille[x][y].setContenu(navire.getSymbole()); // Utilisation du symbole du navire
            }
            if (navire.isHorizontal()) {
                x++;
            } else {
                y++;
            }
        }
        }
       
    }
    public void afficherGrille() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(grille[i][j]);
            }
            System.out.println();
        }
    }
    public void afficherGrilleJoueur() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Affichez seulement les cases touchées et les navires coulés
                if (grille[i][j].getContenu().equals("K") || grille[i][j].getContenu().equals("Y")) {
                    System.out.print(grille[i][j]);
                } else {
                    System.out.print("-"); // Cachez les navires non touchés
                }
            }
            System.out.println();
        }
    }
    public void placerNaviresAleatoires(Grille grille) {
        Random random = new Random();

        for (int i = 0; i < grille.getNombreDePorteAvions(); i++) {
            PorteAvions porteAvions = new PorteAvions();
            porteAvions.genererPositionAleatoire(grille);
            grille.ajouterNavire(porteAvions);
        }

        for (int i = 0; i < grille.getNombreDeTorpilleurs(); i++) {
            Torpilleur torpilleur = new Torpilleur();
            torpilleur.genererPositionAleatoire(grille);
            grille.ajouterNavire(torpilleur);
        }

        for (int i = 0; i < grille.getNombreDeContreTorpilleur(); i++) {
            ContreTorpilleur contreTorpillleur = new ContreTorpilleur();
            contreTorpillleur.genererPositionAleatoire(grille);
            grille.ajouterNavire(contreTorpillleur);
        }
    }
    public static boolean SatisfaitGrille1() {
        Grille grilleJoueur1 = new Grille();
        Grille grilleJoueur2 = new Grille();
        Partie partie= new Partie();
        boolean running = false;
        Scanner sc = new Scanner(System.in);

        while (!running) {
            System.out.println("La grille vous convient-elle? 1/0");
            int choice = sc.nextInt();

            if (choice == 0) {
                grilleJoueur1.initialiserGrille();
                grilleJoueur1.placerNaviresAleatoires(grilleJoueur1);
                grilleJoueur1.afficherGrille();
                running = false;  
            } else {
                running = true;
            }
        }

		return running;
    }
    
    public static boolean SatisfaitGrille2() {
    	Grille grilleJoueur2 = new Grille();
    	Partie partie= new Partie();
    	boolean running = false;
    	Scanner sc = new Scanner(System.in);
    	
    	while (!running) {
    		System.out.println("La grille vous convient-elle? 1/0");
    		int choice = sc.nextInt();
    		
    		if (choice == 0) {
    			grilleJoueur2.initialiserGrille();
    			grilleJoueur2.placerNaviresAleatoires(grilleJoueur2);
    			grilleJoueur2.afficherGrille();
    			running = false;  
    		} else {
    			running = true;
    		}
    	}
    	
    	return running;
    }
    
    public Case[][] getGrille() {
        return grille;
    }
    public void caseContientNavire(int ligne, int colonne) {
        grille[ligne][colonne].setContenu("N");
    }
    public boolean caseContientRien(int ligne, int colonne) {
    	return grille[ligne][colonne].getContenu()=="-";
    }

    public void marquerCaseTouchee(int ligne, int colonne) {
        
        grille[ligne][colonne].setContenu("T");
    }
        

   

    // Ajoutez d'autres méthodes pour afficher la grille, vérifier les attaques, etc.
}