package batailleNavale;

import java.util.Random;
import java.util.Scanner;
import java.util.random.*;
import java.io.*;




class Grille {
    private Case[][] grille;
    private int nombreDePorteAvions=2;
    private int nombreDeTorpilleurs=2;
    private int nombreDeContreTorpilleur=3;
    public int length;

    public int getNombreDePorteAvions() {
    	return nombreDePorteAvions;
    }
    public int getNombreDeTorpilleurs() {
    	return nombreDeTorpilleurs;
    }
    public int getNombreDeContreTorpilleur() {
    	return nombreDeContreTorpilleur;
    }
    public Grille(Case[][]grille,int tailleX, int tailleY) {
        grille = new Case[tailleX][tailleY];
        initialiserGrille(grille,tailleX,tailleY);
    }

    public Grille(Case[][] grilleCases) {
        // TODO Auto-generated constructor stub
    }

    public void initialiserGrille(Case[][] grille,int tailleX, int tailleY) {
        for (int i = 0; i < tailleX; i++) {
            for (int j = 0; j < tailleY; j++) {
                grille[i][j] = new Case(); // E pour Eau
            }
        }
    }
    public static boolean caseEstLibre1(Case[][]grille,int x, int y) {
        return grille[x][y].getContenu().equals("-");
    }
    public boolean caseEstOccupe(int x, int y) {
        return grille[x][y].getContenu().equals("T") || grille[x][y].getContenu().equals("C") || grille[x][y].getContenu().equals("P");
    } 

   	public static void ajouterNavire(Case[][] grille,Navire navire) {
		Random random = new Random();
		int tailleX = grille.length;
		int tailleY = grille[0].length;

		while (!navire.estPlace()) {

			int x = random.nextInt(tailleX);
			int y = random.nextInt(tailleY);
			boolean horizontal = random.nextBoolean();

			if (positionValide(grille,navire, x, y, horizontal)) {
				placerNavire(grille,navire, x, y, horizontal);
			}
		}
	}

	private static boolean positionValide(Case[][]grille,Navire navire, int x, int y, boolean horizontal) {
		int tailleX = grille.length;
		int tailleY = grille[0].length;

		if (horizontal && x + navire.getLongueur() > tailleX) {
			return false;
		}
		if (!horizontal && y + navire.getLongueur() > tailleY) {
			return false;
		}

		// Vérifier si les cases nécessaires pour le navire sont libres
		for (int i = 0; i < navire.getLongueur(); i++) {
			int posX = horizontal ? x + i : x;
			int posY = horizontal ? y : y + i;
			if (!caseEstLibre1(grille,posX, posY)) {
				return false;
			}
		}
		return true;
	}

	private static void placerNavire(Case[][]grille,Navire navire, int x, int y, boolean horizontal) {
		for (int i = 0; i < navire.getLongueur(); i++) {
			int posX = horizontal ? x + i : x;
			int posY = horizontal ? y : y + i;
			grille[posX][posY].setContenu(navire.getSymbole());
		}
		navire.setPlace(true);
	}

	public static void viderGrille(Case[][]grille, int tailleX, int tailleY) {
		for(int i=0; i<tailleX; i++) {
			for(int j=0; j<tailleY; j++) {
				grille[i][j].setContenu("-");;
			}
		}
	}
	public void afficherGrille(Case[][]grille,int tailleX, int tailleY) {
		for (int i = 0; i < tailleX; i++) {
			for (int j = 0; j < tailleY; j++) {
				System.out.print(grille[i][j]);
			}
			System.out.println();
		}
	}
	public void afficherGrilleJoueur(Case[][]grille,int tailleX,int tailleY) {
		for (int i = 0; i < tailleX; i++) {
			for (int j = 0; j < tailleY; j++) {
				// Affichez seulement les cases touchées et les navires coulés
				if (grille[i][j].getContenu().equals("N") || grille[i][j].getContenu().equals("O")) {
					System.out.print(grille[i][j]);
				} else {
					System.out.print("-"); // Cachez les navires non touchés
				}
			}
			System.out.println();
		}
	}

