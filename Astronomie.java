public class Astronomie extends Carte {
    protected String domeniu;

    public Astronomie(String nume, double pret, String subiect, String domeniu) {
        super(nume, pret, subiect);
        this.domeniu = domeniu;
    }

    public void studiazaAstronomie() {
        System.out.println("Cartea exploreaza domeniul: " + domeniu + ".");
    }
}
