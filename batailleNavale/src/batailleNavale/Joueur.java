package batailleNavale;
import java.io.*;

import java.util.*;
public class Joueur {
	private String nomJoueur;
	private int numeroJoueur;
	public String getNomJoueur() {
		return nomJoueur;
	}
	public void getNomJoueur(String nomJoueur) {
		this.nomJoueur=nomJoueur;
	}
	public Joueur setJoueur(String nomJoueur,int numeroJoueur){
		this.nomJoueur=nomJoueur;
		this.numeroJoueur=numeroJoueur;
		return null;
	}
	public void setJoueur(String nomJoueur) {
		this.nomJoueur=nomJoueur;
	}
	public Joueur setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
		return null;
	}
	public int getNumeroJoueur() {
		return numeroJoueur;
	}
	public void setNumeroJoueur(int numeroJoueur) {
		this.numeroJoueur = numeroJoueur;
	}

	public void NbdeJoueur(int tailleX, int tailleY){
		System.out.println("Hello bienvenue sur notre jeu de bataille navale");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez saisir si vous fait une partie contre un robot (1) ou contre un autre joueur(2)");
		int choice= scanner.nextInt();
		scanner.nextLine();
		switch(choice){
		case 1:
			InfoJoueurs(tailleX,tailleY);
			break;
		case 2:
			Info2Joueur(tailleX,tailleY);
			break;
		}
		scanner.close();

	}
	public Joueur creerJoueur() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez saisir le nom du joueur : ");
		String nom = scanner.nextLine();
		Joueur joueur = new Joueur();
		joueur.setNomJoueur(nom);
		System.out.println(joueur.getNomJoueur());
		return joueur;
	}

	public void Info2Joueur(int tailleX, int tailleY) {
		Partie partie = new Partie();
		Joueur joueur1 = creerJoueur();
		Joueur joueur2 = creerJoueur();
		partie.setJoueurs(joueur1, joueur2);
		partie.Partie(joueur1,joueur2,tailleX, tailleY);
	}

	public void InfoJoueurs(int tailleX, int tailleY) {
		Partie partie = new Partie();
		Joueur J1 = creerJoueur();
		partie.setJoueurs(J1, null); 
		partie.Partie2(tailleX, tailleY);
	}

}



