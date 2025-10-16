public class Laptop extends Electronice {
    protected int baterie;

    public Laptop(String nume, double pret, String producator, int baterie) {
        super(nume, pret, producator);
        this.baterie = baterie;
    }

    public void ruleazaSoftware() {
        System.out.println(nume + " ruleaza aplicatii folosind bateria de " + baterie + " mAh.");
    }
}
