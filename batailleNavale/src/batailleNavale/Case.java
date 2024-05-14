package batailleNavale;


public class Case {
    private String contenu; // Contenu de la case
    private Navire navire; // Navire occupant la case, s'il y en a un
    
    // Constante représentant l'état d'une case vide
    public static final String ETAT_VIDE = "-";

    public Case() {
        this.contenu = ETAT_VIDE; // Par défaut, une case est vide
    }
    public Case(boolean estOccupee) {
        this.contenu = ETAT_VIDE; // Par défaut, une case est vide
    }

    // Méthode pour vérifier si la case est occupée par un navire
    public boolean estOccupee() {
        return navire != null;
    }
    
    // Méthode pour obtenir le navire occupant la case, s'il y en a un
    public Navire getNavire() {
        return navire;
    }

    // Méthode pour occuper la case avec un navire
    public void occuperAvecNavire(Navire navire) {
        this.navire = navire;
    }

    // Méthode pour libérer la case
    public void liberer() {
        this.navire = null;
    }

    // Méthode pour obtenir le contenu de la case
    public String getContenu() {
        return contenu;
    }

    // Méthode pour définir le contenu de la case
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    // Méthode toString pour afficher le contenu de la case
    @Override
    public String toString() {
        return contenu + " | ";
    }


	public boolean caseContientNavire(int ligne, int colonne) {
		return true;
	}


	public boolean marqueCaseTouchee(int ligne, int colonne) {
		// TODO Auto-generated method stub
		return true;
	}
}