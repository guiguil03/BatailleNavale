package batailleNavale;
import java.util.Random;
class ContreTorpilleur extends Navire {
	
    @Override
    public int getLongueur() {
        return 3; // Le porte-avions a une longueur de 5 cases
    }

	
	public ContreTorpilleur() {
	}
	
    @Override
    public String getSymbole() {
        return "C"; // Utiliser "P" comme symbole pour le porte-avions
    }
    
}
