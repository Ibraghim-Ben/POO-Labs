public class Produs {
    protected String nume;
    protected double pret;

    public Produs(String nume, double pret) {
        this.nume = nume;
        this.pret = pret;
    }

    public void afisareDetalii() {
        System.out.println("Produs: " + nume + ", Pret: " + pret);
    }
}
