package batailleNavale;
import java.util.Random;

public class PorteAvions extends Navire{
	int taille;
    boolean estHorizontal;

    public PorteAvions(int posX, int posY, int taille, boolean estHorizontal) {
        super(posX, posY);
        this.taille = taille;
        this.estHorizontal = estHorizontal;
    }
	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public boolean isEstHorizontal() {
		return estHorizontal;
	}

	public void setEstHorizontal(boolean estHorizontal) {
		this.estHorizontal = estHorizontal;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}