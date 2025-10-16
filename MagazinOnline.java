public class MagazinOnline {
    public static void main(String[] args) {
        Electronice telefon = new Electronice("Telefon Galaxy", 5000, "Samsung");
        Laptop laptop = new Laptop("Laptop Pro", 12000, "HP", 10000);

        Tricou tricou = new Tricou("Tricou Sport", 500, "Albastru", "Bumbac");

        Carne carne = new Carne("Carne de vita", 300, "Carne", "Vita");

        Astronomie carteAstronomie = new Astronomie("Stele si Planete", 120, "Astronomie", "Cosmos");

        telefon.afisareDetalii();
        laptop.afisareDetalii();
        telefon.pornesteDispozitiv();
        laptop.ruleazaSoftware();

        System.out.println();

        tricou.afiseazaDescriere();
        tricou.poartaTricou();

        System.out.println();

        carne.preparaProdus();
        carne.gatesteCarne();

        System.out.println();

        carteAstronomie.citesteCarte();
        carteAstronomie.studiazaAstronomie();
    }
}
