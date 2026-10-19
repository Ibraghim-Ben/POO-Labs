public class Tricou extends Imbracaminte {

    public Tricou(String nume, double pret, String culoare, String material) {
        super(nume, pret, culoare, material);
    }

    public void poartaTricou() {
        System.out.println(nume + " este purtat.");
    }
}
