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
  }

	  
}


