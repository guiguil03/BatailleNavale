package batailleNavale;
import java.util.Random;


public class Grille {
	private int largeur; 
	private int longueur;
	
	public Grille() {
		
	}
	public Grille (int myLargeur, int myLongueur) {
		this.largeur = myLargeur;
		this.longueur = myLongueur; 
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	public void createMiniGrid() {
		String[][] grille = new String[7][7];
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				grille[0][j] = Integer.toString(j);
				grille[i][0] = Integer.toString(i);
				grille[i][j] = "X";
			}
		}
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				System.out.print(grille[i][j] + " | ");
			}
			System.out.println();
		}
	}
	public void createDefaultGrid() {
		String[][] grille = new String[10][10];
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				grille[0][j] = Integer.toString(j);
				grille[i][0] = Integer.toString(i);
				grille[i][j] = "X";
			}
		}

		for (int k = 0; k < 4; k++) {
	        Navire navire = new Navire();
	        navire.createPorteAvion();
	        ajouterNavire(navire, grille);
	        for (int i = 1; i < navire.getLongueurDuNavire(); i++) {
		        if (navire.isHorizontal()) {
		            navire.setPositionX(navire.getPositionX() + i);
		        } else {
		            navire.setPositionY(navire.getPositionY() + i);
		        }
		    }

	    }
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				System.out.print(grille[i][j] + " | ");
			}
			System.out.println();
		}
		
	}
	
	private void ajouterNavire(Navire navire, String[][] grille) {
		navire.createPorteAvion();
	    int x = navire.getPositionX();
	    int y = navire.getPositionY();

	    // Assurez-vous que les coordonnées du navire sont valides dans la grille
	    if (x >= 0 && x < grille.length && y >= 0 && y < grille[0].length) {
	        grille[x][y] = "N"; // Vous pouvez utiliser un autre symbole pour représenter le navire
	    }
	    	}
   }
	