	public void placerNaviresAleatoires(Case[][] grille, int tailleX, int tailleY) {
		Random random = new Random();

		// Générer 3 porte-avions
		for (int i = 0; i < getNombreDePorteAvions(); i++) {
			PorteAvions porteAvions = new PorteAvions();
			porteAvions.genererPositionAleatoire(grille, tailleX, tailleY);
			ajouterNavire(grille,porteAvions);
		}

		// Générer 2 torpilleurs
		for (int i = 0; i < getNombreDeTorpilleurs(); i++) {
			Torpilleur torpilleur = new Torpilleur();
			torpilleur.genererPositionAleatoire(grille, tailleX, tailleY);
			ajouterNavire(grille,torpilleur);
		}

		// Générer 3 contre-torpilleurs
		for (int i = 0; i < getNombreDeContreTorpilleur(); i++) {
			ContreTorpilleur contreTorpillleur = new ContreTorpilleur();
			contreTorpillleur.genererPositionAleatoire(grille, tailleX, tailleY);
			ajouterNavire(grille,contreTorpillleur);
		}
	}



	public static boolean SatisfaitGrille1(Case[][]grille,int tailleX,int tailleY) {

		Partie partie = new Partie();
		boolean running = false;
		Scanner sc = new Scanner(System.in);

		Case[][] grilleJoueur1= new Case[tailleX][tailleY];
		Grille grilleJoueur1a = new Grille(grilleJoueur1);

		while (!running) {
			System.out.println("La grille vous convient-elle? 1/0");
			int choice = sc.nextInt();

			if (choice == 0) {
				grilleJoueur1a.initialiserGrille(grilleJoueur1,tailleX,tailleY);
	            grilleJoueur1a.placerNaviresAleatoires(grilleJoueur1,tailleX,tailleY); // Correction ici
				grilleJoueur1a.afficherGrille(grilleJoueur1,tailleX,tailleY);

			} else {
				running = true;
			}
		}

		return running;
	}

	public static boolean SatisfaitGrille2(Case[][]grille,int tailleX,int tailleY) {
		Partie partie = new Partie();
		boolean running = false;
		Scanner sc= new Scanner(System.in);


		Case[][] grilleJoueur2= new Case[tailleX][tailleY];
		Grille grilleJoueur2a = new Grille(grilleJoueur2);
		while (!running) {
			System.out.println("La grille vous convient-elle? 1/0");
			int choice = sc.nextInt();

			if (choice == 0) {
				grilleJoueur2a.initialiserGrille(grilleJoueur2,tailleX,tailleY);
				grilleJoueur2a.placerNaviresAleatoires(grilleJoueur2,tailleX,tailleY);
				grilleJoueur2a.afficherGrille(grilleJoueur2,tailleX,tailleY);

			} else {
				running = true;
			}
		}

		return running;
	}
	private int obtenirNouvelleCoordonnee(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.print(message);
		return sc.nextInt();
	}
	private boolean obtenirNouvelleCoordonnee1(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.print(message);
		return sc.nextBoolean();
	}
	public int NouvelleCoordonnee(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.print(message);
		return sc.nextInt();
	}    


	public void placerPorteAvions(Case[][] grille, int x, int y, boolean horizontal) {
		PorteAvions porteAvions = new PorteAvions();
		porteAvions.setPositionX(x);
		porteAvions.setPositionY(y);

		porteAvions.setHorizontal(horizontal);
		if(!(caseTouchee(grille,x,y)) && x >= 0 && x < grille.length-3 && y >= 0 && y < grille.length-3) {


			// Vérifier si l'emplacement est valide pour placer le porte-avions
			ajouterNavire(grille,porteAvions); // Ajouter le porte-avions à la grille
			System.out.println("Porte-avions placé avec succès !");
		} else {
			System.out.println("Placement invalide pour le porte-avions. Veuillez réessayer.");
			// Redemander à l'utilisateur de placer le porte-avions
			int newX = obtenirNouvelleCoordonnee("Entrez la nouvelle coordonnée x : ");
			int newY = obtenirNouvelleCoordonnee("Entrez la nouvelle coordonnée y : ");
			boolean horizontal1= obtenirNouvelleCoordonnee1("Entrez le nouveau positionnement :");
			placerPorteAvions(grille,newX, newY, horizontal1); 

		}

	}


