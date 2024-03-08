package batailleNavale;


class Case {
    private String contenu;
    private Navire navire;

    public boolean estOccupee() {
        return navire != null;
    }
    

    public boolean getNavire() {
        return false;
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