public class Main {
    public static void main(String[] args) {
        Profesor profesor = new Profesor("Rusu Nicolae", "Matematica");
        Elev elev = new Elev("Ion");
        Lectie lectie = new Lectie(profesor, elev);
        lectie.incepe();
    }
}
