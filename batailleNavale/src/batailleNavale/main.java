package batailleNavale;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;



public class main {
  public static void main(String[] args) {
      Grille grille = new Grille();
      grille.chooseGrid();
      // Ajouter un navire principal de taille 4 à une position aléatoire
      Random random = new Random();
      int posX = random.nextInt(10);  // Limiter la position pour éviter le débordement
      int posY = random.nextInt(10);  // Limiter la position pour éviter le débordement
      boolean estHorizontal = random.nextBoolean();

      // Créer le navire principal de taille 4
      PorteAvions navirePrincipal = new PorteAvions(posX, posY, 4, estHorizontal);

      // Ajouter le navire principal à la grille
      grille.ajouterSousNavire(navirePrincipal);

      // Afficher la position du navire principal
      navirePrincipal.afficherPosition();

      // Afficher la grille avec les navires
      grille.afficherGrille();
	  C_Accueil connexion = new C_Accueil();
  }

	  
}


