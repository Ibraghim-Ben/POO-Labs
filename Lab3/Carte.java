public class Carte extends Produs {
    protected String subiect;

    public Carte(String nume, double pret, String subiect) {
        super(nume, pret);
        this.subiect = subiect;
    }

    public void citesteCarte() {
        System.out.println("Citind cartea '" + nume + "', te poti familiariza cu fascinantul domeniu al " + subiect + ".");
    }
}
