public class Carne extends ProduseAlimentare {
    protected String tipCarne;

    public Carne(String nume, double pret, String tipProdus, String tipCarne) {
        super(nume, pret, tipProdus);
        this.tipCarne = tipCarne;
    }

    public void gatesteCarne() {
        System.out.println(nume + " de tip " + tipCarne + " este gatita pentru vanzare.");
    }
}
