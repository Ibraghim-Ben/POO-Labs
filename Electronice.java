public class Electronice extends Produs {
    protected String producator;

    public Electronice(String nume, double pret, String producator) {
        super(nume, pret);
        this.producator = producator;
    }

    public void afisareDetalii() {
        System.out.println("Produsul electronic " + nume + " este fabricat de " + producator + " si are un pret de " + pret + " de lei.");
    }

    public void pornesteDispozitiv() {
        System.out.println(nume + " a fost pornit si functioneaza corect.");
    }
}
