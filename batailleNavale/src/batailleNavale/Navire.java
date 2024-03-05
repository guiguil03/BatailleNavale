package batailleNavale;

import java.util.Random;

public class Navire {
	private int positionX;
	private int positionY;
	private boolean horizontal;
	private boolean vertical;
    private int longueurDuNavire = 4; // Ajoutez cette propriété pour définir la longueur du navire

	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public boolean isHorizontal() {
		return horizontal;
	}
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	public boolean isVertical() {
		return vertical;
	}
	public void setVertical(boolean vertical) {
		this.vertical = vertical;
	}
	int posX;
    int posY;

    public Navire(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void afficherPosition() {
        System.out.println("Position du navire : (" + posX + ", " + posY + ")");
    }
	
}
