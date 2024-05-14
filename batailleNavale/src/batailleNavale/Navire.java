package batailleNavale;
import java.util.Random;
class Navire {
    public Case[][] grille;

    protected int positionX;
    protected int positionY;
    protected boolean horizontal;
    protected boolean estPlace;

    public int getPositionX() {
        return positionX;
    }
    public boolean estPlace() {
        return estPlace;
    }

    public void setPlace(boolean estPlace) {
        this.estPlace = estPlace;
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
    public boolean caseEstLibre(int x, int y) {
        return grille[x][y].getContenu().equals("-");
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
    public void genererPositionAleatoire(Case[][] grilleCases,int tailleX,int tailleY) {
        Random random = new Random();
        setPositionX(random.nextInt(tailleX-3));
        setPositionY(random.nextInt(tailleY-3));
        setHorizontal(random.nextBoolean());

        
    }

}
