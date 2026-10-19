class Profesor {
    String nume;
    String materie;

    Profesor(String nume, String materie) {
        this.nume = nume;
        this.materie = materie;
    }

    void preda() {
        System.out.println("Profesorul " + nume + " incepe sa predea materia " + materie);
    }
}
