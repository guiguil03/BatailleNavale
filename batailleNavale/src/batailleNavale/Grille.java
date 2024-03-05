package batailleNavale;
import java.util.Random;

import java.io.*;
import java.util.Scanner;

class Grille {
    private Navire[][] grille;

    public void chooseGrid() {
    	Scanner sc= new Scanner(System.in);
    	System.out.println("Choisisez la taille de la grille que vous voulez 1 pour 10*10 et 2 pour 5*5");
    	int choice= sc.nextInt();
    	int taille=10;
    	int taille1=5;
    	switch(choice) {
    	case 1:
    		grille1(taille);
    		break;
    	
    	case 2:
    		grille2(taille1);
    	}
    		
    }
    public void grille1(int taille) {
    	grille = new Navire[taille][taille];
    	
    }
    public void grille2(int taille1) {
    	grille = new Navire[taille1][taille1];
    }
    
    

    public void ajouterNavire(Navire navire) {
        grille[navire.posX][navire.posY] = navire;
    }

    public void ajouterSousNavire(PorteAvions sousNavire) {
        int x = sousNavire.posX;
        int y = sousNavire.posY;

        if (sousNavire.estHorizontal) {
            for (int i = 0; i < sousNavire.taille; i++) {
                grille[x + i][y] = sousNavire;
            }
        } else {
            for (int i = 0; i < sousNavire.taille; i++) {
                grille[x][y + i] = sousNavire;
            }
        }
    }

    public void afficherGrille() {
        for (Navire[] ligne : grille) {
            for (Navire navire : ligne) {
                if (navire != null) {
                    System.out.print("X ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}

