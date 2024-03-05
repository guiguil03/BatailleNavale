package batailleNavale;

public class Croiseur extends Navire {
		
int taille;
boolean estHorizontal;
private int posX;
private int posY;

public Croiseur(int positionX, int positionY, int taille, boolean estHorizontal) {
    super(positionX,positionY);
    this.taille = taille;
    this.estHorizontal = estHorizontal;
}
}