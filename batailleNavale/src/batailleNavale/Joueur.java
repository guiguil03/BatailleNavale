package batailleNavale;

public class Joueur {
	private String nomJoueur;
	private int numeroJoueur;
	private int telephone;
	public String getNomJoueur() {
		return nomJoueur;
	}
	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}
	public int getNumeroJoueur() {
		return numeroJoueur;
	}
	public void setNumeroJoueur(int numeroJoueur, int telephone) {
		this.numeroJoueur = numeroJoueur;
		this.telephone=telephone;
	}
	
	
}