	public boolean PositionnerPA(Case[][] grille2,int tailleX, int tailleY) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Placez votre porte-avions (4 cases).");
		System.out.println("Entrez les coordonnées x et y de départ et indiquez si le porte-avions est horizontal (true) ou vertical (false).");
		int x = sc.nextInt();
		int y = sc.nextInt();
		boolean horizontal = sc.nextBoolean();
		PorteAvions porteAvions = new PorteAvions();
		porteAvions.setPositionX(x);
		porteAvions.setPositionY(y);
		porteAvions.setHorizontal(horizontal);

		if((caseEstLibre1(grille2,x,y)) && x >= 0 && x < grille2.length-3 && y >= 0 && y < grille2.length-3) {


			// Vérifier si l'emplacement est valide pour placer le porte-avions
			placerNavire(grille,porteAvions,x,y,horizontal);
			System.out.println("Porte-avions placé avec succès !");
		}else {
			System.out.println("Placement invalide pour le porte-avions. Veuillez réessayer.");
			// Redemander à l'utilisateur de placer le porte-avions
			int newX = obtenirNouvelleCoordonnee("Entrez la nouvelle coordonnée x : ");
			int newY = obtenirNouvelleCoordonnee("Entrez la nouvelle coordonnée y : ");
			boolean horizontal1= obtenirNouvelleCoordonnee1("Entrez le nouveau positionnement :");
			porteAvions.setPositionX(newX);
			porteAvions.setPositionY(newY);
			porteAvions.setHorizontal(horizontal1);
			
			placerNavire(grille,porteAvions,newX, newY, horizontal1); 

		}




		afficherGrille(grille,tailleX, tailleY);


