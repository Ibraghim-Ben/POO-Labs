class Lectie {
    Profesor profesor;
    Elev elev;

    Lectie(Profesor profesor, Elev elev) {
        this.profesor = profesor;
        this.elev = elev;
    }

    void incepe() {
        System.out.println("Lecția a început!");
        profesor.preda();
        elev.invata(profesor.materie);
        System.out.println("Lecția s-a încheiat!");
    }
}
