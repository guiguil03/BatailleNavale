package batailleNavale;
import java.io.*;

import java.util.*;
public class Partie implements Serializable{
	private boolean EtatPartie;
	private Joueur joueurs;
	private static int ScoreJoueur1;
	private static int ScoreJoueur2;
	private static Grille grilleJoueur1;
	private Joueur joueur1;
	private Joueur joueur2;

	

	public void chargerGrilleJoueur1(Grille grille) {
		this.grilleJoueur1 = grille;
	}

	public void chargerGrilleJoueur2(Grille grille) {
	}

	;

	public void setJoueurs(Joueur j1, Joueur j2) {
		this.joueur1 = j1;
		this.joueur2=j2;
	}

	public String getNomJoueur1() {
		return joueur1.getNomJoueur();
	}

	public String getNomJoueur2() {
		return joueur2.getNomJoueur();
	}


	public boolean isEtatPartie() {
		return EtatPartie;
	}
	public void setEtatPartie(boolean etatPartie) {
		EtatPartie = etatPartie;
	}
	public Joueur getJoueurs() {
		return joueurs;
	}
	public void setJoueurs(Joueur joueurs) {
		this.joueurs = joueurs;
	}
	public static int getScoreJoueur1() {
		return ScoreJoueur1;
	}
	public static void setScoreJoueur1(int scoreJoueur1) {
		ScoreJoueur1 += scoreJoueur1;
	}
	public static int getScoreJoueur2() {
		return ScoreJoueur2;
	}
	public static void setScoreJoueur2(int scoreJoueur2) {
		ScoreJoueur2 += scoreJoueur2;
	}
	public boolean checkEntree(int e) {
		if(e>10) {
			System.out.println("Saisi Invalide");
			return false;
		}
		return true;
	}
	private boolean estDansGrille(Case[][] grille,int ligne, int colonne) {
		return ligne >= 0 && ligne < grille.length && colonne >= 0 && colonne < grille[0].length;
	}
	public boolean estGrilleVide(Grille grille) {
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille.length; j++) {
				if (!grille.equals("-")) {
					return false; // S'il y a une case non vide, la grille n'est pas vide
				}
			}
		}
		return true; // Si aucune case non vide n'a été trouvée, la grille est vide
	}


	public void sauvegarderPartie(String fileName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
			System.out.println("La partie a été sauvegardée avec succès !");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Partie chargerPartie(String fileName) {
		Partie partie = null;
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			partie = (Partie) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("La partie a été chargée avec succès !");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return partie;
	}
	public void interactionUtilisateur() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Voulez-vous sauvegarder la partie en cours ? (Oui/Non) ");
		String sauvegarder = sc.nextLine();
		if (sauvegarder.equalsIgnoreCase("Oui")) {
			sauvegarderPartie("partie_en_cours.sav");
			System.out.println("La partie en cours a été sauvegardée.");
		}

		System.out.println("Voulez-vous charger une partie existante ? (Oui/Non) ");
		String charger = sc.nextLine();
		if (charger.equalsIgnoreCase("Oui")) {
			Partie partieChargee = chargerPartie("partie_en_cours.sav");
			if (partieChargee != null) {
				System.out.println("La partie a été chargée avec succès.");
				// Faites ce que vous devez faire avec la partie chargée
			} else {
				System.out.println("Impossible de charger la partie.");
			}
		}
	}

	/*public static void Rejouer(Case[][] grille,int tailleX, int tailleY) {
		afficherGrilleJoueur(grille,tailleX, tailleY);
		System.out.println("Vous pouvez rejouer a vous de retaper les coordonnées");
		int ligne1=grille.NouvelleCoordonnee("Retaper une coordonée x");
		int colonne1=grille.NouvelleCoordonnee("Retaper une coordonnée y");


		if(!(caseContientRien(grille,ligne1,colonne1))){
			System.out.println("Touché !");
			setScoreJoueur1(1);
			gcaseContientNavire(grille,ligne1, colonne1);

			afficherGrilleJoueur(grille,tailleX,tailleY);
			System.out.println("Le score du joueur 1 est de " + getScoreJoueur1());
		} else{

			grille.marquerCaseTouchee(ligne1, colonne1) ;
			System.out.println("Manqué !");
			System.out.println("Le score du joueur 1 est de " + getScoreJoueur1());
			grille.marquerCaseTouchee(ligne1, colonne1);

			grille.afficherGrilleJoueur(tailleX,tailleY);
		}
	}*/






	public void Partie(Joueur joueur, Joueur joueur3,int tailleX, int tailleY) {
		Joueur joueur1=new Joueur();
		Joueur joueur2= new Joueur();
		setJoueurs(joueur1,joueur2);
		System.out.println(joueur2.getNomJoueur());
		Case[][] grilleJoueur1 = new Case[tailleX][tailleY];
		Case[][] grilleJoueur2 = new Case[tailleX][tailleY];
		Grille grilleJoueur1a= new Grille(grilleJoueur1);
		Grille grilleJoueur2a= new Grille(grilleJoueur2);
		int compteur=0;
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("Voulez vous génerer automatiquement la grille (0) ou de facon manuelle (1)");
		int choice= scanner.nextInt();
		scanner.nextLine();
		switch(choice){
		case 0: 

			initialiserGrille(grilleJoueur1,tailleX,tailleY);
			initialiserGrille(grilleJoueur2,tailleX,tailleY);
			grilleJoueur1a.placerNaviresAleatoires(grilleJoueur1,tailleX,tailleY);
			grilleJoueur2a.placerNaviresAleatoires(grilleJoueur2,tailleX,tailleY);


			System.out.println("Grille du joueur 1");
			grilleJoueur1a.afficherGrille(grilleJoueur1,tailleX,tailleY);      
			System.out.println("///////////////////////////:::");
			if(grilleJoueur1a.SatisfaitGrille1(grilleJoueur1,tailleX,tailleY)) {
				System.out.println("Grille du joueur 2");
				grilleJoueur2a.afficherGrille(grilleJoueur2,tailleX,tailleY);

				if(grilleJoueur2a.SatisfaitGrille2(grilleJoueur2,tailleX,tailleY));{
					System.out.println("/////////////////////////// La grille de joueur 1" );
					grilleJoueur1a.afficherGrille(grilleJoueur1,tailleX,tailleY);
					System.out.println("/////////////////////////// La grille de" + joueur2.getNomJoueur());
					grilleJoueur2a.afficherGrille(grilleJoueur2,tailleX,tailleY);
				}
			}

			break;
		case 1: 
			System.out.println("Joueur 1 fait ta grille");

			if(5<tailleX && tailleX<7 && 5<tailleY && tailleY<7) {
				grilleJoueur1a.PositionnerPA(grilleJoueur1,tailleX, tailleY);
				grilleJoueur1a.PositionnerTO(grilleJoueur1,tailleX, tailleY);
				grilleJoueur1a.PositionnerTO(grilleJoueur1,tailleX, tailleY);
				grilleJoueur1a.PositionnerCTO(grilleJoueur1, tailleX, tailleY);
			}else {
				grilleJoueur1a.PositionnerPA(grilleJoueur1,tailleX, tailleY);
				grilleJoueur1a.PositionnerPA(grilleJoueur1,tailleX, tailleY);
				grilleJoueur1a.PositionnerTO(grilleJoueur1,tailleX, tailleY);
				grilleJoueur1a.PositionnerTO(grilleJoueur1,tailleX, tailleY);
				grilleJoueur1a.PositionnerCTO(grilleJoueur1, tailleX, tailleY);
				grilleJoueur1a.PositionnerCTO(grilleJoueur1, tailleX, tailleY);
				grilleJoueur1a.PositionnerCTO(grilleJoueur1, tailleX, tailleY);
			}
			System.out.println("Joueur 2 fait ta grille");

			if(5<tailleX && tailleX<7 && 5<tailleY && tailleY<7) {
				grilleJoueur2a.PositionnerPA(grilleJoueur2,tailleX, tailleY);
				grilleJoueur2a.PositionnerTO(grilleJoueur2,tailleX, tailleY);
				grilleJoueur2a.PositionnerTO(grilleJoueur2,tailleX, tailleY);
				grilleJoueur2a.PositionnerCTO(grilleJoueur2, tailleX, tailleY);
			}else {
				grilleJoueur2a.PositionnerPA(grilleJoueur2,tailleX, tailleY);
				grilleJoueur2a.PositionnerPA(grilleJoueur2,tailleX, tailleY);
				grilleJoueur2a.PositionnerTO(grilleJoueur2,tailleX, tailleY);
				grilleJoueur2a.PositionnerTO(grilleJoueur2,tailleX, tailleY);
				grilleJoueur2a.PositionnerCTO(grilleJoueur2, tailleX, tailleY);
				grilleJoueur2a.PositionnerCTO(grilleJoueur2, tailleX, tailleY);
				grilleJoueur2a.PositionnerCTO(grilleJoueur2, tailleX, tailleY);
			}


		} 
		boolean tjrsJouer=true;
		boolean tjrsJouer1=false;
		int ScoreJ1=0;
		int ScoreJ2=0;

		while(true) {
			/*System.out.println("Voulez vous continuer la partie (1/0)"  );
			int choiceContinue = scanner.nextInt();
			switch (choiceContinue) {*/
				if(tjrsJouer) {
					System.out.println("C'est votre tour de jouer joueur1"  );
					System.out.print("Entrez la ligne : ");
					int ligne = scanner.nextInt();

					System.out.print("Entrez la colonne entre 0 et 9 : ");
					int colonne = scanner.nextInt();

					if(!(grilleJoueur2a.CaseDeJouer(grilleJoueur2,ligne, colonne))) {
						if(!(grilleJoueur2a.caseContientRien(grilleJoueur2,ligne,colonne))){
							System.out.println("Touché !");	       
							setScoreJoueur1(1);
							grilleJoueur2a.caseContientNavire(grilleJoueur2,ligne, colonne);         
							System.out.println("Le score du joueur 1 est de " + getScoreJoueur1());
							//Rejouer(grilleJoueur2,tailleX,tailleY);
						}else {	
							grilleJoueur2a.marquerCaseTouchee(grilleJoueur2,ligne, colonne) ;
							System.out.println("Manqué !");
							System.out.println("Le score du joueur 1 est de " + getScoreJoueur1());
							grilleJoueur2a.marquerCaseTouchee(grilleJoueur2,ligne, colonne);

							grilleJoueur2a.afficherGrilleJoueur(grilleJoueur2,tailleX,tailleY);
							tjrsJouer=false;
							tjrsJouer1=true;
						}



					}
				}
			
			



			if(tjrsJouer1) {
				System.out.println("C'est votre tour de jouer joueur 2 !");
				System.out.print("Entrez la ligne : ");
				int ligne = scanner.nextInt();

				System.out.print("Entrez la colonne : ");
				int colonne = scanner.nextInt();
				if(!(grilleJoueur1a.CaseDeJouer(grilleJoueur1,ligne, colonne))) {

					if(!(grilleJoueur1a.caseContientRien(grilleJoueur1,ligne,colonne))) {
						System.out.println("Touché !");
						setScoreJoueur2(1);

						grilleJoueur1a.caseContientNavire(grilleJoueur1,ligne, colonne);

						System.out.println("Le score du joueur 2 est de " + getScoreJoueur2());
						//Rejouer(grilleJoueur1,tailleX,tailleY);


					} else {
						System.out.println("Manqué !");
						grilleJoueur1a.marquerCaseTouchee(grilleJoueur1,ligne, colonne);

						grilleJoueur1a.afficherGrilleJoueur(grilleJoueur1,tailleX,tailleY);
						System.out.println("Le score du joueur 2 est de " + getScoreJoueur2());
						tjrsJouer=true;
						tjrsJouer1=false;
					}
				}
			}
		}
	}


	




	public void initialiserGrille(Case[][] grille,int tailleX, int tailleY) {
		for (int i = 0; i < tailleX; i++) {
			for (int j = 0; j < tailleY; j++) {
				grille[i][j] = new Case(); // E pour Eau
			}
		}
	}

	public void Partie2(int tailleX,int tailleY) {
		Case[][] grilleJoueur = new Case[tailleX][tailleY];

		Grille grilleJoueur1= new Grille(grilleJoueur);

		Case[][] robot = new Case[tailleX][tailleY];
		Grille robot1= new Grille(robot);

		grilleJoueur1.initialiserGrille(grilleJoueur,tailleX,tailleY);
		robot1.initialiserGrille(robot,tailleX,tailleY);

		grilleJoueur1.placerNaviresAleatoires(grilleJoueur,tailleX,tailleY);
		robot1.placerNaviresAleatoires(robot,tailleX,tailleY);




		System.out.println("Grille du joueur 1");
		grilleJoueur1.afficherGrille(grilleJoueur,tailleX,tailleY);


		System.out.println("///////////////////////////:::");
		if(grilleJoueur1.SatisfaitGrille1(grilleJoueur,tailleX,tailleY)) {
			System.out.println("Grille du joueur 2");
			robot1.afficherGrille(robot,tailleX,tailleY);

		}
		int compteur1=0;
		boolean tjrsJouer=true;
		boolean tourRobot=true;
		while(compteur1!=20) {

			if(tjrsJouer) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("C'est votre tour de jouer !");
				System.out.print("Entrez la ligne : ");
				int ligne = scanner.nextInt();

				System.out.print("Entrez la colonne : ");
				int colonne = scanner.nextInt();

				if(!(robot1.caseContientRien(robot,ligne,colonne))){
					System.out.println("Touché !");
					robot1.caseContientNavire(robot,ligne, colonne);

					robot1.afficherGrilleJoueur(robot,tailleX,tailleY); 
					//Rejouer(robot,tailleX,tailleY);


				} else{

					robot1.marquerCaseTouchee(robot,ligne, colonne) ;
					System.out.println("Manqué !");
					robot1.afficherGrilleJoueur(robot,tailleX,tailleY);
					tjrsJouer= false;
					tourRobot=true;

				}
			}
			if(tourRobot) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
				Random random= new Random();
				int ligne = random.nextInt(10);
				int colonne = random.nextInt(10);
				System.out.println("Le robot a joue aux case [" + ligne +"]["+ colonne +"]");
				if(!(grilleJoueur1.caseContientRien(grilleJoueur,ligne,colonne))) {
					System.out.println("Touché !");
					grilleJoueur1.caseContientNavire(grilleJoueur,ligne, colonne);
					grilleJoueur1.afficherGrilleJoueur(grilleJoueur,tailleX,tailleY);
					//Rejouer(grilleJoueur,tailleX,tailleY);

				}else {
					System.out.println("Manqué !");
					grilleJoueur1.marquerCaseTouchee(grilleJoueur,ligne, colonne);
					grilleJoueur1.afficherGrilleJoueur(grilleJoueur,tailleX,tailleY);
					tourRobot=false;
					tjrsJouer=true;
				}
			}

		}
	}
}




