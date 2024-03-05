package batailleNavale;

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
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				System.out.print(grille[i][j] + " | ");
			}
			System.out.println();
		}
	}
	
}