		return true;
	}
	public void placerTorpilleur(Case[][] grille,int x, int y, boolean horizontal) {
		Torpilleur torpilleurs= new Torpilleur();
		torpilleurs.setPositionX(x);
		torpilleurs.setPositionY(y);

		torpilleurs.setHorizontal(horizontal);

		if((caseEstLibre1(grille,x,y)) && x >= 0 && x < grille.length-1 && y >= 0 && y < grille.length-1) {


			// Vérifier si l'emplacement est valide pour placer le porte-avions
			ajouterNavire(grille, torpilleurs); // Ajouter le porte-avions à la grille
			System.out.println("Porte-avions placé avec succès !");
		} else {
			System.out.println("Placement invalide pour le porte-avions. Veuillez réessayer.");
			// Redemander à l'utilisateur de placer le porte-avions
			int newX = obtenirNouvelleCoordonnee("Entrez la nouvelle coordonnée x : ");
			int newY = obtenirNouvelleCoordonnee("Entrez la nouvelle coordonnée y : ");
			boolean horizontal1= obtenirNouvelleCoordonnee1("Entrez le nouveau positionnement :");
			placerPorteAvions(grille,newX, newY, horizontal1); 
		}

	}
	public boolean PositionnerTO(Case[][] grille,int tailleX, int tailleY) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Placez votre torpilleurs (2 cases).");
		System.out.println("Entrez les coordonnées x et y de départ et indiquez si le porte-avions est horizontal (true) ou vertical (false).");
		int x = sc.nextInt();
		int y = sc.nextInt();
		boolean horizontal = sc.nextBoolean();
		placerTorpilleur(grille,x, y, horizontal);
		afficherGrille(grille,tailleX, tailleY);    	
		return true;
	}
	public void placerCTorpilleur(Case[][] grille,int x, int y, boolean horizontal) {
		ContreTorpilleur contreTorpilleurs= new ContreTorpilleur();
		contreTorpilleurs.setPositionX(x);
		contreTorpilleurs.setPositionY(y);

		contreTorpilleurs.setHorizontal(horizontal);

		if(!(caseTouchee(grille,x,y))) {

			// Vérifier si l'emplacement est valide pour placer le porte-avions
			ajouterNavire(grille,contreTorpilleurs); // Ajouter le porte-avions à la grille
			System.out.println("Porte-avions placé avec succès !");
		} else {
			System.out.println("Placement invalide pour le porte-avions. Veuillez réessayer.");
			// Redemander à l'utilisateur de placer le porte-avions
			int newX = obtenirNouvelleCoordonnee("Entrez la nouvelle coordonnée x : ");
			int newY = obtenirNouvelleCoordonnee("Entrez la nouvelle coordonnée y : ");
			boolean horizontal1= obtenirNouvelleCoordonnee1("Entrez le nouveau positionnement :");
			//placerPorteAvions(grille,newX, newY, horizontal1); 

		}
	}
	public  boolean PositionnerCTO(Case[][] grille,int tailleX, int tailleY) {
		// Initialisation de la grille et d'autres variables nécessaires
		Scanner sc = new Scanner(System.in);

		// Demander au joueur de placer un porte-avions
		System.out.println("Placez votre torpilleurs (3 cases).");
		System.out.println("Entrez les coordonnées x et y de départ et indiquez si le porte-avions est horizontal (true) ou vertical (false).");
		int x = sc.nextInt();
		int y = sc.nextInt();
		boolean horizontal = sc.nextBoolean();

		// Placer le porte-avions dans la grille
		placerCTorpilleur(grille,x, y, horizontal);
		afficherGrille(grille,tailleX, tailleY);

		// Code pour le reste de la logique de votre jeu...

		return true;
	}
	public void GenererSeul(Case[][] grille, int tailleX, int tailleY) {
		if(5<tailleX && tailleX<7 && 5<tailleY && tailleY<7) {
			PositionnerPA(grille,tailleX, tailleY);
			PositionnerTO(grille,tailleX, tailleY);
			PositionnerTO(grille,tailleX, tailleY);
			PositionnerPA(grille, tailleX, tailleY);
		}else {
			PositionnerPA(grille,tailleX, tailleY);
			PositionnerPA(grille,tailleX, tailleY);
			PositionnerTO(grille,tailleX, tailleY);
			PositionnerTO(grille,tailleX, tailleY);
			PositionnerCTO(grille, tailleX, tailleY);
			PositionnerCTO(grille, tailleX, tailleY);
			PositionnerCTO(grille, tailleX, tailleY);
		}
	}
	public void modeRadar(Grille grille,int ligne, int colonne) {
		
	}



	public void caseContientNavire(Case[][]grille,int ligne, int colonne) {
		grille[ligne][colonne].setContenu("N");
	}
	public boolean caseTouchee(Case[][] grille,int ligne, int colonne) {
		return grille[ligne][colonne].getContenu()=="C" || grille[ligne][colonne].getContenu()=="P" || grille[ligne][colonne].getContenu()=="T";
	}
	public boolean caseContientRien(Case[][]grille,int ligne, int colonne) {
		return grille[ligne][colonne].getContenu()=="-";
	}
	public boolean CaseDeJouer(Case[][]grille,int ligne,int colonne) {
		return grille[ligne][colonne].getContenu()== "N" ||grille[ligne][colonne].getContenu()== "O"  ;
	}

	public void marquerCaseTouchee(Case [][] grille,int ligne, int colonne) {

		grille[ligne][colonne].setContenu("O");
	}
	public boolean verifierCase(int ligne, int colonne) {
		if(grille[ligne][colonne].caseContientNavire(ligne,colonne) || grille[ligne][colonne].marqueCaseTouchee(ligne,colonne)) {
			System.out.println("Case deja jouer impossible de jouer ici veuillez rejouer");
		}else {
			return true;
		}
		return false;
	}




	// Ajoutez d'autres méthodes pour afficher la grille, vérifier les attaques, etc.
}
