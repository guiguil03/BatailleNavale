package batailleNavale;
import java.util.Random;
class PorteAvions extends Navire {
	
    @Override
    public int getLongueur() {
        return 4; // Le porte-avions a une longueur de 5 cases
    }

    @Override
    public String getSymbole() {
        return "P"; // Utiliser "P" comme symbole pour le porte-avions
    }
    
}