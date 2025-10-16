public class Imbracaminte extends Produs {
    protected String culoare;
    protected String material;

    public Imbracaminte(String nume, double pret, String culoare, String material) {
        super(nume, pret);
        this.culoare = culoare;
        this.material = material;
    }

    public void afiseazaDescriere() {
        System.out.println("Articolul de imbracaminte " + nume + " este confectionat din " + material + " si are culoarea " + culoare + ".");
    }
}
