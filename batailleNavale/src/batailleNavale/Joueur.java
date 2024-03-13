package batailleNavale;
import java.io.*;

import java.util.*;
public class Joueur {
	private String nomJoueur;
	private int numeroJoueur;
	public String getNomJoueur() {
		return nomJoueur;
	}
	public String getNomJoueur(String nomJoueur) {
		this.nomJoueur=nomJoueur;
		return null;
	}
	public Joueur setJoueur(String nomJoueur,int numeroJoueur){
		this.nomJoueur=nomJoueur;
		this.numeroJoueur=numeroJoueur;
		return null;
	}
	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}
	public int getNumeroJoueur() {
		return numeroJoueur;
	}
	public void setNumeroJoueur(int numeroJoueur) {
		this.numeroJoueur = numeroJoueur;
	}
	
	public void NbdeJoueur(){
		System.out.println("Hello bienvenue sur notre jeu de bataille navale");
		Scanner scanner = new Scanner(System.in);

		System.out.println("Veuillez saisir si vous fait une partie contre un robot (1) ou contre un autre joueur(2)");
		int choice= scanner.nextInt();
		switch(choice){
			case 1:
			InfoJoueurs();
			break;
			case 2:
			Info2Joueur();
			break;
		}
		scanner.close();
	
	 }
	 public void Info2Joueur(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez saisir le nom du premier joueur");
		String nom=scanner.nextLine();
		System.out.println("Saisir le numero du jouer");
		int numero= scanner.nextInt();
		Joueur J1= setJoueur(nom, numero);
		Scanner scanner1 = new Scanner(System.in);

		System.out.println("Veuillez saisir le nom du deuxieme joueur");
		String nom2=scanner1.nextLine();
		System.out.println("Saisir le numero du jouer");
		int numero2= scanner1.nextInt();
		Joueur J2= setJoueur(nom2, numero2);
		scanner.close();
		scanner1.close();
	 }
	 public void InfoJoueurs(){
		 Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez saisir le nom du premier joueur");
		String nom=scanner.nextLine();
		scanner.close();
	 }
}


