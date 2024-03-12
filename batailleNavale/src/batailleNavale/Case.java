package batailleNavale;


class Case {
    private String contenu;
    private static Navire navire;

    public static boolean estOccupee() {
        return navire != null;
    }
    

    public static boolean getNavire() {
        return true;
    }

    public void occuperAvecNavire(Navire navire) {
        this.navire = navire;
    }

    public void liberer() {
        this.navire = null;
    }

    public Case() {
        this.contenu = "-";
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return contenu + " | ";
    }
}