package batailleNavale;


class Torpilleur extends Navire {
	
    @Override
    public String getSymbole() {
        return "T"; // Symbole pour un torpilleur
    }
    public int getLongueur() {
        return 2; // Le porte-avions a une longueur de 5 cases
    }
}
