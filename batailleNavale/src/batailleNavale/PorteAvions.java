package batailleNavale;
import java.util.Random;

public class PorteAvions extends Navire{
	 int taille;
	    boolean estHorizontal;

	    public PorteAvions(int posX, int posY, int taille, boolean estHorizontal) {
	        super();
	        this.taille = taille;
	        this.estHorizontal = estHorizontal;
	    }
	}
