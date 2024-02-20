package batailleNavale;

public class Grille {
	private int largeur; 
	private int longueur;
	
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
	
}
