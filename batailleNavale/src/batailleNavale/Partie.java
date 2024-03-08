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
	public void InitialisationPartie() {
		Scanner sc= new Scanner(System.in);
		Joueur joueur= new Joueur();
		joueur.NbdeJoueur();
        
	}
	   
	

};
