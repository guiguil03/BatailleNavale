package batailleNavale;
import java.io.*;

import java.util.*;

public class Partie {
	private boolean EtatPartie;
	private Joueur joueurs;
	private int ScoreJoueur1;
	private int ScoreJoueur2;
	private Grille grilleJoueur1;
    private Grille grilleJoueur2;
    private static Case[][] grille;

    public Partie() {
        grilleJoueur1 = new Grille();
        grilleJoueur2 = new Grille();
    }
    public void chargerGrilleJoueur1(Grille grille) {
        this.grilleJoueur1 = grille;
    }

    public void chargerGrilleJoueur2(Grille grille) {
        this.grilleJoueur2 = grille;
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
	public int getScoreJoueur1() {
		return ScoreJoueur1;
	}
	public void setScoreJoueur1(int scoreJoueur1) {
		ScoreJoueur1 = scoreJoueur1;
	}
	public int getScoreJoueur2() {
		return ScoreJoueur2;
	}
	public void setScoreJoueur2(int scoreJoueur2) {
		ScoreJoueur2 = scoreJoueur2;
	} 
	public static void Partie() {
		Grille grilleJoueur1 = new Grille();
        Grille grilleJoueur2 = new Grille();
        grilleJoueur1.initialiserGrille();
        grilleJoueur2.initialiserGrille();

        grilleJoueur1.placerNaviresAleatoires(grilleJoueur1);
        grilleJoueur2.placerNaviresAleatoires(grilleJoueur2);
        
        System.out.println("Grille du joueur 1");
        grilleJoueur1.afficherGrille();
        
        System.out.println("///////////////////////////:::");
        if(grilleJoueur1.SatisfaitGrille1()) {
            System.out.println("Grille du joueur 2");
            grilleJoueur2.afficherGrille();
         if(grilleJoueur2.SatisfaitGrille2());
            System.out.println("/////////////////////////// La grille du joueur 1");
            grilleJoueur1.afficherGrille();
            System.out.println("/////////////////////////// La grille du joueur 2");
            grilleJoueur2.afficherGrille();

        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("C'est votre tour de jouer !");
        System.out.print("Entrez la ligne : ");
        int ligne = scanner.nextInt();

        System.out.print("Entrez la colonne : ");
        int colonne = scanner.nextInt();

        
        if (!(grilleJoueur2.caseContientRien(ligne,colonne))) {
            System.out.println("Touché !");
            grilleJoueur2.caseContientNavire(ligne, colonne);
        } else {
            grilleJoueur2.marquerCaseTouchee(ligne, colonne);

            System.out.println("Manqué !");
        }

        grilleJoueur2.afficherGrilleJoueur();
          
    }
}
    		
	


