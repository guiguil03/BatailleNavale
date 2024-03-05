package batailleNavale;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class main {
  public static void main(String[] args) {
	  Grille uneGrille = new Grille();
	  uneGrille.createDefaultGrid();
	  System.out.println("\n");
	  uneGrille.createMiniGrid();
	  Joueur Unjoueur= new Joueur();
	  Unjoueur.NbdeJoueur();	  
	  PorteAvions porteAvions = new PorteAvions();
      porteAvions.createPorteAvion();
	  System.out.println("Hello World");
	  System.out.println("Moi c'est Myrah"); 
	  
	  /*Grille uneGrille = new Grille();
	  uneGrille.chooseGrid();*/
	  
	  C_Accueil connexion = new C_Accueil();
  }

	  
}


