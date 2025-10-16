public class ProduseAlimentare extends Produs {
    protected String tipProdus;

    public ProduseAlimentare(String nume, double pret, String tipProdus) {
        super(nume, pret);
        this.tipProdus = tipProdus;
    }

    public void preparaProdus() {
        System.out.println("Produsul " + nume + " de tip " + tipProdus + " este pregatit pentru vanzare.");
    }
}
