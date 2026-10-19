class Elev {
    String nume;

    Elev(String nume) {
        this.nume = nume;
    }
    void invata(String materie) {
        System.out.println("Elevul " + nume + " invata materia: " + materie);
    }
}
