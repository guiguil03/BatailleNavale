package batailleNavale;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;




public class main {
	public static void main(String[] args) {
		Partie partie= new Partie();
		//partie.InitialisationPartie();
		Grille grilleJoueur1 = new Grille();
        Grille grilleJoueur2 = new Grille();
        grilleJoueur1.initialiserGrille();
        grilleJoueur2.initialiserGrille();

        grilleJoueur1.placerNaviresAleatoires(grilleJoueur1);
        grilleJoueur2.placerNaviresAleatoires(grilleJoueur2);
        
        System.out.println("Grille dun joueur 1");
        grilleJoueur1.afficherGrille();
        
        System.out.println("///////////////////////////:::");
        if(grilleJoueur1.SatisfaitGrille()) {
            System.out.println("Grille dun joueur 2");
            grilleJoueur2.afficherGrille();
            grilleJoueur2.SatisfaitGrille();
            System.out.println("///////////////////////////:::");

        }

    }
    
}