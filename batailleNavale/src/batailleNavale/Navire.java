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
	public void createPorteAvion() {
		Random random = new Random();
		setPositionX(random.nextInt(10));
        setPositionY(random.nextInt(10));
        setHorizontal(random.nextBoolean());
        setVertical(!isHorizontal()); // S
        if (isHorizontal()) {
            // Si le navire est horizontal, assurez-vous qu'il rentre dans la grille horizontalement
            setPositionX(random.nextInt(10 - longueurDuNavire + 1));
            setPositionY(random.nextInt(10));
        } else {
            // Si le navire est vertical, assurez-vous qu'il rentre dans la grille verticalement
            setPositionX(random.nextInt(10));
            setPositionY(random.nextInt(10 - longueurDuNavire + 1));
        }
        
        // Assurez-vous que les éléments du navire se suivent dans la grille
        for (int i = 1; i < longueurDuNavire; i++) {
            if (isHorizontal()) {
                setPositionX(getPositionX() + i);
            } else {
                setPositionY(getPositionY() + i);
            }
        }
        
	}
	public int getLongueurDuNavire() {
		return longueurDuNavire;
	}
	public void setLongueurDuNavire(int longueurDuNavire) {
		this.longueurDuNavire = longueurDuNavire;
	}

	
}
