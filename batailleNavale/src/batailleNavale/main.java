package batailleNavale;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;




public class main {
	public static void main(String[] args) {
		
		/*Scanner sc = new Scanner(System.in);
		int tailleX, tailleY;
		boolean horinzontal;
		
		do {
            System.out.println("Entrez la taille de la grille (nombre de lignes égale au moins à 6) : ");
            while (!sc.hasNextInt()) {
                System.out.println("Veuillez entrer un entier valide pour la taille de la grille (nombre de lignes égale au moins à 6).");
                sc.next(); 
            }
            tailleX = sc.nextInt();

            System.out.println("Entrez la taille de la grille (nombre de colonnes égale au moins à 6) : ");
            // Vérifier si la saisie est un entier
            while (!sc.hasNextInt()) {
                System.out.println("Veuillez entrer un entier valide pour la taille de la grille (nombre de colonnes égale au moins à 6).");
                sc.next(); 
            }
            tailleY = sc.nextInt();

            if (tailleX < 6 || tailleY < 6) {
                System.out.println("La taille de la grille est trop petite, veuillez recommencer.");
            }
        } while (tailleX < 6 || tailleY < 6);


		Grille grille = new Grille(new Case[tailleX][tailleY]);
        Joueur joueur= new Joueur();
        Joueur joueur1= new Joueur();

		joueur.NbdeJoueur(tailleX,tailleY);
		joueur.getNomJoueur();
		joueur1.getNomJoueur();

		
		System.out.println("hello");
		Partie partie= new Partie();
		
		//partie.InitialisationPartie();

       

        
        
		partie.Partie(joueur,joueur1,tailleX,tailleY);
		partie.sauvegarderPartie("test.sav");*/

		C_Accueil lancement = new C_Accueil();
    }
    
}