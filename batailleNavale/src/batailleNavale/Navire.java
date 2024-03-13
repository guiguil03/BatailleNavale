package batailleNavale;
import java.util.Random;
class Navire {
    public Case[][] grille;

    protected int positionX;
    protected int positionY;
    protected boolean horizontal;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public int getLongueur() {
        return 1; // Par défaut, un navire a une longueur de 1 case
    }

    public String getSymbole() {
        return "N"; // Par défaut, utiliser "N" comme symbole
    }
    public int setPositionX(int positionX) {
    	return this.positionX=positionX;
    }
    public int setPositionY(int positionY) {
    	return this.positionY=positionY;
    }
    public boolean setHorizontal(boolean horizontal) {
    	return this.horizontal=horizontal;
    }
    public void genererPositionAleatoire(Grille grille) {
        Random random = new Random();
        setPositionX(random.nextInt(7));
        setPositionY(random.nextInt(7));
        setHorizontal(random.nextBoolean());

        
    }

}
